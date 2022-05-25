package com.sbnz.trud.io.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "ctg")
@SQLDelete(sql = "UPDATE ctg SET deleted = true WHERE id=? AND version = ?")
@Where(clause = "deleted=false")
public class CTG extends BaseEntity{
	private String result;
	
	private String description;
		
	public CTG() {
		super();
	}
	
	public CTG(String result, String description) {
		super();
		this.result = result;
		this.description = description;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}	
}
