package com.charvikent.issuetracking.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		Map<Integer, String> listOrderBeans = null;
		ObjectMapper objectMapper = null;
		String sJson = null;
		model.addAttribute("deptf", new Department());
		try {
			listOrderBeans =mastersService.getDepartmentNames();
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
		mastersService.saveDept(dept);

		redir.addFlashAttribute("msg", "Record Inserted Successfully");
		redir.addFlashAttribute("cssMsg", "success");

		return "redirect:dept";
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
