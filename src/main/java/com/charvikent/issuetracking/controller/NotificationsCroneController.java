package com.charvikent.issuetracking.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.charvikent.issuetracking.config.SendSMS;
import com.charvikent.issuetracking.dao.NotificationsDao;
import com.charvikent.issuetracking.model.NotificationsBean;

@Controller
public class NotificationsCroneController {
	
	@Autowired
	NotificationsDao notificationsDao;
	
	@Autowired
	SendSMS sendSMS;
	
	
	
	
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
	
	

}
