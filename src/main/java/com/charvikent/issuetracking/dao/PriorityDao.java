package com.charvikent.issuetracking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.charvikent.issuetracking.model.Priority;
import com.charvikent.issuetracking.model.User;


@Repository
public class PriorityDao {
	
	@PersistenceContext
    private EntityManager entityManager;


	public void savePriority(Priority priority ) {
		entityManager.persist(priority);
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Priority> getPriorityNames()
	 {
		  
		return (List<Priority>)entityManager.createQuery("SELECT priority FROM Priority priority").getResultList();
		 
	 }
}
