package com.charvikent.issuetracking.model;

public class NotificationsBean {
	
	
	private int id;
	private String taskno;
	
	private String taskdealine;
	
	private String assignto;
	
	private String username;
	
	private String mobilenumber;
	
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTaskno() {
		return taskno;
	}

	public void setTaskno(String taskno) {
		this.taskno = taskno;
	}

	public String getTaskdealine() {
		return taskdealine;
	}

	public void setTaskdealine(String taskdealine) {
		this.taskdealine = taskdealine;
	}

	public String getAssignto() {
		return assignto;
	}

	public void setAssignto(String assignto) {
		this.assignto = assignto;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "NotificationsBean [id=" + id + ", taskno=" + taskno + ", taskdealine=" + taskdealine + ", assignto="
				+ assignto + ", username=" + username + ", mobilenumber=" + mobilenumber + ", email=" + email + "]";
	}
	
	
	
	
	

}
