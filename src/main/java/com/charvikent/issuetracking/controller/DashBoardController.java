package com.charvikent.issuetracking.controller;

import java.util.Set;

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
	
	
   
	@RequestMapping("/dashBoard")
	public String showDashBoard(Model model)
	{
		
		 model.addAttribute("statusCount" ,reportIssueService.getCountByStatusWise());
		 model.addAttribute("gapAndCount", reportIssueService.getGapAndCount());
		 model.addAttribute("severityCount",dashBoardService.getSeverityWiseCount() );
		 model.addAttribute("severityCountsBY",dashBoardService.getSeverityWiseCountsByAssignedBy() );
		 
		 model.addAttribute("SevMonitoredCounts", dashBoardService.getSeverityCountsUnderReportTo());
			
		 
		 return "dashBoard";
		
	}
	
	
	@RequestMapping(value = "/severity")
	public String  tasksFilterByseverityOnAssignedTo(	@RequestParam(value="id", required=true) String sev,Model model,HttpServletRequest request,HttpSession session){
		Set<ReportIssue> listOrderBeans = null;
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
		Set<ReportIssue> listOrderBeans = null;
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
	
	
	@RequestMapping(value = "/severityReportTo")
	public String tasksFilterByseverityOnReportTo(	@RequestParam(value="id", required=true) String sev,Model model,HttpServletRequest request,HttpSession session){
		Set<ReportIssue> listOrderBeans = null;
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
				listOrderBeans =  dashBoardService.GetTaskBySeverityUnderReportTo(sev);
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
	
	

