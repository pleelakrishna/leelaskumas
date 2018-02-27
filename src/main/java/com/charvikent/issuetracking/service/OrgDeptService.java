package com.charvikent.issuetracking.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.charvikent.issuetracking.dao.OrgDeptDao;
import com.charvikent.issuetracking.model.OrgDept;
import com.charvikent.issuetracking.model.OrgDeptHierarchical;

@Service
@Transactional
public class OrgDeptService {
	@Autowired
	OrgDeptDao orgDeptDao;



	public void saveorgDept(OrgDept orgDept)
	{
		orgDeptDao.saveOrgDept(orgDept);
	}


	public List<OrgDept> orgDeptList()
	{
		 List<OrgDept> orgDeptList= orgDeptDao.getorgDeptNames();
		return orgDeptList;

	}


	public Map<Integer, String> getorgDeptNames()
	{
		Map<Integer, String> rolesMap = new LinkedHashMap<Integer, String>();
		try
		{
		List<OrgDept> rolesList= orgDeptDao.getorgDeptNames();
		for(OrgDept bean: rolesList){
			rolesMap.put(bean.getId(), bean.getDept());
		}

	} catch (Exception e) {
		e.printStackTrace();
	}
		return rolesMap;


	}


	public OrgDept getorgDeptById(OrgDept orgDept) {
		// TODO Auto-generated method stub
		return orgDeptDao.getorgDeptById(orgDept);
	}


	public void updateorgDept(OrgDept orgDept) {
		orgDeptDao.updateOrgDept(orgDept);
	}


	public boolean deleteOrgDept(Integer id, String status) {
		return orgDeptDao.deleteOrgDept(id,status);
	}


	public Boolean checkDeptExistsOrnot(String dept, String org) {
		return orgDeptDao.checkDeptExistsOrnot(dept,org);
	}


	public List<OrgDeptHierarchical> orgDeptListHierarchical() {
		List<OrgDeptHierarchical> orgDeptList= orgDeptDao.getorgDeptNamesHierarchical();

			return orgDeptList;
	}

}
