package com.sbnz.trud.io.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "amniocentesis")
@SQLDelete(sql = "UPDATE amniocentesis SET deleted = true WHERE id=? AND version = ?")
@Where(clause = "deleted=false")
public class Amniocentesis extends BaseEntity{

	private int afp;
	
	private String result;
	
	private double trisomy21;
	
	private double trisomy13;
	
	private double trisomy18;
	
	public Amniocentesis() {
		super();
	}

	public Amniocentesis(int afp, String result) {
		this.afp = afp;
		this.result = result;
	}

	public int getAfp() {
		return afp;
	}

	public void setAfp(int afp) {
		this.afp = afp;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public double getTrisomy21() {
		return trisomy21;
	}

	public void setTrisomy21(double trisomy21) {
		this.trisomy21 = trisomy21;
	}

	public double getTrisomy13() {
		return trisomy13;
	}

	public void setTrisomy13(double trisomy13) {
		this.trisomy13 = trisomy13;
	}

	public double getTrisomy18() {
		return trisomy18;
	}

	public void setTrisomy18(double trisomy18) {
		this.trisomy18 = trisomy18;
	}
	
	
}
