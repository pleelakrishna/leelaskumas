
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

import com.charvikent.issuetracking.dao.CategoryDao;
import com.charvikent.issuetracking.model.Category;
import com.charvikent.issuetracking.model.Department;
import com.charvikent.issuetracking.model.User;

@Service
@Transactional
public class CategoryService {
	
	@Autowired
	private CategoryDao  categoryDao;
	
	public Map<Integer, String> getCategoryNames()
	{
		
		User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> authorities =authentication.getAuthorities();
		
		Map<Integer, String>  cateMapForMaster = new LinkedHashMap<Integer, String>();
		List<Category> rolesList= categoryDao.getCategoryNames();
		if(authorities.contains(new SimpleGrantedAuthority("ROLE_MASTERADMIN")))
		{
		for(Category bean: rolesList){
			cateMapForMaster.put(bean.getId(), bean.getCategory());
		}
				
		return cateMapForMaster;
		}
		else
			
		{
			
			for(Category bean: rolesList){
				if(bean.getKpOrgId().equals(objuserBean.getKpOrgId()))
				{
				cateMapForMaster.put(bean.getId(), bean.getCategory());
				}
			}
			return cateMapForMaster;
			
		}
	
		
	}
	
	public void saveCate(Category cate)
	{
		categoryDao.saveCategory(cate);
	}
	
	
	public List<Category> cateList()
	{
       User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		Collection<? extends GrantedAuthority> authorities =authentication.getAuthorities();
		
		
		 List<Category> cateListForMaster= categoryDao.getCategoryNames();
		 List<Category> cateListForAdmin =new ArrayList<>();
		 
		 if(authorities.contains(new SimpleGrantedAuthority("ROLE_MASTERADMIN")))
			   return cateListForMaster;
		 else 
		 {
			 
			 for(Category entry :cateListForMaster)
			 {  
				 if(entry.getKpOrgId().equals(objuserBean.getKpOrgId()))
				 cateListForAdmin.add(entry);
			 }
			 return cateListForAdmin;
		 }
		 
		
	}
	
	public Category getCateById(Category cate) {
		// TODO Auto-generated method stub
		return categoryDao.getCategoryNameById(cate);
	}


	public void updatecate(Category cate) {
		categoryDao.UpdateCategory(cate);
		
		
	}


	public boolean deleteCategory(Integer id, String status) {
		return categoryDao.deleteCategory(id,status);
	}

	public List<Category> inActiveCategoriesList() {
		// TODO Auto-generated method stub
		return categoryDao.getAllInActiveList();
	}
	
	

}
