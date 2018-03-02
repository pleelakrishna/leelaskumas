package com.charvikent.issuetracking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.charvikent.issuetracking.model.Category;

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


}
