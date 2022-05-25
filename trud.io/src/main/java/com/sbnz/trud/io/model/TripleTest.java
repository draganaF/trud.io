package com.sbnz.trud.io.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "triple_test")
@SQLDelete(sql = "UPDATE triple_test SET deleted = true WHERE id=? AND version = ?")
@Where(clause = "deleted=false")
public class TripleTest extends BaseEntity {
	private int hcg;
	
	private int afp;
	
	private int ue3;
	
	private String result;

	public TripleTest() {
		super();
	}

	public TripleTest(int hcg, int afp, int ue3, String result) {
		super();
		this.hcg = hcg;
		this.afp = afp;
		this.ue3 = ue3;
		this.result = result;
	}

	public int getHcg() {
		return hcg;
	}

	public void setHcg(int hcg) {
		this.hcg = hcg;
	}

	public int getAfp() {
		return afp;
	}

	public void setAfp(int afp) {
		this.afp = afp;
	}

	public int getUe3() {
		return ue3;
	}

	public void setUe3(int ue3) {
		this.ue3 = ue3;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
