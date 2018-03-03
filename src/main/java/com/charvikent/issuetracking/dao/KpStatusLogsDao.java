package com.charvikent.issuetracking.dao;

import java.util.List;

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
	public List<KpStatusLogs> getKpStatusLogsDao()
	 {

		return entityManager.createQuery("  from KpStatusLogs ").getResultList();

	 }
	
	public KpStatusLogs getKpStatusLogById(Integer id) {

		return entityManager.find(KpStatusLogs.class, id);
	}


}
