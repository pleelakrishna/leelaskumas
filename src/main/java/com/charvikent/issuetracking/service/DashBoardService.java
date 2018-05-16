package com.charvikent.issuetracking.service;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.charvikent.issuetracking.dao.DashBoardDao;
import com.charvikent.issuetracking.dao.KpStatusLogsDao;
import com.charvikent.issuetracking.dao.UserDao;
import com.charvikent.issuetracking.model.DashBordByCategory;
import com.charvikent.issuetracking.model.DashBordByStatus;
import com.charvikent.issuetracking.model.KpStatusLogs;
import com.charvikent.issuetracking.model.ReportIssue;
import com.charvikent.issuetracking.model.User;

@Service
public class DashBoardService {
	
	@Autowired
	DashBoardDao dashBoardDao;
	
	@Autowired
	UserDao userDao;
	@Autowired
	KpStatusLogsDao kpStatusLogsDao;
	
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
	User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	String id=String.valueOf(objuserBean.getId());
	Map<String,Integer> obj= dashBoardDao.getSeverityCount(id);
	
	Map<String,Integer> Severitymap= new LinkedHashMap<String,Integer>();
	 
	Integer criticalCount =0;
	Integer MajorCount =0;
	Integer MinorCount =0;
	
	 for(Entry<String,Integer> entry:obj.entrySet())
	 {
		 
	         if(entry.getKey().equals("High"))
	        	 criticalCount=entry.getValue();
	         else if(entry.getKey().equals("Medium"))
	        	 MajorCount=entry.getValue();
	         else if(entry.getKey().equals("Low"))
	        	 MinorCount=entry.getValue();
	        	 
	        	 
	        	 
	 }
	 
	 Severitymap.put("High",criticalCount);
	 
	 Severitymap.put("Medium",MajorCount);
	 
	 Severitymap.put("Low",MinorCount);
	 
	 Severitymap.put("Total",criticalCount+MajorCount+MinorCount);
	 
	 
	  
	return Severitymap;
}




public Set<ReportIssue> getTasksBySeverity(String id) {
	// TODO Auto-generated method stub
	return dashBoardDao.getTasksBySeverity(id);
}



public Map<String,Integer> getSeverityWiseCountsByAssignedBy() {
	User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	String id=String.valueOf(objuserBean.getId());
	Map<String,Integer> obj= dashBoardDao.getSeverityCountsByassignedBy(id);
	
	Map<String,Integer> Severitymap= new LinkedHashMap<String,Integer>();
	 
	Integer criticalCount =0;
	Integer MajorCount =0;
	Integer MinorCount =0;
	
	 for(Entry<String,Integer> entry:obj.entrySet())
	 {
		 System.out.println(entry.getKey()+" ....."+entry.getValue());
	         if(entry.getKey().equals("High"))
	        	 criticalCount=entry.getValue();
	         else if(entry.getKey().equals("Medium"))
	        	 MajorCount=entry.getValue();
	         else if(entry.getKey().equals("Low"))
	        	 MinorCount=entry.getValue();
	 }
	 
	 Severitymap.put("High",criticalCount);
	 
	 Severitymap.put("Medium",MajorCount);
	 
	 Severitymap.put("Low",MinorCount);
	 
	 Severitymap.put("Total",criticalCount+MajorCount+MinorCount);
	 
	  
	return Severitymap;
}


public Set<ReportIssue> getTasksBySeverityOnAssignedBy(String sev) {
	// TODO Auto-generated method stub
	return dashBoardDao.getTasksBySeverityOnAssignedBy(sev);
}

	

public  Map<String, Integer> getSeverityCountsUnderReportTo() {
	return  dashBoardDao.getSeverityCountsUnderReportTo();
	
}

public Set<ReportIssue> GetTaskBySeverityUnderReportTo(String sev) {
	// TODO Auto-generated method stub
	
	return dashBoardDao.GetTaskBySeverityUnderReportTo(sev);
}

public Set<ReportIssue> getAllTasks(String qvalue) {
	
	User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	String id=String.valueOf(objuserBean.getId());
	
	Set<ReportIssue> listissue=dashBoardDao.getAllTasks();
	
	Set<ReportIssue> sortedtaskslist =new LinkedHashSet<ReportIssue>();
	
            String qstring [] =qvalue.split("-");
            int fvalue =Integer.parseInt(qstring[0]);
            int svalue =Integer.parseInt(qstring[1]);
            
            
            if(id.equals("1"))
            {
            	
            	for(ReportIssue entry :listissue )
           	 {
           			
           		if(entry.getGapdays() >=fvalue &&  entry.getGapdays() < svalue )
           		{
           			sortedtaskslist.add(entry);
           		}
           	 }
            	
            }
            else
            {
	for(ReportIssue entry :listissue )
	 {
		if(entry.getAssigntoid().equals(id))
		{
			
		if(entry.getGapdays() >=fvalue &&  entry.getGapdays() < svalue )
		{
			sortedtaskslist.add(entry);
		}
		}
	 }
	 }
	return sortedtaskslist;
	 
	
}

public Set<ReportIssue> getTasksByCategoryListDashBord(String statusId,String categoryId) {
	// TODO Auto-generated method stub
	
	return dashBoardDao.getTasksByCategoryList(statusId,categoryId);
}
public List<DashBordByCategory> getCategory() {
	User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	String id=String.valueOf(objuserBean.getId());
	
	List<DashBordByCategory> categoryList=dashBoardDao.getCategory(id);
	return categoryList;
}

public List<DashBordByStatus> getStatusList() {
	
	User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	String id=String.valueOf(objuserBean.getId());
	
	
	return dashBoardDao.getStatusList(id);
}

public Set<ReportIssue> getTasksByStatusListDashBord(String status) {
	// TODO Auto-generated method stub
	return dashBoardDao.getTasksByStatusList(status);
}
public Set<ReportIssue> getAllTasksByclosed(String qvalue) {
	
	User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	String id=String.valueOf(objuserBean.getId());
	
	Set<ReportIssue> listissue=dashBoardDao.getAllTasks();
	
	Set<ReportIssue> sortedtaskslist =new LinkedHashSet<ReportIssue>();
	
            String qstring [] =qvalue.split("-");
            int fvalue =Integer.parseInt(qstring[0]);
            int svalue =Integer.parseInt(qstring[1]);
            
            
            if(id.equals("1"))
            {
            	
            	for(ReportIssue entry :listissue )
           	 {
            		if(entry.getKstatus().equals("Closed"))
            		{
           		if(entry.getGapdays() >=fvalue &&  entry.getGapdays() < svalue )
           		{
           			sortedtaskslist.add(entry);
           		}
            		}
           	 }
            	
            }
            else
            {
	for(ReportIssue entry :listissue )
	 {
		if(entry.getAssigntoid().equals(id) && entry.getKstatus().equals("Closed"))
		{
			
		if(entry.getGapdays() >=fvalue &&  entry.getGapdays() < svalue )
		{
			sortedtaskslist.add(entry);
		}
		}
	 }
	 }
	return sortedtaskslist;
	 
	
}



public Set<ReportIssue> getAllTasksByBalenced(String qvalue) {
	
	User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	String id=String.valueOf(objuserBean.getId());
	
	Set<ReportIssue> listissue=dashBoardDao.getAllTasks();
	
	Set<ReportIssue> sortedtaskslist =new LinkedHashSet<ReportIssue>();
	
            String qstring [] =qvalue.split("-");
            int fvalue =Integer.parseInt(qstring[0]);
            int svalue =Integer.parseInt(qstring[1]);
            
            
            if(id.equals("1"))
            {
            	
            	for(ReportIssue entry :listissue )
           	 {
            		if(!entry.getKstatusid().equals("1"))
            		{
           		if(entry.getGapdays() >=fvalue &&  entry.getGapdays() < svalue )
           		{
           			sortedtaskslist.add(entry);
           		}
            		}
           	 }
            	
            }
            else
            {
	for(ReportIssue entry :listissue )
	 {
		if(entry.getAssigntoid().equals(id) && (!entry.getKstatus().equals("1")))
		{
			
		if(entry.getGapdays() >=fvalue &&  entry.getGapdays() < svalue )
		{
			sortedtaskslist.add(entry);
		}
		}
	 }
	 }
	return sortedtaskslist;
	 
	
}



public Set<KpStatusLogs> getAllTasksForAck() {
	
	User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	String id=String.valueOf(objuserBean.getId());
	
	TreeSet<KpStatusLogs> listissue=kpStatusLogsDao.getKpStatusLogsDao();
	
	Set<KpStatusLogs> sortedtaskslist =new TreeSet<KpStatusLogs>();
            
            if(id.equals("1"))
            {
            	
            	for(KpStatusLogs entry :listissue )
           	 {
           			
           			sortedtaskslist.add(entry);
           		
           	 }
            	
            }
            else
            {
            	for(KpStatusLogs entry :listissue )
	 {
		if(entry.getIassignto().equals(id))
		{
			
			if(entry.getKpstatus().equals("3") )
       		{
       			sortedtaskslist.add(entry);
       			
       		}
		}
	 }
	 }
	return sortedtaskslist;
	 
	
}

public Object getLastLoginTime() {
	return dashBoardDao.getLastloginTime();
}

public Map<String,String> getDepartmentCounts() {
	// TODO Auto-generated method stub
	return dashBoardDao.getDepartmentCounts();
}

public Set<ReportIssue> getTasksByDepartmentWise(String dept) {
	// TODO Auto-generated method stub
	return dashBoardDao.getTasksByDepartmentWise(dept);
}

public Map<String,String> getDepartmentCounts2() {
	
	Map<String,List<String>> maplist =new LinkedHashMap<String,List<String>>();
	
	Map<String,String> mapAllDeptCounts =dashBoardDao.getDepartmentCounts();
	
	List<String> listDeptCounts =new LinkedList<String>();
	
	for(Entry<String,String> entry:mapAllDeptCounts.entrySet())
	{
		
		listDeptCounts.add(entry.getValue());
		
	}
	
	
	return dashBoardDao.getDepartmentCounts();
}

public Object getDepartmentCountsForClosed() {
	return dashBoardDao.getDepartmentCountsForClosed();
}

public Set<ReportIssue> getTasksBydepartmentClosed(String deptname) {
	
	return dashBoardDao.getTasksBydepartmentClosed(deptname);
}

public Set<ReportIssue> getTasksBydepartmentBalanced(String deptname) {
	return dashBoardDao.getTasksBydepartmentBalanced(deptname);
}


	
	
	

}
