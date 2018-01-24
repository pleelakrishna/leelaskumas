package com.charvikent.issuetracking.controller;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.charvikent.issuetracking.dao.UserDao;
import com.charvikent.issuetracking.model.User;
import com.charvikent.issuetracking.service.UserService;

@Controller
public class AdminController {



	@Autowired
	private UserService userService;


	@Autowired
	UserDao userDao;

	@Autowired
	HttpSession session;

	@RequestMapping("/summary")
	public String summary(Model model) {
		return "summary";
	}

	@RequestMapping("/createUser")
	public String homeUser(Model model) {
		model.addAttribute("userForm", new User());
		model.addAttribute("departments", userService.getDepartments());
		model.addAttribute("roles", userService.getRoles());
		model.addAttribute("userNames", userService.getUserName());
		return "user";
	}

	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public String saveAdmin(@Valid @ModelAttribute  User user, BindingResult bindingresults,
			RedirectAttributes redir) throws IOException {

		System.out.print("create user block");
		if (bindingresults.hasErrors()) {
			System.out.println("has some errors");
			return "redirect:/";
		}

		// user.setPassword(passwordEncoder.encode(user.getPassword()));
		userService.saveUser(user);

		redir.addFlashAttribute("msg", "Record Inserted Successfully");
		redir.addFlashAttribute("cssMsg", "success");

		return "redirect:viewUsers";
	}

	@RequestMapping("/viewUsers")
	public String pageView(Model model) {
		System.out.println("view User Block");

		model.addAttribute("allUsers", userService.getAllUsers());

		return "viewUsers";
	}

	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("id") String id) {
		userService.deleteUser(Integer.parseInt(id));
		return "redirect:../viewUsers";

	}


	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String editProfile( Model model,HttpSession session) {

		User objuserBean = (User) session.getAttribute("cacheUserBean");

		Integer id=objuserBean.getId();
		return "redirect:edit?id="+id;

	}

	@RequestMapping(value = "/edit")
	public String bookmark(
			@RequestParam(value="id", required=true) String id,Model model){
		User users = userService.getUserById(Integer.parseInt(id));
		User objuserBean = (User) session.getAttribute("cacheUserBean");
		model.addAttribute("users", users);
		model.addAttribute("departments", userService.getDepartments());
		model.addAttribute("roles", userService.getRoles());
		model.addAttribute("userNames", userService.getUserName());
		if("1".equals(objuserBean.getDesignation()))
			model.addAttribute("flag",false);
		else 
			model.addAttribute("flag",true);
		return "editUser";

	}


	@RequestMapping(value = "/editUser", method = RequestMethod.POST)
	public String edit(@Valid @ModelAttribute User user, RedirectAttributes redir) {
		userService.updateUser(user);
		redir.addFlashAttribute("msg", "Record Updated Successfully");
		redir.addFlashAttribute("cssMsg", "warning");
		return "redirect:viewUsers";

	}




	@RequestMapping("/getCurrentpwd")
	public  @ResponseBody  String cylinderTypes(HttpServletRequest request, HttpSession session)
	{
		if(null != request.getParameter("cpwd"))
		{//return cylindermasterDao.getCylinderCapacityByID(Integer.parseInt(request.getParameter("cpwd")));

			User user=userService.getUserById(Integer.parseInt(request.getParameter("cuid")));

			return user.getPassword();
		}
		else
			return "No data found";
	}


	@RequestMapping("/updatepwd")
	public  @ResponseBody  String setUpdatePwd(HttpServletRequest request, HttpSession session)
	{
		if(null != request.getParameter("upwd"))
		{
			User user=userService.getUserById(Integer.parseInt(request.getParameter("cuid")));
			user.setPassword(request.getParameter("upwd").trim());

			userService.updateUser(user);

			return user.getPassword();
		}
		else
			return "No data found";
	}
	
	@RequestMapping("/getUserName")
	public  @ResponseBody  Boolean getUserName(HttpServletRequest request, HttpSession session)
	{
		String username=request.getParameter("username");
		
		username = username.replaceAll("\\s+","");
		return userService.checkUserExist(username);
	}
	
}




