package com.sbnz.trud.io.apiContracts.request;

public class TemplateTestRule {
	
	private int cutOffT21;
	private String signT21;
	private int cutOffT18;
	private String signT18;
	private int cutOffT13;
	private String signT13;
	private String result;
	private String statusDouble;
	private String statusTriple;
	private String statusQuadriple;
	private int salienceT21 = 1000;
	private int salienceT18 = 800;
	private int salienceT13 = 600;

	public TemplateTestRule() {}
	
	
	public TemplateTestRule(int cutOffT21, int cutOffT18, int cutOffT13) {
		super();
		this.cutOffT21 = cutOffT21;
		this.cutOffT18 = cutOffT18;
		this.cutOffT13 = cutOffT13;
	}



	public int getCutOffT21() {
		return cutOffT21;
	}

	public void setCutOffT21(int cutOffT21) {
		this.cutOffT21 = cutOffT21;
	}

	public int getCutOffT18() {
		return cutOffT18;
	}

	public void setCutOffT18(int cutOffT18) {
		this.cutOffT18 = cutOffT18;
	}

	public int getCutOffT13() {
		return cutOffT13;
	}

	public void setCutOffT13(int cutOffT13) {
		this.cutOffT13 = cutOffT13;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getSignT21() {
		return signT21;
	}

	public void setSignT21(String signT21) {
		this.signT21 = signT21;
	}

	public String getSignT18() {
		return signT18;
	}

	public void setSignT18(String signT18) {
		this.signT18 = signT18;
	}

	public String getSignT13() {
		return signT13;
	}

	public void setSignT13(String signT13) {
		this.signT13 = signT13;
	}


	public String getStatusDouble() {
		return statusDouble;
	}


	public void setStatusDouble(String statusDouble) {
		this.statusDouble = statusDouble;
	}


	public String getStatusTriple() {
		return statusTriple;
	}


	public void setStatusTriple(String statusTriple) {
		this.statusTriple = statusTriple;
	}


	public String getStatusQuadriple() {
		return statusQuadriple;
	}


	public void setStatusQuadriple(String statusQuadriple) {
		this.statusQuadriple = statusQuadriple;
	}


	public int getSalienceT21() {
		return salienceT21;
	}


	public void setSalienceT21(int salienceT21) {
		this.salienceT21 = salienceT21;
	}


	public int getSalienceT18() {
		return salienceT18;
	}


	public void setSalienceT18(int salienceT18) {
		this.salienceT18 = salienceT18;
	}


	public int getSalienceT13() {
		return salienceT13;
	}


	public void setSalienceT13(int salienceT13) {
		this.salienceT13 = salienceT13;
	}
	
	
	
	
	
}