package com.charvikent.issuetracking.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="kpusers")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer  id;
	
	@CreationTimestamp
	private Date createdTime ;

	@UpdateTimestamp
	private Date updatedTime ;
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Column
	private String username;
	@Column
	private String password;
	@Transient
	private String cpassword;
	
	@Transient
	private String npassword;
	
	
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
	@Column
	private String firstname;
	@Column
	private String lastname;
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@Column
	private String mobilenumber;
	
	@Column
	@Email
	private String email;
	//@Column
	//private String designation;
	@Column
	private String department;
	
	@Column
	private Boolean enabled;
	
	@OneToMany(cascade=CascadeType.ALL,fetch= FetchType.LAZY)
	@JoinColumn(name="userfk")
	private List<Designation> designation1 = new ArrayList<Designation>(0);
	
	
	
	 private String  designation;
	
	
	
	public User() {
	}
	
	public User(String username, String password, String firstname, String lastname, String mobilenumber, String email,
			String designation, String department, Boolean enabled, Set<Designation> designations) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobilenumber = mobilenumber;
		this.email = email;
		this.department = department;
		this.enabled = enabled;
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
	
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", createdTime=" + createdTime + ", updatedTime=" + updatedTime + ", username="
				+ username + ", password=" + password + ", firstname=" + firstname + ", mobilenumber=" + mobilenumber
				+ ", email=" + email + ", designation=" + designation + ", department=" + department + ", enabled="
				+ enabled + "]";
	}
	
	
	
	

}
