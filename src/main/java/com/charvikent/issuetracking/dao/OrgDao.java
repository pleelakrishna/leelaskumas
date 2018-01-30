package com.charvikent.issuetracking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.charvikent.issuetracking.model.Department;
import com.charvikent.issuetracking.model.Orgnization;

@Repository
public class OrgDao {
	
	
	@PersistenceContext
    private EntityManager entityManager;
	
	public void saveOrg(Orgnization org) {
		entityManager.persist(org);
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Orgnization> getOrgNames()
	 {
		  
		return (List<Orgnization>)entityManager.createQuery("SELECT orgnization FROM Orgnization orgnization").getResultList();
		 
	 }

	public Orgnization getOrgById(Orgnization org) {
		@SuppressWarnings("unchecked")
		List<Orgnization> orgList =(List<Orgnization>) entityManager.createQuery("SELECT orgnization FROM Orgnization orgnization where name =:custName ").setParameter("custName",org.getName()).getResultList();
		if(orgList.size() > 0)
			return orgList.get(0);
		return null;
	}

	public void updateDept(Orgnization org) {
		Orgnization uo= entityManager.find(Orgnization.class,org.getId());
		uo.setName(org.getName());
		entityManager.merge(uo);
		
	}

	public boolean deleteOrgnization(Integer id, String status) {
		Boolean delete=false;
		try{
			
			Orgnization org= (Orgnization)entityManager.find(Orgnization.class ,id);
			   org.setStatus(status);
			   entityManager.merge(org);
			if(!status.equals(org.getStatus()))
			{
				delete=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return delete;
	}
	}


