package com.charvikent.issuetracking.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
@Entity
@Table(name="kpstatuslogs")
public class KpStatusLogs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer  id;
	
	@CreationTimestamp
	private Date  statustime ;
	
	private String taskno;
	
	private String issueid;
	
	private String iassignto;
	
	private String uploadfiles;
	
	private String kpstatus;
	
	private String  subject;
	
	private String comment;
	
	
	

	public String getTaskno() {
		return taskno;
	}

	public void setTaskno(String taskno) {
		this.taskno = taskno;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getStatustime() {
		return statustime;
	}

	public void setStatustime(Date statustime) {
		this.statustime = statustime;
	}

	public String getIssueid() {
		return issueid;
	}

	public void setIssueid(String issueid) {
		this.issueid = issueid;
	}

	public String getIassignto() {
		return iassignto;
	}

	public void setIassignto(String iassignto) {
		this.iassignto = iassignto;
	}

	

	public String getKpstatus() {
		return kpstatus;
	}

	public void setKpstatus(String kpstatus) {
		this.kpstatus = kpstatus;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getcomment() {
		return comment;
	}

	public void setcomment(String comment) {
		this.comment = comment;
	}

	public String getUploadfiles() {
		return uploadfiles;
	}

	public void setUploadfiles(String uploadfiles) {
		this.uploadfiles = uploadfiles;
	}

	@Override
	public String toString() {
		return "KpStatusLogs [id=" + id + ", statustime=" + statustime + ", taskno=" + taskno + ", issueid=" + issueid
				+ ", iassignto=" + iassignto + ", uploadfiles=" + uploadfiles + ", kpstatus=" + kpstatus + ", subject="
				+ subject + ", comment=" + comment + "]";
	}

	
	
	
	
	
	
	
	

}
