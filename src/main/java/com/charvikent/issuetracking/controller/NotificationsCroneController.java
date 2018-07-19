package com.charvikent.issuetracking.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.charvikent.issuetracking.config.SendSMS;
import com.charvikent.issuetracking.dao.NotificationsDao;
import com.charvikent.issuetracking.model.NotificationsBean;
import com.charvikent.issuetracking.model.ReportIssue;

@Controller
public class NotificationsCroneController {
	
	@Autowired
	NotificationsDao notificationsDao;
	
	@Autowired
	SendSMS sendSMS;
	
	@Autowired
    private Environment environment;
	
	
	
	
	@GetMapping("/dailynotifications")
	public  String  sendNotificationsByDaily(HttpServletRequest request, HttpSession session)
	{
		
		List<NotificationsBean> notificationsList = notificationsDao.getDailyNotifications();
		
		List<NotificationsBean> dailyNotifications = notificationsDao.getDailyNotifications();
		List<NotificationsBean> weeklyNotifications = notificationsDao.getweeklyNotifications();
		List<NotificationsBean> biWeeklyNotifications = notificationsDao.getBiWeeklyNotifications();
		List<NotificationsBean> monthlyNotifications = notificationsDao.getMonthlyNotifications();
	
		
		
		notificationsList.addAll(dailyNotifications);
		notificationsList.addAll(weeklyNotifications);
		notificationsList.addAll(biWeeklyNotifications);
		notificationsList.addAll(monthlyNotifications);
		
		
		
		
		for(NotificationsBean entry : notificationsList)
		{
		      
			String msg = "Hi, "+entry.getUsername() +"  the following task has been pending at your end. Task no:"+entry.getTaskno()+"";
			
			String mobilenumber =entry.getMobilenumber();
			
		try {
			String response =	sendSMS.sendSMS(msg, mobilenumber);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			System.out.println(entry);
			
		}
		
		
		
		return null;
		
		
	}
	
	
	public  void  sendSMSToTasksTomorrowDeadLine() throws IOException
	{
		
	
		List<ReportIssue> notificationsList = notificationsDao.getTasksTommorrowDeadLine();
		
		
		  String tmsg =environment.getProperty("app.tmrmsg");
		  
		  
		
		
		for(ReportIssue entry : notificationsList)
		{
			
			List<String> mobilenumbers = new ArrayList<String>();
			
			  tmsg=  tmsg.replaceAll("_subject_", entry.getSubject());
			  tmsg=  tmsg.replaceAll("_deadline_", entry.getTaskdeadline());
			  tmsg= tmsg.replaceAll("_assignby_", entry.getAssignby());
			  tmsg= tmsg.replaceAll("_assignto_", entry.getAssignto());
			  
			  mobilenumbers.add(entry.getAssigntoid());
			  mobilenumbers.add(entry.getAssignbyid());
		      
			for(String entry2:mobilenumbers)
			{
		
			String response =	sendSMS.sendSMS(tmsg, entry2);
			System.out.println(response);
		
			}
			
		}
		
		
	}
	
	

}
