package com.sbnz.trud.io.apiContracts.request;

public class UpdateTripleTest {
	private int id;
	
	private double hcg;
	
	private double afp;
	
	private double ue3;
	
	public UpdateTripleTest() {
		
	}

	public UpdateTripleTest(int id, double hcg, double afp, double ue3) {
		super();
		this.id = id;
		this.hcg = hcg;
		this.afp = afp;
		this.ue3 = ue3;
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
	
	

}
