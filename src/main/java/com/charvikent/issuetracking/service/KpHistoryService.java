package com.charvikent.issuetracking.service;

import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.charvikent.issuetracking.dao.KpHistoryDao;
import com.charvikent.issuetracking.model.KpHistory;

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
	
   	
	
}
