package com.charvikent.issuetracking.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.charvikent.issuetracking.controller.NotificationsCroneController;

@Configuration
@EnableScheduling
public class TasksAlerts {

	@Autowired
	NotificationsCroneController notificationsCroneController;
	
	
	@Autowired
	private Environment env;
	@Autowired
	SendSMS sendSMS;
	
	
	@Scheduled(cron = "* * 10 * * *")
	public void scheduleTaskUsingCronExpression() throws IOException {
	  
	    long now = System.currentTimeMillis() / 1000;
	    System.out.println(
	      "schedule tasks using cron jobs - " + now);
	    
	    notificationsCroneController.sendSMSToTasksTomorrowDeadLine();
	}
	
	/*@Scheduled(cron = "*5 * * * * *")
	public void testingCronExpression() throws IOException  {
	  
	    long now = System.currentTimeMillis() / 1000;
	    System.out.println(
	      "schedule tasks using cron jobs - " + now);
	    String tmg= env.getProperty("app.taskmsg");
	    //System.out.println(tmg);
	    
	   // notificationsCroneController.sendSMSToTasksTomorrowDeadLine();
	}*/
}
