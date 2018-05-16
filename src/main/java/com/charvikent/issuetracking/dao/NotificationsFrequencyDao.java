package com.charvikent.issuetracking.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.charvikent.issuetracking.model.NotificationsFrequency;
@Repository
@Transactional
public class NotificationsFrequencyDao {
	
	
	@PersistenceContext
    private EntityManager entityManager;

	
	@SuppressWarnings("unchecked")
	public List<NotificationsFrequency> getNotificationsFrequencyes()
	
	 {
		  String hql ="from NotificationsFrequency";
		  
		  Query query =entityManager.createQuery(hql);
		  
		  List<NotificationsFrequency> NotificationsFrequencyList = query.getResultList();
		return NotificationsFrequencyList;
		 
	 }
	
	
	public Map<Integer, String> getNotificationsFrequencyesMap()
	{
		Map<Integer, String> rolesMap = new LinkedHashMap<Integer, String>();
		try
		{
		List<NotificationsFrequency> rolesList= getNotificationsFrequencyes();
		for(NotificationsFrequency bean: rolesList){
			rolesMap.put(bean.getId(), bean.getFrequenceName());
		}
				
	} catch (Exception e) {
		e.printStackTrace();
	}
		return rolesMap;
				
		
	}

}
