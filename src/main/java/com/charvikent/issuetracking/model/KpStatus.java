package com.charvikent.issuetracking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="kpstatus")
public class KpStatus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String name;
	
	private String scolour;
	
	
	

	
	public String getScolour() {
		return scolour;
	}

	public void setScolour(String scolour) {
		this.scolour = scolour;
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

	@Override
	public String toString() {
		return "KpStatus [id=" + id + ", name=" + name + ", scolour=" + scolour + "]";
	}

	

	

}
