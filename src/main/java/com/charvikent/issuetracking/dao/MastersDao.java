package com.charvikent.issuetracking.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.charvikent.issuetracking.model.Department;
import com.charvikent.issuetracking.model.KpStatus;
import com.charvikent.issuetracking.model.User;

@Repository
public class MastersDao {


	@PersistenceContext
    private EntityManager entityManager;
	
	
	
	
	@SuppressWarnings("unchecked")
	public List<Department> getDepartmentNames()
	 {
		
       List<Department> list=new ArrayList<Department>();
		
		List <Object[]> rows=entityManager.createNativeQuery("select d.id,d.name,d.description,d.status ,d.kp_org_id from kpdepartment d  where d.status='1'").getResultList();
		for(Object[] row: rows)
		{
		Department dept =new Department();
		dept.setId( Integer.parseInt(String.valueOf(row[0])));
		dept.setName((String)row[1]);
		dept.setDescription((String)row[2]);
		dept.setStatus((String)row[3]);
		dept.setKpOrgId((String)row[4]);
		
		list.add(dept);
		}
		return list;
		  
		 
	 }
	
	@SuppressWarnings("unchecked")
	public List<Department> getAllInActiveDepartments()
	 {
       List<Department> list=new ArrayList<Department>();
		
		List <Object[]> rows=entityManager.createNativeQuery("select d.id,d.name,kp.username,d.depthead,d.description,d.status from kpdepartment d,kpusers kp where d.depthead=kp.id and d.status='0'").getResultList();
		for(Object[] row: rows)
		{
		 

		Department dept =new Department();
		dept.setId( Integer.parseInt(String.valueOf(row[0])));
		dept.setName((String)row[1]);
		dept.setDepthead((String)row[2]);
		dept.setDeptheadid((String)row[3]);
		dept.setDescription((String)row[4]);
		dept.setStatus((String)row[5]);
		list.add(dept);
		}
		return list;
		  
		 
	 }


	
	public void saveDept(Department dept) {
		User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		dept.setKpOrgId(objuserBean.getKpOrgId());
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
		Department ud =entityManager.find(Department.class,dept.getId());
		ud.setName(dept.getName());
		//ud.setDepthead(dept.getDepthead());
		ud.setDescription(dept.getDescription());;
		
		entityManager.merge(ud);
		
		
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
	
	@SuppressWarnings("unchecked")
	public List<KpStatus> getKpStatues() {
		return entityManager.createQuery("SELECT kpstatus FROM KpStatus kpstatus").getResultList();
		//return entityManager.createQuery("from KpStatus where id in (1,4,5,6,7,8").getResultList();
	
	
	}
	
}
