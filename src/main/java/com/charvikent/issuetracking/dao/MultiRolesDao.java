package com.charvikent.issuetracking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.charvikent.issuetracking.model.MultiRoles;


@Repository
public class MultiRolesDao {

	
	@PersistenceContext
    private EntityManager entityManager;

	
	@SuppressWarnings("unchecked")
	public List<MultiRoles> getMultiRoles()
	 {
		  
		return (List<MultiRoles>)entityManager.createQuery("SELECT multiroles FROM MultiRoles multiroles").getResultList();
		 
	 }
}
