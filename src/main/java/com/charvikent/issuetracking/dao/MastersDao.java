package com.charvikent.issuetracking.dao;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.charvikent.issuetracking.model.Department;
import com.charvikent.issuetracking.model.KpStatus;
import com.charvikent.issuetracking.model.User;

@Repository
public class MastersDao {


	@PersistenceContext
    private EntityManager entityManager;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	
	
	@SuppressWarnings("unchecked")
	public List<Department> getDepartmentNames()
	 {
		
       List<Department> list=new ArrayList<Department>();
		
		List <Object[]> rows=entityManager.createNativeQuery("select d.id,d.name,d.description,d.status ,d.kp_org_id,d.dept_code from kpdepartment d  where d.status='1' order by updated_time desc  ").getResultList();
		for(Object[] row: rows)
		{
		Department dept =new Department();
		dept.setId( Integer.parseInt(String.valueOf(row[0])));
		dept.setName((String)row[1]);
		dept.setDescription((String)row[2]);
		dept.setStatus((String)row[3]);
		dept.setKpOrgId((String)row[4]);
		dept.setDeptCode((String)row[5]);
		
		list.add(dept);
		}
		return list;
		  
		 
	 }
	
	@SuppressWarnings("unchecked")
	public List<Department> getAllInActiveDepartments()
	 {
       List<Department> list=new ArrayList<Department>();
		
		List <Object[]> rows=entityManager.createNativeQuery("select d.id,d.name,d.description,d.status ,d.kp_org_id,d.dept_code from kpdepartment d where  d.status='0'").getResultList();
		for(Object[] row: rows)
		{
		 

		Department dept =new Department();
		dept.setId( Integer.parseInt(String.valueOf(row[0])));
		dept.setName((String)row[1]);
		dept.setDescription((String)row[2]);
		dept.setStatus((String)row[3]);
		dept.setKpOrgId((String)row[4]);
		dept.setDeptCode((String)row[5]);
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
		ud.setDeptCode(dept.getDeptCode());
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
		
		String hql ="select ks.id,ks.name from kpstatus ks order by  ks.sorder ";
		
		RowMapper<KpStatus> rowMapper = new BeanPropertyRowMapper<KpStatus>(KpStatus.class);	
		List<KpStatus> kpStatus = jdbcTemplate.query(hql, rowMapper);
		return kpStatus;
	
	
	}

	public void saveBranch(Department dept) {
		
		// TODO Auto-generated method stub
		

		//String timestamp = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss").format(Calendar.getInstance().getTime());
		
		java.sql.Timestamp Date = 
				new java.sql.Timestamp(new Date().getTime()); 
		
		
		
		 
		 
	String hql ="INSERT INTO kumar_branch (id,branch_cr_time,branchname,branchcode,status) VALUES ( "+dept.getId()+" , '"+Date+" ' ,'"+dept.getName()+" ','"+dept.getDeptCode()+" ','"+dept.getStatus()+" ') ";
	jdbcTemplate.update(hql);
		
		
		
	
		
	}
	
	
	public void updateBranch(Department dept) {
		//String timestamp = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss").format(Calendar.getInstance().getTime());
		
		java.sql.Timestamp Date = 
				new java.sql.Timestamp(new Date().getTime()); 
		
			String hql ="update kumar_branch set branchname='"+dept.getName()+"' , branch_up_time = '"+Date+"' ,branchcode = '"+dept.getDeptCode()+"' where id="+dept.getId()+" ";  
			
			jdbcTemplate.update(hql);
			
		
		
		
		
		
	}

	public void deletebranch(Integer id, String status) {
		//String timestamp = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss").format(Calendar.getInstance().getTime());
		
		java.sql.Timestamp Date = 
				new java.sql.Timestamp(new Date().getTime()); 
			
		
		String hql ="update kumar_branch set  branch_up_time = '"+Date+"' ,status = '"+status+"' where id="+id+" ";  
		
		jdbcTemplate.update(hql);
		
		
	}
		
	
}
