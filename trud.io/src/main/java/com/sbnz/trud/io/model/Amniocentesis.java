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
}
