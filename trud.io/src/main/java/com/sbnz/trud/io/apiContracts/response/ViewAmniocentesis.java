package com.sbnz.trud.io.apiContracts.response;

public class ViewAmniocentesis {
	private int id;
	private double afp;
	
	private String result;
	
	private double trisomy21;
	
	private String resultT21;
	
	private double trisomy13;
	
	private String resultT13;
	
	private double trisomy18;
	
	private String resultT18;
	
	private String neuralDefects;
	
	public ViewAmniocentesis() {}
	
	public ViewAmniocentesis(int id, double afp, String result, double trisomy21, String resultT21, double trisomy13,
			String resultT13, double trisomy18, String resultT18, String neuralDefects) {
		super();
		this.id = id;
		this.afp = afp;
		this.result = result;
		this.trisomy21 = trisomy21;
		this.resultT21 = resultT21;
		this.trisomy13 = trisomy13;
		this.resultT13 = resultT13;
		this.trisomy18 = trisomy18;
		this.resultT18 = resultT18;
		this.neuralDefects = neuralDefects;
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

	public String getNeuralDefects() {
		return neuralDefects;
	}

	public void setNeuralDefects(String neuralDefects) {
		this.neuralDefects = neuralDefects;
	}
	
	

}
