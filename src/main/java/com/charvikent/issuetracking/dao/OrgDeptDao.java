package com.charvikent.issuetracking.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.charvikent.issuetracking.model.OrgDept;

@Repository
public class OrgDeptDao {

	@PersistenceContext
    private EntityManager entityManager;
	
	public void saveOrgDept(OrgDept orgDept) {
		entityManager.persist(orgDept);
		
	}
	
	@SuppressWarnings("unchecked")
	public List<OrgDept> getorgDeptNames()
	 {
		
		List<OrgDept> list=new ArrayList<OrgDept>();
		
		List <Object[]> rows=entityManager.createNativeQuery("select od.id,d.name as pd2 ,o.name,d1.name as pd1,od.status from org_dept od,department d,orgnization o, department d1 where od.dept=d.id and od.org=o.id and od.parent_dept=d1.id").getResultList();
		  
		for(Object[] row: rows)
		{
			OrgDept od =new OrgDept();
			od.setId( Integer.parseInt(String.valueOf(row[0])));
			od.setDept((String)row[1]);
			od.setOrg((String)row[2]);
			od.setParentDept((String)row[3]);
			od.setStatus((String)row[4]);
			list.add(od);
			
		}
		
		return list;
		 
	 }

	public OrgDept getorgDeptById(OrgDept orgDept) {
		@SuppressWarnings("unchecked")
		List<OrgDept> orgDeptList =(List<OrgDept>) entityManager.createQuery("SELECT OrgDept FROM OrgDept OrgDept where id =:custName ").setParameter("custName",orgDept.getId()).getResultList();
		if(orgDeptList.size() > 0)
			return orgDeptList.get(0);
		return null;
	}

	public void updateOrgDept(OrgDept orgDept) {
		entityManager.merge(orgDept);
		
	}

	public boolean deleteOrgDept(Integer id, String status) {
		Boolean delete=false;
		try{
			
			OrgDept orgDept= (OrgDept)entityManager.find(OrgDept.class ,id);
			   orgDept.setStatus(status);
			   entityManager.merge(orgDept);
			if(!status.equals(orgDept.getStatus()))
			{
				delete=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return delete;
	}
	}

