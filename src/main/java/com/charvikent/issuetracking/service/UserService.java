package com.charvikent.issuetracking.service;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.charvikent.issuetracking.dao.UserDao;
import com.charvikent.issuetracking.model.Department;
import com.charvikent.issuetracking.model.Designation;
import com.charvikent.issuetracking.model.User;

@Service
@Transactional
public class UserService {

	//private final static Logger logger = Logger.getLogger(AdminService.class);  
	private static final String SUBJECT_MAIL_REGISTRATION_CONFIRMATION = "Registration Confirmation";  
	//private static final String CHARSET_UTF8 = "UTF-8";

	@Autowired
	private UserDao userDao;

	/*@Autowired
	private ReportIssue reportIssue;*/
	@Autowired  
	private VelocityEngine velocityEngine; 

	@Autowired  
	private JavaMailSender javaMailSender; 

	public void saveUser(User user)
	{
		userDao.saveuser(user);
		sendConfirmationEmail(user);
	}

	public List<User> getAllUsers()
	{

		return userDao.getAllUsers();
	}
	
	
	public Map<Integer, String> getDepartments()
	{
		Map<Integer, String> statesMap = new LinkedHashMap<Integer, String>();
		try
		{
		List<Department> departmentList= userDao.getDepartmentslist();
		for(Department bean: departmentList){
			statesMap.put(bean.getId(), bean.getDepartment());
		}
				
	} catch (Exception e) {
		e.printStackTrace();
	}
		return statesMap;
				
		
	}
	
	
	public Map<Integer, String> getRoles()
	{
		Map<Integer, String> rolesMap = new LinkedHashMap<Integer, String>();
		try
		{
		List<Designation> rolesList= userDao.getRoles();
		for(Designation bean: rolesList){
			rolesMap.put(bean.getId(), bean.getName());
		}
				
	} catch (Exception e) {
		e.printStackTrace();
	}
		return rolesMap;
				
		
	}
	
	/*public List<Object> getAllDe*/
	
	private void sendConfirmationEmail(final User user) {  
		try {
			MimeMessagePreparator preparator = new MimeMessagePreparator() {  
				@SuppressWarnings({ "unchecked", "deprecation" })
				@Override  
				public void prepare(MimeMessage mimeMessage) throws Exception {  
					MimeMessageHelper message = new MimeMessageHelper(mimeMessage);  
					message.setTo(user.getEmail());

					message.setSubject(SUBJECT_MAIL_REGISTRATION_CONFIRMATION);  
					Map model = new HashMap<>();  
					VelocityContext velocityContext = new VelocityContext();
					//model.put("name", user.getUsername());  
					//TODO: get issue id
					//model.put("issueId", "457896");
					
					velocityContext.put("name",user.getUsername());
					velocityContext.put("issueId",user.getId());
					StringWriter stringWriter = new StringWriter();
					velocityEngine.mergeTemplate("emailtemplate.vm", "UTF-8", velocityContext, stringWriter);
					
					//velocityContext.put("user",user);
					/*message.setText(VelocityEngineUtils.mergeTemplateIntoString(velocityEngine  
							, "emailtemplate.vm", CHARSET_UTF8, model), true);*/  
					
					message.setText(stringWriter.toString(), true);
					
				}  
			};  
			this.javaMailSender.send(preparator);
		} catch (MailException e) {
			e.printStackTrace();
			System.out.println(e);
		}  
	}  

	

		public User  findWithName(String username, String lpassword)
	{
	 
		 User userdao=null;
		
		try {
			userdao= userDao.findWithName(username, lpassword);
		} catch (Exception e) {
			System.out.println("error occured service");
			
			
			e.printStackTrace();
		}
				
				return userdao;
		
	}

	public void deleteUser(Integer id) {
		
		userDao.deleteUser(id);
		
	}

	public User getUserById(Integer id) {
		
		User obj=userDao.getUserById(id);
		return obj;
	}

	public void updateUser(User user) {
		
		userDao.updateUser(user);
		
	}
	public Map<Integer, String> getUserName()
	{
		Map<Integer, String> rolesMap = new LinkedHashMap<Integer, String>();
		try
		{
		List<User> rolesList= userDao.getUserNames();
		for(User bean: rolesList){
			rolesMap.put(bean.getId(), bean.getUsername());
		}
				
	} catch (Exception e) {
		e.printStackTrace();
	}
		return rolesMap;
				
		
	}

	public void setLoginRecord(Integer id,String str) {
          
		userDao.setLoginRecord(id,str);
	}
	
	
	
	
	
	

}
