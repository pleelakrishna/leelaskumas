package com.charvikent.issuetracking.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="kpuserslogs")
public class UserLogs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer  id;
	
	@CreationTimestamp
	private Date logintime ;
	
	
	
	private String userid ;
	
	private String sessionname;

	public String getSessionname() {
		return sessionname;
	}

	public void setSessionname(String sessionname) {
		this.sessionname = sessionname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getLogintime() {
		return logintime;
	}

	public void setLogintime(Date logintime) {
		this.logintime = logintime;
	}

	

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "UserLogs [id=" + id + ", logintime=" + logintime + ", userid=" + userid + ", sessionname=" + sessionname
				+ "]";
	}

	

	
	
	


	
	
	

}
