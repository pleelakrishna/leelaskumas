package com.charvikent.issuetracking.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charvikent.issuetracking.dao.DashBoardDao;
import com.charvikent.issuetracking.dao.UserDao;
import com.charvikent.issuetracking.model.ReportIssue;

@Service
public class DashBoardService {
	
	@Autowired
	DashBoardDao dashBoardDao;
	
	@Autowired
	UserDao userDao;
	
	
	public List<ReportIssue> getIssuesByAssignBy(String id) {
		List<ReportIssue> list = new ArrayList<ReportIssue> (dashBoardDao.getIssuesAssignBy(id));
		return  list;
	}
	
	
	
	public Set getIssuesByAssignTo(String id) {
 
		return dashBoardDao.getIssuesAssignTo(id);
	}  
	
	public Set getIssuesByAssignToResolved(String id) {
		 
		return dashBoardDao.getIssuesAssignToResolved(id);
	} 
	
	public Set<ReportIssue> getRecentlyModified(String id)
	{
		return dashBoardDao.getRecentlyModified(id);
		
	}
	
@SuppressWarnings("unchecked")
public Set getIssuesByAssignToUnderMonitor(String rto) {
		
		List<String> monitorList=userDao.getUsersUnderReportTo(rto);
		//List<ReportIssue> listissue=new ArrayList<>();
		
		Set<ReportIssue> listissue=new TreeSet<ReportIssue>();
		
		for(String id2:monitorList)
		{
			listissue.addAll((Collection<? extends ReportIssue>) dashBoardDao.getIssuesAssignTo(id2));
		
		}
		
		for(String id2:monitorList)
		{
			listissue.addAll((Collection<? extends ReportIssue>) dashBoardDao.getIssuesAssignBy(id2));
		
		}
		
		return listissue;
	}

	
	
	

}
