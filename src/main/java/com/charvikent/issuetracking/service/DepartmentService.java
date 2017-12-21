package com.charvikent.issuetracking.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.charvikent.issuetracking.dao.DepartmentDao;
import com.charvikent.issuetracking.model.Department;


@Service
@Transactional
public class DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;
	
	public Map<Integer, String> getDepartmentNames()
	{
		Map<Integer, String> rolesMap = new LinkedHashMap<Integer, String>();
		try
		{
		List<Department> rolesList= departmentDao.getDepartmentNames();
		for(Department bean: rolesList){
			rolesMap.put(bean.getId(), bean.getDepartment());
		}
				
	} catch (Exception e) {
		e.printStackTrace();
	}
		return rolesMap;
				
		
	}
}
