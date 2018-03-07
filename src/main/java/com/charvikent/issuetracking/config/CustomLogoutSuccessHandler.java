package com.charvikent.issuetracking.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

import com.charvikent.issuetracking.model.User;
import com.charvikent.issuetracking.service.UserService;

@Component
public class CustomLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler implements LogoutSuccessHandler {

	/*
	 * @Autowired private AuditService auditService;
	 * 
	 * 
	 */
	
	@Autowired UserService userService;
	
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {

		//String refererUrl = request.getHeader("Referer");
		
		User objuserBean = (User)authentication.getPrincipal();
		userService.setLoginRecord(objuserBean.getId(),"logout");

		String URL = request.getContextPath() + "/";
		response.setStatus(HttpStatus.OK.value());
		response.sendRedirect(URL);
	}

}
