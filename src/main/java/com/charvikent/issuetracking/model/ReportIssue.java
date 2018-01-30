package com.charvikent.issuetracking.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
public class ReportIssue implements Comparable<ReportIssue>{


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer  id;

	@CreationTimestamp
	private Date createdTime;

	@UpdateTimestamp
	private Date updatedTime;

	private String category;
	private String severity;
	private String priority;
	private String assignto;
	private String subject;
	private String description;
	private  String uploadfile;
	@Transient
	private Integer gapdays;
	@Transient
	private Integer gapcount;

	private String kstatus;
	private String status;
	private String additionalinfo;
	
	@Transient
	private String assigntoid;
	@Transient
	private String categoryid;
	@Transient
	private String priorityid;
	@Transient
	private String  severityid;
	
	
	public String getAdditionalinfo() {
		return additionalinfo;
	}
	public void setAdditionalinfo(String additionalinfo) {
		this.additionalinfo = additionalinfo;
	}
	public String getKstatus() {
		return kstatus;
	}
	public void setKstatus(String kstatus) {
		this.kstatus = kstatus;
	}
	public Integer getGapdays() {
		return gapdays;
	}
	public void setGapdays(Integer gapdays) {
		this.gapdays = gapdays;
	}
	public Integer getGapcount() {
		return gapcount;
	}
	public void setGapcount(Integer gapcount) {
		this.gapcount = gapcount;
	}

	private String  assignby;

	public String getAssignby() {
		return assignby;
	}
	public void setAssignby(String assignby) {
		this.assignby = assignby;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getAssignto() {
		return assignto;
	}
	public void setAssignto(String assignto) {
		this.assignto = assignto;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}





	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUploadfile() {
		return uploadfile;
	}
	public void setUploadfile(String uploadfile) {
		this.uploadfile = uploadfile;
	}
	
	
	
	
	
	public String getAssigntoid() {
		return assigntoid;
	}
	public void setAssigntoid(String assigntoid) {
		this.assigntoid = assigntoid;
	}
	public String getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}
	public String getPriorityid() {
		return priorityid;
	}
	public void setPriorityid(String priorityid) {
		this.priorityid = priorityid;
	}
	public String getSeverityid() {
		return severityid;
	}
	public void setSeverityid(String severityid) {
		this.severityid = severityid;
	}
	
	
	
	
	
	@Override
	public String toString() {
		return "ReportIssue [id=" + id + ", createdTime=" + createdTime + ", updatedTime=" + updatedTime + ", category="
				+ category + ", severity=" + severity + ", priority=" + priority + ", assignto=" + assignto
				+ ", subject=" + subject + ", description=" + description + ", uploadfile=" + uploadfile + ", gapdays="
				+ gapdays + ", gapcount=" + gapcount + ", kstatus=" + kstatus + ", status=" + status
				+ ", additionalinfo=" + additionalinfo + ", assigntoid=" + assigntoid + ", categoryid=" + categoryid
				+ ", priorityid=" + priorityid + ", severityid=" + severityid + ", assignby=" + assignby + "]";
	}
	@Override
	public int compareTo(ReportIssue o) {
		if(id<o.id)
			return 1;
		else if(id>o.id)
		return -1;
		else
		return 0;
	}
	

}
