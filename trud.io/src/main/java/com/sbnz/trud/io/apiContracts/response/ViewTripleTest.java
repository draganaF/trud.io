package com.sbnz.trud.io.apiContracts.response;

public class ViewTripleTest {
	
	private int id;
	
	private double hcg;
	
	private double afp;
	
	private double ue3;
	
	private String result;
	
	private double trisomy21;
	
	private String resultT21;
	
	private double trisomy13;
	
	private String resultT13;
	
	private double trisomy18;
	
	private String resultT18;

	public ViewTripleTest() {}
	
	public ViewTripleTest(int id, double hcg, double afp, double ue3, String result, double trisomy21, String resultT21,
			double trisomy13, String resultT13, double trisomy18, String resultT18) {
		super();
		this.id = id;
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
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public double getTrisomy21() {
		return trisomy21;
	}

	public void setTrisomy21(double trisomy21) {
		this.trisomy21 = trisomy21;
	}

	public String getResultT21() {
		return resultT21;
	}

	public void setResultT21(String resultT21) {
		this.resultT21 = resultT21;
	}

	public double getTrisomy13() {
		return trisomy13;
	}

	public void setTrisomy13(double trisomy13) {
		this.trisomy13 = trisomy13;
	}

	public String getResultT13() {
		return resultT13;
	}

	public void setResultT13(String resultT13) {
		this.resultT13 = resultT13;
	}

	public double getTrisomy18() {
		return trisomy18;
	}

	public void setTrisomy18(double trisomy18) {
		this.trisomy18 = trisomy18;
	}

	public String getResultT18() {
		return resultT18;
	}

	public void setResultT18(String resultT18) {
		this.resultT18 = resultT18;
	}
	
	
	

}
