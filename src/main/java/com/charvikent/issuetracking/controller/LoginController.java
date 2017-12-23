package com.charvikent.issuetracking.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.charvikent.issuetracking.model.Admin;
import com.charvikent.issuetracking.model.User;
import com.charvikent.issuetracking.service.UserService;

@Controller
//@RequestMapping(value = "/kptts")
public class LoginController {
	@Autowired UserService userService;

	@RequestMapping(value = "/")
	public String LoginHome(Map<String, Object> model1, ModelMap model, HttpServletRequest request,
			HttpSession session) {
		System.out.println("LoginHome page...");
		model.addAttribute("adminForm", new Admin());
//		User loginBean = new User();
//		model.put("adminForm", loginBean);
		try {
			User objuserBean = (User) session.getAttribute("cacheUserBean");
			if (objuserBean != null) {
				return "redirect:summary";
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);

		}
		return "login";
	}

	@RequestMapping(value = "/loginAction")
	public String loginAction(@Valid @ModelAttribute("adminForm")  Admin admin, BindingResult result,
			ModelMap model, HttpServletRequest request, HttpSession session, HttpServletResponse responses,
			RedirectAttributes redir) {
		System.out.println("loginAction page...");
		User lbean = null;
//		JSONObject obj = new JSONObject();
//		String object1 = null;
		try {
			if (result.hasErrors()) {
				// model.addAttribute("newUser", userObj);
				return "login";
			}
			lbean = userService.findWithName(admin.getName(),admin.getPassword());
			if(lbean != null){
				 session.setAttribute("cacheUserBean", lbean);
				 userService.setLoginRecord(lbean.getId(),"login");
				 return "redirect:summary";
			 }else{
				 redir.addFlashAttribute("msg","Invalid Crediantals");
				 redir.addFlashAttribute("cssMsg", "danger");
				 return  "redirect:/";
			 }
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);

		}
		return null;
	}

	@RequestMapping(value = "/logoutHome")
	public String logoutHome(ModelMap model, HttpServletRequest request, HttpSession objSession,
			HttpServletResponse response) {
		System.out.println("logout page...");
		try {

			HttpSession session = request.getSession(false);
			User objuserBean = (User) session.getAttribute("cacheUserBean");
			if (objuserBean != null) {
				 userService.setLoginRecord(objuserBean.getId(),"logout");
				session.removeAttribute("cacheUserBean");
				session.removeAttribute("cacheGuest");
				session.removeAttribute("rolId");
				session.removeAttribute("userName");
				session.invalidate();
				response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");// HTTP
																							// 1.1
				response.setHeader("Pragma", "no-cache"); // HTTP 1.0
				response.setDateHeader("Expires", -1); // prevents caching at
														// the proxy server
				// String baseUrl = MiscUtils.getBaseUrl(request);
				// System.out.println(baseUrl);
				// response.sendRedirect(baseUrl+"/LoginHome1.htm" );
				// response.sendRedirect(request.getContextPath() +
				// "/LoginHome");
			}
			return "redirect:/";
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return "redirect:/";
	}
}
