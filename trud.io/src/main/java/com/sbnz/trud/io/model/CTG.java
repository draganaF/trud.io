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
	private boolean tachycardia;
	private boolean bradycardia;
	private double fetalHartRate;
	private double varibilty;
	private CTGStatus fhrStatus;
	private CTGStatus variabiltyStatus;
	private CTGStatus result;
		
	public CTG() {
		super();
		this.bradycardia = false;
		this.tachycardia = false;
	}

	
	public CTG(boolean tachycardia, boolean bradycardia, double fetalHartRate, double varibilty, CTGStatus fhrStatus,
			CTGStatus variabiltyStatus, CTGStatus result) {
		super();
		this.tachycardia = tachycardia;
		this.bradycardia = bradycardia;
		this.fetalHartRate = fetalHartRate;
		this.varibilty = varibilty;
		this.fhrStatus = fhrStatus;
		this.variabiltyStatus = variabiltyStatus;
		this.result = result;
	}


	public boolean isTachycardia() {
		return tachycardia;
	}

	public void setTachycardia(boolean tachycardia) {
		this.tachycardia = tachycardia;
	}

	public boolean isBradycardia() {
		return bradycardia;
	}

	public void setBradycardia(boolean bradycardia) {
		this.bradycardia = bradycardia;
	}

	public double getFetalHartRate() {
		return fetalHartRate;
	}

	public void setFetalHartRate(double fetalHartRate) {
		this.fetalHartRate = fetalHartRate;
	}

	public double getVaribilty() {
		return varibilty;
	}

	public void setVaribilty(double varibilty) {
		this.varibilty = varibilty;
	}

	public CTGStatus getFhrStatus() {
		return fhrStatus;
	}

	public void setFhrStatus(CTGStatus fhrStatus) {
		this.fhrStatus = fhrStatus;
	}

	public CTGStatus getVariabiltyStatus() {
		return variabiltyStatus;
	}

	public void setVariabiltyStatus(CTGStatus variabiltyStatus) {
		this.variabiltyStatus = variabiltyStatus;
	}

	public CTGStatus getResult() {
		return result;
	}

	public void setResult(CTGStatus result) {
		this.result = result;
	}
}
