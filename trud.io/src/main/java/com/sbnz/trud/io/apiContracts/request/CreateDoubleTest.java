package com.sbnz.trud.io.apiContracts.request;

public class CreateDoubleTest {

	private double crl;
	
	private double nt;
	
	private boolean nasalBone;
	
	private double freeBetaHCG;
	
	private double pappa;
	
	private String result;
	
	public CreateDoubleTest() {}
	
	public CreateDoubleTest(double crl, double nt, boolean nasalBone, double freeBetaHCG, double pappa, String result) {
		super();
		this.crl = crl;
		this.nt = nt;
		this.nasalBone = nasalBone;
		this.freeBetaHCG = freeBetaHCG;
		this.pappa = pappa;
		this.result = result;
	}



	public double getCrl() {
		return crl;
	}

	public void setCrl(double crl) {
		this.crl = crl;
	}

	public double getNt() {
		return nt;
	}

	public void setNt(double nt) {
		this.nt = nt;
	}

	public boolean isNasalBone() {
		return nasalBone;
	}

	public void setNasalBone(boolean nasalBone) {
		this.nasalBone = nasalBone;
	}

	public double getFreeBetaHCG() {
		return freeBetaHCG;
	}

	public void setFreeBetaHCG(double freeBetaHCG) {
		this.freeBetaHCG = freeBetaHCG;
	}

	public double getPappa() {
		return pappa;
	}

	public void setPappa(double pappa) {
		this.pappa = pappa;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	
}
