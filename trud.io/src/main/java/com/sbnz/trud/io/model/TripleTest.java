package com.sbnz.trud.io.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "pregnancy")
@SQLDelete(sql = "UPDATE pregnancy SET deleted = true WHERE id=? AND version = ?")
@Where(clause = "deleted=false")
public class TripleTest {

	@Version
	@Column(name = "version", columnDefinition = "integer DEFAULT 0", nullable = false)
	private Long version;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
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
	
	public Long getVersion() {
	    return version;
	}

	public void setVersion(Long version) {
	    this.version = version;
	}
	
	public Integer getId() {
	    return id;
	}

	public void setId(Integer id) {
	    this.id = id;
	}
}
