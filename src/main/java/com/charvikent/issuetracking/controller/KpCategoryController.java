package com.charvikent.issuetracking.controller;



import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.charvikent.issuetracking.config.FilesStuff;
import com.charvikent.issuetracking.dao.KpCategoryDao;
import com.charvikent.issuetracking.model.KpCategory;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
public class KpCategoryController {
	
	@Autowired
	KpCategoryDao categoryDao;
	
	@Autowired
	FilesStuff fileTemplate;
	
	@RequestMapping("/category")
	public String  department( @ModelAttribute("catef")  KpCategory catef,Model model ,HttpServletRequest request) {
		List<KpCategory> listOrderBeans = null;
		ObjectMapper objectMapper = null;
		String sJson = null;
		model.addAttribute("catef", new KpCategory());
		
		try {
			listOrderBeans = categoryDao.getCategoryNames();
			if (listOrderBeans != null && listOrderBeans.size() > 0) {
				objectMapper = new ObjectMapper();
				sJson = objectMapper.writeValueAsString(listOrderBeans);
				request.setAttribute("allOrders1", sJson);
				// System.out.println(sJson);
			} else {
				objectMapper = new ObjectMapper();
				sJson = objectMapper.writeValueAsString(listOrderBeans);
				request.setAttribute("allOrders1", "''");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);

		}
		
		
		return "category";
	
	}
	
	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public String saveAdmin(@Valid @ModelAttribute  KpCategory cate, BindingResult bindingresults,
			RedirectAttributes redir, @RequestParam("file1") MultipartFile[] categorypic) throws IOException {
		
		if (bindingresults.hasErrors()) {
			System.out.println("has some errors");
			return "redirect:/";
		}
		
		int id = 0;
		try
		{
			 KpCategory orgBean= categoryDao.getCategoryNameById(cate);
			
			int dummyId =0;
			
			if(orgBean != null){
				dummyId = orgBean.getId();
			}
			
			if(cate.getId()==null)
			{
				if(dummyId ==0)
				{
					
					int filecount =0;
			    	 
			    	 for(MultipartFile multipartFile : categorypic) {
							String fileName = multipartFile.getOriginalFilename();
							if(!multipartFile.isEmpty())
							{
								filecount++;
							 multipartFile.transferTo(fileTemplate.moveFileTodir(fileName));
							}
						}
			    	 
			    	 if(filecount>0)
			    	 {
			    		 cate.setCategoryimg(fileTemplate.concurrentFileNames());
			    		 fileTemplate.clearFiles();
			    		 
			    	 }
					cate.setStatus("1");
					categoryDao.saveCategory(cate);

					redir.addFlashAttribute("msg", "Record Inserted Successfully");
					redir.addFlashAttribute("cssMsg", "success");
					
				} else
				{
					redir.addFlashAttribute("msg", "Already Record Exist");
					redir.addFlashAttribute("cssMsg", "danger");
					
				}
				
			
			}
			
			else
			{
				id=cate.getId();
				if(id == dummyId || orgBean == null)
				{
					int filecount =0;
		        	 
		        	 for(MultipartFile multipartFile : categorypic) {
		    				String fileName = multipartFile.getOriginalFilename();
		    				if(!multipartFile.isEmpty())
		    				{
		    					filecount++;
		    				 multipartFile.transferTo(fileTemplate.moveFileTodir(fileName));
		    				}
		    			}
		        	 
		        	 if(filecount>0)
		        	 {
		        		 cate.setCategoryimg(fileTemplate.concurrentFileNames());
		        		 fileTemplate.clearFiles();
		        		 
		        	 }
					categoryDao.UpdateKpCategory(cate);
					redir.addFlashAttribute("msg", "Record Updated Successfully");
					redir.addFlashAttribute("cssMsg", "warning");
					
				} else
				{
					redir.addFlashAttribute("msg", "Already Record Exist");
					redir.addFlashAttribute("cssMsg", "danger");
				}
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);

		}
		
		
		return "redirect:category";
	}
	
	
	@RequestMapping(value = "/deletecategory")
	public @ResponseBody String deleteDept(KpCategory  objorg,ModelMap model,HttpServletRequest request,HttpSession session,BindingResult objBindingResult) {
		System.out.println("deleteEducation page...");
		List<KpCategory> listOrderBeans  = null;
		JSONObject jsonObj = new JSONObject();
		ObjectMapper objectMapper = null;
		String sJson=null;
		boolean delete = false;
		try{
			if(objorg.getId() != 0){
 				delete = categoryDao.deleteKpCategory(objorg.getId(),objorg.getStatus());
 				if(delete){
 					jsonObj.put("message", "deleted");
 				}else{
 					jsonObj.put("message", "delete fail");
 				}
 			}
 				
			listOrderBeans = categoryDao.getCategoryNames();
			 objectMapper = new ObjectMapper();
			if (listOrderBeans != null && listOrderBeans.size() > 0) {
				
				objectMapper = new ObjectMapper();
				sJson = objectMapper.writeValueAsString(listOrderBeans);
				request.setAttribute("allOrders1", sJson);
				jsonObj.put("allOrders1", listOrderBeans);
				// System.out.println(sJson);
			} else {
				objectMapper = new ObjectMapper();
				sJson = objectMapper.writeValueAsString(listOrderBeans);
				request.setAttribute("allOrders1", "''");
				jsonObj.put("allOrders1", listOrderBeans);
			}
		}catch(Exception e){
			e.printStackTrace();
	System.out.println(e);
			return String.valueOf(jsonObj);
			
		}
		return String.valueOf(jsonObj);
	}
	
	@RequestMapping(value = "/inActivekpCategories")
	public @ResponseBody String getAllActiveOrInactiveCategories(KpCategory  objdept,ModelMap model,HttpServletRequest request,HttpSession session,BindingResult objBindingResult) {
		List<KpCategory> listOrderBeans  = null;
		JSONObject jsonObj = new JSONObject();
		ObjectMapper objectMapper = null;
		String sJson=null;
		try{
			if(objdept.getStatus().equals("0"))
				listOrderBeans = categoryDao.getAllInActiveList();
				else
					listOrderBeans = categoryDao.getCategoryNames();
					
					
 				
			 objectMapper = new ObjectMapper();
			if (listOrderBeans != null && listOrderBeans.size() > 0) {
				
				objectMapper = new ObjectMapper();
				sJson = objectMapper.writeValueAsString(listOrderBeans);
				request.setAttribute("allOrders1", sJson);
				jsonObj.put("allOrders1", listOrderBeans);
				// System.out.println(sJson);
			} else {
				objectMapper = new ObjectMapper();
				sJson = objectMapper.writeValueAsString(listOrderBeans);
				request.setAttribute("allOrders1", "''");
				jsonObj.put("allOrders1", listOrderBeans);
			}
		}catch(Exception e){
			e.printStackTrace();
	System.out.println(e);
			return String.valueOf(jsonObj);
			
		}
		return String.valueOf(jsonObj);
	}
	
	
	/*@RequestMapping("/abheecategory")
	public String abheeCategories(@RequestParam(value="id", required=false) String categoryid,@RequestParam(value="company", required=false) String companyid,
			@RequestParam(value="model", required=false) String modelid,
			Model model,HttpServletRequest request) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		List<KpCategory> listOrderBeans = categoryDao.getCategoryNames();
		//model.addAttribute("categories", listOrderBeans);
		
		String sJson = objectMapper.writeValueAsString(listOrderBeans);	
		request.setAttribute("allOrders1", sJson);
		
		List<KpProduct> productdetails = productDao.getProductCompaniesByCategoryId(categoryid);
		
		String productJson = objectMapper.writeValueAsString(productdetails);	
		request.setAttribute("productdetails", productJson);
		
		String modelJson = objectMapper.writeValueAsString(productDao.getProductModels(categoryid,companyid,modelid));	
		request.setAttribute("productmodels", modelJson);
		
		
		return "abheecategory";
	}*/
	
	

}
