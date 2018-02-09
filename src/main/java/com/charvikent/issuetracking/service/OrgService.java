package com.charvikent.issuetracking.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.charvikent.issuetracking.dao.OrgDao;
import com.charvikent.issuetracking.model.Orgnization;

@Service
@Transactional
public class OrgService {
	
	@Autowired
	OrgDao orgDao;
	
	@PersistenceContext
    private EntityManager entityManager;
	
	
	public void saveOrg(Orgnization org)
	{
		orgDao.saveOrg(org);
	}
	
	
	public List<Orgnization> orgList()
	{
		 List<Orgnization> orgList= orgDao.getOrgNames();
		return orgList;
		
	}
	
	
	public Map<Integer, String> getOrgNames()
	{
		Map<Integer, String> rolesMap = new LinkedHashMap<Integer, String>();
		try
		{
		List<Orgnization> rolesList= orgDao.getOrgNames();
		for(Orgnization bean: rolesList){
			rolesMap.put(bean.getId(), bean.getName());
		}
				
	} catch (Exception e) {
		e.printStackTrace();
	}
		return rolesMap;
				
		
	}


	public Orgnization getOrgById(Orgnization org) {
		// TODO Auto-generated method stub
		return orgDao.getOrgById(org);
	}


	public void updateOrg(Orgnization org) {
		orgDao.updateOrg(org);
	}


	public boolean deleteOrgnization(Integer id, String status) {
		return orgDao.deleteOrgnization(id,status);
	}


	

	

}
