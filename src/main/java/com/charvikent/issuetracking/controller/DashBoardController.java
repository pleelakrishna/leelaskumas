package com.charvikent.issuetracking.controller;

import java.util.List;
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
import com.charvikent.issuetracking.dao.DashBoardDao;
import com.charvikent.issuetracking.dao.NotificationsFrequencyDao;
import com.charvikent.issuetracking.model.DashBordByCategory;
import com.charvikent.issuetracking.model.DashBordByStatus;
import com.charvikent.issuetracking.model.KpStatusLogs;
import com.charvikent.issuetracking.model.ReportIssue;
import com.charvikent.issuetracking.model.User;
import com.charvikent.issuetracking.service.CategoryService;
import com.charvikent.issuetracking.service.DashBoardService;
import com.charvikent.issuetracking.service.KpHistoryService;
import com.charvikent.issuetracking.service.MastersService;
import com.charvikent.issuetracking.service.PriorityService;
import com.charvikent.issuetracking.service.ReportIssueService;
import com.charvikent.issuetracking.service.SeverityService;
import com.charvikent.issuetracking.service.TasksSelectionService;
import com.charvikent.issuetracking.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
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
	
	@Autowired
	KpHistoryService kpHistoryService;
	
	@Autowired
	DashBoardDao dashBoardDao;
	@Autowired
	NotificationsFrequencyDao notificationsFrequencyDao;
	
	
	
   
	@RequestMapping("/dashBoard")
	public String showDashBoard(Model model,HttpServletRequest request,HttpSession session) throws JsonProcessingException
	{
		
		 model.addAttribute("statusCount" ,reportIssueService.getCountByStatusWise());
		 model.addAttribute("gapAndCount", reportIssueService.getGapAndCount());
		 model.addAttribute("severityCount",dashBoardService.getSeverityWiseCount() );
		 model.addAttribute("severityCountsBY",dashBoardService.getSeverityWiseCountsByAssignedBy() );
		 
		 model.addAttribute("ackdetails", dashBoardService.getAllTasksForAck());
		 
		 model.addAttribute("lastLoginTime", dashBoardService.getLastLoginTime());
		 
		 model.addAttribute("deptCounts", dashBoardService.getDepartmentCounts());
		 
		 model.addAttribute("deptCountsForClosed", dashBoardService.getDepartmentCountsForClosed());
		 
		 User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			
	User userDesignation= userService.getUserDesignationById(objuserBean.getId());
		
		 session.setAttribute("userDesignationSession", userDesignation);
		 
		 ObjectMapper deptmapper =new ObjectMapper();
		String deptcountjson = deptmapper.writeValueAsString(dashBoardService.getDepartmentCounts());
		String deptcountclosedjson = deptmapper.writeValueAsString(dashBoardService.getDepartmentCountsForClosed());
		request.setAttribute("deptcountjson", deptcountjson);
		request.setAttribute("deptcountclosedjson", deptcountclosedjson);
		
		System.out.println(deptcountjson);
		 
		 
		
		 //System.out.println(dashBoardService.getAllTasksForAck());
		 
		 
		 model.addAttribute("SevMonitoredCounts", dashBoardService.getSeverityCountsUnderReportTo());
		//model.addAttribute("byCategory",dashBoardService.getCategory() );	
		List<DashBordByCategory> list=null;
		List<DashBordByStatus> byStatusList=null;
		try {
			String json = null;
			list = dashBoardService.getCategory();
			byStatusList=dashBoardService.getStatusList();
			ObjectMapper objmapper = new ObjectMapper();
			if(list !=null ) {
				json = objmapper.writeValueAsString(list);
				
				request.setAttribute("list", json);
				}
			if(byStatusList !=null) {
			json =objmapper.writeValueAsString(byStatusList);
			request.setAttribute("byStatusList", json);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		 
		 //model.addAttribute("notifications", kpHistoryService.getHeaderNotifications());
		// model.addAttribute("acknotification", kpHistoryService.getHeaderNotificationsforack());
		 
		// session.setAttribute("acknotification", kpHistoryService.getHeaderNotificationsforack());
		 
		 //session.setAttribute("notifications", kpHistoryService.getHeaderNotifications());
		 
		 
		// System.out.println( kpHistoryService.getHeaderNotificationsforack());
		 
		 return "dashBoard";
		
	}
	
	
	@RequestMapping(value = "/severity")
	public String  tasksFilterByseverityOnAssignedTo(@RequestParam(value="id", required=true) String sev,Model model,HttpServletRequest request,HttpSession session){
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
		
		model.addAttribute("NotificationsFrequency", notificationsFrequencyDao.getNotificationsFrequencyesMap());
		
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
		
		model.addAttribute("NotificationsFrequency", notificationsFrequencyDao.getNotificationsFrequencyesMap());
		
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
		
		model.addAttribute("NotificationsFrequency", notificationsFrequencyDao.getNotificationsFrequencyesMap());
		
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
	
	
	
	/**
	 * timeline is string and 0 is loop iterate value in ddashboard,sjp page
	 * 
	 *  loop interate using jstl tag with varstatus property
	 *
	 */
	@RequestMapping(value = "/timeline0")
	public String timelineTasksByOpen(	@RequestParam(value="range", required=true) String range,Model model,HttpServletRequest request,HttpSession session){
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
		
		
		model.addAttribute("NotificationsFrequency", notificationsFrequencyDao.getNotificationsFrequencyesMap());
		
		User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String id=String.valueOf(objuserBean.getId());
		
		model.addAttribute("objuserBean", objuserBean);
		
			
		
			try {
				listOrderBeans = dashBoardService.getAllTasks(range);
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
	
	
	@RequestMapping(value = "/statusDashBord")
	public String tasksByStatus(	Model model,HttpServletRequest request,HttpSession session){
		Set<ReportIssue> listOrderBeans = null;
		ObjectMapper objectMapper = null;
		String sJson = null;
		
		String status=null;
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
		
		model.addAttribute("NotificationsFrequency", notificationsFrequencyDao.getNotificationsFrequencyesMap());
		
		User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String id=String.valueOf(objuserBean.getId());
		
		model.addAttribute("objuserBean", objuserBean);
		
			
		
			try {
				status = request.getParameter("status");
				listOrderBeans =  dashBoardService.getTasksByStatusListDashBord(status);
				if (listOrderBeans != null && listOrderBeans.size() > 0) {
					objectMapper = new ObjectMapper();
					sJson = objectMapper.writeValueAsString(listOrderBeans);
					request.setAttribute("allOrders1", sJson);
				 //System.out.println("##############3"+sJson);
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
	
	
	@RequestMapping(value = "/categoryDashBord")
	public String taskscategoryOnReportTo(	Model model,HttpServletRequest request,HttpSession session){
		Set<ReportIssue> listOrderBeans = null;
		ObjectMapper objectMapper = null;
		String sJson = null;
		
		String status=null;
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
		
		model.addAttribute("NotificationsFrequency", notificationsFrequencyDao.getNotificationsFrequencyesMap());
		
		User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String id=String.valueOf(objuserBean.getId());
		
		model.addAttribute("objuserBean", objuserBean);
		
			
		
			try {
				status = request.getParameter("status");
				String categoryId =request.getParameter("categoryId");
				listOrderBeans =  dashBoardService.getTasksByCategoryListDashBord(status,categoryId);
				if (listOrderBeans != null && listOrderBeans.size() > 0) {
					objectMapper = new ObjectMapper();
					sJson = objectMapper.writeValueAsString(listOrderBeans);
					request.setAttribute("allOrders1", sJson);
				 //System.out.println("##############3"+sJson);
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
	/**
	 * timeline is string and 1 is loop iterate value in ddashboard,sjp page
	 * 
	 *  loop interate using jstl tag with varstatus property
	 *
	 */
	
	@RequestMapping(value = "/timeline1")
	public String timelineTasksByclose(	@RequestParam(value="range", required=true) String range,Model model,HttpServletRequest request,HttpSession session){
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
		
		model.addAttribute("NotificationsFrequency", notificationsFrequencyDao.getNotificationsFrequencyesMap());
		
		User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String id=String.valueOf(objuserBean.getId());
		
		model.addAttribute("objuserBean", objuserBean);
		
			
		
			try {
				listOrderBeans = dashBoardService.getAllTasksByclosed(range);
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
	

	
	/**
	 * timeline is string and 2 is loop iterate value in ddashboard,sjp page
	 * 
	 *  loop interate using jstl tag with varstatus property
	 *
	 */
	@RequestMapping(value = "/timeline2")
	public String timelineTasksByBalaenced(	@RequestParam(value="range", required=true) String range,Model model,HttpServletRequest request,HttpSession session){
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
		
		
		model.addAttribute("NotificationsFrequency", notificationsFrequencyDao.getNotificationsFrequencyesMap());
		
		User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String id=String.valueOf(objuserBean.getId());
		
		model.addAttribute("objuserBean", objuserBean);
		
			
		
			try {
				listOrderBeans = dashBoardService.getAllTasksByBalenced(range);
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
	
	
	@RequestMapping(value = "/departmentwise")
	public String tasksFilterByDepartmentWise(	@RequestParam(value="id", required=true) String dept,Model model,HttpServletRequest request,HttpSession session){
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
		
		model.addAttribute("NotificationsFrequency", notificationsFrequencyDao.getNotificationsFrequencyesMap());
		
			
		
			try {
				listOrderBeans = dashBoardService.getTasksByDepartmentWise(dept);
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
	
	
	@RequestMapping(value = "/deptAll")
	public String DepartmentwisedataByAll(	@RequestParam(value="id", required=true) String deptname,Model model,HttpServletRequest request,HttpSession session){
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
		
		model.addAttribute("NotificationsFrequency", notificationsFrequencyDao.getNotificationsFrequencyesMap());
		
		User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String id=String.valueOf(objuserBean.getId());
		
		model.addAttribute("objuserBean", objuserBean);
		
			
		
			try {
				listOrderBeans = dashBoardService.getTasksByDepartmentWise(deptname);
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
	
	@RequestMapping(value = "/deptClosed")
	public String DepartmentwisedataByClosed(	@RequestParam(value="id", required=true) String deptname,Model model,HttpServletRequest request,HttpSession session){
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
		
		model.addAttribute("NotificationsFrequency", notificationsFrequencyDao.getNotificationsFrequencyesMap());
		
			
		
			try {
				listOrderBeans = dashBoardService.getTasksBydepartmentClosed(deptname);
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
	
	@RequestMapping(value = "/deptBalanced")
	public String DepartmentwisedataByBalanced(	@RequestParam(value="id", required=true) String deptname,Model model,HttpServletRequest request,HttpSession session){
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
		
		model.addAttribute("NotificationsFrequency", notificationsFrequencyDao.getNotificationsFrequencyesMap());
		
			
		
			try {
				listOrderBeans = dashBoardService.getTasksBydepartmentBalanced(deptname);
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
	
	

