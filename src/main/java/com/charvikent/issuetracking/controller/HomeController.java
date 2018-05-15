package com.charvikent.issuetracking.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.charvikent.issuetracking.model.User;
import com.charvikent.issuetracking.service.UserService;

@Controller
public class HomeController {
	
	@Autowired UserService userService;
	
	@RequestMapping("/welcome")
	public String customwelcome(Model model) {
		return "welcome";
	}
	
	@RequestMapping("/homesc")
	public String scHome(Model model)
	{
		return "homesc";
	}
	
	@RequestMapping("/")
	public String customlogin(Model model) {
	//	System.out.println("login called at /");
		return "login";
	}
	@RequestMapping("/login")
	public String loginView(Model model) {
		System.out.println("login called at /login page");
		//User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 //userService.setLoginRecord(objuserBean.getId(),"login");

		return "login";
	}
	
	@RequestMapping("/logout")
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    
	    userService.setLoginRecord(objuserBean.getId(),"logout");
	    
	   // userService.setLoginRecord(objuserBean.getId(),"logout");
	    if (null != auth){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    SecurityContextHolder.clearContext();
	    if(null != auth) {
	    	SecurityContextHolder.getContext().setAuthentication(null);
	    }
	    System.out.println("Called Logout");
	    return "redirect:/login";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}
	
	@RequestMapping("/403")
	public String failureLogin(Model model) {
		return "403";
	}
	
	
	@RequestMapping("*")
	public String pag04e(Model model) {
		return "login";
	}
	
	

}
