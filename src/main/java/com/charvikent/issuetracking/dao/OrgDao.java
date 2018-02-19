package com.charvikent.issuetracking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

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
		  
		return (List<Orgnization>)entityManager.createQuery("from Orgnization where status='1'").getResultList();
		 
	 }

	public Orgnization getOrgById(Orgnization org) {
		@SuppressWarnings("unchecked")
		List<Orgnization> orgList =(List<Orgnization>) entityManager.createQuery("SELECT orgnization FROM Orgnization orgnization where name =:custName ").setParameter("custName",org.getName()).getResultList();
		if(orgList.size() > 0)
			return orgList.get(0);
		return null;
	}

	public void updateDept1(Orgnization org) {
		Orgnization uo= entityManager.find(Orgnization.class,org.getId());
		uo.setName(org.getName());
		entityManager.merge(uo);
		
	}
	
	
	
	public void updateOrg(Orgnization org) {
		String hql="update Orgnization set  description =:d, name =:n   where  id =:i";
		
		Query query =entityManager.createQuery(hql); 
		
		query.setParameter("d", org.getDescription());
		query.setParameter("n", org.getName());
		query.setParameter("i", org.getId());
		query.executeUpdate(); 
		
	}

	/*public boolean deleteOrgnization1(Integer id, String status) {
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
	}*/
	
	public boolean deleteOrgnization(Integer id, String status) {
		
		String hql="update Orgnization set status =:s where  id =:i";
		Query query =entityManager.createQuery(hql);  
		query.setParameter("s", status);
		query.setParameter("i", id);
		
		
		int result=query.executeUpdate(); 
		if(result == 1)
			return true;
			else
		return false;
		
	}

	@SuppressWarnings("unchecked")
	public List<Orgnization> getInActiveList() {
		// TODO Auto-generated method stub
		return (List<Orgnization>)entityManager.createQuery(" from Orgnization where status='0'").getResultList();
		 	}
	
	
	
	
	
	}


