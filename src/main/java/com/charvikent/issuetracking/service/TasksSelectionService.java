package com.charvikent.issuetracking.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.charvikent.issuetracking.dao.TasksSelectionDao;
import com.charvikent.issuetracking.model.TasksSelection;

@Service
@Transactional
public class TasksSelectionService {
	
	@Autowired
	TasksSelectionDao tasksSelectionDao;
	
	
	public Map<Integer, String> getTasksSelectionMap()
	{
		Map<Integer, String> tasksSelectionMap = new LinkedHashMap<Integer, String>();
		try
		{
		List<TasksSelection> tasksSelectionList= tasksSelectionDao.getAllTasksSelections();
		for(TasksSelection bean: tasksSelectionList){
			tasksSelectionMap.put(bean.getId(), bean.getName());
		}
				
	} catch (Exception e) {
		e.printStackTrace();
	}
		return tasksSelectionMap;
				
		
	}
	
	
	

}
