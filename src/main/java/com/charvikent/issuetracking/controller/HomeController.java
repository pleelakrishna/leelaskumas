package com.charvikent.issuetracking.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	
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
		return "login";
	}
	@RequestMapping("/login")
	public String loginView(Model model) {
		return "login";
	}
	
	@RequestMapping("/logout")
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (null != auth){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    SecurityContextHolder.clearContext();
	    if(null != auth) {
	    	SecurityContextHolder.getContext().setAuthentication(null);
	    }
	    
	    return "redirect:/";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}
	
	@RequestMapping("/403")
	public String failureLogin(Model model) {
		return "403";
	}
	
	

}
