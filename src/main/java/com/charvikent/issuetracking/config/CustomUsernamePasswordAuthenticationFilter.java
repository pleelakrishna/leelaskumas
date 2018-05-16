package com.charvikent.issuetracking.config;


import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.filter.GenericFilterBean;

public class CustomUsernamePasswordAuthenticationFilter extends GenericFilterBean {
	
	
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        if(servletRequest instanceof HttpServletRequest) {
            HttpServletRequest r = (HttpServletRequest)servletRequest;
            
          /* Enumeration<String> str = r.getAttributeNames();
           
           while (str.hasMoreElements()) {
               System.out.println(str.nextElement()); 
            }*/
           
          
            
            
           // System.out.println("Filter" + loginType);
        
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}