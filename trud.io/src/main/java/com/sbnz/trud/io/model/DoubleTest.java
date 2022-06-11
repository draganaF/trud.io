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
	private Double crl;
	
	private Double nt;
	
	private boolean nasalBone;
	
	private Double freeBetaHCG;
	
	private Double pappa;
	
	private String result;
	
	private Double trisomy21;
	
	private String resultT21;
	
	private Double trisomy13;
	
	private String resultT13;
	
	private Double trisomy18;
	
	private String resultT18;
	
	private String status;
	
	public DoubleTest() {
		super();
	}

	
	public DoubleTest(Double crl, Double nt, boolean nasalBone, Double freeBetaHCG, Double pappa, String result,
			Double trisomy21, Double trisomy13, Double trisomy18, String status) {
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
		this.status = status;
	}

	public DoubleTest(Double crl, Double nt, boolean nasalBone, Double freeBetaHCG, Double pappa, String result, String status) {
		super();
		this.crl = crl;
		this.nt = nt;
		this.nasalBone = nasalBone;
		this.freeBetaHCG = freeBetaHCG;
		this.pappa = pappa;
		this.result = result;
		this.status = status;
	}


	public double getCrl() {
		return crl;
	}

	public void setCrl(Double crl) {
		this.crl = crl;
	}

	public Double getNt() {
		return nt;
	}

	public void setNt(Double nt) {
		this.nt = nt;
	}

	public boolean isNasalBone() {
		return nasalBone;
	}

	public void setNasalBone(boolean nasalBone) {
		this.nasalBone = nasalBone;
	}

	public Double getFreeBetaHCG() {
		return freeBetaHCG;
	}

	public Double getPappa() {
		return pappa;
	}

	public void setPappa(Double pappa) {
		this.pappa = pappa;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	

	public void setFreeBetaHCG(Double freeBetaHCG) {
		this.freeBetaHCG = freeBetaHCG;
	}
	
	public Double getTrisomy21() {
		return trisomy21;
	}


	public void setTrisomy21(Double trisomy21) {
		this.trisomy21 = trisomy21;
	}


	public Double getTrisomy13() {
		return trisomy13;
	}


	public void setTrisomy13(Double trisomy13) {
		this.trisomy13 = trisomy13;
	}


	public Double getTrisomy18() {
		return trisomy18;
	}


	public void setTrisomy18(Double trisomy18) {
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


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}


