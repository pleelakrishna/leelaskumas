package com.charvikent.issuetracking.service;

import java.io.File;
import java.io.StringWriter;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.charvikent.issuetracking.dao.ReportIssueDao;
import com.charvikent.issuetracking.dao.UserDao;
import com.charvikent.issuetracking.model.ReportIssue;
import com.charvikent.issuetracking.model.User;

@Service
@Transactional
public class ReportIssueService {
	
	private static final String SUBJECT_MAIL_TICKET_ISSUED = "Ticket Issued";
	@Autowired
	private UserDao userDao;

	/*@Autowired
	private ReportIssue reportIssue;*/
	@Autowired  
	private VelocityEngine velocityEngine; 

	@Autowired  
	private JavaMailSender javaMailSender; 
	
	@Autowired
	private ReportIssueDao reportIssueDao;
	private User user;
	
	public void saveReportIssue(ReportIssue reportIssue,File serverFile) throws MessagingException
	{
		reportIssueDao.saveReportIssue(reportIssue);
		sendConfirmationEmail(reportIssue,user,serverFile);
	}
	
	public List<ReportIssue> getAllReportIssues()
	{
		
		return reportIssueDao.getAllReportIssues();
	}
	
	public void sendConfirmationEmail( final ReportIssue reportIssue,User user, File serverFile) throws MessagingException {  
		try {
			
			
			int assignedUser = Integer.parseInt(reportIssue.getAssignto());
			user = userDao.find(assignedUser);

			/*String text1=reportIssue.getDescription();
			
			String text2= "hi you have have following issue";*/
			String email = user.getEmail();
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			/*helper.setTo(email);
			helper.setText(text2+text1);
			helper.setSubject("Isuue id  "+reportIssue.getId());
			helper.addAttachment("file", serverFile);
			sender.send(message);
*/
			
			VelocityContext velocityContext = new VelocityContext();
			velocityContext.put("assignedName",user.getUsername());
			velocityContext.put("issueId",reportIssue.getId());
			
			velocityContext.put("severity",reportIssue.getSeverity());
			velocityContext.put("category",reportIssue.getSubject());
			velocityContext.put("description",reportIssue.getDescription());
			//Map model1 = new HashMap<>();
			//model1.put("newMessage", velocityContext);
			StringWriter stringWriter = new StringWriter();
			//@SuppressWarnings("deprecation")
			//String text2=VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "issuedEmailTemplate.vm", "UTF-8", model1);
			velocityEngine.mergeTemplate("issuedEmailTemplate.vm", "UTF-8", velocityContext, stringWriter);
			helper.setText(stringWriter.toString(), true);
			helper.setTo( email);
			helper.setSubject(SUBJECT_MAIL_TICKET_ISSUED);  
			//helper.setSubject("Hi");
			helper.addAttachment("file",serverFile);
			javaMailSender.send(message);
				
			/*MimeMessagePreparator preparator = new MimeMessagePreparator() {  
				//@Autowired(required = false)
				@SuppressWarnings({ "unchecked", "deprecation" })
				@Override  
				public void prepare(MimeMessage mimeMessage) throws Exception { 
					//String email = user.getEmail();
					
					mimeMessage = javaMailSender.createMimeMessage();  
					MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
					helper.setTo(user.getEmail());
					

					helper.setSubject(SUBJECT_MAIL_TICKET_ISSUED);  
					//Map model = new HashMap<>();  
					//model.put("reportIssue", reportIssue);  
					//model.put("issueId", "457896");
					VelocityContext velocityContext = new VelocityContext();
					velocityContext.put("assignedName",user.getUsername());
					velocityContext.put("issueId",reportIssue.getId());
					//velocityContext.put("category",reportIssue.getCategory());
					//velocityContext.put("assignedName", reportIssue.getAssignto());
					//velocityContext.put("dateAndTime",reportIssue.getCreatedTime());
					velocityContext.put("severity",reportIssue.getSeverity());
					velocityContext.put("category",reportIssue.getSubject());
					velocityContext.put("discription",reportIssue.getDescription());
					StringWriter stringWriter = new StringWriter();
					velocityEngine.mergeTemplate("issuedEmailTemplate.vm", "UTF-8", velocityContext, stringWriter);
					
					//velocityContext.put("user",user);
					message.setText(VelocityEngineUtils.mergeTemplateIntoString(velocityEngine  
							, "emailtemplate.vm", CHARSET_UTF8, model), true); 
					//File file = reportIssue.getUploadfile();
					
					helper.setText(stringWriter.toString(), true);
 					//helper.addAttachment(file.getName(), file);
	
				}  
			};  
			this.javaMailSender.send(preparator);*/
		} catch (MailException e) {
			e.printStackTrace();
			System.out.println(e);
		}  
	}

	public List<ReportIssue> getIssuesByAssignBy(String id) {
		// TODO Auto-generated method stub
		return reportIssueDao.getIssuesAssignBy(id);
	}  




}
