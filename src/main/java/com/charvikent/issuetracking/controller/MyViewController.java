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
		
		model.addAttribute("reportedByMe", reportIssueService.getIssuesByAssignBy(String.valueOf(objuserBean.getId())));
		
		return "myView";
	}

}
