package com.sbnz.trud.io.apiContracts.request;

public class TemplateTestRule {
	
	private int cutOffT21;
	private String signT21;
	private int cutOffT18;
	private String signT18;
	private int cutOffT13;
	private String signT13;
	private String result;
	
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
	
	
	
}