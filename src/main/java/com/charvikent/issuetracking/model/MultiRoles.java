package com.charvikent.issuetracking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="kpmultiroles")
public class MultiRoles {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private String designationid;

private String desigrole;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getDesignationid() {
	return designationid;
}

public void setDesignationid(String designationid) {
	this.designationid = designationid;
}

public String getDesigrole() {
	return desigrole;
}

public void setDesigrole(String desigrole) {
	this.desigrole = desigrole;
}

@Override
public String toString() {
	return "MultiRoles [id=" + id + ", designationid=" + designationid + ", desigrole=" + desigrole + "]";
}




}
