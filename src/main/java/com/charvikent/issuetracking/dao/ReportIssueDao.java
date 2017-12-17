package com.charvikent.issuetracking.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.charvikent.issuetracking.model.ReportIssue;
import com.charvikent.issuetracking.model.User;

@Repository
public class ReportIssueDao {
	
	@PersistenceContext
    private EntityManager em;
	@Autowired
	HttpSession session;
 
 public void saveReportIssue(ReportIssue reportIssue) {
	 User objuserBean = (User) session.getAttribute("cacheUserBean");
	 
	 reportIssue.setAssignby(String.valueOf(objuserBean.getId()));
		em.persist(reportIssue);
		
	}
 
/* @SuppressWarnings("unchecked")
public List<ReportIssue> getAllReportIssues()
 {
	 return (List<ReportIssue>) em.createQuery("select reportIssue from ReportIssue reportIssue").getResultList();
 }
*/
 
 
 
public List<ReportIssue> getIssuesAssignBy(String id) {
	List<ReportIssue> listissue=new ArrayList<>();

	try {
		@SuppressWarnings("unchecked")
		List <Object[]> rows=em.createQuery("select r.id , u.username, s.severity, p.priority,r.uploadfile,r.subject from ReportIssue r, Category c, Priority p, User u, Severity s  where r.assignto=u.id and p.id=r.priority and s.id=r.severity and c.id=r.category  and  r.assignby =:custName").setParameter("custName", id).getResultList();
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
		listissue.add(issue);
		
}
	} catch (Exception e) {
		System.out.println("error here");
		e.printStackTrace();
	}

	return  listissue;

}

public Object getIssuesAssignTo(String id) {
	List<ReportIssue> listissue=new ArrayList<>();

	try {
		@SuppressWarnings("unchecked")
		List <Object[]> rows=em.createQuery("select r.id , u.username, s.severity, p.priority,r.uploadfile,r.subject from ReportIssue r, Category c, Priority p, User u, Severity s  where r.assignby=u.id and p.id=r.priority and s.id=r.severity and c.id=r.category  and  r.assignto =:custName").setParameter("custName", id).getResultList();
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
		listissue.add(issue);
		
}
	} catch (Exception e) {
		System.out.println("error here");
		e.printStackTrace();
	}

	return  listissue;

}


public List<ReportIssue> getAllReportIssues() {
	List<ReportIssue> listissue=new ArrayList<>();

		try {
			@SuppressWarnings("unchecked")
			List<Object[]> rows = em
					.createQuery(
							"select r.id, c.category ,s.severity,p.priority," + "u.username ,r.subject ,r.uploadfile,"
									+ "r.createdTime from ReportIssue r, Category c ,Severity s,Priority p,User u  where r.assignto=c.id and r.severity=s.id and r.priority=p.id and r.assignto=u.id")
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
				// issue.setUpdatedTime((String) row[7]);
				issue.setCreatedTime((Date) row[7]);
				listissue.add(issue);

			}
		} catch (Exception e) {
			System.out.println("error here");
			e.printStackTrace();
		}

	return  listissue;

}







}
