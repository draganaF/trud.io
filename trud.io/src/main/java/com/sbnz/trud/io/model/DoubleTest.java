package com.sbnz.trud.io.model;

import javax.persistence.Entity;

import javax.persistence.Table;


import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "double_test")
@SQLDelete(sql = "UPDATE double_test SET deleted = true WHERE id=? AND version = ?")
@Where(clause = "deleted=false")
public class DoubleTest extends BaseEntity{	    
	private double crl;
	
	private double nt;
	
	private boolean nasalBone;
	
	private double freeBetaHCG;
	
	private double pappa;
	
	private String result;
	
	private double trisomy21;
	
	private String resultT21;
	
	private double trisomy13;
	
	private String resultT13;
	
	private double trisomy18;
	
	private String resultT18;
	
	public DoubleTest() {
		super();
	}

	
	public DoubleTest(double crl, double nt, boolean nasalBone, double freeBetaHCG, double pappa, String result,
			double trisomy21, double trisomy13, double trisomy18) {
		super();
		this.crl = crl;
		this.nt = nt;
		this.nasalBone = nasalBone;
		this.freeBetaHCG = freeBetaHCG;
		this.pappa = pappa;
		this.result = result;
		this.trisomy21 = trisomy21;
		this.trisomy13 = trisomy13;
		this.trisomy18 = trisomy18;
	}

	public DoubleTest(double crl, double nt, boolean nasalBone, double freeBetaHCG, double pappa, String result) {
		super();
		this.crl = crl;
		this.nt = nt;
		this.nasalBone = nasalBone;
		this.freeBetaHCG = freeBetaHCG;
		this.pappa = pappa;
		this.result = result;
	}


	public double getCrl() {
		return crl;
	}

	public void setCrl(double crl) {
		this.crl = crl;
	}

	public double getNt() {
		return nt;
	}

	public void setNt(double nt) {
		this.nt = nt;
	}

	public boolean isNasalBone() {
		return nasalBone;
	}

	public void setNasalBone(boolean nasalBone) {
		this.nasalBone = nasalBone;
	}

	public double getFreeBetaHCG() {
		return freeBetaHCG;
	}

	public double getPappa() {
		return pappa;
	}

	public void setPappa(double pappa) {
		this.pappa = pappa;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	

	public void setFreeBetaHCG(double freeBetaHCG) {
		this.freeBetaHCG = freeBetaHCG;
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


	public double getCoefNt() {
		if(this.nt > 3.5) {
			return 0.3;
		}
		return this.nt;
	}
	
	public double getCoefPappa(double median) {
		if(this.pappa < median) {
			return 0.2;
		}
		return 1;
	}
	
	public double getCoefHCG(double median, String trisomy) {
		if(this.freeBetaHCG < median && (trisomy.equals("Trisomy13") || trisomy.equals("Trisomy18"))) {
			return 0.2;
		}else if(this.freeBetaHCG >median && trisomy.equals("Trisomy21")) {
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


