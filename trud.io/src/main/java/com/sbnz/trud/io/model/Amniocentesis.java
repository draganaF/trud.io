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

	private double afp;
	
	private String result;
	
	private double trisomy21;
	
	private String resultT21;
	
	private double trisomy13;
	
	private String resultT13;
	
	private double trisomy18;
	
	private String resultT18;
	
	private String neuralDefects;
	
	public Amniocentesis() {
		super();
	}

	public Amniocentesis(double afp, String result) {
		this.afp = afp;
		this.result = result;
	}

	public double getAfp() {
		return afp;
	}

	public void setAfp(double afp) {
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

	public String getNeuralDefects() {
		return neuralDefects;
	}

	public void setNeuralDefects(String neuralDefects) {
		this.neuralDefects = neuralDefects;
	}
	
	public double getCoefAfp(double median, boolean defect) {
		if(this.afp < median && !defect) {
			return 0.2;
		}else if(this.afp > median && defect) {
			return 0.2;
		}
		return 1;
	}
	
	
	public double getCoefSmoker(boolean smoker) {
		if(smoker) {
			return 0.2;
		}
		return 1;
	}
	
	public String getNeuralDefectRisk(int birthsWithChromosomalDisorder, boolean geneticAnomalies, int illness, boolean obesity, double coefAfp) {
		if(birthsWithChromosomalDisorder > 0 || geneticAnomalies || obesity ||  illness > 0 || coefAfp !=1) {
			return "High risk";
		}
		return "Low risk";
	}
	
	public String getResultT21() {
		return resultT21;
	}


	public void setResultT21(String resultT21) {
		this.resultT21 = resultT21;
	}


	public String getResultT13() {
		return resultT13;
	}


	public void setResultT13(String resultT13) {
		this.resultT13 = resultT13;
	}


	public String getResultT18() {
		return resultT18;
	}


	public void setResultT18(String resultT18) {
		this.resultT18 = resultT18;
	}
}
