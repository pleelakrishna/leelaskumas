package com.charvikent.issuetracking.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.charvikent.issuetracking.dao.OrgDeptDao;
import com.charvikent.issuetracking.model.Department;
import com.charvikent.issuetracking.model.OrgDept;
import com.charvikent.issuetracking.model.OrgDeptHierarchical;
import com.charvikent.issuetracking.model.User;

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
      User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		Collection<? extends GrantedAuthority> authorities =authentication.getAuthorities();
		
		 List<OrgDept> orgdeptListForMaster= orgDeptDao.getorgDeptNames();
		 List<OrgDept> deptListForAdmin =new ArrayList<>();
		 if(authorities.contains(new SimpleGrantedAuthority("ROLE_MASTERADMIN")))
			   return orgdeptListForMaster;
		 else
		 {
			 for(OrgDept entry :orgdeptListForMaster)
			 {  
				 if(entry.getOrgid().equals(objuserBean.getKpOrgId()))
				 deptListForAdmin.add(entry);
			 }
			 return deptListForAdmin;
		 }

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
		User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		Collection<? extends GrantedAuthority> authorities =authentication.getAuthorities();
		
		 List<OrgDept> orgdeptListForMaster= orgDeptDao.getorgDeptNames();
		// List<OrgDept> deptListForAdmin =new ArrayList<>();
		 //if(authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {}
		 for(OrgDept entry :orgdeptListForMaster)
		 {  
			 if(entry.getOrgid().equals(objuserBean.getKpOrgId())) {
				 List<OrgDeptHierarchical> orgDeptList= orgDeptDao.getorgDeptNamesHierarchical(objuserBean.getKpOrgId());
				 
				 return orgDeptList;
			 }
		 }
		return null;
		

			
	}

}
