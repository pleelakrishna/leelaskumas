package com.charvikent.issuetracking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.charvikent.issuetracking.model.Designation;

@Repository
public class DesignDao {
	@PersistenceContext
    private EntityManager entityManager;
	
	public void saveDesign(Designation desig) {
		entityManager.persist(desig);
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Designation> getDesignNames()
	 {
		  
		return (List<Designation>)entityManager.createQuery("SELECT Designation FROM Designation Designation").getResultList();
		 
	 }

	public Designation getDesignById(Designation desig) {
		@SuppressWarnings("unchecked")
		List<Designation> orgList =(List<Designation>) entityManager.createQuery("SELECT Designation FROM Designation Designation where name =:custName ").setParameter("custName",desig.getName()).getResultList();
		if(orgList.size() > 0)
			return orgList.get(0);
		return null;
	}

	

	public boolean deleteDesignation(Integer id, String status) {
		Boolean delete=false;
		try{
			
			Designation design= (Designation)entityManager.find(Designation.class ,id);
			   design.setStatus(status);
			   entityManager.merge(design);
			if(!status.equals(design.getStatus()))
			{
				delete=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return delete;
	}
	}
