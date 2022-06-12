package com.sbnz.trud.io.apiContracts.response;

import com.sbnz.trud.io.model.CTGStatus;

public class ViewCTG {

	private int id;
	private boolean tachycardia;
	private boolean bradycardia;
	private double fetalHartRate;
	private double varibilty;
	private int contractions;
	private CTGStatus fhrStatus;
	private CTGStatus variabiltyStatus;
	private CTGStatus result;
	
	
	public ViewCTG() {
		super();
	}
	public ViewCTG(int id, boolean tachycardia, boolean bradycardia, double fetalHartRate, double varibilty, int contractions,
			CTGStatus fhrStatus, CTGStatus variabiltyStatus, CTGStatus result) {
		super();
		this.id = id;
		this.tachycardia = tachycardia;
		this.bradycardia = bradycardia;
		this.fetalHartRate = fetalHartRate;
		this.varibilty = varibilty;
		this.contractions = contractions;
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
	public int getContractions() {
		return contractions;
	}
	public void setContractions(int contractions) {
		this.contractions = contractions;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
