package com.charvikent.issuetracking.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.charvikent.issuetracking.model.Category;
import com.charvikent.issuetracking.model.KpStatusLogs;
import com.charvikent.issuetracking.model.ReportIssue;

@Repository
public class KpStatusLogsDao {
	
	@PersistenceContext
    private EntityManager entityManager;


	public void saveKpStatusLogs(Category category ) {
		entityManager.persist(category);

	}

	@SuppressWarnings("unchecked")
	public List<Category> getCategoryNames()
	 {

		return entityManager.createQuery("  from Category where status='1'").getResultList();

	 }
	
	
	@SuppressWarnings("unchecked")
	public TreeSet<KpStatusLogs> getKpStatusLogsDao()
	 {
		
		TreeSet<KpStatusLogs> listissue=new TreeSet<KpStatusLogs>();
		
		String hql ="select kl.id,kl.comment,u.username,s.name,kl.issueid,kl.statustime" + 
				" from kpstatuslogs kl,kpusers u,kpstatus s " + 
				" where kl.iassignto=u.id and kl.kpstatus=s.id";
		
		try {
			@SuppressWarnings("unchecked")
			List <Object[]> rows=entityManager.createNativeQuery(hql).getResultList();
			for(Object[] row: rows)
			{
				KpStatusLogs issue =new KpStatusLogs();
				int j = Integer.parseInt(String.valueOf(row[0]));
				Integer intobj=new Integer(j);
				issue.setId(intobj);
				
				issue.setComment((String) row[1]);
				issue.setIassignto((String) row[2]);
				issue.setKpstatus((String) row[3]);
				issue.setIssueid((String) row[4]);
				issue.setStatustime((Date) row[5]);
				
				listissue.add(issue);

			}
		} catch (Exception e) {
			System.out.println("error here");
			e.printStackTrace();
		}
		return listissue;

		//return entityManager.createQuery("  from KpStatusLogs ").getResultList();

	 }
	
	public KpStatusLogs getKpStatusLogById(Integer id) {

		return entityManager.find(KpStatusLogs.class, id);
	}
	
	
	
	


}
