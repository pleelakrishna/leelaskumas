package com.charvikent.issuetracking.controller;

import java.io.IOException;
//import java.io.StringWriter;

import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

import com.charvikent.issuetracking.config.FilesStuff;
import com.charvikent.issuetracking.dao.ReportIssueDao;
import com.charvikent.issuetracking.dao.UserDao;
import com.charvikent.issuetracking.model.ReportIssue;
import com.charvikent.issuetracking.service.CategoryService;
import com.charvikent.issuetracking.service.DepartmentService;
import com.charvikent.issuetracking.service.PriorityService;
//import com.charvikent.issuetracking.service.AdminService;
import com.charvikent.issuetracking.service.ReportIssueService;
import com.charvikent.issuetracking.service.SeverityService;
import com.charvikent.issuetracking.service.UserService;

@Controller
public class CreateTicketIssueController {
	// private static final String SUBJECT_MAIL_TICKET_ISSUED = "Ticket Issued";

	// @Autowired
	// private AdminService adminService;

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
	private DepartmentService departmentService;
	@Autowired
	FilesStuff fileTemplate;


	// @Autowired
	// private VelocityEngine velocityEngine;

	// @Autowired
	// private JavaMailSender sender;
	@Autowired
	UserDao userDao;

	@RequestMapping("/createTicketIssues")
	public String createReportIssues(Model model) {
		System.out.println("----createTicketIssues home-----");
		model.addAttribute("createTicketIssues", new ReportIssue());
		// model.addAttribute("adminNames", userService.getAdminNames());
		model.addAttribute("userNames", userService.getUserName());
		model.addAttribute("category", categoryService.getCategoryNames());
		model.addAttribute("departmentNames", departmentService.getDepartmentNames());
		model.addAttribute("severity", severityService.getSeverityNames());
		model.addAttribute("priority", priorityService.getPriorityNames());
		return "createTicketIssues";
	}

	@RequestMapping(value = "/createTicketIssues", method = RequestMethod.POST)
    public String uploadFiles(@Valid @ModelAttribute("createTicketIssues") ReportIssue reportIssue,  @RequestParam("file") MultipartFile[] uploadedFiles,BindingResult results, Model model,    
			RedirectAttributes redir) throws IOException, MessagingException {
        try {
			for(MultipartFile multipartFile : uploadedFiles) {
				String fileName = multipartFile.getOriginalFilename();
				if(!multipartFile.isEmpty())
				{
					reportIssue.setUploadfile("user browsed file(s)");            //add dummy value to check file upload status in dao layers
				 multipartFile.transferTo(fileTemplate.moveFileTodir(fileName));
				}
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
        reportIssueService.saveReportIssue(reportIssue);

		redir.addFlashAttribute("msg", "Ticket Issued Successfully");
		redir.addFlashAttribute("cssMsg", "success");
		return "redirect:viewReportIssues";
    }
	
	@RequestMapping(value="/viewReportIssues")
	public String viewReportIssues(Model model) {
		System.out.println("view report Issues Block");
		model.addAttribute("allReportIssues", reportIssueService.getAllReportIssues());
		return "viewReportIssues";
	}

	@RequestMapping(value = "/editIssue", method = RequestMethod.POST)
	public String createReportIssues(@RequestParam(value = "id", required = true) String id,
			@RequestParam(value = "pgn", required = false) String pgn, Model model) {
		model.addAttribute("pagname", pgn);
		ReportIssue issue = reportIssueService.getReportIssueById(Integer.parseInt(id));
		model.addAttribute("cissue", issue);

		model.addAttribute("departments", userService.getDepartments());
		model.addAttribute("userNames", userService.getUserName());
		model.addAttribute("category", categoryService.getCategoryNames());
		model.addAttribute("severity", severityService.getSeverityNames());
		model.addAttribute("priority", priorityService.getPriorityNames());

		model.addAttribute("kpstatuses", reportIssueService.getKpStatues());

		model.addAttribute("pagename", "1");

		// return "updateIssue";
		return "editTicket";

	}

	@RequestMapping(value = "/updateIssue", method = RequestMethod.POST)
	public String saveIssue(@Valid @ModelAttribute ReportIssue reportIssue, @RequestParam("file") MultipartFile[] uploadedFiles, HttpServletRequest request,
			RedirectAttributes redir) throws IOException {
		
		try {
			for(MultipartFile multipartFile : uploadedFiles) {
				String fileName = multipartFile.getOriginalFilename();
				System.out.println("xxxxxx"+fileName);
				if(!multipartFile.isEmpty())
				{
					reportIssue.setUploadfile("user browsed file(s)");          //add dummy value to check file upload status in dao layers
				 multipartFile.transferTo(fileTemplate.moveFileTodir(fileName));
				}
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}

		reportIssueService.updateIssue(reportIssue);
		System.out.println(request.getParameter("xxxxxxx"));

		System.out.println(request.getParameter("pagname"));
		String pagname = request.getParameter("pagname");

		redir.addFlashAttribute("msg", "Record Updated Successfully");
		redir.addFlashAttribute("cssMsg", "warning");
           if(pagname.equals("1"))
        	   return "redirect:viewReportIssues";
           if(pagname.equals("2"))
		return "redirect:myView";
           else
        	  return "redirect:/";
   }
	
	@RequestMapping(value = "/viewTicket",method = RequestMethod.POST)
	public String viewIssue(@RequestParam(value = "id", required = true) String id, Model model) {

		System.out.print(id);

		ReportIssue issue = reportIssueService.getReportIssueById(Integer.parseInt(id));
		model.addAttribute("cissue", issue);
		model.addAttribute("departments", userService.getDepartments());
		model.addAttribute("userNames", userService.getUserName());
		model.addAttribute("category", categoryService.getCategoryNames());
		model.addAttribute("severity", severityService.getSeverityNames());
		model.addAttribute("priority", priorityService.getPriorityNames());
		model.addAttribute("kpstatuses", reportIssueService.getKpStatues());
		System.out.println(reportIssueService.getrepeatLogsById(Integer.parseInt(id)));
		
		model.addAttribute("repeatLogs",reportIssueService.getrepeatLogsById(Integer.parseInt(id)));

		return "ViewTicket";

	}

	@RequestMapping("/postEdit")
	public String getUserName(HttpServletRequest request, HttpSession session, Model model) {
		String href = request.getParameter("href");
		System.out.println(href);
		String id = href.substring(href.indexOf("=") + 1, href.indexOf("&"));
		System.out.println(id);
		System.out.println(href.substring(href.length() - 1));
		String pgn = href.substring(href.length() - 1);
		model.addAttribute("pagname", pgn);
		ReportIssue issue = reportIssueService.getReportIssueById(Integer.parseInt(id));
		model.addAttribute("cissue", issue);
		model.addAttribute("departments", userService.getDepartments());
		model.addAttribute("userNames", userService.getUserName());
		model.addAttribute("category", categoryService.getCategoryNames());
		model.addAttribute("severity", severityService.getSeverityNames());
		model.addAttribute("priority", priorityService.getPriorityNames());
		model.addAttribute("kpstatuses", reportIssueService.getKpStatues());

		model.addAttribute("pagename", "1");
		return "editTicket";

	}

}
