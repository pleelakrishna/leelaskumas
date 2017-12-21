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
	public Category getCategoryNameById(Integer id) {

		return entityManager.find(Category.class, id);
	}

}
