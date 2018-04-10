package com.charvikent.issuetracking.controller;

import java.util.HashMap;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.charvikent.issuetracking.dao.KpCategoryDao;
import com.charvikent.issuetracking.model.KpCategory;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class RestControllerHome {
	
	@Autowired
	KpCategoryDao categoryDao;
	
	
	@RequestMapping(value="/getkpcategories", method=RequestMethod.POST, consumes = "application/json", produces = "application/json")  
	public String  getCategoriesList() throws JsonProcessingException, JSONException {
		
		String code =null;
		HashMap<String,String> hm =new HashMap<String,String>();
		List<KpCategory> listOrderBeans = categoryDao.getCategoryNames();
		
		JSONObject json =new JSONObject();
		
		
		
		
			
			//ObjectMapper objectMapper = new ObjectMapper();
			//String userjson = objectMapper.writeValueAsString(userBean);
			//String categoryjson = objectMapper.writeValueAsString(listOrderBeans);
			
			if(null != listOrderBeans)
			{
				json.put("kpcategorieslist", listOrderBeans);
				
			}
			else
				//code="NOT_FOUND";
				
				json.put("kpcategorieslist", "NOT_FOUND");
		
			System.out.println("rest call user status:  "+code);
		

		
		return String.valueOf(json);
	}

}
