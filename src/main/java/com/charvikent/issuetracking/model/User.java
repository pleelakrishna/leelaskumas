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

@Entity
@Table(name = "kpusers")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@CreationTimestamp
	private Date createdTime;

	@UpdateTimestamp
	private Date updatedTime;

	@Column
	private String mobilenumber;

	@Column
	private String email;
	// @Column
	// private String designation;
	@Column
	private String department;

	private String reportto;
	
	private String kpOrgId;

	@Column
	private String enabled;
	private String designation;

	@Column(unique = true)
	private String username;
	@Column
	private String password;
	@Transient
	private String npassword;
	@Transient
	private String cpassword;
	@Transient
	private String departmentName;
	@Transient
	private String designationName;
	@Transient
	private String reportId;
	@Transient
	private String reportName;
	@Column
	private String firstname;
	@Column
	private String lastname;
	@Transient
	private String status;

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}



	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCpassword() {
		return cpassword;
	}

	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}

	public String getNpassword() {
		return npassword;
	}

	public void setNpassword(String npassword) {
		this.npassword = npassword;
	}


	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	public String getReportId() {
		return reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	public User() {
	}



	public User(User user) {
		this.id = user.id;
		this.createdTime = user.createdTime;
		this.updatedTime = user.updatedTime;
		this.mobilenumber = user.mobilenumber;
		this.email = user.email;
		this.department = user.department;
		this.reportto = user.reportto;
		this.enabled = user.enabled;
		this.designation = user.designation;
		this.username = user.username;
		this.password = user.password;
		this.npassword = user.npassword;
		this.cpassword = user.cpassword;
		this.departmentName = user.departmentName;
		this.designationName = user.designationName;
		this.reportId = user.reportId;
		this.status = user.status;
		this.firstname = user.firstname;
		this.lastname = user.lastname;
		this.reportName=user.reportName;
		this.kpOrgId=user.kpOrgId;

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getReportto() {
		return reportto;
	}

	public void setReportto(String reportto) {
		this.reportto = reportto;
	}

	
	

	public String getKpOrgId() {
		return kpOrgId;
	}

	public void setKpOrgId(String kpOrgId) {
		this.kpOrgId = kpOrgId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", createdTime=" + createdTime + ", updatedTime=" + updatedTime + ", mobilenumber="
				+ mobilenumber + ", email=" + email + ", department=" + department + ", reportto=" + reportto
				+ ", kpOrgId=" + kpOrgId + ", enabled=" + enabled + ", designation=" + designation + ", username="
				+ username + ", password=" + password + ", npassword=" + npassword + ", cpassword=" + cpassword
				+ ", departmentName=" + departmentName + ", designationName=" + designationName + ", reportId="
				+ reportId + ", reportName=" + reportName + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", status=" + status + "]";
	}

	



}
