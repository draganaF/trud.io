package com.sbnz.trud.io.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "triple_test")
@SQLDelete(sql = "UPDATE triple_test SET deleted = true WHERE id=? AND version = ?")
@Where(clause = "deleted=false")
public class TripleTest extends BaseEntity {
	private Double hcg;
	
	private Double afp;
	
	private Double ue3;
	
	private String result;
	
	private Double trisomy21;
	
	private String resultT21;
	
	private Double trisomy13;
	
	private String resultT13;
	
	private Double trisomy18;
	
	private String resultT18;
	
	private String status;

	public TripleTest() {
		super();
	}

	public TripleTest(Double hcg, Double afp, Double ue3, String result, String status) {
		super();
		this.hcg = hcg;
		this.afp = afp;
		this.ue3 = ue3;
		this.result = result;
		this.status = status;
	}
	
	public TripleTest(Double hcg, Double afp, Double ue3, String result, Double trisomy21, String resultT21,
			Double trisomy13, String resultT13, Double trisomy18, String resultT18, String status) {
		super();
		this.hcg = hcg;
		this.afp = afp;
		this.ue3 = ue3;
		this.result = result;
		this.trisomy21 = trisomy21;
		this.resultT21 = resultT21;
		this.trisomy13 = trisomy13;
		this.resultT13 = resultT13;
		this.trisomy18 = trisomy18;
		this.resultT18 = resultT18;
		this.status = status;
	}

	public Double getHcg() {
		return hcg;
	}

	public void setHcg(Double hcg) {
		this.hcg = hcg;
	}

	public Double getAfp() {
		return afp;
	}

	public void setAfp(Double afp) {
		this.afp = afp;
	}

	public Double getUe3() {
		return ue3;
	}

	public void setUe3(Double ue3) {
		this.ue3 = ue3;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
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
	
	public double getCoefHCG(double median) {
		if(this.hcg > median) {
			return 0.2;
		}
		return 1;
	}
	
	public double getCoefAfp(double median) {
		if(this.afp < median) {
			return 0.2;
		}
		return 1;
	}
	
	public double getCoefUe3(double median) {
		if(this.ue3 > median) {
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
