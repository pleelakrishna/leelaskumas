package com.charvikent.issuetracking.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.charvikent.issuetracking.model.DashBordByCategory;
import com.charvikent.issuetracking.model.DashBordByStatus;
import com.charvikent.issuetracking.model.ReportIssue;
import com.charvikent.issuetracking.model.User;
import com.charvikent.issuetracking.model.UserLogs;
import com.charvikent.issuetracking.service.ReportIssueService;

@Repository
public class DashBoardDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DashBoardDao.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	ReportIssueService taskService;
	
	
	
	
	public Set<ReportIssue> getIssuesAssignBy(String id) {
		Set<ReportIssue> listissue=new TreeSet<ReportIssue>();
		
		LOGGER.debug("In getIssuesAssignBy calling createQuery with id {}", id);

		try {
			@SuppressWarnings("unchecked")
			List <Object[]> rows=em.createQuery("select r.id , u.username, s.colour, p.priority,r.uploadfile,r.subject ,c.category,r.createdTime,r.status,ks.name,r.taskno from ReportIssue r, Category c, Priority p, User u, Severity s, KpStatus ks where r.assignto=u.id and r.kstatus=ks.id and p.id=r.priority and s.id=r.severity and c.id=r.category and r.kstatus<>'1'  and  r.assignby =:custName").setParameter("custName", id).getResultList();
			for(Object[] row: rows)
			{
				ReportIssue issue =new ReportIssue();
				int j = Integer.parseInt(String.valueOf(row[0]));
				Integer intobj=new Integer(j);
				issue.setId(intobj);
				issue.setAssignto((String) row[1]);
				issue.setSeverity((String) row[2]);
				issue.setPriority((String) row[3]);
				issue.setUploadfile((String) row[4]);
				issue.setSubject((String) row[5]);
				issue.setCategory((String) row[6]);
				issue.setCreatedTime((Date) row[7]);
				issue.setStatus( row[8].toString());         
				issue.setAssignby((String) row[9]);
				issue.setTaskno((String) row[10]);// assume setassignby is status of ticket status assigned to this variable
				listissue.add(issue);

			}
		} catch (Exception e) {
			System.out.println("error here");
			e.printStackTrace();
		}

		return  listissue;

	}
	
	 public static Integer assigntocount =null;
	public Set getIssuesAssignTo(String id) {
		
		
		LOGGER.debug("In getIssuesAssignTo calling createNativeQuery with AssignTo {}", id);
		Set<ReportIssue> listissue=new TreeSet<ReportIssue>();

		try {
			@SuppressWarnings("unchecked")
			List <Object[]> rows=em.createNativeQuery("select r.id , u.username, s.colour, p.priority,r.uploadfile,r.subject ,r.created_time,c.category,ks.name,ks.scolour,r.taskno from report_issue r, kpcategory c, kppriority p, kpusers u, kpseverity s ,kpstatus ks  where r.assignto=u.id and r.kstatus=ks.id and p.id=r.priority and s.id=r.severity and c.id=r.category  and r.kstatus in(2,6,9) and r.assignto =:custName").setParameter("custName", id).getResultList();
			for(Object[] row: rows)
			{
				ReportIssue issue =new ReportIssue();
				int j = Integer.parseInt(String.valueOf(row[0]));
				Integer intobj=new Integer(j);
				issue.setId(intobj);
				issue.setAssignby((String) row[1]);
				issue.setSeverity((String) row[2]);
				issue.setPriority((String) row[3]);
				issue.setUploadfile((String) row[4]);
				issue.setSubject((String) row[5]);
				issue.setCreatedTime((Date) row[6]);
				issue.setCategory((String) row[7]);
				issue.setAssignto((String) row[8]);                    // assume setassignby is status of ticket status assigned to this variable
				issue.setKstatus( (String) row[9]);                   // ticket colour assigned to this variable
				issue.setTaskno((String) row[10]);

				listissue.add(issue);

			}
		} catch (Exception e) {
			System.out.println("error here");
			e.printStackTrace();
		}
		

		return  listissue;

	}


	public Set getIssuesAssignToResolved(String id) {
		//List<ReportIssue> listissue=new ArrayList<>();
		
		LOGGER.debug("In getIssuesAssignToResolved calling createQuery with AssignTo {}", id);
		
		Set<ReportIssue> listissue=new TreeSet<ReportIssue>();

		try {
			@SuppressWarnings("unchecked")
			List <Object[]> rows=em.createQuery("select r.id , u.username, s.colour, p.priority,r.uploadfile,r.subject ,r.createdTime,c.category,ks.scolour,ks.name ,r.taskno from ReportIssue r, Category c, Priority p, User u, Severity s, KpStatus ks   where  r.kstatus=ks.id and r.assignto=u.id and p.id=r.priority and s.id=r.severity and c.id=r.category  and r.kstatus='4' and  r.assignto =:custName").setParameter("custName", id).getResultList();
			for(Object[] row: rows)
			{
				ReportIssue issue =new ReportIssue();
				int j = Integer.parseInt(String.valueOf(row[0]));
				Integer intobj=new Integer(j);
				issue.setId(intobj);
				issue.setAssignby((String) row[1]);
				issue.setSeverity((String) row[2]);
				issue.setPriority((String) row[3]);
				issue.setUploadfile((String) row[4]);
				issue.setSubject((String) row[5]);
				issue.setCreatedTime((Date) row[6]);
				issue.setCategory((String) row[7]);
				issue.setKstatus((String) row[8]);
				issue.setAssignto((String) row[9]);
				issue.setTaskno((String) row[10]);


				listissue.add(issue);

			}
		} catch (Exception e) {
			System.out.println("error here");
			e.printStackTrace();
		}

		return  listissue;

	}
	
	
	@SuppressWarnings("unchecked")
	public Map<Integer, Integer>  getGapAndCountForClosed() {
		
		
		LOGGER.debug("In getGapAndCountForClosed calling createNativeQuery ");

		List<ReportIssue> listissuegap=new ArrayList<>();
		ReportIssue issuegap =null;

		//String custName=null;

		List<Object[]> rows = 	em.createNativeQuery(" SELECT DATEDIFF(CURDATE(),created_time ) as gap ,count(id)  from report_issue where kstatus =:custName  group by gap  ").setParameter("custName", "1").getResultList();

		Map<Integer, Integer> issueTimelines = new HashMap<Integer, Integer>();

		for (Object[] row : rows) {
			issuegap = new ReportIssue();
			issuegap.setGapdays(Integer.parseInt(String.valueOf(row[0])));
			issuegap.setGapcount(Integer.parseInt(String.valueOf(row[1])));
			listissuegap.add(issuegap);

			issueTimelines.put(Integer.parseInt(String.valueOf(row[0])), Integer.parseInt(String.valueOf(row[1])));
		}
		return issueTimelines;

	}

	@SuppressWarnings("unchecked")
	public  Set<ReportIssue> getRecentlyModified(String id) {
		
		
		LOGGER.debug("In getRecentlyModified calling createNativeQuery with assignTo{} ",id);

		Set<ReportIssue> listissue=new TreeSet<ReportIssue>();

		try {
			List<Object[]> rows = em
			.createNativeQuery(" select   r.id , u.username, s.colour, p.priority,r.uploadfile,r.subject ,c.category,r.created_time,ks.name,ks.scolour,r.taskno from vreport_issue r, kpcategory c, kppriority p, kpusers u, kpseverity s,kpstatus ks  where r.kstatus=ks.id and r.assignto=u.id and p.id=r.priority and s.id=r.severity and c.id=r.category and r.kstatus='1'  and DATEDIFF (CURDATE(),r.updated_time )<=30 and  r.assignby =:custName union (select   r.id , u.username, s.colour, p.priority,r.uploadfile,r.subject ,c.category,r.created_time,ks.name,ks.scolour from report_issue r, category c, priority p, kpusers u, severity s,kpstatus ks  where r.kstatus=ks.id and r.assignto=u.id and p.id=r.priority and s.id=r.severity and c.id=r.category and r.kstatus='1'  and DATEDIFF (CURDATE(),r.updated_time )<=30 and  r.assignto =:custName )").setParameter("custName", id)
			.getResultList();
			for (Object[] row : rows) {
				ReportIssue issue = new ReportIssue();
				issue.setId(Integer.parseInt(String.valueOf(row[0])));
				issue.setAssignto((String) row[1]);
				issue.setSeverity((String) row[2]);
				issue.setPriority((String) row[3]);
				issue.setUploadfile((String) row[4]);
				issue.setSubject((String) row[5]);
				issue.setCategory((String) row[6]);
				issue.setCreatedTime((Date) row[7]);
				issue.setKstatus((String) row[9]);
				issue.setAssignby((String) row[8]);
				issue.setTaskno((String) row[9]);
				listissue.add(issue);

			}
		} catch (Exception e) {
			System.out.println("error here");
			e.printStackTrace();
		}

		return  listissue;


	}


	public Map<String,Integer> getSeverityCount(String id) {
		
		/*User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String id=String.valueOf(objuserBean.getId());
		*/
		LOGGER.debug("In getSeverityCount calling createQuery with AssignTo {}", id);

		Map<String,Integer> statusCounts =new LinkedHashMap<String,Integer>();

		Integer opentotal=0;

		try {
			@SuppressWarnings("unchecked")
			List<Object[]> rows = em
			.createNativeQuery(" select ks.severity,count(*)as count from report_issue r,kpseverity ks" + 
					" where  r.severity=ks.id  and r.assignto =:id  and r.kstatus<>'1'  group by severity").setParameter("id", id).getResultList();
			for (Object[] row : rows) {
				
				opentotal=opentotal+Integer.parseInt(String.valueOf(row[1]));
				statusCounts.put((String)row[0], Integer.parseInt(String.valueOf(row[1])));
				
			}

			statusCounts.put("Open",opentotal);
		} catch (Exception e) {
			System.out.println("error here");
			e.printStackTrace();
		}
		
		
		return statusCounts;
	}


		
	
	
public Map<String,Integer> getSeverityCountsByassignedBy(String id) {
		
		/*User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String id=String.valueOf(objuserBean.getId());*/
		
	LOGGER.debug("In getSeverityCountsByassignedBy calling createQuery with AssignBy {}", id);


		Map<String,Integer> statusCounts =new LinkedHashMap<String,Integer>();

		Integer opentotal=0;

		try {
			@SuppressWarnings("unchecked")
			List<Object[]> rows = em
			.createNativeQuery(" select ks.severity,count(*)as count from report_issue r,kpseverity ks" + 
					" where  r.severity=ks.id  and r.assignby =:id  and r.kstatus<>'1'  group by severity").setParameter("id", id).getResultList();
			for (Object[] row : rows) {
				
				opentotal=opentotal+Integer.parseInt(String.valueOf(row[1]));
				statusCounts.put((String)row[0], Integer.parseInt(String.valueOf(row[1])));
				
			}

			statusCounts.put("Open",opentotal);
		} catch (Exception e) {
			System.out.println("error here");
			e.printStackTrace();
		}
		
		
		return statusCounts;
	}



public Map<String, Integer> getSeverityCountsUnderReportTo()
{
	LOGGER.debug("In getSeverityCountsUnderReportTo calling createnativeQuery");

	User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	String id=String.valueOf(objuserBean.getId());
	
	List<String> monitorList=userDao.getUsersUnderReportTo(id);
	
	Map<String,Integer> severityList=new LinkedHashMap<String,Integer>();
	
	
	String hql ="select severity,count(*) as scount from report_issue r where r.assignto=:id and r.kstatus<>'1'  group by severity";
	
	Integer minor=0;
	Integer major=0;
	Integer critical=0;
	
	for(String id2:monitorList)
	{
		List<Object[]> rows= em.createNativeQuery(hql).setParameter("id", id2).getResultList();
		
         for (Object[] row : rows) {
        	 if(row[0].equals("3"))
        	 minor=minor+Integer.parseInt(String.valueOf(row[1]));
        	 else if(row[0].equals("2"))
        	 major=major+Integer.parseInt(String.valueOf(row[1]));
        	 else if(row[0].equals("1"))
        	 critical=critical+Integer.parseInt(String.valueOf(row[1]));
		}
	
	}
	
	severityList.put("High",critical);
	severityList.put("Medium",major);
	severityList.put("Low",minor);
	severityList.put("Total",critical+major+minor);
	
	
	return severityList;
	
}




     public Set<ReportIssue> GetTaskBySeverityUnderReportTo(String sev)
     {
    	 LOGGER.debug("In GetTaskBySeverityUnderReportTo calling  with reporto {}", sev);
    	 User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 		String id=String.valueOf(objuserBean.getId());
    	 
    	 
 		Set<ReportIssue> listissue= taskService.getIssuesByAssignToUnderMonitor(id);
 		
 		Set<ReportIssue> SeverityReportToList= new LinkedHashSet();
 		
 		if(sev.equals("Total"))
  		{
 			for(ReportIssue entry:listissue)
 	 		{
 	 			if(!entry.getKstatusid().equals("1"))
 	 			{
 	 				SeverityReportToList.add(entry);
  			
  		}
 	 		}
 			return SeverityReportToList;
  		}
 			
 		
 		for(ReportIssue entry:listissue)
 		{
 			if(!entry.getKstatusid().equals("1"))
 			{
 			if(entry.getSeverity().equals(sev))
 			{
 				SeverityReportToList.add(entry);
 			}
 			
 			}
 				
 			
 		}
		return SeverityReportToList;
 		
    	 
     }
     
     
     public Set<ReportIssue> getTasksBySeverityOnAssignedBy(String sev) {
    	 
    	 LOGGER.debug("In getTasksBySeverityOnAssignedBy calling  with AssignBy {}", sev);
    	 User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  		String id=String.valueOf(objuserBean.getId());
  		
  		 
 		Set<ReportIssue> listissue= taskService.getissuesByselectionAssignBy(id);
 		
 		Set<ReportIssue> SeverityReportToList= new LinkedHashSet();
 		
 		if(sev.equals("Total"))
  		{
  			return listissue;
  		}
 		for(ReportIssue entry:listissue)
 		{
 			if(!entry.getKstatusid().equals("1"))
 			{
 			if(entry.getSeverity().equals(sev))
 			{
 				SeverityReportToList.add(entry);
 			}
 			}
 				
 			
 		}
		return SeverityReportToList;
    	 
    	 
    	 
     }
     
     
     
     public Set<ReportIssue> getTasksBySeverity(String sev) {
    	 
    	 LOGGER.debug("In getTasksBySeverity calling  AssignTo {}", sev);
    	 
    	 User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
   		String id=String.valueOf(objuserBean.getId());
   		
   		 
  		Set<ReportIssue> listissue= taskService.getissuesByselectionAssignTo(id);
  		
  		Set<ReportIssue> SeverityReportToList= new LinkedHashSet();
  		
  		if(sev.equals("Total"))
  		{
  			return listissue;
  		}
  		
  		for(ReportIssue entry:listissue)
  		{
  			if(!entry.getKstatusid().equals("1"))
  			{
  			if(entry.getSeverity().equals(sev))
  			{
  				SeverityReportToList.add(entry);
  			}
  			
  			}
  				
  			
  		}
 		return SeverityReportToList;
     }



	public List<DashBordByCategory> getCategory(String id) {
		
		LOGGER.debug("In getSeverityCountsUnderReportTo calling createnativeQuery");

		
		
		List<DashBordByCategory> dashBordCategoryList=new ArrayList<>();
		try {
		
		String hql ="select ri.category,kc.category as categoryname,kstatus  ,GROUP_CONCAT(ks.name) from report_issue ri,kpcategory kc,kpstatus ks where ri.category=kc.id and ks.id=kstatus and assignto=:assignto and ri.kstatus in(1,2,4) group by ri.category ORDER BY ri.category";
		
		String hqladmin ="select ri.category,kc.category as categoryname,kstatus  ,GROUP_CONCAT(ks.name) from report_issue ri,kpcategory kc,kpstatus ks where ri.category=kc.id and ks.id=kstatus  and ri.kstatus in(1,2,4) group by ri.category ORDER BY ri.category";
			
		List<Object[]> rows =null;
		
		if(id.equals("1")){
			rows= em.createNativeQuery(hqladmin).getResultList();
		}else {
		      rows= em.createNativeQuery(hql).setParameter("assignto", id).getResultList();
		}
			
			
				
				for (Object[] row : rows) {
					DashBordByCategory dashBordByCategory= new DashBordByCategory();
					dashBordByCategory.setCategoryId((String)row[0]);
					dashBordByCategory.setCategoryName((String) row[1]);
					dashBordByCategory.setkStatus((String) row[2]);
					dashBordByCategory.setkStatusNameWithId((String) row[3]);
					dashBordCategoryList.add(dashBordByCategory);

				}
			} catch (Exception e) {
				System.out.println("error here");
				e.printStackTrace();
			}

		
		
		
		
		return dashBordCategoryList;
		
	}
	
 public Set<ReportIssue> getTasksByCategoryList(String statusId,String categoryId) {
    	 
    	 LOGGER.debug("In getTasksBySeverityOnAssignedBy calling  with AssignBy {}", statusId);
    	 User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  		String id=String.valueOf(objuserBean.getId());
  		
  		 
//Set<ReportIssue> listissue=taskService.getTaskByCategory(statusId) ;
 		
 		//Set<ReportIssue> SeverityReportToList= new LinkedHashSet();
 		
 		
 		/*for(ReportIssue entry:listissue)
 		{
 			if(entry.getSeverity().equals(statusId))
 			{
 				SeverityReportToList.add(entry);
 			}
 				
 			
 		}*/

		return taskService.getTaskByCategory(statusId, categoryId);
    	 
    	 
    	 
     }


public List<DashBordByStatus> getStatusList(String id) {
	LOGGER.debug("In getSeverityCountsUnderReportTo calling createnativeQuery");

	List<DashBordByStatus> dashBordStatusList=new ArrayList<>();
	
	try {
	
	String hql ="select kstatus, ks.name,GROUP_CONCAT(ks.name) from report_issue ri,kpcategory kc,kpstatus ks where ri.category=kc.id and ks.id=kstatus and assignto=:assignto and ri.kstatus in(1,2,4) group by ri.kstatus ORDER BY ri.kstatus";
	
	String hqladmin ="select  kstatus, ks.name,GROUP_CONCAT(ks.name) from report_issue ri,kpcategory kc,kpstatus ks where ri.category=kc.id and ks.id=kstatus  and ri.kstatus in(1,2,4) group by ri.kstatus ORDER BY ri.kstatus";
		
	List<Object[]> rows =null;
	
	
	if(id.equals("1")){
		rows= em.createNativeQuery(hqladmin).getResultList();
	}else {
	      rows= em.createNativeQuery(hql).setParameter("assignto", id).getResultList();
	}
		
	
			
			for (Object[] row : rows) {
				DashBordByStatus dashBordByStatus= new DashBordByStatus();
				dashBordByStatus.setStatusId((String)row[0]);
				dashBordByStatus.setStatusName((String) row[1]);
				dashBordByStatus.setStatusConcatination((String) row[2]);
				dashBordStatusList.add(dashBordByStatus);

			}
		} catch (Exception e) {
			System.out.println("error here");
			e.printStackTrace();
		}

	
	
	
	
	return dashBordStatusList;
	}


public Set<ReportIssue> getTasksByStatusList(String status) {
	 	
		 
		
	return taskService.getTaskByStatusDashBord(status);
}
     

public Set<ReportIssue> getAllTasks() {
		Set<ReportIssue> listissue=new LinkedHashSet<ReportIssue>();
		
		String hql ="select  r.id , u.username, s.severity as sev, p.priority as pp,r.uploadfile,r.subject ,r.created_time,c.category as cc,ks.name,r.status ,r.taskno ,r.severity as sid, r.priority as pid,r.assignto , r.category as rcid,r.description ,r.taskdeadline,r.assignby,u1.username as asby ,r.kstatus ,DATEDIFF(CURDATE(),r.created_time ) as gap , nf.frequence_name , r.notificationsfrequency " 
                  +" from report_issue r, kpcategory c, kppriority p, kpusers u, kpusers u1, kpseverity s, kpstatus ks , notifications_frequency nf  "  
                   +" where  r.kstatus=ks.id and r.assignto=u.id and r.assignby=u1.id and p.id=r.priority and s.id=r.severity and c.id=r.category and nf.id=r.notificationsfrequency ";
		
		
		
		try {
			List<Object[]> rows = em.createNativeQuery(hql).getResultList();
			for (Object[] row : rows) {
				ReportIssue issue = new ReportIssue();
				issue.setId(Integer.parseInt(String.valueOf(row[0])));
				issue.setAssignto((String) row[1]);
				issue.setSeverity((String) row[2]);
				issue.setPriority((String) row[3]);
				issue.setUploadfile((String) row[4]);
				issue.setSubject((String) row[5]);
				issue.setCreatedTime((Date) row[6]);
				issue.setCategory((String) row[7]);
				issue.setKstatus((String) row[8]);
				issue.setStatus((String) row[9]);
				issue.setTaskno((String) row[10]);
				
				issue.setSeverityid((String) row[11]);
				issue.setPriorityid((String) row[12]);
				issue.setAssigntoid((String) row[13]);
			    issue.setCategoryid((String) row[14]);
			    issue.setDescription((String) row[15]);
				issue.setTaskdeadline((String) row[16]);
				issue.setAssignbyid((String) row[17]);
				issue.setAssignby((String) row[18]);
				
				issue.setKstatusid((String) row[19]);
				issue.setGapdays(Integer.parseInt(String.valueOf(row[20])));
				
				issue.setNotificationsfrequency((String) row[21]);
				issue.setNotificationsfrequencyid((String) row[22]);
				
			    
			    
				
				listissue.add(issue);

			}
			
		} catch (Exception e) {
			System.out.println("error here");
			e.printStackTrace();
		}
		
		
		return listissue;
		
		
	}


public Object getLastloginTime() {
	
	User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String id=String.valueOf(objuserBean.getId());
	
	String hql ="select logintime from kpuserslogs where sessionname='login' and userid=:uid order by logintime desc limit 1,1 ";
	@SuppressWarnings("unchecked")
	List<UserLogs> rows = (List<UserLogs>) em.createNativeQuery(hql).setParameter("uid",id).getResultList();
	 if(rows.size()>0)
	 {
		 return rows.get(0);
	 }
	
	 else
		 
	return "";
}




public Object getNotifyAckCounts()
{
	String hql ="select count(*) from kp_history h, report_issue r"
			+ " where r.id=h.issueid and  ( h.kpfield = ('New Task created') or h.kpfield =('Task Mark As Read') ) and h.status='1'  and assignby='1'";
	
	return em;
	
}




public Map<String, String> getDepartmentCounts()
{
	
	User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	String id=String.valueOf(objuserBean.getDesignation());
	String orgid=String.valueOf(objuserBean.getKpOrgId());

	
	HashMap<String,String> deptCounts =new LinkedHashMap<String,String>();
	
	String hql ="";
	
	if(id.equals("1"))
	{
	
     hql ="SELECT kpdepartment.name ,COUNT(report_issue.departmentid)as number  FROM report_issue  RIGHT  JOIN kpdepartment "
                    +" ON (kpdepartment.id=report_issue.departmentid)  GROUP BY kpdepartment.id ";
	}
	
	else
	{
	
	 hql="SELECT kpdepartment.name ,COUNT(report_issue.departmentid)as number  FROM report_issue  RIGHT  JOIN kpdepartment" 
                   +" ON (kpdepartment.id=report_issue.departmentid) and kp_org_id='"+orgid+" ' GROUP BY kpdepartment.id ";
	}	
	
	@SuppressWarnings("unchecked")
		List<Object[]> rows = em.createNativeQuery(hql).getResultList();
		for (Object[] row : rows) {
			deptCounts.put((String)row[0], String.valueOf(row[1]));
    }
		return deptCounts;
}


public Set<ReportIssue> getTasksByDepartmentWise(String dept) {
	

	User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	String id=String.valueOf(objuserBean.getDesignation());
	String orgid=String.valueOf(objuserBean.getKpOrgId());
	
	Set<ReportIssue> listissue=new LinkedHashSet<ReportIssue>();
	
String hql ="";
	
	if(id.equals("1"))
	{
	
	 hql ="select  r.id , u.username, s.severity as sev, p.priority as pp,r.uploadfile,r.subject ,r.created_time,c.category as cc,ks.name,r.status ,r.taskno ,r.severity as sid, r.priority as pid,r.assignto , r.category as rcid,r.description ,r.taskdeadline,r.assignby,u1.username as asby ,"
                 +" r.kstatus ,DATEDIFF(CURDATE(),r.created_time ) as gap, nf.frequence_name , r.notificationsfrequency  "
                +" from report_issue r, kpcategory c, kppriority p, kpusers u, kpusers u1, kpseverity s, kpstatus ks,kpdepartment kpd ,notifications_frequency nf  "
               +"  where  r.kstatus=ks.id and r.assignto=u.id and r.assignby=u1.id and p.id=r.priority and s.id=r.severity and c.id=r.category and kpd.id=r.departmentid and nf.id=r.notificationsfrequency "
               +" and kpd.name='"+dept +"'";
	}
	
	else
		if(id.equals("2"))
		{
			hql ="select  r.id , u.username, s.severity as sev, p.priority as pp,r.uploadfile,r.subject ,r.created_time,c.category as cc,ks.name,r.status ,r.taskno ,r.severity as sid, r.priority as pid,r.assignto , r.category as rcid,r.description ,r.taskdeadline,r.assignby,u1.username as asby , r.kstatus ,DATEDIFF(CURDATE(),r.created_time ) as gap ,nf.frequence_name , r.notificationsfrequency "
 
                  +" from report_issue r, kpcategory c, kppriority p, kpusers u, kpusers u1, kpseverity s, kpstatus ks,kpdepartment kpd ,notifications_frequency nf  "  
                   +"  where  r.kstatus=ks.id and r.assignto=u.id and r.assignby=u1.id and p.id=r.priority and s.id=r.severity and c.id=r.category and kpd.id=r.departmentid and and nf.id=r.notificationsfrequency  and kpd.name='"+dept+"' and kpd.kp_org_id ='"+orgid+"'";

		}

	try {
		List<Object[]> rows = em.createNativeQuery(hql).getResultList();
		for (Object[] row : rows) {
			ReportIssue issue = new ReportIssue();
			issue.setId(Integer.parseInt(String.valueOf(row[0])));
			issue.setAssignto((String) row[1]);
			issue.setSeverity((String) row[2]);
			issue.setPriority((String) row[3]);
			issue.setUploadfile((String) row[4]);
			issue.setSubject((String) row[5]);
			issue.setCreatedTime((Date) row[6]);
			issue.setCategory((String) row[7]);
			issue.setKstatus((String) row[8]);
			issue.setStatus((String) row[9]);
			issue.setTaskno((String) row[10]);
			
			issue.setSeverityid((String) row[11]);
			issue.setPriorityid((String) row[12]);
			issue.setAssigntoid((String) row[13]);
		    issue.setCategoryid((String) row[14]);
		    issue.setDescription((String) row[15]);
			issue.setTaskdeadline((String) row[16]);
			issue.setAssignbyid((String) row[17]);
			issue.setAssignby((String) row[18]);
			
			issue.setKstatusid((String) row[19]);
			issue.setGapdays(Integer.parseInt(String.valueOf(row[20])));
			
			
			issue.setNotificationsfrequency((String) row[21]);
			issue.setNotificationsfrequencyid((String) row[22]);
			
			listissue.add(issue);

		}
		
	} catch (Exception e) {
		System.out.println("error here");
		e.printStackTrace();
	}
	
	return listissue;
	
}


public Map<String, String> getDepartmentCountsForClosed()
{
	
	User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	String id=String.valueOf(objuserBean.getDesignation());
	String orgid=String.valueOf(objuserBean.getKpOrgId());

	
	HashMap<String,String> deptCounts =new LinkedHashMap<String,String>();
	
	String hql ="";
	
	if(id.equals("1"))
	{
	
     hql ="SELECT kpdepartment.name ,COUNT(report_issue.departmentid)as number  FROM report_issue  RIGHT  JOIN kpdepartment "
                    +" ON (kpdepartment.id=report_issue.departmentid) and report_issue.kstatus='1'  GROUP BY kpdepartment.id ";
	}
	
	else
	{
	
	 hql="SELECT kpdepartment.name ,COUNT(report_issue.departmentid)as number  FROM report_issue  RIGHT  JOIN kpdepartment" 
                   +" ON (kpdepartment.id=report_issue.departmentid) and report_issue.kstatus='1'and kp_org_id='"+orgid+" ' GROUP BY kpdepartment.id ";
	}	
	
	@SuppressWarnings("unchecked")
		List<Object[]> rows = em.createNativeQuery(hql).getResultList();
		for (Object[] row : rows) {
			deptCounts.put((String)row[0], String.valueOf(row[1]));
    }
		return deptCounts;
}



public Set<ReportIssue> getTasksBydepartmentClosed(String dept) {
	

	User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	String id=String.valueOf(objuserBean.getDesignation());
	String orgid=String.valueOf(objuserBean.getKpOrgId());
	
	Set<ReportIssue> listissue=new LinkedHashSet<ReportIssue>();
	
String hql ="";
	
	if(id.equals("1"))
	{
	
	 hql ="select  r.id , u.username, s.severity as sev, p.priority as pp,r.uploadfile,r.subject ,r.created_time,c.category as cc,ks.name,r.status ,r.taskno ,r.severity as sid, r.priority as pid,r.assignto , r.category as rcid,r.description ,r.taskdeadline,r.assignby,u1.username as asby ,"
                 +" r.kstatus ,DATEDIFF(CURDATE(),r.created_time ) as gap ,nf.frequence_name , r.notificationsfrequency  "
                +" from report_issue r, kpcategory c, kppriority p, kpusers u, kpusers u1, kpseverity s, kpstatus ks,kpdepartment kpd , notifications_frequency nf  "
               +"  where  r.kstatus=ks.id and r.assignto=u.id and r.assignby=u1.id and p.id=r.priority and s.id=r.severity and c.id=r.category and kpd.id=r.departmentid and r.kstatus='1'"
               +" and nf.id=r.notificationsfrequency  and kpd.name='"+dept +"'";
	}
	
	else
		if(id.equals("2"))
		{
			hql ="select  r.id , u.username, s.severity as sev, p.priority as pp,r.uploadfile,r.subject ,r.created_time,c.category as cc,ks.name,r.status ,r.taskno ,r.severity as sid, r.priority as pid,r.assignto , r.category as rcid,r.description ,r.taskdeadline,r.assignby,u1.username as asby , r.kstatus ,DATEDIFF(CURDATE(),r.created_time ) as gap , nf.frequence_name , r.notificationsfrequency " 
                  +" from report_issue r, kpcategory c, kppriority p, kpusers u, kpusers u1, kpseverity s, kpstatus ks,kpdepartment kpd , notifications_frequency nf "  
                   +"  where  r.kstatus=ks.id and r.assignto=u.id and r.assignby=u1.id and p.id=r.priority and s.id=r.severity and c.id=r.category and kpd.id=r.departmentid and r.kstatus='1' and and nf.id=r.notificationsfrequency and nf.id=r.notificationsfrequency  and  kpd.name='"+dept+"' and kpd.kp_org_id ='"+orgid+"'";

		}

	try {
		List<Object[]> rows = em.createNativeQuery(hql).getResultList();
		for (Object[] row : rows) {
			ReportIssue issue = new ReportIssue(); 
			issue.setId(Integer.parseInt(String.valueOf(row[0])));
			issue.setAssignto((String) row[1]);
			issue.setSeverity((String) row[2]);
			issue.setPriority((String) row[3]);
			issue.setUploadfile((String) row[4]);
			issue.setSubject((String) row[5]);
			issue.setCreatedTime((Date) row[6]);
			issue.setCategory((String) row[7]);
			issue.setKstatus((String) row[8]);
			issue.setStatus((String) row[9]);
			issue.setTaskno((String) row[10]);
			
			issue.setSeverityid((String) row[11]);
			issue.setPriorityid((String) row[12]);
			issue.setAssigntoid((String) row[13]);
		    issue.setCategoryid((String) row[14]);
		    issue.setDescription((String) row[15]);
			issue.setTaskdeadline((String) row[16]);
			issue.setAssignbyid((String) row[17]);
			issue.setAssignby((String) row[18]);
			
			issue.setKstatusid((String) row[19]);
			issue.setGapdays(Integer.parseInt(String.valueOf(row[20])));
			
			issue.setNotificationsfrequency((String) row[21]);
			issue.setNotificationsfrequencyid((String) row[22]);
			
			listissue.add(issue);

		}
		
	} catch (Exception e) {
		System.out.println("error here");
		e.printStackTrace();
	}
	
	return listissue;
	
}

public Set<ReportIssue> getTasksBydepartmentBalanced(String dept) {
	

	User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	String id=String.valueOf(objuserBean.getDesignation());
	String orgid=String.valueOf(objuserBean.getKpOrgId());
	
	Set<ReportIssue> listissue=new LinkedHashSet<ReportIssue>();
	
String hql ="";
	
	if(id.equals("1"))
	{
	
	 hql ="select  r.id , u.username, s.severity as sev, p.priority as pp,r.uploadfile,r.subject ,r.created_time,c.category as cc,ks.name,r.status ,r.taskno ,r.severity as sid, r.priority as pid,r.assignto , r.category as rcid,r.description ,r.taskdeadline,r.assignby,u1.username as asby ,"
                 +" r.kstatus ,DATEDIFF(CURDATE(),r.created_time ) as gap ,nf.frequence_name , r.notificationsfrequency "
                +" from report_issue r, kpcategory c, kppriority p, kpusers u, kpusers u1, kpseverity s, kpstatus ks,kpdepartment kpd , notifications_frequency nf "
               +"  where  r.kstatus=ks.id and r.assignto=u.id and r.assignby=u1.id and p.id=r.priority and s.id=r.severity and c.id=r.category and kpd.id=r.departmentid and r.kstatus <>'1'"
               +"  and nf.id=r.notificationsfrequency  and kpd.name='"+dept +"'";
	}
	
	else
		if(id.equals("2"))
		{
			hql ="select  r.id , u.username, s.severity as sev, p.priority as pp,r.uploadfile,r.subject ,r.created_time,c.category as cc,ks.name,r.status ,r.taskno ,r.severity as sid, r.priority as pid,r.assignto , r.category as rcid,r.description ,r.taskdeadline,r.assignby,u1.username as asby , r.kstatus ,DATEDIFF(CURDATE(),r.created_time ) as gap , nf.frequence_name , r.notificationsfrequency " 
                  +" from report_issue r, kpcategory c, kppriority p, kpusers u, kpusers u1, kpseverity s, kpstatus ks,kpdepartment kpd ,notifications_frequency nf  "  
                   +"  where  r.kstatus=ks.id and r.assignto=u.id and r.assignby=u1.id and p.id=r.priority and s.id=r.severity and c.id=r.category and kpd.id=r.departmentid and r.kstatus<>'1' and and nf.id=r.notificationsfrequency  and kpd.name='"+dept+"' and kpd.kp_org_id ='"+orgid+"'";

		}

	try {
		List<Object[]> rows = em.createNativeQuery(hql).getResultList();
		for (Object[] row : rows) {
			ReportIssue issue = new ReportIssue();
			issue.setId(Integer.parseInt(String.valueOf(row[0])));
			issue.setAssignto((String) row[1]);
			issue.setSeverity((String) row[2]);
			issue.setPriority((String) row[3]);
			issue.setUploadfile((String) row[4]);
			issue.setSubject((String) row[5]);
			issue.setCreatedTime((Date) row[6]);
			issue.setCategory((String) row[7]);
			issue.setKstatus((String) row[8]);
			issue.setStatus((String) row[9]);
			issue.setTaskno((String) row[10]);
			
			issue.setSeverityid((String) row[11]);
			issue.setPriorityid((String) row[12]);
			issue.setAssigntoid((String) row[13]);
		    issue.setCategoryid((String) row[14]);
		    issue.setDescription((String) row[15]);
			issue.setTaskdeadline((String) row[16]);
			issue.setAssignbyid((String) row[17]);
			issue.setAssignby((String) row[18]);
			
			issue.setKstatusid((String) row[19]);
			issue.setGapdays(Integer.parseInt(String.valueOf(row[20])));
			
			issue.setNotificationsfrequency((String) row[21]);
			issue.setNotificationsfrequencyid((String) row[22]);
			
			listissue.add(issue);

		}
		
	} catch (Exception e) {
		System.out.println("error here");
		e.printStackTrace();
	}
	
	return listissue;
	
}


public Set<ReportIssue> getfrequencyNotifications(String id) {
	Set<ReportIssue> listissue=new LinkedHashSet<ReportIssue>();
	//User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	
	String hql ="select r.id, r.taskno,r.subject,c.category as cname,r.category cid,p.priority as pname,r.priority as pid,u.username, r.assignto,r.created_time,s.severity as sname ,r.severity  as sid,r.status,r.description ,r.taskdeadline ,r.additionalinfo,u1.username as asby,r.assignby ,r.notificationsfrequency"
                 +"from report_issue r, kpcategory c, kppriority p, kpusers u, kpseverity s, kpstatus ks , kpstatuslogs kpl ,kpusers u1"
                 +"where  r.kstatus=ks.id and r.assignto=u.id and r.assignby =u1.id  and p.id=r.priority and s.id=r.severity and c.id=r.category and kpl.issueid=r.id and r.assignto ='4'  and r.additionalinfo ='1'  and  notificationsfrequency ='2' and datediff(Date(STR_TO_DATE(taskdeadline, '%d-%M-%Y %H:%i')),date(r.created_time))>20 order by kpl.statustime desc";
	
	try {
		List<Object[]> rows = em.createNativeQuery(hql).setParameter("id",id).getResultList();
		for (Object[] row : rows) {
			ReportIssue issue = new ReportIssue();
			issue.setId(Integer.parseInt(String.valueOf(row[0])));
			issue.setTaskno((String) row[1]);
			issue.setSubject((String) row[2]);
			issue.setCategory((String) row[3]);
			issue.setCategoryid((String) row[4]);
			issue.setPriority((String) row[5]);
			issue.setPriorityid((String) row[6]);
			issue.setAssignto((String) row[7]);
			issue.setAssigntoid((String) row[8]);
			issue.setCreatedTime((Date) row[9]);
			issue.setSeverity((String) row[10]);
			issue.setSeverityid((String) row[11]);
			issue.setStatus((String) row[12]);
			issue.setDescription((String) row[13]);
			issue.setTaskdeadline((String) row[14]);
			issue.setAdditionalinfo((String) row[15]);
			
			issue.setAssignby((String) row[16]);
			issue.setAssignbyid((String) row[17]);
			
			listissue.add(issue);

		}
	} catch (Exception e) {
		System.out.println("error here");
		e.printStackTrace();
	}
	
	
	return listissue;
}



     
     }



