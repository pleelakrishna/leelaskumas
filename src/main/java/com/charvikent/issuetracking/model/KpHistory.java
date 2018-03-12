package com.charvikent.issuetracking.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class KpHistory implements Comparable<KpHistory>{ 
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer  id;
	
	
	private String issueid;
	
	private String kpfield;
	
	private String kpchange;
	
	private String taskno;
	
	@CreationTimestamp
	private Date createdTime;

	
	
	private String changedby;
	
	private String uploadfiles;
	
	private String status;
	
	
	@Transient
	private String iassignto;
	
	@Transient
	private String iassignby;
	

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

	
	public String getKpfield() {
		return kpfield;
	}

	public void setKpfield(String kpfield) {
		this.kpfield = kpfield;
	}

	public String getKpchange() {
		return kpchange;
	}

	public void setKpchange(String kpchange) {
		this.kpchange = kpchange;
	}
	
	

	public String getChangedby() {
		return changedby;
	}

	public void setChangedby(String changedby) {
		this.changedby = changedby;
	}
	
	

	public String getUploadfiles() {
		return uploadfiles;
	}

	public void setUploadfiles(String uploadfiles) {
		this.uploadfiles = uploadfiles;
	}




	
	public String getIassignto() {
		return iassignto;
	}

	public void setIassignto(String iassignto) {
		this.iassignto = iassignto;
	}

	public String getIassignby() {
		return iassignby;
	}

	public void setIassignby(String iassignby) {
		this.iassignby = iassignby;
	}




	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "KpHistory [id=" + id + ", issueid=" + issueid + ", kpfield=" + kpfield + ", kpchange=" + kpchange
				+ ", taskno=" + taskno + ", createdTime=" + createdTime + ", changedby=" + changedby + ", uploadfiles="
				+ uploadfiles + ", iassignto=" + iassignto + ", iassignby=" + iassignby + "]";
	}
	
	
	
	

	@Override
	public int compareTo(KpHistory o) {
		return -createdTime.compareTo(o.createdTime);
		
	}

	
	
	
	
}
