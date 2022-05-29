package com.sbnz.trud.io.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "therapy")
@SQLDelete(sql = "UPDATE therapy SET deleted = true WHERE id=? AND version = ?")
@Where(clause = "deleted=false")
public class Therapy  extends BaseEntity{
	
	private String medicine;
	
	private String report;
	
	private boolean deleted = false;
	
	public Therapy() {
		super();
	}

	public Therapy(String medicine, String report) {
		super();
		this.medicine = medicine;
		this.report = report;
	}
	public Therapy(String medicine) {
		super();
		this.medicine = medicine;
	}


	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	
	

}
