package com.charvikent.issuetracking.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.charvikent.issuetracking.model.User;
import com.charvikent.issuetracking.service.ReportIssueService;
@Controller
public class MyViewController {
	@Autowired
	HttpSession session;
	@Autowired
	private ReportIssueService reportIssueService;
	
	
	@RequestMapping("/myView")
	public String myview(Model model) {
		User objuserBean = (User) session.getAttribute("cacheUserBean");
		
	
		//System.out.println(reportIssueService.getIssuesByAssignBy(String.valueOf(objuserBean.getId())));
		
		model.addAttribute("reportedByMe", reportIssueService.getIssuesByAssignBy(String.valueOf(objuserBean.getId())));
		
		model.addAttribute("assignToMe", reportIssueService.getIssuesByAssignTo(String.valueOf(objuserBean.getId())));
		model.addAttribute("gapAndCount", reportIssueService.getGapAndCount());
		System.out.println("Problem here occured");
		System.out.println(reportIssueService.getGapAndCount());
		
		return "myView";
		
	}

}
