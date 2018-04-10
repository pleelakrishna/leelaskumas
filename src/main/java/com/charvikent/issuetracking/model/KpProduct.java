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
@Table(name = "KpProducts")
public class KpProduct 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer  id;
	private String name;
	private String description;
	private String categoryid;
	private String companyid;
	private String productmodelpics;
	private String productmodelvideoslinks;
	
	private String ProductModelSpecifications;
	
	private String ProductPrice;
	
	private String maxAllowedDiscount;
	
	@Transient
	private String categoryname;
	@Transient
	private String companyname;
	
	
	
	
	
	@Column
	private String status;
	
	@CreationTimestamp
	private Date createdTime;

	@UpdateTimestamp
	private Date updatedTime;

	public KpProduct() 
	{
		super();
	}

	public KpProduct(Integer id, String name, String description, String status, Date createdTime, Date updatedTime) 
	{
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.status = status;
		this.createdTime = createdTime;
		this.updatedTime = updatedTime;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
	
	
	

	public String getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}

	

	public String getProductmodelpics() {
		return productmodelpics;
	}

	public void setProductmodelpics(String productmodelpics) {
		this.productmodelpics = productmodelpics;
	}

	public String getProductmodelvideoslinks() {
		return productmodelvideoslinks;
	}

	public void setProductmodelvideoslinks(String productmodelvideoslinks) {
		this.productmodelvideoslinks = productmodelvideoslinks;
	}

	public String getCompanyid() {
		return companyid;
	}

	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}
	
	
	

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	
	
	
	public String getProductModelSpecifications() {
		return ProductModelSpecifications;
	}

	public void setProductModelSpecifications(String productModelSpecifications) {
		ProductModelSpecifications = productModelSpecifications;
	}

	public String getProductPrice() {
		return ProductPrice;
	}

	public void setProductPrice(String productPrice) {
		ProductPrice = productPrice;
	}
	
	
	
	

	public String getMaxAllowedDiscount() {
		return maxAllowedDiscount;
	}

	public void setMaxAllowedDiscount(String maxAllowedDiscount) {
		this.maxAllowedDiscount = maxAllowedDiscount;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", categoryid=" + categoryid
				+ ", companyid=" + companyid + ", productmodelpics=" + productmodelpics + ", productmodelvideoslinks="
				+ productmodelvideoslinks + ", status=" + status + ", createdTime=" + createdTime + ", updatedTime="
				+ updatedTime + "]";
	}

	
	
}
