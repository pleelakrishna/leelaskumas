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
public class ReportIssue  {


	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer  id;
	
	private String taskno;

	@CreationTimestamp
	private Date createdTime;

	@UpdateTimestamp
	private Date updatedTime;

	private String category;
	private String severity;
	private String priority;
	private String assignto;
	private String  assignby;
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
	
	private String taskdeadline;
	@Transient
	private String taskdeadlineid;
	
	
	
	@Transient
	private String assigntoid;
	@Transient
	private String categoryid;
	@Transient
	private String priorityid;
	@Transient
	private String  severityid;
	@Transient
	private String assignbyid;
	@Transient
	private String kstatusid;
	
	
	private  String departmentid;
	
	
	private String notificationsfrequency;
	
	@Transient
	private String notificationsfrequencyid;
	@Transient
	private String strcreatedTime;
	@Transient
	private String departmentName;
	
	
	
	
	
	
	public String getAssignbyid() {
		return assignbyid;
	}
	public void setAssignbyid(String assignbyid) {
		this.assignbyid = assignbyid;
	}
	public String getTaskno() {
		return taskno;
	}
	public void setTaskno(String taskno) {
		this.taskno = taskno;
	}
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
	
	public String getTaskdeadline() {
		return taskdeadline;
	}
	public void setTaskdeadline(String taskdeadline) {
		this.taskdeadline = taskdeadline;
	}
	
	
	
	public String getTaskdeadlineid() {
		return taskdeadlineid;
	}
	public void setTaskdeadlineid(String taskdeadlineid) {
		this.taskdeadlineid = taskdeadlineid;
	}
	
	
	
	
	
	
	
	public String getKstatusid() {
		return kstatusid;
	}
	public void setKstatusid(String kstatusid) {
		this.kstatusid = kstatusid;
	}
	
	
	public String getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(String departmentid) {
		this.departmentid = departmentid;
	}
	
	
	
	public String getNotificationsfrequency() {
		return notificationsfrequency;
	}
	public void setNotificationsfrequency(String notificationsfrequency) {
		this.notificationsfrequency = notificationsfrequency;
	}
	
	
	
	public String getNotificationsfrequencyid() {
		return notificationsfrequencyid;
	}
	public void setNotificationsfrequencyid(String notificationsfrequencyid) {
		this.notificationsfrequencyid = notificationsfrequencyid;
	}
	
	
	
	
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getStrcreatedTime() {
		return strcreatedTime;
	}
	public void setStrcreatedTime(String strcreatedTime) {
		this.strcreatedTime = strcreatedTime;
	}
	
	
	
	
	
	@Override
	public String toString() {
		return "ReportIssue [id=" + id + ", taskno=" + taskno + ", createdTime=" + createdTime + ", updatedTime="
				+ updatedTime + ", category=" + category + ", severity=" + severity + ", priority=" + priority
				+ ", assignto=" + assignto + ", subject=" + subject + ", description=" + description + ", uploadfile="
				+ uploadfile + ", gapdays=" + gapdays + ", gapcount=" + gapcount + ", kstatus=" + kstatus + ", status="
				+ status + ", additionalinfo=" + additionalinfo + ", taskdeadline=" + taskdeadline + ", taskdeadlineid="
				+ taskdeadlineid + ", assigntoid=" + assigntoid + ", categoryid=" + categoryid + ", priorityid="
				+ priorityid + ", severityid=" + severityid + ", assignbyid=" + assignbyid + ", kstatusid=" + kstatusid
				+ ", departmentid=" + departmentid + ", notificationsfrequency=" + notificationsfrequency
				+ ", notificationsfrequencyid=" + notificationsfrequencyid + ", strcreatedTime=" + strcreatedTime
				+ ", departmentName=" + departmentName + ", assignby=" + assignby + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReportIssue other = (ReportIssue) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	

}
