package com.charvikent.issuetracking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class NotificationsFrequency {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String frequenceName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFrequenceName() {
		return frequenceName;
	}

	public void setFrequenceName(String frequenceName) {
		this.frequenceName = frequenceName;
	}

	@Override
	public String toString() {
		return "NotificationsFrequency [id=" + id + ", frequenceName=" + frequenceName + "]";
	}
	
	
	
	
	

}
