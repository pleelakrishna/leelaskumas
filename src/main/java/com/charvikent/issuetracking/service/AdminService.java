package com.charvikent.issuetracking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.charvikent.issuetracking.dao.AdminDao;
import com.charvikent.issuetracking.model.Admin;

@Service
@Transactional
public class AdminService {
	@Autowired
	private AdminDao adminDao;
	
	public void saveAdmin(Admin admin)
	{
		adminDao.saveAdmin(admin);
	}
	

}
