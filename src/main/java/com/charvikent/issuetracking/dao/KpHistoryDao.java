package com.charvikent.issuetracking.dao;

import java.util.Date;
import java.util.List;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.charvikent.issuetracking.model.KpHistory;

@Repository
public class KpHistoryDao {
  
	@PersistenceContext
    private EntityManager entityManager;
	
	
	public void saveHistory(KpHistory history) {
		entityManager.persist(history);
		
		
	}
	
	
	public List<KpHistory>  listhistory()
	{
		return  entityManager.createQuery("from KpHistory").getResultList();
		
		
	}
	
	
	@SuppressWarnings("unchecked")
	public TreeSet<KpHistory> getTaskHistory()
	 {
		
		TreeSet<KpHistory> listissue=new TreeSet<KpHistory>();
		
		String hql ="select r.id,r.taskno,h.kpchange,h.kpfield,h.created_time,u.username,h.issueid,h.uploadfiles, r.assignto,r.assignby "+ 
				" from kp_history h, report_issue r,kpusers u" + 
				" where  h.issueid=r.id and h.changedby=u.id";
		
		try {
			@SuppressWarnings("unchecked")
			List <Object[]> rows=entityManager.createNativeQuery(hql).getResultList();
			for(Object[] row: rows)
			{
				KpHistory issue =new KpHistory();
				int j = Integer.parseInt(String.valueOf(row[0]));
				Integer intobj=new Integer(j);
				issue.setId(intobj);
				
				issue.setTaskno((String) row[1]);
				issue.setKpchange((String) row[2]);
				
				issue.setKpfield((String) row[3]);
				issue.setCreatedTime((Date) row[4]);
				
				issue.setChangedby((String) row[5]);
				
				issue.setIssueid((String) row[6]);
				
				issue.setUploadfiles((String) row[7]);
				
				issue.setIassignto((String) row[8]);
				
				issue.setIassignby((String) row[9]);
				
				
				listissue.add(issue);

			}
		} catch (Exception e) {
			System.out.println("error here");
			e.printStackTrace();
		}
		return listissue;


	 }
	
	
	
	
}
