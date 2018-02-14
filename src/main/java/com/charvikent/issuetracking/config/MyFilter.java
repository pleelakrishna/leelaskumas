package com.charvikent.issuetracking.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/*@Component
@Order(1)
*/public class MyFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
		      throws IOException, ServletException {
		    
	      String url = req instanceof HttpServletRequest ?
	                ((HttpServletRequest) req).getRequestURL().toString() : "N/A";
	                
	                System.out.println("from filter, processing url: "+url);


		   // System.out.println("MyFilter doFilter() is invoked.");
		   /* Enumeration<String> params = req.getParameterNames();
		    while (params.hasMoreElements()) {
		      String param=params.nextElement();
		      System. out.println("Parameter:"+param+"\tValue:"+req.getParameter(param));
		    }*/
		    
		    HttpServletRequest request = (HttpServletRequest) req;
		  //  System.out.println(request.getHeader("referer"));
		    HttpServletResponse response = (HttpServletResponse) res;
		    HttpSession session = request.getSession(false);
		    /* if (session == null || session.getAttribute("cacheUserBean") == null) {
		    	 System.out.println("hi"+request.getContextPath());
		        response.sendRedirect(request.getContextPath() + "login.html"); // No logged-in user found, so redirect to login page.
		    } else {
		   */
		    chain.doFilter(req, res);
		    
		    
		  }
		    

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
