package com.charvikent.issuetracking.service;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.charvikent.issuetracking.dao.OrgDao;
import com.charvikent.issuetracking.model.Orgnization;
import com.charvikent.issuetracking.model.User;

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
		User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> authorities =authentication.getAuthorities();
		Map<Integer, String> rolesMap = new LinkedHashMap<Integer, String>();
		
		List<Orgnization> rolesList= orgDao.getOrgNames();
		if(authorities.contains(new SimpleGrantedAuthority("ROLE_MASTERADMIN")))
		{
		for(Orgnization bean: rolesList){
			rolesMap.put(bean.getId(), bean.getName());
		}
		}
		else
		{
			for(Orgnization bean: rolesList){
				if(String.valueOf(bean.getId()).equals(objuserBean.getKpOrgId()))
				{
				rolesMap.put(bean.getId(), bean.getName());
				}
			}
			
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


	public List<Orgnization> orgInactiveList() {
		// TODO Auto-generated method stub
		return orgDao.getInActiveList();
	}


	

	

}
