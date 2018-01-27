package com.charvikent.issuetracking.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.charvikent.issuetracking.dao.MastersDao;
import com.charvikent.issuetracking.model.Department;

@Service
@Transactional
public class MastersService {
	
	@Autowired
	MastersDao mastersDao;
	
	
	
	
	public List<Department> deptList()
	{
		 List<Department> deptList= mastersDao.getDepartmentNames();
		return deptList;
		
	}
	
	
	
	public Map<Integer, String> getDepartmentNames()
	{
		Map<Integer, String> rolesMap = new LinkedHashMap<Integer, String>();
		try
		{
		List<Department> rolesList= mastersDao.getDepartmentNames();
		for(Department bean: rolesList){
			rolesMap.put(bean.getId(), bean.getName());
		}
				
	} catch (Exception e) {
		e.printStackTrace();
	}
		return rolesMap;
				
		
	}
	
	public void saveDept(Department dept)
	{
		mastersDao.saveDept(dept);
	}
	
	
	

	public Department getDepartmentsById(Department dept) {
		return mastersDao.getDepartmentById(dept);
	}

	public void updateDept(Department dept) {
		mastersDao.updateDept(dept);
		
	}

	public boolean deleteDepartment(Integer id, String status) {
		return mastersDao.deleteDepartment(id,status);
	}

	
	

}
