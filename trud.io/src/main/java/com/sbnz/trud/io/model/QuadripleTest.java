package com.sbnz.trud.io.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "quadriple_test")
@PrimaryKeyJoinColumn(name = "triple_test")
public class QuadripleTest extends TripleTest {

	private Double inhibinA;

	public QuadripleTest() {
		super();
	}

	public QuadripleTest(Double hcg, Double afp, Double ue3, String result, Double inhibinA, String status) {
		super(hcg, afp, ue3, result, status);
		this.inhibinA = inhibinA;
	}

	public Double getInhibinA() {
		return inhibinA;
	}

	public void setInhibinA(Double inhibinA) {
		this.inhibinA = inhibinA;
	}
	
	public double getCoefInhibinA(double median) {
		if(this.inhibinA > median) {
			return 0.2;
		}
		return 1;
	}
}
