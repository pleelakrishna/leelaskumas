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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.charvikent.issuetracking.config.FilesStuff;
import com.charvikent.issuetracking.config.KptsUtil;
import com.charvikent.issuetracking.model.KpHistory;
import com.charvikent.issuetracking.model.KpStatus;
import com.charvikent.issuetracking.model.KpStatusLogs;
import com.charvikent.issuetracking.model.ReportIssue;
import com.charvikent.issuetracking.model.User;
import com.charvikent.issuetracking.service.CategoryService;
import com.charvikent.issuetracking.service.KpStatusLogsService;
import com.charvikent.issuetracking.service.MastersService;
import com.charvikent.issuetracking.service.PriorityService;
import com.charvikent.issuetracking.service.SeverityService;
import com.charvikent.issuetracking.service.UserService;

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
	@Autowired
	KpStatusLogsDao kpStatusLogsDao;
	
	@Autowired
	MastersService  mastersService;
	
	@Autowired
	private PriorityService priorityService;

	@Autowired
	private SeverityService severityService;
	@Autowired
	private UserService userService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	KpStatusLogsService kpStatusLogsService;

	public void saveReportIssue(ReportIssue reportIssue) {
		String randomNum = utilities.randNum();
		User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String id=String.valueOf(objuserBean.getId());
		String deptid=String.valueOf(objuserBean.getDepartment());
		
		reportIssue.setAssignby(id);
		reportIssue.setTaskno(randomNum);
		reportIssue.setKstatus("2");
		reportIssue.setDepartmentid(deptid);
		if(reportIssue.getUploadfile()!=null)
	     {
			reportIssue.setUploadfile(fileTemplate.concurrentFileNames());
			
	     } 
		em.persist(reportIssue);
		KpStatusLogs slogs=new KpStatusLogs();

		slogs.setIssueid(String.valueOf(reportIssue.getId()));
		slogs.setIassignto(reportIssue.getAssignby());
		slogs.setComment(reportIssue.getDescription());
		slogs.setKpstatus(reportIssue.getKstatus());
		if(reportIssue.getUploadfile()!=null)
	     {
		slogs.setUploadfiles(fileTemplate.concurrentFileNames());
		
	     }

		em.persist(slogs);
		
		
		KpHistory history =new KpHistory();
		
		history.setIssueid(String.valueOf(reportIssue.getId()));
		history.setKpfield("New Task created");
		history.setKpchange("");
		history.setChangedby(id);
		
		if(reportIssue.getUploadfile()!=null)
	     {
			history.setUploadfiles(fileTemplate.concurrentFileNames());
			fileTemplate.clearFiles();
	     }
		em.persist(history);
		
		

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


	public Set<ReportIssue> getIssuesAssignTo(String id) {
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


	public Set<ReportIssue> getIssuesAssignToResolved(String id) {
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
		Set<ReportIssue> listissue=new LinkedHashSet<ReportIssue>();

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
		
		User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String id=String.valueOf(objuserBean.getDesignation());

		List<ReportIssue> listissuegap=new ArrayList<>();
		ReportIssue issuegap =null;
		
		List<Object[]> rows =null;
		
		String hql ="SELECT DATEDIFF(CURDATE(),created_time ) as gap ,count(id)  from report_issue  r where r.assignto=:cuid  group by gap";
         
		if(id.equals("1"))
		{
		
		 rows = 	em.createNativeQuery("SELECT DATEDIFF(CURDATE(),created_time ) as gap ,count(id)  from report_issue group by gap ").getResultList();
		}
		else
		{
		
	      rows = 	em.createNativeQuery(hql).setParameter("cuid", id).getResultList();
		}
		
		
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
		
		User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String id=String.valueOf(objuserBean.getId());

		//String custName=null;
		
		List<Object[]> rows =null;
		
		String hql ="SELECT DATEDIFF(CURDATE(),created_time ) as gap ,count(id)  from report_issue  r where r.assignto=:cuid and r.kstatus =:kstatus  group by gap";
          
		if(id.equals("1"))
		{

		 rows = 	em.createNativeQuery(" SELECT DATEDIFF(CURDATE(),created_time ) as gap ,count(id)  from report_issue where kstatus =:custName  group by gap  ").setParameter("custName", "1").getResultList();
		}
		else
		{
		 rows = 	em.createNativeQuery(hql).setParameter("cuid",id).setParameter("kstatus", "1").getResultList();
		}
		
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
		
		User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String id=String.valueOf(objuserBean.getId());
		
		
		String fieldname ="";
		String change  ="";
		
		//Before  inserting getting data
		Set<ReportIssue> set= getTaksByid(issue.getId());
    
     List<ReportIssue> list = new ArrayList<ReportIssue>(set);
     ReportIssue editissue1= list.get(0);
     
     ReportIssue editissue=getReportIssueById(issue.getId());
     
     
     
     Map<Integer,String> semap= severityService.getSeverityNames();
		 Map<Integer,String> pmap=priorityService.getPriorityNames();
	   Map<Integer,String> umap=userService.getUserName();
	   Map<Integer,String> cmap= categoryService.getCategoryNames();
		 Map<Integer,String> smap = mastersService.getKpStatues();
		
		
     
     
     
     editissue.setAssignto(issue.getAssignto());
     //editissue.setAssignby(issue.getAssignby());
     editissue.setCategory(issue.getCategory());
     editissue.setDescription(issue.getDescription());
    // editissue.setPriority(issue.getPriority());
     editissue.setSeverity(issue.getSeverity());
     editissue.setSubject(issue.getSubject());
     editissue.setTaskdeadline(issue.getTaskdeadline());
     editissue.setNotificationsfrequency(issue.getNotificationsfrequency());
    // editissue.setKstatus(issue.getKstatus());
     //editissue.setAdditionalinfo(issue.getAdditionalinfo());
     if(issue.getUploadfile()!=null)
     {
     editissue.setUploadfile(fileTemplate.concurrentFileNames());
     
     fieldname = fieldname+" New file added ";
	 change =change+issue.getUploadfile();
     }
		em.merge(editissue);
		
		
		//after inserting getting values
		
		
		System.out.println(editissue1.getSeverity());
		System.out.println(semap.get(Integer.parseInt(issue.getSeverity())));
		
		
		
		if(!editissue1.getCategory().equals(cmap.get(Integer.parseInt(issue.getCategory()))))
	     {
	    	 fieldname = fieldname+" Category field changed  &";
	    	 change =change+editissue1.getCategory() +"-->"+ cmap.get(Integer.parseInt(issue.getCategory()))+"&";
	     }
	     if(!editissue1.getSeverity().equals(semap.get(Integer.parseInt(issue.getSeverity()))))
	     {
	    	 fieldname = fieldname+" Severity field changed &";
	    	 change =change+ editissue1.getSeverity() +"-->"+semap.get(Integer.parseInt(issue.getSeverity()))+"&";
	     }
	    /* if(!editissue1.getPriority().equals(pmap.get(Integer.parseInt(issue.getPriority()))) )
	     {
	    	 fieldname = fieldname+" Priority field changed  &";
	    	 change =change+ editissue1.getPriority() +"-->"+pmap.get(Integer.parseInt(issue.getPriority()))+"&";
	     }*/
	     if(!editissue1.getAssignto().equals(umap.get(Integer.parseInt(issue.getAssignto())) ))
	     {
	    	 fieldname = fieldname+" Assignto field changed  &";
	    	 change =change+ editissue1.getAssignto()+"-->"+umap.get(Integer.parseInt(issue.getAssignto())) +"&";
	     }
	     
	     if(!editissue1.getSubject().equals(issue.getSubject() ))
	     {
	    	 fieldname = fieldname+" Subject field changed &";
	    	 change =change+ editissue1.getSubject()+"-->"+issue.getSubject()+"&";
	     }
	     if(!editissue1.getDescription().equals(issue.getDescription() ))
	     {
	    	 fieldname = fieldname+" Description field changed  &";
	    	 change =change+ editissue1.getDescription()+"-->"+issue.getDescription()+"&";
	     }
	     if(!editissue1.getTaskdeadline().equals(issue.getTaskdeadline() ))
	     {
	    	 fieldname = fieldname+" TaskDeadline field changed &";
	    	 change =change+ editissue1.getTaskdeadline()+"-->"+issue.getTaskdeadline()+"&";
	     }
	     
		
	     if(fieldname.length()>0)
	     {
		System.out.println(fieldname.substring(0,fieldname.length()-1));
		KpHistory history =new KpHistory();
		
		history.setIssueid(String.valueOf(issue.getId()));
		history.setKpfield((fieldname.substring(0,fieldname.length()-1)));
		history.setKpchange((change.substring(0,change.length()-1)));
		history.setChangedby(id);
		
		if(issue.getUploadfile()!=null)
	     {
			history.setUploadfiles(fileTemplate.concurrentFileNames());
	     }
		em.persist(history);
		
	     }

		KpStatusLogs slogs=new KpStatusLogs();

		slogs.setIssueid(issue.getId().toString());
		slogs.setIassignto(id);
		slogs.setComment(issue.getDescription());
		slogs.setKpstatus(editissue.getKstatus());
		
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
		
		
		User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String id=String.valueOf(objuserBean.getId());
		

		Map<String,Integer> statusCounts =new LinkedHashMap<String,Integer>();

		Integer opentotal=0;

		try {
			@SuppressWarnings("unchecked")
			List<Object[]> rows = em
			.createNativeQuery(" select ks.name,count(ks.name)as count from report_issue r,kpstatus ks  where  r.kstatus=ks.id  and r.assignto =:id group by kstatus").setParameter("id", id).getResultList();
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
		
		
		for(KpStatusLogs entry:listRepeatlogs)
		{
			System.out.println(entry.getComment());
		}
		
		
		return listRepeatlogs;
	}
	
	
	
	public boolean deleteTask(Integer id, String status) {
		Boolean delete=false;
		try{
			
			ReportIssue task= em.find(ReportIssue.class ,id);
			   task.setStatus(status);
			   em.merge(task);

		}catch(Exception e){
			e.printStackTrace();
		}
		return delete;
	}

	public void saveSubTask(KpStatusLogs subtask) {
		
		User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String id=String.valueOf(objuserBean.getId());
		//TreeSet<KpStatusLogs>  list =kpStatusLogsDao.getKpStatusLogsDao();
		Map<Integer,String> listmap =mastersService.getKpStatues();
		
		KpStatusLogs  editlog =  kpStatusLogsService.getLastRecord(subtask.getIssueid());
		
			//KpStatusLogs editlog1   = list.last();
		
		subtask.setIassignto(id);
		String fieldname ="";
		String change ="";
		//KpStatusLogs editlog = kpStatusLogsDao.getKpStatusLogById(clog.getId());
		
		if(!editlog.getComment().equals(subtask.getComment()) )
	     {
	    	 fieldname = fieldname+" New comment added &";
	    	 change =change+editlog.getComment() +"-->"+ subtask.getComment()+"&";
	     }
		if(!editlog.getKpstatus().equals(listmap.get(Integer.parseInt(subtask.getKpstatus()))) )
	     {
			
			
	    	 fieldname = fieldname+" Status changed  &";
	    	 change =change+editlog.getKpstatus() +"-->"+ listmap.get(Integer.parseInt(subtask.getKpstatus()))+"&";
	     }
		
		 KpHistory history =new KpHistory();
		 
		 
		if(subtask.getUploadfiles()!=null)
	     {
			 fieldname = fieldname+" New file added &";
		subtask.setUploadfiles(fileTemplate.concurrentFileNames());
		change =change+subtask.getUploadfiles()+"&";
		
		history.setUploadfiles(fileTemplate.concurrentFileNames());
		fileTemplate.clearFiles();
	     }
		
		
		em.persist(subtask);
		
		
		
		ReportIssue issue =getReportIssueById(Integer.parseInt(subtask.getIssueid()));
		issue.setKstatus(subtask.getKpstatus());
		em.merge(issue);  //status updated
		
		
        
		
		history.setIssueid(String.valueOf(issue.getId()));
		history.setKpfield((fieldname.substring(0,fieldname.length()-1)));
		history.setKpchange(change.substring(0,change.length()-1));
		history.setChangedby(id);
		em.persist(history);
		
		
		
		
		
		
		
	}

	

	public Set<ReportIssue> getissuesByselectionAssignTo(String id) {
		Set<ReportIssue> listissue=new LinkedHashSet<ReportIssue>();
		//User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			List<Object[]> rows = em.createNativeQuery("select r.id, r.taskno,r.subject,c.category as cname,r.category cid,p.priority as pname,r.priority as pid,u.username, r.assignto,r.created_time,s.severity as sname ,r.severity  as sid,r.status,r.description ,r.taskdeadline ,u1.username as asby,r.assignby,ks.name, r.kstatus ,nf.frequence_name , r.notificationsfrequency  from report_issue r, kpcategory c, kppriority p, kpusers u, kpusers u1, kpseverity s, kpstatus ks , kpstatuslogs kpl,notifications_frequency nf   where  r.kstatus=ks.id and r.assignto=u.id and r.assignby=u1.id and p.id=r.priority and s.id=r.severity and c.id=r.category and kpl.issueid=r.id and r.assignto =:id and r.kstatus<>'1' and  nf.id=r.notificationsfrequency  order by kpl.statustime desc").setParameter("id",id).getResultList();
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
				issue.setAssignby((String) row[15]);
				issue.setAssignbyid((String) row[16]);
				
				issue.setKstatus((String) row[17]);
				
				issue.setKstatusid((String) row[18]);
				issue.setNotificationsfrequency((String) row[19]);
				issue.setNotificationsfrequencyid((String) row[20]);

				
				listissue.add(issue);

			}
		} catch (Exception e) {
			System.out.println("error here");
			e.printStackTrace();
		}
		
		
		return listissue;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public Set<ReportIssue> getissuesByselectionAssignBy(String id) {
		Set<ReportIssue> listissue=new LinkedHashSet<ReportIssue>();
		String hql ="select r.id, r.taskno,r.subject,c.category as cname,r.category cid,p.priority as pname,r.priority as pid,u.username, r.assignto,r.created_time,s.severity as sname ,r.severity  as sid ,r.status,r.description ,r.taskdeadline,r.assignby,u1.username as asby,ks.name ,r.kstatus, nf.frequence_name , r.notificationsfrequency  "
				+ "from report_issue r, kpcategory c, kppriority p, kpusers u, kpusers u1, kpseverity s, kpstatus ks ,kpstatuslogs kpl ,notifications_frequency nf  "
				+ "  where  r.kstatus=ks.id and r.assignto=u.id and  r.assignby=u1.id and p.id=r.priority and s.id=r.severity and c.id=r.category  and kpl.issueid=r.id and  r.assignby="+id+" and nf.id=r.notificationsfrequency  and r.kstatus<>'1' order by kpl.statustime desc";
		
		try {
			//List<Object[]> rows = em.createNativeQuery(" select r.id, r.taskno,r.subject,c.category as cname,r.category cid,p.priority as pname,r.priority as pid,u.username, r.assignto,r.created_time,s.severity as sname ,r.severity  as sid ,r.status,r.description ,r.taskdeadline,r.assignby,u1.username as asby,ks.name ,r.kstatus from report_issue r, kpcategory c, kppriority p, kpusers u, kpusers u1, kpseverity s, kpstatus ks ,kpstatuslogs kpl   where  r.kstatus=ks.id and r.assignto=u.id and  r.assignby=u1.id and p.id=r.priority and s.id=r.severity and c.id=r.category  and kpl.issueid=r.id and  r.assignby=:id  and r.kstatus<>'1' order by kpl.statustime desc").setParameter("id",id).getResultList();
			List<Object[]> rows = em.createNativeQuery(hql).getResultList();
			
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
				issue.setAssignbyid((String) row[15]);
				issue.setAssignby((String) row[16]);
				issue.setKstatus((String) row[17]);
				issue.setKstatusid((String) row[18]);
				issue.setNotificationsfrequency((String) row[19]);
				issue.setNotificationsfrequencyid((String) row[20]);
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
			List<Object[]> rows = em.createNativeQuery("select  r.id , u.username, s.severity as sev, p.priority as pp,r.uploadfile,r.subject ,r.created_time,c.category as cc,ks.name,r.status ,r.taskno ,r.severity as sid, r.priority as pid,r.assignto , r.category as rcid,r.description ,r.taskdeadline,r.assignby,u1.username as asby ,r.kstatus from report_issue r, kpcategory c, kppriority p, kpusers u, kpusers u1, kpseverity s, kpstatus ks, kpstatuslogs kpl    where  r.kstatus=ks.id and r.assignto=u.id and r.assignby=u1.id and p.id=r.priority and s.id=r.severity and c.id=r.category   and  kpl.issueid=r.id and u.department =:custName order by kpl.statustime desc").setParameter("custName", deptid).getResultList();
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
				
				//issue.setKstatus((String) row[19]);
			    
			    
				
				listissue.add(issue);

			}
			
		} catch (Exception e) {
			System.out.println("error here");
			e.printStackTrace();
		}
		
		
		return listissue;
	}
	
	public Set<ReportIssue> getTaskByCategory(String statusId,String categoryId) {
		Set<ReportIssue> listissue=new LinkedHashSet<ReportIssue>();
		try {
			List<Object[]> rows = em.createNativeQuery("select r.id, r.taskno,r.subject,c.category as cname,r.category cid,p.priority as pname,r.priority as pid,u.username, r.assignto,r.created_time,s.severity as sname ,r.severity  as sid ,r.status,r.description ,r.taskdeadline,r.assignby,u1.username as asby,ks.name ,  nf.frequence_name , r.notificationsfrequency  from report_issue r, kpcategory c, kppriority p, kpusers u, kpusers u1, kpseverity s, kpstatus ks ,notifications_frequency nf     where  r.kstatus=ks.id and r.assignto=u.id and  r.assignby=u1.id and p.id=r.priority and s.id=r.severity and c.id=r.category  and  nf.id=r.notificationsfrequency and r.kstatus=:status and r.category=:categoryId").setParameter("status",statusId).setParameter("categoryId",categoryId).getResultList();
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
				issue.setAssignbyid((String) row[15]);
				issue.setAssignby((String) row[16]);
				issue.setKstatus((String) row[17]);
				
				issue.setNotificationsfrequency((String) row[18]);
				issue.setNotificationsfrequencyid((String) row[19]);


				
				listissue.add(issue);

			}
		} catch (Exception e) {
			System.out.println("error here");
			e.printStackTrace();
		}
		
		
		return listissue;
	}
	
	
	

	public void  openTask(Integer id) {
		
		
		User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String id2=String.valueOf(objuserBean.getId());
		
		try{
			
			ReportIssue task= em.find(ReportIssue.class ,id);
			if(!task.getAdditionalinfo().equals("1"))
			{
			   task.setAdditionalinfo("1");
			   task.setKstatus("3");
			   em.merge(task);
			KpStatusLogs slogs=new KpStatusLogs();
			slogs.setIssueid(String.valueOf(id));
			slogs.setIassignto(task.getAssignto());
			slogs.setComment("Task Mark As Read");
			slogs.setKpstatus(task.getKstatus());
			em.persist(slogs);
			

			KpHistory history =new KpHistory();
			
			history.setIssueid(String.valueOf(id));
			history.setKpfield("Task Mark As Read");
			history.setKpchange("");
			history.setChangedby(id2);
			
			
			em.persist(history);
			
			
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public Set<ReportIssue> getOpenTasks(String id) {
		Set<ReportIssue> listissue=new LinkedHashSet<ReportIssue>();
		//User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			List<Object[]> rows = em.createNativeQuery("select r.id, r.taskno,r.subject,c.category as cname,r.category cid,p.priority as pname,r.priority as pid,u.username, r.assignto,r.created_time,s.severity as sname ,r.severity  as sid,r.status,r.description ,r.taskdeadline ,r.additionalinfo,u1.username as asby,r.assignby from report_issue r, kpcategory c, kppriority p, kpusers u, kpseverity s, kpstatus ks , kpstatuslogs kpl ,kpusers u1 where  r.kstatus=ks.id and r.assignto=u.id and r.assignby =u1.id  and p.id=r.priority and s.id=r.severity and c.id=r.category and kpl.issueid=r.id and r.assignto =:id  and r.additionalinfo ='0' order by kpl.statustime desc").setParameter("id",id).getResultList();
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
	
	
	
	
	public Set<ReportIssue> getTaksByid(Integer id2) {
		
		User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String id=String.valueOf(objuserBean.getId());
		Set<ReportIssue> listissue=new LinkedHashSet<ReportIssue>();
		
		String hql ="select r.id, r.taskno,r.subject,c.category as cname,r.category as cid,p.priority as pname,r.priority as pid,u.username, r.assignto,r.created_time,s.severity as sname ,r.severity  as sid ,r.status,r.description ,r.taskdeadline,r.assignby,u1.username as asby,ks.name,r.uploadfile"
        +" from report_issue r, kpcategory c, kppriority p, kpusers u, kpusers u1, kpseverity s, kpstatus ks"   
        +" where  r.kstatus=ks.id and r.assignto=u.id and  r.assignby=u1.id and p.id=r.priority and s.id=r.severity and c.id=r.category and r.id=:tid"; 

		try {
			@SuppressWarnings("unchecked")
			List<Object[]> rows = em.createNativeQuery(hql).setParameter("tid",id2).getResultList();
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
				issue.setAssignbyid((String) row[15]);
				issue.setAssignby((String) row[16]);
				issue.setKstatus((String) row[17]);
				issue.setUploadfile((String) row[18]);
				listissue.add(issue);

			}
		} catch (Exception e) {
			System.out.println("error here");
			e.printStackTrace();
		}

		return  listissue;

	}

	public List<ReportIssue> getStatusList(String id) {
		List<ReportIssue> listissue=null;
		try {
			List<Object[]> rows = em.createNativeQuery("select r.id, r.taskno,r.subject,c.category as cname,r.category cid,p.priority as pname,r.priority as pid,u.username, r.assignto,r.created_time,s.severity as sname ,r.severity  as sid ,r.status,r.description ,r.taskdeadline,r.assignby,u1.username as asby,ks.name from report_issue r, kpcategory c, kppriority p, kpusers u, kpusers u1, kpseverity s, kpstatus ks    where  r.kstatus=ks.id and r.assignto=u.id and  r.assignby=u1.id and p.id=r.priority and s.id=r.severity and c.id=r.category  and  r.kstatus=:status and r.kstatus=:id").setParameter("id",id).getResultList();
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
				issue.setAssignbyid((String) row[15]);
				issue.setAssignby((String) row[16]);
				issue.setKstatus((String) row[17]);


				
				listissue.add(issue);

			}
		} catch (Exception e) {
			System.out.println("error here");
			e.printStackTrace();
		}
		
		
		return listissue;	}

	public Set<ReportIssue> getTaskByStatusDashBord(String status) {
		
		User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String id=String.valueOf(objuserBean.getDesignation());
		Set<ReportIssue> listissue=new LinkedHashSet<ReportIssue>();
		String hqlAdmin = "select r.id, r.taskno,r.subject,c.category as cname,r.category cid,p.priority as pname,r.priority as pid,u.username, r.assignto,r.created_time,s.severity as sname ,r.severity  as sid ,r.status,r.description ,r.taskdeadline,r.assignby,u1.username as asby,ks.name , nf.frequence_name , r.notificationsfrequency  from report_issue r, kpcategory c, kppriority p, kpusers u, kpusers u1, kpseverity s, kpstatus ks ,notifications_frequency nf    where  r.kstatus=ks.id and r.assignto=u.id and  r.assignby=u1.id and p.id=r.priority and s.id=r.severity and c.id=r.category and nf.id=r.notificationsfrequency and  r.kstatus=:status";
		String hqlUser= hqlAdmin + " and r.assignto=:assignto";
		List<Object[]> rows =null;
		try {
			
			if(id.equals("1")) {
		          rows = em.createNativeQuery(hqlAdmin).setParameter("status",status).getResultList();
			}else {
				  rows = em.createNativeQuery(hqlUser).setParameter("status",status).setParameter("assignto",id).getResultList();
			}
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
				issue.setAssignbyid((String) row[15]);
				issue.setAssignby((String) row[16]);
				issue.setKstatus((String) row[17]);
				
				issue.setNotificationsfrequency((String) row[18]);
				issue.setNotificationsfrequencyid((String) row[19]);


				
				listissue.add(issue);

			}
		} catch (Exception e) {
			System.out.println("error here");
			e.printStackTrace();
		}
		
		
		return listissue;
	}
	
	
	
	/*public Set<ReportIssue> getAllTasks() {
		Set<ReportIssue> listissue=new LinkedHashSet<ReportIssue>();
		
		String hql ="select  r.id , u.username, s.severity as sev, p.priority as pp,r.uploadfile,r.subject ,r.created_time,c.category as cc,ks.name,r.status ,r.taskno ,r.severity as sid, r.priority as pid,r.assignto , r.category as rcid,r.description ,r.taskdeadline,r.assignby,u1.username as asby ,r.kstatus" 
                     +" from report_issue r, kpcategory c, kppriority p, kpusers u, kpusers u1, kpseverity s, kpstatus ks "  
                      +" where  r.kstatus=ks.id and r.assignto=u.id and r.assignby=u1.id and p.id=r.priority and s.id=r.severity and c.id=r.category ";
		
		
		
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
				
				//issue.setKstatus((String) row[19]);
			    
			    
				
				listissue.add(issue);

			}
			
		} catch (Exception e) {
			System.out.println("error here");
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		return listissue;
		
		
	}
	
	
	
*/

	
	

}








