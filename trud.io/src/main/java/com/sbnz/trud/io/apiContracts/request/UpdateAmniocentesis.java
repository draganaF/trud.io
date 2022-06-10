package com.sbnz.trud.io.apiContracts.request;

public class UpdateAmniocentesis {
	private int id;

	private double afp;
	
	public UpdateAmniocentesis() {
		
	}
	public UpdateAmniocentesis(int id, double afp) {
		super();
		this.id = id;
		this.afp = afp;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAfp() {
		return afp;
	}

	public void setAfp(double afp) {
		this.afp = afp;
	}
	

}
