package com.charvikent.issuetracking.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class KpHistory {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer  id;
	
	
	private String issueid;
	
	private String field;
	
	private String change;
	
	private String taskno;
	
	@CreationTimestamp
	private Date createdTime;

	@UpdateTimestamp
	private Date updatedTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIssueid() {
		return issueid;
	}

	public void setIssueid(String issueid) {
		this.issueid = issueid;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getChange() {
		return change;
	}

	public void setChange(String change) {
		this.change = change;
	}

	public String getTaskno() {
		return taskno;
	}

	public void setTaskno(String taskno) {
		this.taskno = taskno;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	@Override
	public String toString() {
		return "KpHistory [id=" + id + ", issueid=" + issueid + ", field=" + field + ", change=" + change + ", taskno="
				+ taskno + ", createdTime=" + createdTime + ", updatedTime=" + updatedTime + "]";
	}

	
	
	
	
	
}
