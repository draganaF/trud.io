package com.sbnz.trud.io.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "quadriple_test")
@PrimaryKeyJoinColumn(name = "triple_test")
public class QuadripleTest extends TripleTest {

	private int inhibinA;

	public QuadripleTest() {
		super();
	}

	public QuadripleTest(int hcg, int afp, int ue3, String result, int inhibinA) {
		super(hcg, afp, ue3, result);
		this.inhibinA = inhibinA;
	}

	public int getInhibinA() {
		return inhibinA;
	}

	public void setInhibinA(int inhibinA) {
		this.inhibinA = inhibinA;
	}
}
