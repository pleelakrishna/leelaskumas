package com.charvikent.issuetracking.dao;

import java.util.List;

import javax.persistence.Cache;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.charvikent.issuetracking.model.Category;
import com.charvikent.issuetracking.model.Designation;
import com.charvikent.issuetracking.model.KpStatusLogs;

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
			
//		   test case of second level cache
           /*Cache cache = entityManager.getEntityManagerFactory().getCache();
			
			if (cache.contains(Designation.class, id)) {
				System.out.println("the data is  cached");

			} else {
				  System.out.println("the data is NOT cached");
			}
*/

		}catch(Exception e){
			e.printStackTrace();
		}
		return delete;
	}

	public void updatDesign(Designation design) {
		Designation ud= (Designation)entityManager.find(Designation.class ,design.getId());
		ud.setName(design.getName());
		entityManager.merge(ud);
		
	}
	}
