package com.charvikent.issuetracking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.charvikent.issuetracking.model.Department;


@Repository
public class DepartmentDao {

	@PersistenceContext
    private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Department> getDepartmentNames()
	 {
		  
		return (List<Department>)entityManager.createQuery("SELECT department FROM Department department").getResultList();
		 
	 }
}
