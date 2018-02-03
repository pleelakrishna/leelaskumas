package com.charvikent.issuetracking.controller;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.charvikent.issuetracking.config.FilesStuff;
import com.charvikent.issuetracking.model.KpStatusLogs;
import com.charvikent.issuetracking.model.ReportIssue;
import com.charvikent.issuetracking.model.User;
import com.charvikent.issuetracking.service.CategoryService;
import com.charvikent.issuetracking.service.DashBoardService;
import com.charvikent.issuetracking.service.MastersService;
import com.charvikent.issuetracking.service.PriorityService;
import com.charvikent.issuetracking.service.ReportIssueService;
import com.charvikent.issuetracking.service.SeverityService;
import com.charvikent.issuetracking.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class TaskController {
	
	@Autowired
	ReportIssueService taskService;
	@Autowired
	private PriorityService priorityService;

	@Autowired
	private SeverityService severityService;
	@Autowired
	private UserService userService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	MastersService  mastersService;

	@Autowired
	FilesStuff fileTemplate;
	
	@Autowired
	DashBoardService dashBoardService;
	
	
	
	@RequestMapping("/task")
	public String  department( @ModelAttribute("taskf")  ReportIssue taskf,Model model , HttpServletRequest request) {
		Set<ReportIssue> listOrderBeans = null;
		ObjectMapper objectMapper = null;
		String sJson = null;
		model.addAttribute("taskf", new ReportIssue());
		model.addAttribute("subTaskf", new KpStatusLogs());   // model attribute for formmodel popup
		model.addAttribute("severity", severityService.getSeverityNames());
		model.addAttribute("priority", priorityService.getPriorityNames());
		model.addAttribute("userNames", userService.getUserName());
		model.addAttribute("category", categoryService.getCategoryNames());
		model.addAttribute("departmentNames", mastersService.getDepartmentNames());
		model.addAttribute("kpstatuses", mastersService.getKpStatues());
		
		//model.addAttribute("departmentNames", mastersService.getSortedDepartments());
		
		
		
		try {
			listOrderBeans = taskService.getAllReportIssues();
			if (listOrderBeans != null && listOrderBeans.size() > 0) {
				objectMapper = new ObjectMapper();
				sJson = objectMapper.writeValueAsString(listOrderBeans);
				request.setAttribute("allOrders1", sJson);
				// System.out.println(sJson);
			} else {
				objectMapper = new ObjectMapper();
				sJson = objectMapper.writeValueAsString(listOrderBeans);
				request.setAttribute("allOrders1", "''");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);

		}
		
		
		return "task";
	
	}
	
	@RequestMapping(value = "/task", method = RequestMethod.POST)
	public String saveAdmin(@Valid @ModelAttribute  ReportIssue task, BindingResult bindingresults, @RequestParam("file") MultipartFile[] uploadedFiles,
			RedirectAttributes redir) throws IOException {
		
		if (bindingresults.hasErrors()) {
			System.out.println("has some errors");
			return "redirect:/";
		}
		
		int id = 0;
		try
		{
			ReportIssue orgBean=null;
			if(task.getId()!=null)
			{
			  orgBean= taskService.getReportIssueById(task.getId());
			
			}
			int dummyId =0;
			
			if(orgBean != null){
				dummyId = orgBean.getId();
			}
			
			if(task.getId()==null)
			{
				if(dummyId ==0)
				{
					
					try {
						for(MultipartFile multipartFile : uploadedFiles) {
							String fileName = multipartFile.getOriginalFilename();
							if(!multipartFile.isEmpty())
							{
							 task.setUploadfile("user browsed file(s)");            //add dummy value to check file upload status in dao layers
							 multipartFile.transferTo(fileTemplate.moveFileTodir(fileName));
							}
						}
					} catch (IllegalStateException e) {
						e.printStackTrace();
					}
					
					
					
					
					task.setStatus("1");
					
					taskService.saveReportIssue(task);

					redir.addFlashAttribute("msg", "Record Inserted Successfully");
					redir.addFlashAttribute("cssMsg", "success");
					
				} else
				{
					redir.addFlashAttribute("msg", "Already Record Exist");
					redir.addFlashAttribute("cssMsg", "danger");
					
				}
				
			
			}
			
			else
			{
				id=task.getId();
				if(id == dummyId || orgBean == null)
				{
					
					try {
						for(MultipartFile multipartFile : uploadedFiles) {
							String fileName = multipartFile.getOriginalFilename();
							if(!multipartFile.isEmpty())
							{
							 task.setUploadfile("user browsed file(s)");            //add dummy value to check file upload status in dao layers
							 multipartFile.transferTo(fileTemplate.moveFileTodir(fileName));
							}
						}
					} catch (IllegalStateException e) {
						e.printStackTrace();
					}
					taskService.updateIssue(task);
					redir.addFlashAttribute("msg", "Record Updated Successfully");
					redir.addFlashAttribute("cssMsg", "warning");
					
				} else
				{
					redir.addFlashAttribute("msg", "Already Record Exist");
					redir.addFlashAttribute("cssMsg", "danger");
				}
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);

		}
		
		
		return "redirect:task";
	}
	
	
	@RequestMapping(value = "/deleteTask")
	public @ResponseBody String deleteDept(ReportIssue  objorg,ModelMap model,HttpServletRequest request,HttpSession session,BindingResult objBindingResult) {
		System.out.println("deleteEducation page...");
		Set<ReportIssue> listOrderBeans  = null;
		JSONObject jsonObj = new JSONObject();
		ObjectMapper objectMapper = null;
		String sJson=null;
		boolean delete = false;
		try{
			if(objorg.getId() != 0){
 				delete = taskService.deleteTask(objorg.getId(),objorg.getStatus());
 				if(delete){
 					jsonObj.put("message", "deleted");
 				}else{
 					jsonObj.put("message", "delete fail");
 				}
 			}
 				
			listOrderBeans = taskService.getAllReportIssues();
			 objectMapper = new ObjectMapper();
			if (listOrderBeans != null && listOrderBeans.size() > 0) {
				
				objectMapper = new ObjectMapper();
				sJson = objectMapper.writeValueAsString(listOrderBeans);
				request.setAttribute("allOrders1", sJson);
				jsonObj.put("allOrders1", sJson);
				// System.out.println(sJson);
			} else {
				objectMapper = new ObjectMapper();
				sJson = objectMapper.writeValueAsString(listOrderBeans);
				request.setAttribute("allOrders1", "''");
				jsonObj.put("allOrders1", sJson);
			}
		}catch(Exception e){
			e.printStackTrace();
	System.out.println(e);
			return String.valueOf(jsonObj);
			
		}
		return String.valueOf(jsonObj);
	}
	
	
	@RequestMapping(value = "/viewTask",method = RequestMethod.POST)
	public @ResponseBody Object viewIssue(@RequestParam(value = "id", required = true) String id, Model model,HttpServletRequest request, HttpSession session) throws JSONException {

		
		List<KpStatusLogs> taskHistory =taskService.getrepeatLogsById(Integer.parseInt(id));
		
		JSONObject obj = new JSONObject();
		obj.put("list", taskHistory);
		return String.valueOf(obj);

	}
	
	

	@RequestMapping(value = "/subTask", method = RequestMethod.POST)
	public @ResponseBody String saveSubtask(@RequestParam(value = "comment", required = true) String comment, @RequestParam(value = "kpstatus", required = true) String kpstatus, @RequestParam(value = "issueid", required = true) String issueid, @Valid @ModelAttribute  KpStatusLogs subtask, BindingResult bindingresults, @RequestParam("file[]") MultipartFile[] uploadedFiles,
			RedirectAttributes redir) throws IOException {
		
		
		try {
			for(MultipartFile multipartFile : uploadedFiles) {
				String fileName = multipartFile.getOriginalFilename();
				if(!multipartFile.isEmpty())
				{
					subtask.setUploadfiles("user browsed file(s)");            //add dummy value to check file upload status in dao layers
				 multipartFile.transferTo(fileTemplate.moveFileTodir(fileName));
				}
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		subtask.setIssueid(issueid);
		
		taskService.saveSubTask(subtask);
		
		String str="success";

		
		
		return str;
		
	}
	
	
	
	@RequestMapping(value = "/setdata",method = RequestMethod.POST)
	public @ResponseBody Object setTasks(@RequestParam(value = "ttypeid", required = true) String ttypeid, @RequestParam(value = "deptid", required = true) String deptid, Model model,HttpServletRequest request, HttpSession session) throws JSONException {
		
		System.out.println(ttypeid);
		System.out.println(deptid);
		
		Set<ReportIssue> listOrderBeans = null;
		User objuserBean = (User) session.getAttribute("cacheUserBean");
		
		if(ttypeid.equals("1"))
		
		{
		
		listOrderBeans = dashBoardService.getIssuesByAssignTo(String.valueOf(objuserBean.getId()));
		}
		
		if(ttypeid.equals("2"))
			
		{
		
		listOrderBeans = dashBoardService.getIssuesByAssignBy(String.valueOf(objuserBean.getId()));
		}
		
        if(ttypeid.equals("3"))
			
		{
		
		listOrderBeans = dashBoardService.getIssuesByAssignToUnderMonitor(String.valueOf(objuserBean.getId()));
		}
		
		
		

		JSONObject obj = new JSONObject();
		obj.put("list", listOrderBeans);
		
		return String.valueOf(obj);
		
		
		

	}
	
		

}
