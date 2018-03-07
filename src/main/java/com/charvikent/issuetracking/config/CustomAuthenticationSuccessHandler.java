package com.charvikent.issuetracking.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.charvikent.issuetracking.model.User;
import com.charvikent.issuetracking.service.UserService;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired UserService userService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		logger.info("AT onAuthenticationSuccess(...) function!");
		// set our response to OK status
		response.setStatus(HttpServletResponse.SC_OK);
		// Add save record here
		
		User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 userService.setLoginRecord(objuserBean.getId(),"login");
		

		response.sendRedirect("dashBoard");
	}

}
