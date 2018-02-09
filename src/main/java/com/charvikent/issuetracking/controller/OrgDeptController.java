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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.charvikent.issuetracking.model.OrgDept;
import com.charvikent.issuetracking.service.MastersService;
import com.charvikent.issuetracking.service.OrgDeptService;
import com.charvikent.issuetracking.service.OrgService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class OrgDeptController {
	@Autowired
	OrgService orgService;
	@Autowired
	OrgDeptService orgDeptService;
	@Autowired
	MastersService masterService;
	
	
	
	@RequestMapping("/orgDept")
	public String  department( @ModelAttribute("orgDeptf")  OrgDept orgDeptf,Model model ,HttpServletRequest request) {
		List<OrgDept> listOrderBeans = null;
		ObjectMapper objectMapper = null;
		String sJson = null;
		model.addAttribute("orgDeptf", new OrgDept());
		model.addAttribute("orgs",orgService.getOrgNames());
		model.addAttribute("depts",masterService.getDepartmentNames());
		try {
			listOrderBeans = orgDeptService.orgDeptList();
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
		
		
		return "orgDept";
	
	}
	
	
	@RequestMapping(value = "/orgDept", method = RequestMethod.POST)
	public String saveAdmin(@Valid @ModelAttribute  OrgDept orgDept, BindingResult bindingresults,
			RedirectAttributes redir) throws IOException {
		
		if (bindingresults.hasErrors()) {
			System.out.println("has some errors");
			return "redirect:/";
		}
		
		int id = 0;
		try
		{
			OrgDept  orgDeptBean= orgDeptService.getorgDeptById(orgDept);
			int dummyId =0;
			
			if(orgDeptBean != null){
				dummyId = orgDeptBean.getId();
			}
			
			if(orgDept.getId()==null)
			{
				if(dummyId ==0)
				{
					orgDept.setStatus("1");
					orgDeptService.saveorgDept(orgDept);

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
				id=orgDept.getId();
				if(id == dummyId || orgDeptBean == null)
				{
					orgDeptService.updateorgDept(orgDept);
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
		
		
		return "redirect:orgDept";
	}
	
	
	@RequestMapping(value = "/deleteorgDept")
	public @ResponseBody String deleteDept(OrgDept  objorgDept,ModelMap model,HttpServletRequest request,HttpSession session,BindingResult objBindingResult) {
		System.out.println("deleteEducation page...");
		List<OrgDept> listOrderBeans  = null;
		JSONObject jsonObj = new JSONObject();
		ObjectMapper objectMapper = null;
		String sJson=null;
		boolean delete = false;
		try{
			if(objorgDept.getId() != 0){
 				delete = orgDeptService.deleteOrgDept(objorgDept.getId(),objorgDept.getStatus());
 				if(delete){
 					jsonObj.put("message", "deleted");
 				}else{
 					jsonObj.put("message", "delete fail");
 				}
 			}
 				
			listOrderBeans = orgDeptService.orgDeptList();
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
	
	
	
	@RequestMapping(value = "/existOrNot")
	public @ResponseBody Boolean deptExistOrnot(
			@RequestParam(value = "dept", required = true) String dept,
			@RequestParam(value = "org", required = true) String org,
			Model model,HttpServletRequest request, HttpSession session) {
		
		Boolean result =orgDeptService.checkDeptExistsOrnot(dept,org);
		return result;
	}	
}
