package com.charvikent.issuetracking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.charvikent.issuetracking.model.Category;
import com.charvikent.issuetracking.model.User;
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
		  
		return (List<Category>)entityManager.createQuery("SELECT category FROM Category category").getResultList();
		 
	 }

}
