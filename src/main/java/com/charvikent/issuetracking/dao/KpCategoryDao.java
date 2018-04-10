package com.charvikent.issuetracking.dao;




import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.charvikent.issuetracking.model.KpCategory;



@Repository
@Transactional
public class KpCategoryDao {

	@PersistenceContext
    private EntityManager entityManager;


	public void saveCategory(KpCategory category ) {
		entityManager.persist(category);

	}

	@SuppressWarnings("unchecked")
	public List<KpCategory> getCategoryNames()
	 {

		return entityManager.createQuery("  from KpCategory where status='1'").getResultList();

	 }
	public KpCategory getCategoryNameById(KpCategory cate) {
		
		@SuppressWarnings("unchecked")
		List<KpCategory> cateList =(List<KpCategory>) entityManager.createQuery("SELECT cate FROM KpCategory cate where category =:custName ").setParameter("custName",cate.getCategory()).getResultList();
		if(cateList.size() > 0)
			return cateList.get(0);
		return null;
		
	}
	
	
	public void UpdateKpCategory(KpCategory cate)
	{
		KpCategory uc= (KpCategory)entityManager.find(KpCategory.class ,cate.getId());
		uc.setCategory(cate.getCategory());
		uc.setCategoryimg(cate.getCategoryimg());
		entityManager.flush();
	}

	
	
	public boolean deleteKpCategory(Integer id, String status) {
		Boolean delete=false;
		try{
			
			KpCategory cate= (KpCategory)entityManager.find(KpCategory.class ,id);
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

	@SuppressWarnings("unchecked")
	public List<KpCategory> getAllInActiveList() {
		return entityManager.createQuery("  from KpCategory where status='0'").getResultList();
	}
	
	
	public Map<Integer, String> getKpCategorymap()
	{
		Map<Integer, String> rolesMap = new LinkedHashMap<Integer, String>();
		try
		{
		List<KpCategory> rolesList= getCategoryNames();
		for(KpCategory bean: rolesList){
			rolesMap.put(bean.getId(), bean.getCategory());
		}
				
	} catch (Exception e) {
		e.printStackTrace();
	}
		return rolesMap;
				
		
	}
}
