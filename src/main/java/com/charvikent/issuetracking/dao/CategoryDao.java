package com.charvikent.issuetracking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.charvikent.issuetracking.model.Category;
@Repository
public class CategoryDao {

	@PersistenceContext
    private EntityManager entityManager;


	public void saveCategory(Category category ) {
		entityManager.persist(category);

	}

	@SuppressWarnings("unchecked")
	public List<Category> getCategoryNames()
	 {

		return entityManager.createQuery("SELECT category FROM Category category").getResultList();

	 }
	public Category getCategoryNameById(Category cate) {
		
		@SuppressWarnings("unchecked")
		List<Category> cateList =(List<Category>) entityManager.createQuery("SELECT cate FROM Category cate where category =:custName ").setParameter("custName",cate.getCategory()).getResultList();
		if(cateList.size() > 0)
			return cateList.get(0);
		return null;
		
	}
	
	
	public void UpdateCategory(Category cate)
	{
		Category uc= (Category)entityManager.find(Category.class ,cate.getId());
		uc.setCategory(cate.getCategory());
		entityManager.flush();
	}

	
	
	public boolean deleteCategory(Integer id, String status) {
		Boolean delete=false;
		try{
			
			Category cate= (Category)entityManager.find(Category.class ,id);
			   cate.setStatus(status);
			   entityManager.merge(cate);
			if(!status.equals(cate.getStatus()))
			{
				delete=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return delete;
	}
}
