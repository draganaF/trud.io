package com.sbnz.trud.io.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "quadriple_test")
@PrimaryKeyJoinColumn(name = "triple_test")
public class QuadripleTest extends TripleTest {

	private double inhibinA;

	public QuadripleTest() {
		super();
	}

	public QuadripleTest(double hcg, double afp, double ue3, String result, double inhibinA) {
		super(hcg, afp, ue3, result);
		this.inhibinA = inhibinA;
	}

	public double getInhibinA() {
		return inhibinA;
	}

	public void setInhibinA(double inhibinA) {
		this.inhibinA = inhibinA;
	}
	
	public double getCoefInhibinA(double median) {
		if(this.inhibinA > median) {
			return 0.2;
		}
		return 1;
	}
}
