package com.charvikent.issuetracking.controller;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.charvikent.issuetracking.dao.TasksReportsDao;
import com.google.gson.JsonObject;

@Controller
public class TasksReportsController {
	
	private static final Logger logger = LoggerFactory.getLogger(TasksReportsController.class);
	
	@Autowired
	TasksReportsDao tasksReportsDao;
	
	@RequestMapping("/getDataByDates")
	public  @ResponseBody  String getUserName(HttpServletRequest request, HttpSession session) throws JSONException
	{
		logger.debug("Calling getUserName at controller");
		String fromDate=request.getParameter("fromdateval");
		String toDate=request.getParameter("todateval");
		

		JSONObject objJSON = new JSONObject();
		
	Set<Map<String,Object>> listByDates	=tasksReportsDao.getTasksByDates(fromDate,toDate);
	
	objJSON.put("listByDates",listByDates);

		return String.valueOf(objJSON);
	}

}
