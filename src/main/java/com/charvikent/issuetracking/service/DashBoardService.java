package com.charvikent.issuetracking.service;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
	
	
	/*public Set<ReportIssue> getIssuesByAssignBy(String id) {
		Set<ReportIssue> list=(dashBoardDao.getIssuesAssignBy(id));
		return  list;
	}
	*/
	
	
	/*public Set getIssuesByAssignTo(String id) {
 
		return dashBoardDao.getIssuesAssignTo(id);
	}  
	*/
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

public Map<String,Integer> getSeverityWiseCount() {
	Map<String,Integer> obj= dashBoardDao.getSeverityCount();
	
	Map<String,Integer> Severitymap= new LinkedHashMap<String,Integer>();
	 
	Integer criticalCount =0;
	Integer MajorCount =0;
	Integer MinorCount =0;
	
	 for(Entry<String,Integer> entry:obj.entrySet())
	 {
		 System.out.println(entry.getKey()+" ....."+entry.getValue());
	         if(entry.getKey().equals("Critical"))
	        	 criticalCount=entry.getValue();
	         else if(entry.getKey().equals("Major"))
	        	 MajorCount=entry.getValue();
	         else if(entry.getKey().equals("Minor"))
	        	 MinorCount=entry.getValue();
	        	 
	        	 
	        	 
	 }
	 
	 Severitymap.put("Critical",criticalCount);
	 
	 Severitymap.put("Major",MajorCount);
	 
	 Severitymap.put("Minor",MinorCount);
	 
	 
	  
	return Severitymap;
}




	
	
	

}
