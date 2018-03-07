
package com.charvikent.issuetracking.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * @author KLS
 *
 */
/**
 * @author KLS
 *
 */
@Entity
@Table(name = "kpdepartment")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String name;
	
	@Column
	private String  description;
	
	@Column
	private String  depthead;
	
	@Column
	@Transient
	private String  deptheadid;
	
	
	@Column
	private String status;
	
	@Column
	private String kpOrgId;
	
	@CreationTimestamp
	protected Date createdTime ;

	@UpdateTimestamp
	protected Date updatedTime ;
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	
	

	
	public String getDeptheadid() {
		return deptheadid;
	}

	
	public void setDeptheadid(String deptheadid) {
		this.deptheadid = deptheadid;
	}

	
	public String getDepthead() {
		return depthead;
	}

	
	public void setDepthead(String depthead) {
		this.depthead = depthead;
	
	}

	
   
	

	public String getKpOrgId() {
		return kpOrgId;
	}

	public void setKpOrgId(String kpOrgId) {
		this.kpOrgId = kpOrgId;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", description=" + description + ", depthead=" + depthead
				+ ", deptheadid=" + deptheadid + ", status=" + status + ", kpOrgId=" + kpOrgId + ", createdTime="
				+ createdTime + ", updatedTime=" + updatedTime + "]";
	}

	
	
	
	
}
