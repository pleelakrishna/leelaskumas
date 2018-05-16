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
	@Override
	public String toString() {
		return "ReportIssue [id=" + id + ", taskno=" + taskno + ", createdTime=" + createdTime + ", updatedTime="
				+ updatedTime + ", category=" + category + ", severity=" + severity + ", priority=" + priority
				+ ", assignto=" + assignto + ", subject=" + subject + ", description=" + description + ", uploadfile="
				+ uploadfile + ", gapdays=" + gapdays + ", gapcount=" + gapcount + ", kstatus=" + kstatus + ", status="
				+ status + ", additionalinfo=" + additionalinfo + ", taskdeadline=" + taskdeadline + ", taskdeadlineid="
				+ taskdeadlineid + ", assigntoid=" + assigntoid + ", categoryid=" + categoryid + ", priorityid="
				+ priorityid + ", severityid=" + severityid + ", assignby=" + assignby + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((additionalinfo == null) ? 0 : additionalinfo.hashCode());
		result = prime * result + ((assignby == null) ? 0 : assignby.hashCode());
		result = prime * result + ((assignto == null) ? 0 : assignto.hashCode());
		result = prime * result + ((assigntoid == null) ? 0 : assigntoid.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((categoryid == null) ? 0 : categoryid.hashCode());
		result = prime * result + ((createdTime == null) ? 0 : createdTime.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((gapcount == null) ? 0 : gapcount.hashCode());
		result = prime * result + ((gapdays == null) ? 0 : gapdays.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((kstatus == null) ? 0 : kstatus.hashCode());
		result = prime * result + ((priority == null) ? 0 : priority.hashCode());
		result = prime * result + ((priorityid == null) ? 0 : priorityid.hashCode());
		result = prime * result + ((severity == null) ? 0 : severity.hashCode());
		result = prime * result + ((severityid == null) ? 0 : severityid.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		result = prime * result + ((taskno == null) ? 0 : taskno.hashCode());
		result = prime * result + ((updatedTime == null) ? 0 : updatedTime.hashCode());
		result = prime * result + ((uploadfile == null) ? 0 : uploadfile.hashCode());
		result = prime * result + ((kstatusid == null) ? 0 : kstatusid.hashCode());
		result = prime * result + ((departmentid == null) ? 0 : departmentid.hashCode());
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
		if (additionalinfo == null) {
			if (other.additionalinfo != null)
				return false;
		} else if (!additionalinfo.equals(other.additionalinfo))
			return false;
		if (assignby == null) {
			if (other.assignby != null)
				return false;
		} else if (!assignby.equals(other.assignby))
			return false;
		if (assignto == null) {
			if (other.assignto != null)
				return false;
		} else if (!assignto.equals(other.assignto))
			return false;
		if (assigntoid == null) {
			if (other.assigntoid != null)
				return false;
		} else if (!assigntoid.equals(other.assigntoid))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (categoryid == null) {
			if (other.categoryid != null)
				return false;
		} else if (!categoryid.equals(other.categoryid))
			return false;
		if (createdTime == null) {
			if (other.createdTime != null)
				return false;
		} else if (!createdTime.equals(other.createdTime))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (gapcount == null) {
			if (other.gapcount != null)
				return false;
		} else if (!gapcount.equals(other.gapcount))
			return false;
		if (gapdays == null) {
			if (other.gapdays != null)
				return false;
		} else if (!gapdays.equals(other.gapdays))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (kstatus == null) {
			if (other.kstatus != null)
				return false;
		} else if (!kstatus.equals(other.kstatus))
			return false;
		if (priority == null) {
			if (other.priority != null)
				return false;
		} else if (!priority.equals(other.priority))
			return false;
		if (priorityid == null) {
			if (other.priorityid != null)
				return false;
		} else if (!priorityid.equals(other.priorityid))
			return false;
		if (severity == null) {
			if (other.severity != null)
				return false;
		} else if (!severity.equals(other.severity))
			return false;
		if (severityid == null) {
			if (other.severityid != null)
				return false;
		} else if (!severityid.equals(other.severityid))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		if (taskno == null) {
			if (other.taskno != null)
				return false;
		} else if (!taskno.equals(other.taskno))
			return false;
		if (updatedTime == null) {
			if (other.updatedTime != null)
				return false;
		} else if (!updatedTime.equals(other.updatedTime))
			return false;
		if (uploadfile == null) {
			if (other.uploadfile != null)
				return false;
		} else if (!uploadfile.equals(other.uploadfile))
			return false;
		if (kstatusid == null) {
			if (other.kstatusid != null)
				return false;
		} else if (!kstatusid.equals(other.kstatusid))
			return false;
		if (departmentid == null) {
			if (other.departmentid != null)
				return false;
		} else if (!departmentid.equals(other.departmentid))
			return false;
		return true;
	}

	
	
	
	
	

}
