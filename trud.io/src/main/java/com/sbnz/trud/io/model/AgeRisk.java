package com.sbnz.trud.io.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "age_risk")
@SQLDelete(sql = "UPDATE triple_test SET deleted = true WHERE id=? AND version = ?")
@Where(clause = "deleted=false")
public class AgeRisk extends BaseEntity {
	
	private int age;
	
	private double risk;
	
	private String trisomy;
	
	public AgeRisk() {}

	public AgeRisk(int age, double risk, String trisomy) {
		super();
		this.age = age;
		this.risk = risk;
		this.trisomy = trisomy;
	}


	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getRisk() {
		return risk;
	}

	public void setRisk(double risk) {
		this.risk = risk;
	}

	public String getTrisomy() {
		return trisomy;
	}

	public void setTrisomy(String trisomy) {
		this.trisomy = trisomy;
	}
	
	
	

}
