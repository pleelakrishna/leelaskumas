package com.charvikent.issuetracking.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
import com.charvikent.issuetracking.service.TasksSelectionService;
import com.charvikent.issuetracking.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class DashBoardController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	DashBoardService dashBoardService;
	
	
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
	private ReportIssueService reportIssueService;
	
	@Autowired
	TasksSelectionService tasksSelectionService;
	
	
	/*@RequestMapping("/dashBoard")
	public String  department( @ModelAttribute("designf")  Designation designf,Model model ,HttpServletRequest request) {
		Set<ReportIssue> listOrderBeans = null;
		Set<ReportIssue> listOrderBeansTo = null;
		Set<ReportIssue> listOrderBeansRe = null;
		Set<ReportIssue> listOrderBeansMo = null;
		Set<ReportIssue> listOrderBeansMn = null;
		ObjectMapper objectMapper = null;
		String sJson = null;
		User objuserBean = (User) session.getAttribute("cacheUserBean");
		try {
			listOrderBeans =  dashBoardService.getIssuesByAssignBy(String.valueOf(objuserBean.getId()));
			if (listOrderBeans != null && listOrderBeans.size() > 0) {
				objectMapper = new ObjectMapper();
				sJson = objectMapper.writeValueAsString(listOrderBeans);
				request.setAttribute("allOrders1by", sJson);
				// System.out.println(sJson);
			} 
			else {
				objectMapper = new ObjectMapper();
				sJson = objectMapper.writeValueAsString(listOrderBeans);
				request.setAttribute("allOrders1by", "''");
			}
			
			listOrderBeansTo = dashBoardService.getIssuesByAssignTo(String.valueOf(objuserBean.getId()));
			if (listOrderBeansTo != null && listOrderBeansTo.size() > 0) {
				objectMapper = new ObjectMapper();
				sJson = objectMapper.writeValueAsString(listOrderBeansTo);
				request.setAttribute("allOrders1to", sJson);
				// System.out.println(sJson);
			}
			else
			{
				objectMapper = new ObjectMapper();
				sJson = objectMapper.writeValueAsString(listOrderBeansTo);
				request.setAttribute("allOrders1to", "''");
			}
			
			listOrderBeansRe = dashBoardService.getIssuesByAssignToResolved(String.valueOf(objuserBean.getId()));
			if (listOrderBeansRe != null && listOrderBeansRe.size() > 0) {
				objectMapper = new ObjectMapper();
				sJson = objectMapper.writeValueAsString(listOrderBeansRe);
				request.setAttribute("allOrders1Re", sJson);
				// System.out.println(sJson);
			} 
			else
			{
				objectMapper = new ObjectMapper();
				sJson = objectMapper.writeValueAsString(listOrderBeansRe);
				request.setAttribute("allOrders1Re", "''");
			}
			
			listOrderBeansMo = dashBoardService.getRecentlyModified(String.valueOf(objuserBean.getId()));
			if (listOrderBeansMo != null && listOrderBeansMo.size() > 0) {
				objectMapper = new ObjectMapper();
				sJson = objectMapper.writeValueAsString(listOrderBeansMo);
				System.out.println(sJson);
				request.setAttribute("allOrders1Mo", sJson);
				// System.out.println(sJson);
			} 
			else
			{
				objectMapper = new ObjectMapper();
				sJson = objectMapper.writeValueAsString(listOrderBeansMo);
				request.setAttribute("allOrders1Mo", "''");
			}
			listOrderBeansMn = dashBoardService.getIssuesByAssignToUnderMonitor(String.valueOf(objuserBean.getId()));
			if (listOrderBeansMn != null && listOrderBeansMn.size() > 0) {
				objectMapper = new ObjectMapper();
				sJson = objectMapper.writeValueAsString(listOrderBeansMn);
				request.setAttribute("allOrders1Mn", sJson);
				// System.out.println(sJson);
			}
			else
			{
				objectMapper = new ObjectMapper();
				sJson = objectMapper.writeValueAsString(listOrderBeansMn);
				request.setAttribute("allOrders1Mn", "''");
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		
		return "dashBoard";
	
	}
*/
   
	@RequestMapping("/dashBoard")
	public String showDashBoard(Model model)
	{
		
		 model.addAttribute("statusCount" ,reportIssueService.getCountByStatusWise());
		 model.addAttribute("gapAndCount", reportIssueService.getGapAndCount());
		 model.addAttribute("severityCount",dashBoardService.getSeverityWiseCount() );
		 model.addAttribute("severityCountsBY",dashBoardService.getSeverityWiseCountsByAssignedBy() );
		 
		 model.addAttribute("SevMonitoredCounts", dashBoardService.getSeverityCountsUnderReportTo());
		 dashBoardService.GetTaskBySeverityUnderReportTo();	
		 
		 return "dashBoard";
		
	}
	
	
	@RequestMapping(value = "/severity")
	public String  tasksFilterByseverityOnAssignedTo(	@RequestParam(value="id", required=true) String sev,Model model,HttpServletRequest request,HttpSession session){
		List<ReportIssue> listOrderBeans = null;
		ObjectMapper objectMapper = null;
		String sJson = null;
		
		model.addAttribute("taskf", new ReportIssue());
		model.addAttribute("subTaskf", new KpStatusLogs());   // model attribute for formmodel popup
		model.addAttribute("severity", severityService.getSeverityNames());
		model.addAttribute("priority", priorityService.getPriorityNames());
		model.addAttribute("userNames", userService.getUserName());
		model.addAttribute("category", categoryService.getCategoryNames());
		//model.addAttribute("departmentNames", mastersService.getDepartmentNames());
		model.addAttribute("kpstatuses", mastersService.getKpStatues());
		model.addAttribute("tasksSelection", tasksSelectionService.getTasksSelectionMap());
		
		model.addAttribute("departmentNames", mastersService.getSortedDepartments());
		
		User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String id=String.valueOf(objuserBean.getId());
		
		model.addAttribute("objuserBean", objuserBean);
		
			
		
			try {
				listOrderBeans = dashBoardService.getTasksBySeverity(sev);
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
	
	
	
	@RequestMapping(value = "/severityby")
	public String tasksFilterByseverityOnAssignedBY(	@RequestParam(value="id", required=true) String sev,Model model,HttpServletRequest request,HttpSession session){
		List<ReportIssue> listOrderBeans = null;
		ObjectMapper objectMapper = null;
		String sJson = null;
		
		model.addAttribute("taskf", new ReportIssue());
		model.addAttribute("subTaskf", new KpStatusLogs());   // model attribute for formmodel popup
		model.addAttribute("severity", severityService.getSeverityNames());
		model.addAttribute("priority", priorityService.getPriorityNames());
		model.addAttribute("userNames", userService.getUserName());
		model.addAttribute("category", categoryService.getCategoryNames());
		//model.addAttribute("departmentNames", mastersService.getDepartmentNames());
		model.addAttribute("kpstatuses", mastersService.getKpStatues());
		model.addAttribute("tasksSelection", tasksSelectionService.getTasksSelectionMap());
		
		model.addAttribute("departmentNames", mastersService.getSortedDepartments());
		
		User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String id=String.valueOf(objuserBean.getId());
		
		model.addAttribute("objuserBean", objuserBean);
		
			
		
			try {
				listOrderBeans = dashBoardService.getTasksBySeverityOnAssignedBy(sev);
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

	
	
	
	}
	
	

