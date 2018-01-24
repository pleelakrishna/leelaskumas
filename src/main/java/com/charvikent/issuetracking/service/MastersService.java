package com.charvikent.issuetracking.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.charvikent.issuetracking.dao.MastersDao;
import com.charvikent.issuetracking.model.Department;
import com.charvikent.issuetracking.model.Designation;
import com.charvikent.issuetracking.model.OrgDept;
import com.charvikent.issuetracking.model.Orgnization;

@Service
@Transactional
public class MastersService {
	
	@Autowired
	MastersDao mastersDao;
	
	
	public void saveOrg(Orgnization org)
	{
		mastersDao.saveOrg(org);
	}
	
	public Map<Integer, String> getOrgNames()
	{
		Map<Integer, String> rolesMap = new LinkedHashMap<Integer, String>();
		try
		{
		List<Orgnization> rolesList= mastersDao.getOrgNames();
		for(Orgnization bean: rolesList){
			rolesMap.put(bean.getId(), bean.getName());
		}
				
	} catch (Exception e) {
		e.printStackTrace();
	}
		return rolesMap;
				
		
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
	public void saveDesig(Designation desig)
	{
		mastersDao.saveDesig(desig);
	}
	
	public void saveOrgDept(OrgDept orgDept)
	{
		mastersDao.saveOrgDept(orgDept);
	}
	

}
