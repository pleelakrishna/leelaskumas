package com.charvikent.issuetracking.service;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charvikent.issuetracking.config.SendSMS;
import com.charvikent.issuetracking.dao.UserDao;
import com.charvikent.issuetracking.model.Department;
import com.charvikent.issuetracking.model.Designation;
import com.charvikent.issuetracking.model.User;

@Service
@Transactional
public class UserService {

	private final static Logger logger = Logger.getLogger(AdminService.class);  

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private SendSMS smsTemplate;

	
    
    SendSMS smstemplate =new SendSMS();

	public void saveUser(User user) throws IOException
	{
		String msg =user.getFirstname()+" "+user.getLastname()+",  Successfully registered with KPTMS. \n You can login using \n Username:  "+user.getUsername()+"\n password: "+user.getPassword();
		String mbnum=user.getMobilenumber();
		userDao.saveuser(user);
		logger.info("Sending message.......");
		smsTemplate.sendSMSFromClass(msg,mbnum);
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

	public boolean checkUserExist(String username) {
		
		List<User> usersList= userDao.getUserNames();
		
		for(User bean: usersList){
			  if(username.equalsIgnoreCase(bean.getUsername()))
			  {
				  
				  return true;
		       }
	}
		return false;
	}

	
	
	
	
	
	
	

}
