package com.charvikent.issuetracking.controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.charvikent.issuetracking.model.Designation;
import com.charvikent.issuetracking.model.ReportIssue;
import com.charvikent.issuetracking.model.User;
import com.charvikent.issuetracking.service.DashBoardService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class DashBoardController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	DashBoardService dashBoardService;
	
	
	@RequestMapping("/dashBoard")
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
			listOrderBeans = dashBoardService.getIssuesByAssignBy(String.valueOf(objuserBean.getId()));
			if (listOrderBeans != null && listOrderBeans.size() > 0) {
				objectMapper = new ObjectMapper();
				sJson = objectMapper.writeValueAsString(listOrderBeans);
				System.out.println(sJson);
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
				System.out.println(sJson);
				request.setAttribute("allOrders1to", sJson);
				// System.out.println(sJson);
			} 
			{
				objectMapper = new ObjectMapper();
				sJson = objectMapper.writeValueAsString(listOrderBeansTo);
				request.setAttribute("allOrders1to", "''");
			}
			
			listOrderBeansRe = dashBoardService.getIssuesByAssignToResolved(String.valueOf(objuserBean.getId()));
			if (listOrderBeansRe != null && listOrderBeansRe.size() > 0) {
				objectMapper = new ObjectMapper();
				sJson = objectMapper.writeValueAsString(listOrderBeansRe);
				System.out.println(sJson);
				request.setAttribute("allOrders1re", sJson);
				// System.out.println(sJson);
			} 
			{
				objectMapper = new ObjectMapper();
				sJson = objectMapper.writeValueAsString(listOrderBeansRe);
				request.setAttribute("allOrders1re", "''");
			}
			
			listOrderBeansMo = dashBoardService.getRecentlyModified(String.valueOf(objuserBean.getId()));
			if (listOrderBeansMo != null && listOrderBeansMo.size() > 0) {
				objectMapper = new ObjectMapper();
				sJson = objectMapper.writeValueAsString(listOrderBeansMo);
				System.out.println(sJson);
				request.setAttribute("allOrders1mo", sJson);
				// System.out.println(sJson);
			} 
			{
				objectMapper = new ObjectMapper();
				sJson = objectMapper.writeValueAsString(listOrderBeansMo);
				request.setAttribute("allOrders1Mo", "''");
			}
			listOrderBeansMn = dashBoardService.getIssuesByAssignToUnderMonitor(String.valueOf(objuserBean.getId()));
			if (listOrderBeansMn != null && listOrderBeansMn.size() > 0) {
				objectMapper = new ObjectMapper();
				sJson = objectMapper.writeValueAsString(listOrderBeansMn);
				System.out.println(sJson);
				request.setAttribute("allOrders1mn", sJson);
				// System.out.println(sJson);
			}
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


}
