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
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.charvikent.issuetracking.config.FilesStuff;
import com.charvikent.issuetracking.config.KptsUtil;
import com.charvikent.issuetracking.model.KpStatus;
import com.charvikent.issuetracking.model.KpStatusLogs;
import com.charvikent.issuetracking.model.ReportIssue;
import com.charvikent.issuetracking.model.User;

@Repository
public class ReportIssueDao {

	@PersistenceContext
	private EntityManager em;
	@Autowired
	HttpSession session;
	@Autowired
	FilesStuff fileTemplate;
	
	@Autowired
	KptsUtil utilities;

	public void saveReportIssue(ReportIssue reportIssue) {
		String randomNum = utilities.randNum();
		User objuserBean = (User) session.getAttribute("cacheUserBean");
		reportIssue.setAssignby(String.valueOf(objuserBean.getId()));
		reportIssue.setTaskno(randomNum);
		reportIssue.setKstatus("2");
		if(reportIssue.getUploadfile()!=null)
	     {
			reportIssue.setUploadfile(fileTemplate.concurrentFileNames());
			
	     } 
		em.persist(reportIssue);
		KpStatusLogs slogs=new KpStatusLogs();

		slogs.setIssueid(String.valueOf(reportIssue.getId()));
		slogs.setIassignto(reportIssue.getAssignto());
		slogs.setComment(reportIssue.getDescription());
		slogs.setKpstatus(reportIssue.getKstatus());
		if(reportIssue.getUploadfile()!=null)
	     {
		slogs.setUploadfiles(fileTemplate.concurrentFileNames());
		fileTemplate.clearFiles();
	     }

		em.persist(slogs);
		
		
		

	}

	/* @SuppressWarnings("unchecked")
public List<ReportIssue> getAllReportIssues()
 {
	 return (List<ReportIssue>) em.createQuery("select reportIssue from ReportIssue reportIssue").getResultList();
 }
	 */
 

	public Set<ReportIssue> getIssuesAssignBy(String id) {
		Set<ReportIssue> listissue=new TreeSet<ReportIssue>();

		try {
			@SuppressWarnings("unchecked")
			List <Object[]> rows=em.createQuery("select r.id , u.username, s.colour, p.priority,r.uploadfile,r.subject ,c.category,r.createdTime,ks.scolour,ks.name ,r.status, r.taskno from ReportIssue r, Category c, Priority p, User u, Severity s, KpStatus ks where r.assignto=u.id and r.kstatus=ks.id and p.id=r.priority and s.id=r.severity and c.id=r.category and r.kstatus<>'1'  and  r.assignby =:custName").setParameter("custName", id).getResultList();
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
				issue.setKstatus( row[8].toString());         
				issue.setAssignby((String) row[9]);
				issue.setStatus((String) row[10]);
				issue.setTaskno((String) row[11]);
				listissue.add(issue);

			}
		} catch (Exception e) {
			System.out.println("error here");
			e.printStackTrace();
		}

		return  listissue;

	}


	public Set getIssuesAssignTo(String id) {
		Set<ReportIssue> listissue=new TreeSet<ReportIssue>();

		try {
			@SuppressWarnings("unchecked")
			List <Object[]> rows=em.createNativeQuery("select r.id, r.taskno,r.subject,c.category as cname,r.category cid,p.priority as pname,r.priority as pid,u.username, r.assignto,r.created_time from report_issue r, kpcategory c, kppriority p, kpusers u, kpseverity s, kpstatus ks    where  r.kstatus=ks.id and r.assignto=u.id and p.id=r.priority and s.id=r.severity and c.id=r.category and r.assignto=:custid").setParameter("custid", id).getResultList();
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
				issue.setAssignto((String) row[8]);                  
				issue.setKstatus( (String) row[9]);
				issue.setStatus((String) row[10]);
				issue.setTaskno((String) row[11]);


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
		
		Set<ReportIssue> listissue=new TreeSet<ReportIssue>();

		try {
			@SuppressWarnings("unchecked")
			List <Object[]> rows=em.createQuery("select r.id , u.username, s.colour, p.priority,r.uploadfile,r.subject ,r.createdTime,c.category,ks.scolour,ks.name, t.status ,r.taskno  from ReportIssue r, Category c, Priority p, User u, Severity s, KpStatus ks   where  r.kstatus=ks.id and r.assignto=u.id and p.id=r.priority and s.id=r.severity and c.id=r.category  and r.kstatus='4' and  r.assignto =:custName").setParameter("custName", id).getResultList();
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
				issue.setStatus((String) row[10]);
				issue.setTaskno((String) row[11]);


				listissue.add(issue);

			}
		} catch (Exception e) {
			System.out.println("error here");
			e.printStackTrace();
		}

		return  listissue;

	}








	public Set<ReportIssue> getAllReportIssues() {
		Set<ReportIssue> listissue=new TreeSet<ReportIssue>();

		try {
			@SuppressWarnings("unchecked")
			List<Object[]> rows = em.createQuery("select r.id, c.category ,s.severity,p.priority,"
					+ "u.username ,r.subject ,r.uploadfile,"
					+ "DATE(r.createdTime), Date(r.updatedTime),r.status,r.description,r.assignto,r.category,r.priority,r.severity,r.status from ReportIssue r, Category c ,Severity s,Priority p,User u  where r.category=c.id and r.severity=s.id and r.priority=p.id and r.assignto=u.id")
			.getResultList();
			for (Object[] row : rows) {
				ReportIssue issue = new ReportIssue();

				issue.setId(Integer.parseInt(String.valueOf(row[0])));

				issue.setCategory((String) row[1]);
				issue.setSeverity((String) row[2]);
				issue.setPriority((String) row[3]);
				issue.setAssignto((String) row[4]);
				issue.setSubject((String) row[5]);
				issue.setUploadfile((String) row[6]);
				issue.setCreatedTime((Date) row[7]);
				issue.setUpdatedTime((Date) row[8]);
				issue.setStatus((String) row[9]);
				issue.setDescription((String) row[10]);
				issue.setAssigntoid((String) row[11]);
				issue.setCategoryid((String) row[12]);
				issue.setPriorityid((String) row[13]);
				issue.setSeverityid((String) row[14]);
				issue.setTaskno((String) row[15]);
				listissue.add(issue);

			}
		} catch (Exception e) {
			System.out.println("error here");
			e.printStackTrace();
		}

		return  listissue;

	}


	@SuppressWarnings("unchecked")
	public Map<Integer, Integer>  getGapAndCount() {

		List<ReportIssue> listissuegap=new ArrayList<>();
		ReportIssue issuegap =null;

		List<Object[]> rows = 	em.createNativeQuery("SELECT DATEDIFF(CURDATE(),created_time ) as gap ,count(id)  from report_issue group by gap ").getResultList();

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
	public Map<Integer, Integer>  getGapAndCountForClosed() {

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

		Set<ReportIssue> listissue=new TreeSet<ReportIssue>();

		try {
			List<Object[]> rows = em
			.createNativeQuery(" select   r.id , u.username, s.colour, p.priority,r.uploadfile,r.subject ,c.category,r.created_time,ks.name,ks.scolour,r.status ,r.taskno from report_issue r, kpcategory c, kppriority p, kpusers u, kpseverity s,kpstatus ks  where r.kstatus=ks.id and r.assignto=u.id and p.id=r.priority and s.id=r.severity and c.id=r.category and r.kstatus='1'  and DATEDIFF (CURDATE(),r.updated_time )<=30 and  r.assignby =:custName union (select   r.id , u.username, s.colour, p.priority,r.uploadfile,r.subject ,c.category,r.created_time,ks.name,ks.scolour from report_issue r, category c, priority p, kpusers u, severity s,kpstatus ks  where r.kstatus=ks.id and r.assignto=u.id and p.id=r.priority and s.id=r.severity and c.id=r.category and r.kstatus='1'  and DATEDIFF (CURDATE(),r.updated_time )<=30 and  r.assignto =:custName )").setParameter("custName", id)
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
				issue.setStatus((String) row[10]);
				issue.setTaskno((String) row[11]);
				listissue.add(issue);

			}
		} catch (Exception e) {
			System.out.println("error here");
			e.printStackTrace();
		}

		return  listissue;


	}

	/**
	 * @param 
	 * @return
	 */
	public ReportIssue getReportIssueById(Integer id) {

		return em.find(ReportIssue.class, id);
	}
	

	public void updateIssue(ReportIssue issue) {
		
		User objuserBean = (User) session.getAttribute("cacheUserBean");
     ReportIssue editissue=getReportIssueById(issue.getId());
     editissue.setAssignto(issue.getAssignto());
     //editissue.setAssignby(issue.getAssignby());
     editissue.setCategory(issue.getCategory());
     editissue.setDescription(issue.getDescription());
     editissue.setPriority(issue.getPriority());
     editissue.setSeverity(issue.getSeverity());
     editissue.setSubject(issue.getSubject());
    // editissue.setKstatus(issue.getKstatus());
     //editissue.setAdditionalinfo(issue.getAdditionalinfo());
     if(issue.getUploadfile()!=null)
     {
     editissue.setUploadfile(fileTemplate.concurrentFileNames());
     }
		em.flush();

		KpStatusLogs slogs=new KpStatusLogs();

		slogs.setIssueid(issue.getId().toString());
		slogs.setIassignto(String.valueOf(objuserBean.getId()));
		slogs.setComment(issue.getDescription());
		slogs.setKpstatus(issue.getKstatus());
		
		if(issue.getUploadfile()!=null)
	     {
		slogs.setUploadfiles(fileTemplate.concurrentFileNames());
		fileTemplate.clearFiles();
	     }
		em.merge(slogs);
		em.flush();


	}



	@SuppressWarnings("unchecked")
	public List<KpStatus> getKpStatues() {
		return em.createQuery("SELECT kpstatus FROM KpStatus kpstatus").getResultList();
	}

	

	public  Map<String,Integer> getCountByStatusWise() {

		Map<String,Integer> statusCounts =new LinkedHashMap<String,Integer>();

		Integer opentotal=0;

		try {
			@SuppressWarnings("unchecked")
			List<Object[]> rows = em
			.createNativeQuery(" select ks.name,count(*)as count from report_issue r,kpstatus ks  where  r.kstatus=ks.id group by kstatus")
			.getResultList();
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

	public Set<KpStatusLogs> getRepeatlogsById(int id) {
		
		Set<KpStatusLogs> listRepeatlogs =new TreeSet<KpStatusLogs>();
		try {
			@SuppressWarnings("unchecked")
			List<Object[]> rows = em
			.createNativeQuery("select l.comment,l.uploadfiles,l.statustime,kp.username,s.name from kpstatuslogs l,kpusers kp,kpstatus s where l.iassignto=kp.id and l.kpstatus=s.id and l.issueid =:custName" ).setParameter("custName", id)
			.getResultList();
			for (Object[] row : rows) {
				KpStatusLogs logs=new KpStatusLogs();
				logs.setComment((String) row[0]);
				logs.setUploadfiles((String) row[1]);
				logs.setStatustime((Date)row[2]);
				logs.setIssueid((String) row[3]);  // passing username
				logs.setKpstatus((String) row[4]);
				listRepeatlogs.add(logs);

			}
		} catch (Exception e) {
			System.out.println("error here");
			e.printStackTrace();
		}
		
		return listRepeatlogs;
	}
	
	
	
	public boolean deleteTask(Integer id, String status) {
		Boolean delete=false;
		try{
			
			ReportIssue task= (ReportIssue)em.find(ReportIssue.class ,id);
			   task.setStatus(status);
			   em.merge(task);
			if(!status.equals(task.getStatus()))
			{
				delete=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return delete;
	}

	public void saveSubTask(KpStatusLogs subtask) {
		
		User objuserBean = (User) session.getAttribute("cacheUserBean");
		subtask.setIassignto(String.valueOf(objuserBean.getId()));
		
		if(subtask.getUploadfiles()!=null)
	     {
		subtask.setUploadfiles(fileTemplate.concurrentFileNames());
		fileTemplate.clearFiles();
	     }
		em.persist(subtask);
		
		
		
	}

	

	public Set<ReportIssue> getissuesByselectionAssignTo() {
		Set<ReportIssue> listissue=new LinkedHashSet<ReportIssue>();
		User sessionBean = (User) session.getAttribute("cacheUserBean");
		try {
			List<Object[]> rows = em.createNativeQuery("select r.id, r.taskno,r.subject,c.category as cname,r.category cid,p.priority as pname,r.priority as pid,u.username, r.assignto,r.created_time,s.severity as sname ,r.severity  as sid,r.status,r.description  from report_issue r, kpcategory c, kppriority p, kpusers u, kpseverity s, kpstatus ks , kpstatuslogs kpl  where  r.kstatus=ks.id and r.assignto=u.id and p.id=r.priority and s.id=r.severity and c.id=r.category and kpl.issueid=r.id and r.assignto =:id  order by kpl.statustime").setParameter("id", sessionBean.getId()).getResultList();
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

				
				listissue.add(issue);

			}
		} catch (Exception e) {
			System.out.println("error here");
			e.printStackTrace();
		}
		
		
		return listissue;
	}
	
	
	
	public Set<ReportIssue> getissuesByselectionAssignBy() {
		Set<ReportIssue> listissue=new LinkedHashSet<ReportIssue>();
		User sessionBean = (User) session.getAttribute("cacheUserBean");
		try {
			List<Object[]> rows = em.createNativeQuery(" select r.id, r.taskno,r.subject,c.category as cname,r.category cid,p.priority as pname,r.priority as pid,u.username, r.assignto,r.created_time,s.severity as sname ,r.severity  as sid ,r.status,r.description from report_issue r, kpcategory c, kppriority p, kpusers u, kpseverity s, kpstatus ks ,kpstatuslogs kpl   where  r.kstatus=ks.id and r.assignto=u.id and p.id=r.priority and s.id=r.severity and c.id=r.category  and kpl.issueid=r.id and  r.assignby=:id  order by kpl.statustime").setParameter("id", sessionBean.getId()).getResultList();
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

				
				listissue.add(issue);

			}
		} catch (Exception e) {
			System.out.println("error here");
			e.printStackTrace();
		}
		
		
		return listissue;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public Set<ReportIssue> getDepartmentWise(String deptid) {
		Set<ReportIssue> listissue=new LinkedHashSet<ReportIssue>();
		
		
		try {
			List<Object[]> rows = em.createNativeQuery("select r.id , u.username, s.severity as sev, p.priority as pp,r.uploadfile,r.subject ,r.created_time,c.category as cc,ks.name,r.status ,r.taskno ,r.severity as sid, r.priority as pid,r.assignto , r.category as rcid,r.description from report_issue r, kpcategory c, kppriority p, kpusers u, kpseverity s, kpstatus ks, kpstatuslogs kpl    where  r.kstatus=ks.id and r.assignto=u.id and p.id=r.priority and s.id=r.severity and c.id=r.category   and  kpl.issueid=r.id and u.department =:custName order by   kpl.statustime desc").setParameter("custName", deptid).getResultList();
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
				
				listissue.add(issue);

			}
			
		} catch (Exception e) {
			System.out.println("error here");
			e.printStackTrace();
		}
		
		
		return listissue;
	}
	
	
	
	
	
	
	
	
	
	





}








