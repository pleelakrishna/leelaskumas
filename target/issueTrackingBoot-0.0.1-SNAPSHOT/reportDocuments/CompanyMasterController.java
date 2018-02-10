package com.aurospaces.neighbourhood.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aurospaces.neighbourhood.bean.CompanymasterBean;
import com.aurospaces.neighbourhood.db.dao.CompanymasterDao;

@Controller
public class CompanyMasterController {
	private Logger logger = Logger.getLogger(CompanyMasterController.class);
	@Autowired
	CompanymasterDao cd;
	@RequestMapping(value = "/companymaster")
	public String companyMasterHome(@ModelAttribute("companymaster")CompanymasterBean objcompanyMasterBean, ModelMap model, HttpServletRequest request,
			HttpSession session) {
		
		List<CompanymasterBean> listOrderBeans = null;
		ObjectMapper objectMapper = null;
		String sJson = null;
		try {

			listOrderBeans = cd.getAllCompanyMasterDetails();
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
			logger.error(e);
			logger.fatal("error in CompanyMasterController class in companyMasterHome method");
		}
			return "companymasterHome";
	}
	
	/*@RequestMapping(value = "/save")
	public String save(@ModelAttribute("companymaster")CompanymasterBean objcompanyMasterBean, ModelMap model, HttpServletRequest request,
			HttpSession session) {
		
	
	cd.save(objcompanyMasterBean);
		
			return "companymasterHome";
	}*/
	
	@RequestMapping(value = "/save")
	public  String addCompanyMasterDetails(@ModelAttribute("companymaster")CompanymasterBean objCompanymasterBean, BindingResult result,
			ModelMap model, HttpServletRequest request, HttpSession session, HttpServletResponse responses,RedirectAttributes redir){
		System.out.println("addCompanyMasterDetails page...");
		int id = 0;
		String name = null;
//		model.put("userForm", user);
		CompanymasterBean existModel=null;
		boolean isUpdate=false;
		
		try {
			if (result.hasErrors()) {
//				model.addAttribute("newUser", userObj);
				return "companymasterHome";
			}
//			objCompanymasterBean.setStatus("1");
			List<CompanymasterBean> companymasterBean = cd.getByName(objCompanymasterBean);
			
			
			if(companymasterBean.size() == 0 || companymasterBean == null)
			{
				cd.save(objCompanymasterBean);
				redir.addFlashAttribute("msg", "Record Inserted Successfully");
				redir.addFlashAttribute("cssMsg", "success");
			}
			else
			{
				for(int i=0;i<companymasterBean.size();i++)
				{
					existModel = companymasterBean.get(i);
					name = existModel.getCompanyname();
					int exId = existModel.getId();
					if(exId == objCompanymasterBean.getId())
					{
						 isUpdate=true;
					}
					else
					{
						redir.addFlashAttribute("msg", "Already Record Exist");
						redir.addFlashAttribute("cssMsg", "danger");
					}
				}
				if(isUpdate){
					cd.save(objCompanymasterBean);
					redir.addFlashAttribute("msg", "Record Updated Successfully");
					redir.addFlashAttribute("cssMsg", "warning");
				}
			}
			
			/*if(objCompanymasterBean.getId() != 0)
			{
				id = objCompanymasterBean.getId();
				if(id == dummyId || companymasterBean == null )
				{
					cd.save(objCompanymasterBean);
					redir.addFlashAttribute("msg", "Record Updated Successfully");
					redir.addFlashAttribute("cssMsg", "warning");
				}
				else
				{
					redir.addFlashAttribute("msg", "Already Record Exist");
					redir.addFlashAttribute("cssMsg", "danger");
				}
			}
			if(objCompanymasterBean.getId() == 0 && companymasterBean == null)
			{
				cd.save(objCompanymasterBean);
				redir.addFlashAttribute("msg", "Record Inserted Successfully");
				redir.addFlashAttribute("cssMsg", "success");
			}
			if(objCompanymasterBean.getId() == 0 && companymasterBean != null)
			{
				redir.addFlashAttribute("msg", "Already Record Exist");
				redir.addFlashAttribute("cssMsg", "danger");
			}*/
			//redir.addFlashAttribute("msg", "Record Inserted Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			logger.error(e);
			logger.fatal("error in CompanyMasterController class addCompanyMasterDetails method");
			redir.addFlashAttribute("msg", e);
		}
		return "redirect:companymaster";
	}
	
	@RequestMapping(value = "/deleteCompanyMasterDetails")
	public @ResponseBody String deleteCompanyMasterDetails( CompanymasterBean objCompanymasterBean,ModelMap model,HttpServletRequest request,HttpSession session,BindingResult objBindingResult,RedirectAttributes redir) {
		System.out.println("deleteCompanyMasterDetails page...");
		List<CompanymasterBean> listOrderBeans  = null;
		JSONObject jsonObj = new JSONObject();
		ObjectMapper objectMapper = null;
		String sJson=null;
		boolean delete = false;
		try{
			if(objCompanymasterBean.getId() != 0){
 				delete = cd.delete(objCompanymasterBean.getId());
 				if(delete){
 					jsonObj.put("message", "Record Deleted Successfully");
 					redir.addFlashAttribute("msg", "Record Updated Successfully");
					redir.addFlashAttribute("cssMsg", "danger");
 				}else{
 					jsonObj.put("message", "Failed to Delete..!");
 				}
 			}
 			listOrderBeans = cd.getAllCompanyMasterDetails();
			objectMapper = new ObjectMapper();
			if (listOrderBeans != null && listOrderBeans.size() > 0) 
			{
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
			logger.error(e);
			logger.fatal("error in CompanyMasterController class deleteCompanyMasterDetails method");
			jsonObj.put("message", "excetption"+e);
			return String.valueOf(jsonObj);
		}
		return String.valueOf(jsonObj);
	}

}