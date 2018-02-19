package com.charvikent.issuetracking.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.charvikent.issuetracking.dao.MultiRolesDao;
import com.charvikent.issuetracking.model.MultiRoles;

@Service
@Transactional
public class MultiRolesService {
	
	@Autowired
	private MultiRolesDao multiRolesDao;
	
	
	public Map<Integer, String> getMultiRoles()
	{
		Map<Integer, String> rolesMap = new LinkedHashMap<Integer, String>();
		try
		{
		List<MultiRoles> rolesList= multiRolesDao.getMultiRoles();
		for(MultiRoles bean: rolesList){
			rolesMap.put(bean.getId(), bean.getDesigrole());
		}
				
	} catch (Exception e) {
		e.printStackTrace();
	}
		return rolesMap;
				
		
	}

	

}
