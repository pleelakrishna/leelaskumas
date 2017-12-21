package com.charvikent.issuetracking.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
//import java.io.StringWriter;

//import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.apache.velocity.VelocityContext;
//import org.apache.velocity.app.VelocityEngine;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.charvikent.issuetracking.dao.ReportIssueDao;
import com.charvikent.issuetracking.dao.UserDao;
import com.charvikent.issuetracking.model.ReportIssue;
import com.charvikent.issuetracking.model.User;
import com.charvikent.issuetracking.service.CategoryService;
import com.charvikent.issuetracking.service.DepartmentService;
import com.charvikent.issuetracking.service.PriorityService;
//import com.charvikent.issuetracking.service.AdminService;
import com.charvikent.issuetracking.service.ReportIssueService;
import com.charvikent.issuetracking.service.SeverityService;
import com.charvikent.issuetracking.service.UserService;

@Controller
public class CreateTicketIssueController {
	//private static final String SUBJECT_MAIL_TICKET_ISSUED = "Ticket Issued";

	//@Autowired
	//private AdminService adminService;

	@Autowired
	private UserService userService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private PriorityService priorityService;

	@Autowired
	private SeverityService severityService;

	@Autowired
	private ReportIssueService reportIssueService;
	@Autowired
	private DepartmentService  departmentService;

	@Autowired
	private ReportIssueDao reportIssueDao;

	//@Autowired
	//private VelocityEngine velocityEngine;

	//@Autowired
	//private JavaMailSender sender;
	@Autowired
	UserDao userDao;


	@RequestMapping("/createTicketIssues")
	public String createReportIssues(Model model) {
		System.out.println("----createTicketIssues home-----");
		model.addAttribute("createTicketIssues", new ReportIssue());
		// model.addAttribute("adminNames", userService.getAdminNames());
		model.addAttribute("userNames", userService.getUserName());
		model.addAttribute("category",categoryService.getCategoryNames());
		model.addAttribute("departmentNames",departmentService.getDepartmentNames());
		model.addAttribute("severity", severityService.getSeverityNames());
		model.addAttribute("priority",  priorityService.getPriorityNames());
		return "createTicketIssues";

	}

	@RequestMapping(value = "/createTicketIssues", method = RequestMethod.POST)
	public String saveAdmin(@Valid @ModelAttribute("createTicketIssues") ReportIssue reportIssue,
			@RequestParam("file") MultipartFile file, BindingResult results, Model model, HttpServletRequest request,
			RedirectAttributes redir) {

		String name = null;
		//String sTomcatRootPath = null;
		//String sDirPath = null;
		String filepath = null;
		File serverFile = null;
		try {
			if (!file.isEmpty()) {
				byte[] bytes = file.getBytes();
				name = file.getOriginalFilename();
				/*
				 * int n=name.lastIndexOf("."); if(n == -1) { filepath = name;
				 * }else { String ext1 = FilenameUtils.getExtension(name);
				 * filepath= name+"."+ext1; //filepath=
				 * name+file.getContentType(); }
				 */ System.out.println("+++++++++++++" + filepath);
				String rootPath = request.getSession().getServletContext().getRealPath("/");
				// String rootPath = "/home/raju/Charvikent Pvt
				// Ltd/KhaibarGas/src/main/webapp";
				System.out.println("rootpath ---------" + rootPath);
				File dir = new File(rootPath + File.separator + "reportDocuments");
				if (!dir.exists()) {
					dir.mkdirs();
				}

				serverFile = new File(dir.getAbsolutePath() + File.separator + name);
				try {
					try (InputStream is = file.getInputStream();
							BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile))) {
						int i;
						while ((i = is.read()) != -1) {
							stream.write(i);
						}
						stream.flush();
					}
				} catch (IOException e) {
					System.out.println("error : " + e);
				}
				System.out.println("********after file write**********");
				filepath = "reportDocuments/" + name;
				reportIssue.setUploadfile(filepath);
				/*
				 * sTomcatRootPath = System.getProperty("catalina.base");
				 * sDirPath = sTomcatRootPath + File.separator + "webapps"+
				 * File.separator + "reportDocuments"+ File.separator;
				 * System.out.println(sDirPath); File file1 = new
				 * File(sDirPath); file.transferTo(file1);
				 */
			}

			System.out.print("create report issue block");

			if (results.hasErrors()) {
				//System.out.println("has some errors");
				return "redirect:/";
			}

			reportIssueService.saveReportIssue(reportIssue,serverFile);


		} catch (Exception ex) {
			System.out.println(ex);
			ex.printStackTrace();

		}

		redir.addFlashAttribute("msg", "Ticket Issued Successfully");
		redir.addFlashAttribute("cssMsg", "success");
		return "redirect:viewReportIssues";
	}

	@RequestMapping("/viewReportIssues")
	public String viewReportIssues(Model model) {
		System.out.println("view report Issues Block");

		model.addAttribute("allReportIssues", reportIssueService.getAllReportIssues());

		return "viewReportIssues";
	}


	@RequestMapping("/editIssue")
	public String createReportIssues(@RequestParam(value="id", required=true) String id,Model model) {


         System.out.print(id);
         
         System.out.print("enter to edit issue");
		
		ReportIssue issue = reportIssueService.getReportIssueById(Integer.parseInt(id));
		model.addAttribute("cissue", issue);
		
		model.addAttribute("departments", userService.getDepartments());
		model.addAttribute("userNames", userService.getUserName());
		model.addAttribute("category",categoryService.getCategoryNames());
		model.addAttribute("severity", severityService.getSeverityNames());
		model.addAttribute("priority",  priorityService.getPriorityNames());
		

		//return "updateIssue";
		return "editTicket";

	}

	@RequestMapping(value = "/updateIssue", method = RequestMethod.POST)
	public String saveIssue(@Valid @ModelAttribute ReportIssue reportIssue, RedirectAttributes redir) {

		
		reportIssueService.updateIssue(reportIssue);

		redir.addFlashAttribute("msg", "Record Updated Successfully");
		redir.addFlashAttribute("cssMsg", "warning");

		return "redirect:viewReportIssues";

   }
	
	@RequestMapping(value = "/viewTicket")
	public String viewIssue(
	    @RequestParam(value="id", required=true) String id,Model model){
		
		System.out.print(id);
		
		ReportIssue issue = reportIssueService.getReportIssueById(Integer.parseInt(id));
		model.addAttribute("cissue", issue);
		model.addAttribute("departments", userService.getDepartments());
		model.addAttribute("userNames", userService.getUserName());
		model.addAttribute("category",categoryService.getCategoryNames());
		model.addAttribute("severity", severityService.getSeverityNames());
		model.addAttribute("priority",  priorityService.getPriorityNames());
		
		
		
			return "ViewTicket";

	}
	
}
