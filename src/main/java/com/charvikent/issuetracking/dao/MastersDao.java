package com.charvikent.issuetracking.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.charvikent.issuetracking.model.Department;
import com.charvikent.issuetracking.model.Designation;
import com.charvikent.issuetracking.model.OrgDept;
import com.charvikent.issuetracking.model.Orgnization;

@Repository
public class MastersDao {


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
	@SuppressWarnings("unchecked")
	public List<Department> getDepartmentNames()
	 {
		  
		return (List<Department>)entityManager.createQuery("SELECT department FROM Department department").getResultList();
		 
	 }

	public void saveDept(Department dept) {
		entityManager.persist(dept);
		
	}
	public void saveDesig(Designation desig)
	{
		entityManager.persist(desig);
	}
	public void saveOrgDept(OrgDept orgDept)
	{
		entityManager.persist(orgDept);
	}
	
}
