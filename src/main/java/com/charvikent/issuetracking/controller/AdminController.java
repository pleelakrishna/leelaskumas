package com.charvikent.issuetracking.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.RedirectAttributesMethodArgumentResolver;
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

	/*@RequestMapping("/summary")
	public String summary(Model model) {
		return "summary";
	}

//	@RequestMapping(value= {"/createUser","/deleteUser/createUser"})
	@RequestMapping("/createUser")
	public String homeUser(Model model,HttpServletRequest request) {
		ObjectMapper objectMapper = null;
		String sJson =null;
		try {
		model.addAttribute("userForm", new User());
		model.addAttribute("departments", userService.getDepartments());
		model.addAttribute("roles", userService.getRoles());
		model.addAttribute("userNames", userService.getUserName());
		model.addAttribute("reportto",userService.getUserName());
		model.addAttribute("allUsers", userService.getAllUsers());
		objectMapper = new ObjectMapper();
		sJson = objectMapper.writeValueAsString(userService.getAllUsers());
		request.setAttribute("allOrders1", sJson);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return "user";
	}

	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public String saveAdmin(@Valid @ModelAttribute  User user, BindingResult bindingresults,RedirectAttributes redir) throws IOException {

		System.out.print("create user block");
		if (bindingresults.hasErrors()) {
			System.out.println("has some errors");
			return "redirect:/createUser";
		}

		// user.setPassword(passwordEncoder.encode(user.getPassword()));
		userService.saveUser(user);

		redir.addFlashAttribute("msg", "Employee Inserted Successfully");
		redir.addFlashAttribute("cssMsg", "success");

		return "redirect:createUser";
	}

	@RequestMapping("/viewUsers")
	public String pageView(Model model) {
		System.out.println("view User Block");

		model.addAttribute("allUsers", userService.getAllUsers());

		return "viewUsers";
	}

	@RequestMapping(value = "/deleteUser")
	public @ResponseBody String deleteUser(@RequestParam("id") String id,@RequestParam("enabled") String enabled, RedirectAttributes redir) {

		userService.deleteUser(Integer.parseInt(id),enabled);

		redir.addFlashAttribute("msg", "Employee Deleted Successfully");
		redir.addFlashAttribute("cssMsg", "success");


		return null;

	}




	@RequestMapping(value = "/deleteUser")
	public @ResponseBody String deleteDept(User  objUser,ModelMap model,HttpServletRequest request,HttpSession session,BindingResult objBindingResult) {
		System.out.println("deleteEducation page...");
		List<User> listOrderBeans  = null;
		JSONObject jsonObj = new JSONObject();
		ObjectMapper objectMapper = null;
		String sJson=null;
		boolean delete = false;
		try{
			if(objUser.getId() != 0){
 				delete = userService.deleteUser(objUser.getId(),objUser.getEnabled());
 				if(delete){
 					jsonObj.put("message", "deleted");
 				}else{
 					jsonObj.put("message", "delete fail");
 				}
 			}

			listOrderBeans = userService.getAllUsers();
			 objectMapper = new ObjectMapper();
			if (listOrderBeans != null && listOrderBeans.size() > 0) {

				objectMapper = new ObjectMapper();
				sJson = objectMapper.writeValueAsString(listOrderBeans);
				request.setAttribute("allOrders1", sJson);
				jsonObj.put("allOrders1", listOrderBeans);
				// System.out.println(sJson);
			} else {
				objectMapper = new ObjectMapper();
				sJson = objectMapper.writeValueAsString(listOrderBeans);
				request.setAttribute("allOrders1", "''");
				jsonObj.put("allOrders1", listOrderBeans);
			}
		}catch(Exception e){
			e.printStackTrace();
	System.out.println(e);
			return String.valueOf(jsonObj);

		}
		return String.valueOf(jsonObj);
	}



	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String editProfile( Model model,HttpSession session) {

		User objuserBean = (User) session.getAttribute("cacheUserBean");

		Integer id=objuserBean.getId();
		return "redirect:edit?id="+id;

	}

	@RequestMapping(value = "/edit")
	public String bookmark(	@RequestParam(value="id", required=true) String id,Model model){
		User users = userService.getUserById(Integer.parseInt(id));
		User objuserBean = (User) session.getAttribute("cacheUserBean");
		model.addAttribute("userForm", users);
		model.addAttribute("departments", userService.getDepartments());
		model.addAttribute("roles", userService.getRoles());
		model.addAttribute("userNames", userService.getUserName());
		if("1".equals(objuserBean.getDesignation()))
			model.addAttribute("flag",false);
		else
			model.addAttribute("flag",true);
		return "user";

	}


	@RequestMapping(value = "/editUser", method = RequestMethod.POST)
	public String edit(@PathVariable("id") String id,@Valid @ModelAttribute User user, RedirectAttributes redir) {

		userService.updateUser(user);
		redir.addFlashAttribute("msg", "Employee Detailes Updated Successfully");
		redir.addFlashAttribute("cssMsg", "warning");
		return "redirect:createUser";

	}

	@RequestMapping("/changePassword")
	public String changePasswordHome(@ModelAttribute("changePassword") User user){

		return "changePassword";

	}
	@RequestMapping(value="/changePassword", method= RequestMethod.POST )
	public String changePassword(@ModelAttribute("changePassword") User user,RedirectAttributes redir,HttpServletRequest request){

		User objuserBean = (User) session.getAttribute("cacheUserBean");

		User users = userService.getUserById(objuserBean.getId());
		if(users.getPassword().equals(user.getPassword())) {

			users.setPassword(user.getCpassword());
			userService.updatePassword(users);
			redir.addFlashAttribute("msg", "Password Updated Successfully");
			redir.addFlashAttribute("cssMsg", "warning");
			return "redirect:/";
		}else {
			request.setAttribute("msg", "You Entered Wrong Password");
			request.setAttribute("cssMsg", "warning");
			return "changePassword";
		}



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
	
	*/
	
	@RequestMapping(value="/adminChangePassword", method= RequestMethod.POST )
	public String adminChangePassword(User user,RedirectAttributes redir,HttpServletRequest request){

		
		User users = userService.getUserById(user.getId());
		if(user.getNpassword()!=null) {

			users.setPassword(user.getNpassword());
			userService.updatePassword(users);
			redir.addFlashAttribute("msg", "Password Updated Successfully");
			redir.addFlashAttribute("cssMsg", "warning");
			
		}else {
			request.setAttribute("msg", "You Entered Wrong Password");
			request.setAttribute("cssMsg", "warning");
			return "changePassword";
		}
		return "redirect:/employee";
	}
}




