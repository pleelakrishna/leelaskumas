package com.charvikent.issuetracking.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.charvikent.issuetracking.model.KpProduct;


/*import com.charvikent.abheeSmartHomeSystems.model.User;*/


@Repository
@Transactional
public class KpProductDao 
{
	@PersistenceContext
    private EntityManager entityManager;
	
	@Autowired
    private JdbcTemplate jdbcTemplate;


	public void saveProduct(KpProduct product) 
	{
		entityManager.persist(product);
		

	}
	@SuppressWarnings("unchecked")
	public List<KpProduct> getProductNames()
	 {

		return entityManager.createQuery("  from KpProduct where status='1'").getResultList();

	 }
	
	
	public KpProduct getProductNameById(KpProduct pro) 
	{
			
			@SuppressWarnings("unchecked")
			List<KpProduct> proList =(List<KpProduct>) entityManager.createQuery("  FROM KpProduct where name =:custName ").setParameter("custName",pro.getName()).getResultList();
			if(proList.size() > 0)
				return proList.get(0);
			return null;
			
	}
	public void UpdateKpProduct(KpProduct pro)
	{
		KpProduct uc= (KpProduct)entityManager.find(KpProduct.class ,pro.getId());
		uc.setName(pro.getName());
		uc.setDescription(pro.getDescription());
		uc.setProductmodelvideoslinks(pro.getProductmodelvideoslinks());
		
		entityManager.flush();
	}
	public boolean deleteKpProduct(Integer id, String status) 
	{
		Boolean delete=false;
		try{
			
			KpProduct pro= (KpProduct)entityManager.find(KpProduct.class ,id);
			   pro.setStatus(status);
			   entityManager.merge(pro);
			if(!status.equals(pro.getStatus()))
			{
				delete=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return delete;
	}

	@SuppressWarnings("unchecked")
	public List<KpProduct> getAllInActiveList() 
	{
		
		List<KpProduct> listProducts =new ArrayList<KpProduct>();
		
		String hql ="select p.id,p.categoryid,cat.category,p.companyid,p.description,p.name,p.productmodelpics,p.productmodelvideoslinks,p.status from KpProduct  p , KpCategory cat  where p.categoryid=cat.id and  p.status='0'";

		List<Object[]> rows = entityManager.createQuery(hql).getResultList();
		
		for (Object[] row : rows) {
			
			KpProduct product =new KpProduct();
			product.setId(Integer.parseInt(String.valueOf(row[0])));
			product.setCategoryid((String) row[1]);
			product.setCategoryname((String) row[2]);
			product.setCompanyid((String) row[3]);
			product.setDescription((String) row[4]);
			product.setName((String) row[5]);
			product.setProductmodelpics((String) row[6]);
			product.setProductmodelvideoslinks((String) row[7]);
			product.setStatus((String) row[8]);
			
			listProducts.add(product);

	}
		 return listProducts;
	}
	
	@SuppressWarnings("unchecked")
	public List<KpProduct> getProductDetails()
	 {
		List<KpProduct> listProducts =new ArrayList<KpProduct>();
		
		String hql ="select p.id,p.categoryid,cat.category,p.companyid,p.description,p.name,p.productmodelpics,p.productmodelvideoslinks,p.status,p.ProductModelSpecifications,p.ProductPrice,p.maxAllowedDiscount from KpProduct  p , KpCategory cat  where p.categoryid=cat.id  and p.status='1'";

		List<Object[]> rows = entityManager.createQuery(hql).getResultList();
		
		for (Object[] row : rows) {
			
			KpProduct product =new KpProduct();
			product.setId(Integer.parseInt(String.valueOf(row[0])));
			product.setCategoryid((String) row[1]);
			product.setCategoryname((String) row[2]);
			product.setCompanyid((String) row[3]);
			product.setDescription((String) row[4]);
			product.setName((String) row[5]);
			product.setProductmodelpics((String) row[6]);
			product.setProductmodelvideoslinks((String) row[7]);
			product.setStatus((String) row[8]);
			product.setProductModelSpecifications((String) row[9]);
			product.setProductPrice((String) row[10]);
			product.setMaxAllowedDiscount((String) row[11]);
			
			listProducts.add(product);


	 }
		return listProducts;
	 }
	public List<KpProduct> getProductCompaniesByCategoryId(String categoryid) {
		
		
		List<KpProduct> listProducts =new ArrayList<KpProduct>();
		
		String hql ="select p.id,p.name,c.name as companyname,p.productmodelvideoslinks,p.productmodelpics,p.companyid from Product p,Company c where p.categoryid='"+categoryid+"' and p.companyid=c.id group by c.name";

List<Object[]> rows = entityManager.createQuery(hql).getResultList();
		
		for (Object[] row : rows) {
			
			KpProduct product =new KpProduct();
			product.setId(Integer.parseInt(String.valueOf(row[0])));
			product.setName((String) row[1]);
			product.setCompanyname((String) row[2]);
			product.setProductmodelvideoslinks((String) row[3]);
			product.setProductmodelpics((String) row[4]);
			product.setCompanyid((String) row[5]);
			
			
			listProducts.add(product);

	}
		return listProducts;
}
	
	public List<Map<String,Object>> getProductModels(String categoryid,String companyId,String modelid){
		StringBuffer buffer = new StringBuffer("select abc.category as categoryname,p.id,p.name,c.name as companyname,p.productmodelvideoslinks,p.productmodelpics,p.companyid,categoryid,p.description,p.product_model_specifications,product_price,max_allowed_discount from Kp_products p,abhee_company c,productcategory abc where p.companyid=c.id and p.categoryid =abc.id ");
		
		if(categoryid  !=null && categoryid !="" )
		{
			
			buffer.append(" and p.categoryid= '"+categoryid+"'");
		}
		
		if(companyId  !=null && companyId !="" )
		{
			
			buffer.append(" and  p.companyid='"+companyId+"'");
		}
		if(modelid  !=null && modelid !="" )
		{
			
			buffer.append(" and  p.id='"+modelid+"'");
		}
		buffer.append(" order by p.companyid ");
		String sql = buffer.toString();
		
		System.out.println(sql);
		List<Map<String,Object>>  retlist = jdbcTemplate.queryForList(sql,new Object[]{});
		
		return retlist ;
		
	}
}
