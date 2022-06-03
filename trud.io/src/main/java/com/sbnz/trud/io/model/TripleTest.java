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
	private double hcg;
	
	private double afp;
	
	private double ue3;
	
	private String result;
	
	private double trisomy21;
	
	private double trisomy13;
	
	private double trisomy18;

	public TripleTest() {
		super();
	}

	public TripleTest(double hcg, double afp, double ue3, String result) {
		super();
		this.hcg = hcg;
		this.afp = afp;
		this.ue3 = ue3;
		this.result = result;
	}

	public double getHcg() {
		return hcg;
	}

	public void setHcg(double hcg) {
		this.hcg = hcg;
	}

	public double getAfp() {
		return afp;
	}

	public void setAfp(double afp) {
		this.afp = afp;
	}

	public double getUe3() {
		return ue3;
	}

	public void setUe3(double ue3) {
		this.ue3 = ue3;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
//	public double calculateCRLForWeek(int week) {
//		return (week - 6.5) * 100;
//	}
//	
//	public double medianAFP(int week, double kg) {
//		return Math.pow(10, 0.7569 + 0.0078 * week) / (2.2856 - 0.0328 * kg + 0.0002 * kg * kg);
//	}
//	
//	public double calculateMomAFP(int week, double kg) {
//		return this.afp / medianAFP(week, kg);
//	}
//	
//	public double medianHCG(int week, double kg) {
//		return Math.pow(10, 6.5772 - 0.0733 * week + 0.0003 * week * week) / Math.pow(10, 0.2636 - 0.0047 * kg);
//	}
//	
//	public double calculateMomHCG(int week, double kg) {
//		return this.hcg / medianHCG(week, kg);
//	}

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
	
	public int checkAge(int age) {
		if(age < 18) {
			return 18;
			
		}else if(age > 35) {
			return 35;
		}
		return age;
	}
	
}
