package com.charvikent.issuetracking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.charvikent.issuetracking.model.Designation;
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
 
 @SuppressWarnings("unchecked")
public List<ReportIssue> getAllReportIssues()
 {
	 return (List<ReportIssue>) em.createQuery("select reportIssue from ReportIssue reportIssue").getResultList();
 }

@SuppressWarnings("unchecked")
public List<ReportIssue> getIssuesAssignBy(String id) {

	return (List<ReportIssue>)em.createQuery("select r from ReportIssue r where r.assignby =:custName").setParameter("custName", id).getResultList();
}


}
