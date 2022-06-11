package com.sbnz.trud.io.apiContracts.response;

public class ViewDoubleTest {

	private double crl;
	
	private double nt;
	
	private boolean nasalBone;
	
	private double freeBetaHCG;
	
	private double pappa;
	
	private double trisomy21;
	
	private String resultT21;
	
	private double trisomy13;
	
	private String resultT13;
	
	private double trisomy18;
	
	private String resultT18;
	
	private String result;
	
	public ViewDoubleTest() {}

	public ViewDoubleTest(double crl, double nt, boolean nasalBone, double freeBetaHCG, double pappa, double trisomy21,
			String resultT21, double trisomy13, String resultT13, double trisomy18, String resultT18, String result) {
		super();
		this.crl = crl;
		this.nt = nt;
		this.nasalBone = nasalBone;
		this.freeBetaHCG = freeBetaHCG;
		this.pappa = pappa;
		this.trisomy21 = trisomy21;
		this.resultT21 = resultT21;
		this.trisomy13 = trisomy13;
		this.resultT13 = resultT13;
		this.trisomy18 = trisomy18;
		this.resultT18 = resultT18;
		this.result = result;
	}
	
	public ViewDoubleTest(double crl, double nt, boolean nasalBone, double freeBetaHCG, double pappa,  String result) {
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

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	
	
	
}
