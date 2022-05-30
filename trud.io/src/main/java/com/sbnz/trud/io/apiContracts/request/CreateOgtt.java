package com.sbnz.trud.io.apiContracts.request;

public class CreateOgtt {

	private int primarySampling;
	
	private int firstBloodSampling;
	
	private int secondBloodSampling;
	
	private int thirdBloodSampling;
	
	private int fourthBloodSampling;
	
	private String result;

	
	public CreateOgtt() {
		super();
	}

	public CreateOgtt(int primarySampling, int firstBloodSampling, int secondBloodSampling, int thirdBloodSampling,
			int fourthBloodSampling, String result) {
		super();
		this.primarySampling = primarySampling;
		this.firstBloodSampling = firstBloodSampling;
		this.secondBloodSampling = secondBloodSampling;
		this.thirdBloodSampling = thirdBloodSampling;
		this.fourthBloodSampling = fourthBloodSampling;
		this.result = result;
	}

	public int getPrimarySampling() {
		return primarySampling;
	}

	public void setPrimarySampling(int primarySampling) {
		this.primarySampling = primarySampling;
	}

	public int getFirstBloodSampling() {
		return firstBloodSampling;
	}

	public void setFirstBloodSampling(int firstBloodSampling) {
		this.firstBloodSampling = firstBloodSampling;
	}

	public int getSecondBloodSampling() {
		return secondBloodSampling;
	}

	public void setSecondBloodSampling(int secondBloodSampling) {
		this.secondBloodSampling = secondBloodSampling;
	}

	public int getThirdBloodSampling() {
		return thirdBloodSampling;
	}

	public void setThirdBloodSampling(int thirdBloodSampling) {
		this.thirdBloodSampling = thirdBloodSampling;
	}

	public int getFourthBloodSampling() {
		return fourthBloodSampling;
	}

	public void setFourthBloodSampling(int fourthBloodSampling) {
		this.fourthBloodSampling = fourthBloodSampling;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
