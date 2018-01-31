package com.charvikent.issuetracking.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.charvikent.issuetracking.dao.DesignDao;
import com.charvikent.issuetracking.model.Designation;

@Service
@Transactional
public class DesignService {

	@Autowired
	DesignDao designDao;

	@PersistenceContext
    private EntityManager entityManager;


	public void saveOrg(Designation design)
	{
		designDao.saveDesign(design);
	}


	public List<Designation> designList()
	{
		 List<Designation> designList= designDao.getDesignNames();
		return designList;

	}


	public Map<Integer, String> getDesignNames()
	{
		Map<Integer, String> rolesMap = new LinkedHashMap<Integer, String>();
		try
		{
		List<Designation> rolesList= designDao.getDesignNames();
		for(Designation bean: rolesList){
			rolesMap.put(bean.getId(), bean.getName());
		}

	} catch (Exception e) {
		e.printStackTrace();
	}
		return rolesMap;


	}


	public Designation getOrgById(Designation design) {
		// TODO Auto-generated method stub
		return designDao.getDesignById(design);
	}


	public void updateDesign(Designation design) {
		//designDao.updatDesign(design);

	}


	public boolean deleteDesignation(Integer id, String status) {
		return designDao.deleteDesignation(id,status);
	}


}



