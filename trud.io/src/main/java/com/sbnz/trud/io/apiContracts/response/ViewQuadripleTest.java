package com.sbnz.trud.io.apiContracts.response;

public class ViewQuadripleTest extends ViewTripleTest{
	
	private double inhibinA;

	public ViewQuadripleTest() {}
	
	public ViewQuadripleTest(int id, double hcg, double afp, double ue3, String result, double trisomy21, String resultT21,
			double trisomy13, String resultT13, double trisomy18, String resultT18, double inhibinA) {
		super(id, hcg, afp, ue3, result, trisomy21, resultT21, trisomy13, resultT13, trisomy18, resultT18);
		this.inhibinA = inhibinA;
	}

	public double getInhibinA() {
		return inhibinA;
	}

	public void setInhibinA(double inhibinA) {
		this.inhibinA = inhibinA;
	}
	
	

}
