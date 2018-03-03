package com.charvikent.issuetracking.dao;

import java.util.List;

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
	
	
	
	
}
