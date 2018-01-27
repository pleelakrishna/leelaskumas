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
	
	
	
	
	@SuppressWarnings("unchecked")
	public List<Department> getDepartmentNames()
	 {
		  
		return (List<Department>)entityManager.createQuery("SELECT department FROM Department department").getResultList();
		 
	 }

	public void saveDept(Department dept) {
		entityManager.persist(dept);
		
	}
	
	

	@SuppressWarnings("unchecked")
	public Department getDepartmentById(Department dept) {
		
		List< Department> deptList =(List<Department>) entityManager.createQuery("SELECT department FROM Department department where name =:custName ").setParameter("custName",dept.getName()).getResultList();
		if(deptList.size() > 0)
			return deptList.get(0);
		return null;
		
	}

	public void updateDept(Department dept) {
		
		entityManager.merge(dept);
		
		
	}

	

	public boolean deleteDepartment(Integer id, String status) {
		Boolean delete=false;
		try{
			
			Department dept= (Department)entityManager.find(Department.class ,id);
			   dept.setStatus(status);
			   entityManager.merge(dept);
			if(!status.equals(dept.getStatus()))
			{
				delete=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return delete;
	}
	
}
