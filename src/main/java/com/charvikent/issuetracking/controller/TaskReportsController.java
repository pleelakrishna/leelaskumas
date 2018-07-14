package com.charvikent.issuetracking.controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.charvikent.issuetracking.config.FilesStuff;
import com.charvikent.issuetracking.dao.KpHistoryDao;
import com.charvikent.issuetracking.dao.NotificationsFrequencyDao;
import com.charvikent.issuetracking.model.KpStatusLogs;
import com.charvikent.issuetracking.model.ReportIssue;
import com.charvikent.issuetracking.model.User;
import com.charvikent.issuetracking.service.CategoryService;
import com.charvikent.issuetracking.service.KpHistoryService;
import com.charvikent.issuetracking.service.MastersService;
import com.charvikent.issuetracking.service.PriorityService;
import com.charvikent.issuetracking.service.ReportIssueService;
import com.charvikent.issuetracking.service.SeverityService;
import com.charvikent.issuetracking.service.TasksSelectionService;
import com.charvikent.issuetracking.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class TaskReportsController {
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
	TasksSelectionService tasksSelectionService;
	
	@Autowired
	KpHistoryDao kpHistoryDao;
	
	@Autowired
	KpHistoryService kpHistoryService;
	@Autowired
	NotificationsFrequencyDao notificationsFrequencyDao;
	
	
	@RequestMapping("/taskReports")
	public String  department( @ModelAttribute("taskf")  ReportIssue taskf, Model model , HttpServletRequest request,HttpSession session) {
		Set<ReportIssue> listOrderBeans = null;
		ObjectMapper objectMapper = null;
		String sJson = null;
		
	/*	model.addAttribute("taskf", new ReportIssue());*/
		model.addAttribute("subTaskf", new KpStatusLogs());   // model attribute for formmodel popup
		model.addAttribute("severity", severityService.getSeverityNames());
		model.addAttribute("priority", priorityService.getPriorityNames());
		model.addAttribute("userNames", userService.getUserName());
		model.addAttribute("category", categoryService.getCategoryNames());
		//model.addAttribute("departmentNames", mastersService.getDepartmentNames());
		model.addAttribute("kpstatuses", mastersService.getKpStatues());
		model.addAttribute("tasksSelection", tasksSelectionService.getTasksSelectionMap());
		
		model.addAttribute("departmentNames", mastersService.getSortedDepartments());
		
		model.addAttribute("NotificationsFrequency", notificationsFrequencyDao.getNotificationsFrequencyesMap());
		
		User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String id=String.valueOf(objuserBean.getId());
		
		model.addAttribute("objuserBean", objuserBean);
		
		try {
			listOrderBeans = taskService.getissuesByselectionAssignBy(id);
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
		
		
		return "taskReports";
	
	}

}
