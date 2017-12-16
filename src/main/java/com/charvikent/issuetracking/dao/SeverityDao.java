package com.charvikent.issuetracking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.charvikent.issuetracking.model.Severity;
import com.charvikent.issuetracking.model.User;

@Repository
public class SeverityDao {

	
	@PersistenceContext
    private EntityManager entityManager;
	
	public void saveSeverity(Severity severity ) {
		entityManager.persist(severity);
		
	}

	@SuppressWarnings("unchecked")
	public List<Severity> getSeverityNames()
	 {
		  
		return (List<Severity>)entityManager.createQuery("SELECT severity FROM Severity severity").getResultList();
		 
	 }
}
