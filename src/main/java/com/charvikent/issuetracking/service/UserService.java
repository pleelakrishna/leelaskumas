package com.charvikent.issuetracking.service;

import java.io.IOException;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
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

import com.charvikent.issuetracking.config.SendSMS;
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
	
	
	//String mobileNumber =null;
    String username = "RKKIDS";
    String password = "RK@kids987";
    String from = "RKKIDS";
    String requestUrl = null;
    String toAddress = null;
    
    //String message=null;
    
    SendSMS smstemplate =new SendSMS();

	public void saveUser(User user) throws IOException
	{
		String msg ="you are Successfully Registered with  Username:  "+user.getUsername()+"  and  password:"+user.getPassword();
		String mbnum=user.getMobilenumber();
		userDao.saveuser(user);
		smstemplate.sendSMSFromClass(msg,mbnum);
		//sendConfirmationEmail(user);
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
				@Override  
				public void prepare(MimeMessage mimeMessage) throws Exception {  
					MimeMessageHelper message = new MimeMessageHelper(mimeMessage);  
					message.setTo(user.getEmail());

					message.setSubject(SUBJECT_MAIL_REGISTRATION_CONFIRMATION);  
					VelocityContext velocityContext = new VelocityContext();
				
					
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
	
	
	
	/*public void sendSMS() throws IOException
	{
		
		//message ="hi test";
		requestUrl  = "http://182.18.160.225/index.php/api/bulk-sms?username="+URLEncoder.encode(username, "UTF-8")+"&password="+ URLEncoder.encode(password, "UTF-8")+"&from="+from+"&to="+URLEncoder.encode(mobileNumber, "UTF-8")+"&message="+URLEncoder.encode(message, "UTF-8")+"&sms_type=2";
        URL url = new URL(requestUrl);
        HttpURLConnection uc = (HttpURLConnection)url.openConnection();
        System.out.println(uc.getResponseMessage());
        uc.disconnect();
	}*/
	
	
	
	

}
