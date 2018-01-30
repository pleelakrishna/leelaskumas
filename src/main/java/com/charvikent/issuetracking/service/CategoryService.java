
package com.charvikent.issuetracking.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.charvikent.issuetracking.dao.CategoryDao;
import com.charvikent.issuetracking.model.Category;

@Service
@Transactional
public class CategoryService {
	
	@Autowired
	private CategoryDao  categoryDao;
	
	public Map<Integer, String> getCategoryNames()
	{
		Map<Integer, String> rolesMap = new LinkedHashMap<Integer, String>();
		try
		{
		List<Category> rolesList= categoryDao.getCategoryNames();
		for(Category bean: rolesList){
			rolesMap.put(bean.getId(), bean.getCategory());
		}
				
	} catch (Exception e) {
		e.printStackTrace();
	}
		return rolesMap;
				
		
	}
	
	public void saveCate(Category cate)
	{
		categoryDao.saveCategory(cate);
	}
	
	
	public List<Category> cateList()
	{
		 List<Category> cateList= categoryDao.getCategoryNames();
		return cateList;
		
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
	
	

}
