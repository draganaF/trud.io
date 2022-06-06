package com.sbnz.trud.io.apiContracts.request;

public class CreateAmniocentesis {
	
	private double afp;
	
	private String result;
	
	
	public CreateAmniocentesis() {}
	
	public CreateAmniocentesis(double afp, String result) {
		super();
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


}
