package com.sbnz.trud.io.apiContracts.request;

public class CreateQuadripleTest {
private double hcg;
	
	private double afp;
	
	private double ue3;
	
	private String result;
	
	private double inhibinA;
	
	public CreateQuadripleTest() {}

	public CreateQuadripleTest(double hcg, double afp, double ue3, String result, double inhibinA) {
		super();
		this.hcg = hcg;
		this.afp = afp;
		this.ue3 = ue3;
		this.result = result;
		this.inhibinA = inhibinA;
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

	public double getInhibinA() {
		return inhibinA;
	}

	public void setInhibinA(double inhibinA) {
		this.inhibinA = inhibinA;
	}
	
	

}
