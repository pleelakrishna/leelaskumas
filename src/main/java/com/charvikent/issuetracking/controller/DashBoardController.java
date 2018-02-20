package com.charvikent.issuetracking.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.charvikent.issuetracking.model.User;
import com.charvikent.issuetracking.service.DashBoardService;
import com.charvikent.issuetracking.service.ReportIssueService;

@Controller
public class DashBoardController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	DashBoardService dashBoardService;
	
	
	@Autowired
	private ReportIssueService reportIssueService;
	
	
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
		return "dashBoard";
		
	}
	
	
	@RequestMapping(value = "/severity")
	public String tasksFilter(	@RequestParam(value="id", required=true) String id,Model model){
		
		
		return "tasksFilter";

	}

	
	
	
	}
	
	

