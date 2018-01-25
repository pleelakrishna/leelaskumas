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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.charvikent.issuetracking.model.Department;
import com.charvikent.issuetracking.model.Designation;
import com.charvikent.issuetracking.model.OrgDept;
import com.charvikent.issuetracking.model.Orgnization;
import com.charvikent.issuetracking.service.MastersService;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
public class MastersController {
	
	@Autowired
	MastersService  mastersService;
	
	
	
	@RequestMapping("/dept")
	public String  department( @ModelAttribute("deptf")  Department deptf,Model model ,HttpServletRequest request) {
		List<Department> listOrderBeans = null;
		ObjectMapper objectMapper = null;
		String sJson = null;
		model.addAttribute("deptf", new Department());
		try {
			listOrderBeans =mastersService.deptList();
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
		
		
		return "dept";
	
	}
	
	
	@RequestMapping(value = "/dept", method = RequestMethod.POST)
	public String saveAdmin(@Valid @ModelAttribute  Department dept, BindingResult bindingresults,
			RedirectAttributes redir) throws IOException {
		
		if (bindingresults.hasErrors()) {
			System.out.println("has some errors");
			return "redirect:/";
		}
		
		int id = 0;
		try
		{
			Department deptBean= mastersService.getDepartmentsById(dept);
			int dummyId =0;
			
			if(deptBean != null){
				dummyId = deptBean.getId();
			}
			
			if(dept.getId()==null)
			{
				if(dummyId ==0)
				{
					dept.setStatus("1");
					mastersService.saveDept(dept);

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
				id=dept.getId();
				if(id == dummyId || deptBean == null)
				{
					mastersService.updateDept(dept);
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
		
		
		return "redirect:dept";
	}
	
	
	
	
	
	
	
	@RequestMapping(value = "/deleteDept")
	public @ResponseBody String deleteDept(Department  objdept,ModelMap model,HttpServletRequest request,HttpSession session,BindingResult objBindingResult) {
		System.out.println("deleteEducation page...");
		List<Department> listOrderBeans  = null;
		JSONObject jsonObj = new JSONObject();
		ObjectMapper objectMapper = null;
		String sJson=null;
		boolean delete = false;
		try{
			if(objdept.getId() != 0){
 				delete = mastersService.deleteDepartment(objdept.getId(),objdept.getStatus());
 				if(delete){
 					jsonObj.put("message", "deleted");
 				}else{
 					jsonObj.put("message", "delete fail");
 				}
 			}
 				
			listOrderBeans = mastersService.deptList();
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

	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/desig")
	public String  designation(Model model) {
		model.addAttribute("desigf", new Designation());
		return "desig";
	}
	
	@RequestMapping(value = "/desig", method = RequestMethod.POST)
	public String saveDesignation(@Valid @ModelAttribute  Designation desig, BindingResult bindingresults,
			RedirectAttributes redir) throws IOException {

		if (bindingresults.hasErrors()) {
			System.out.println("has some errors");
			return "redirect:/";
		}
		mastersService.saveDesig(desig);

		redir.addFlashAttribute("msg", "Record Inserted Successfully");
		redir.addFlashAttribute("cssMsg", "success");

		return "redirect:desig";
	}
	
	@RequestMapping("/org")
	public String  orgnization(Model model) {
		
		model.addAttribute("orgf", new Orgnization());
		return "org";
	
	}
	
	
	@RequestMapping(value = "/org", method = RequestMethod.POST)
	public String saveOrg(@Valid @ModelAttribute  Orgnization org, BindingResult bindingresults,
			RedirectAttributes redir) throws IOException {

		if (bindingresults.hasErrors()) {
			System.out.println("has some errors");
			return "redirect:/";
		}
		mastersService.saveOrg(org);

		redir.addFlashAttribute("msg", "Record Inserted Successfully");
		redir.addFlashAttribute("cssMsg", "success");

		return "redirect:org";
	}
	@RequestMapping("/orgDept")
	public String  orgDept(Model model) {
		
		model.addAttribute("orgDeptf", new OrgDept());
		model.addAttribute("depts", mastersService.getDepartmentNames());
		model.addAttribute("orgs", mastersService.getOrgNames());
		
		return "orgDept";
	
	}
	
	
	@RequestMapping(value = "/orgDept", method = RequestMethod.POST)
	public String saveOrgDept(@Valid @ModelAttribute  OrgDept orgDept, BindingResult bindingresults,
			RedirectAttributes redir) throws IOException {

		if (bindingresults.hasErrors()) {
			System.out.println("has some errors");
			return "redirect:/";
		}
		mastersService.saveOrgDept(orgDept);

		redir.addFlashAttribute("msg", "Record Inserted Successfully");
		redir.addFlashAttribute("cssMsg", "success");

		return "redirect:orgDept";
	}

	
	
	
	
	
}
