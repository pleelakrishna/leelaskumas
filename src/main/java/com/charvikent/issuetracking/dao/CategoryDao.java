
package com.charvikent.issuetracking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.charvikent.issuetracking.model.Category;
import com.charvikent.issuetracking.model.User;
@Repository
public class CategoryDao {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@PersistenceContext
    private EntityManager entityManager;
	
	


	public void saveCategory(Category category ) {
		logger.info("saving category");
		User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		category.setKpOrgId(objuserBean.getKpOrgId());
		entityManager.persist(category);

	}

	@SuppressWarnings("unchecked")
	public List<Category> getCategoryNames()
	 {
		logger.debug("calling category Names list");

		return entityManager.createQuery("  from Category where status='1'").getResultList();

	 }
	public Category getCategoryNameById(Category cate) {
		
		logger.debug("calling getCategoryNameById method");
		
		@SuppressWarnings("unchecked")
		List<Category> cateList =(List<Category>) entityManager.createQuery("SELECT cate FROM Category cate where category =:custName ").setParameter("custName",cate.getCategory()).getResultList();
		if(cateList.size() > 0)
			return cateList.get(0);
		return null;
		
	}
	
	
	public void UpdateCategory(Category cate)
	{
		logger.debug("calling update category");
		Category uc= (Category)entityManager.find(Category.class ,cate.getId());
		uc.setCategory(cate.getCategory());
		entityManager.flush();
	}

	
	
	public boolean deleteCategory(Integer id, String status) {
		
		logger.debug("calling deactive category");
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

	public List<Category> getAllInActiveList() {
		
		logger.debug("calling Inactive categorylist");
		return entityManager.createQuery("  from Category where status='0'").getResultList();
	}
}
