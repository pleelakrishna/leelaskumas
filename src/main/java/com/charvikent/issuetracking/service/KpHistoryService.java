package com.charvikent.issuetracking.service;

import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.charvikent.issuetracking.dao.KpHistoryDao;
import com.charvikent.issuetracking.model.KpHistory;
import com.charvikent.issuetracking.model.ReportIssue;
import com.charvikent.issuetracking.model.User;

@Service
@Transactional
public class KpHistoryService {
	
	@Autowired
	KpHistoryDao  kpHistoryDao;
	
	
	
	public Set<KpHistory> getTaskHistory(String id) {
		
	Set<KpHistory> setlist =	kpHistoryDao.getTaskHistory();
	
	TreeSet<KpHistory> klist =new TreeSet<KpHistory>();
	
	for(KpHistory entry :setlist)
	{
		if(entry.getIssueid().equals(id))
		{
			klist.add(entry);
			
		}
		
		
		
	}
	return klist;
		
	}



	public Object getHeaderNotifications() {
		
		
		User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String id=String.valueOf(objuserBean.getDesignation());
		String uid=String.valueOf(objuserBean.getId());
		
		
		
		Set<KpHistory> setlist =	kpHistoryDao.getTaskHistory();
		
		TreeSet<KpHistory> klist =new TreeSet<KpHistory>();
		
		
		if(id.equals("1"))
        {
			for(KpHistory entry :setlist)
			{
			if(!entry.getKpfield().equals("New Task created") &&(!entry.getKpfield().equals("Task Mark As Read")))
			{
				klist.add(entry);
				
			}
			}
        	
        }
		
		else
		{
			
		
		for(KpHistory entry :setlist)
		{
			if(entry.getIassignto().equals(uid)  || entry.getIassignby().equals(uid))
			{
			if(!entry.getKpfield().equals("New Task created") &&(!entry.getKpfield().equals("Task Mark As Read")))
			{
				klist.add(entry);
				
			}
			}
	}
	
		}
		return klist;
	
	}
	
	
public Object getHeaderNotificationsforack() {
		
		
		User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String id=String.valueOf(objuserBean.getDesignation());
		
		String uid=String.valueOf(objuserBean.getId());
		
		
		
		Set<KpHistory> setlist =	kpHistoryDao.getTaskHistory();
		
		TreeSet<KpHistory> klist =new TreeSet<KpHistory>();
		
		
		if(id.equals("1"))
        {
			for(KpHistory entry :setlist)
			{
				
				if(entry.getIassignby().equals(uid))
				{
			if(entry.getKpfield().equals("New Task created") ||(entry.getKpfield().equals("Task Mark As Read")))
			{
				klist.add(entry);
				
			}
			}
			}
        	
        }
		
		else
		{
		
			
		for(KpHistory entry :setlist)
		{
			if(entry.getIassignby().equals(uid))
			{
		
			if(entry.getKpfield().equals("New Task created") ||(entry.getKpfield().equals("Task Mark As Read")))
			{
				klist.add(entry);
				
			}
			}
	}
	
		}
		return klist;
	
	}
	
	
	
	
	
}
