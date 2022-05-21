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
@Table(name = "double_test")
@SQLDelete(sql = "UPDATE double_test SET deleted = true WHERE id=? AND version = ?")
@Where(clause = "deleted=false")
public class DoubleTest {

	@Version
	@Column(name = "version", columnDefinition = "integer DEFAULT 0", nullable = false)
	private Long version;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	    
	private int crl;
	
	private int nt;
	
	private boolean nasalBone;
	
	private int freeBetaHCG;
	
	private int pappa;
	
	private String result;
	
	public DoubleTest() {
		super();
	}

	public DoubleTest(int crl, int nt, boolean nasalBone, int freeBetaHCG, int pappa, String result) {
		super();
		this.crl = crl;
		this.nt = nt;
		this.nasalBone = nasalBone;
		this.freeBetaHCG = freeBetaHCG;
		this.pappa = pappa;
		this.result = result;
	}

	public int getCrl() {
		return crl;
	}

	public void setCrl(int crl) {
		this.crl = crl;
	}

	public int getNt() {
		return nt;
	}

	public void setNt(int nt) {
		this.nt = nt;
	}

	public boolean isNasalBone() {
		return nasalBone;
	}

	public void setNasalBone(boolean nasalBone) {
		this.nasalBone = nasalBone;
	}

	public int getFreeBetaHCG() {
		return freeBetaHCG;
	}

	public void setFreeBetaHCG(int freeBetaHCG) {
		this.freeBetaHCG = freeBetaHCG;
	}

	public int getPappa() {
		return pappa;
	}

	public void setPappa(int pappa) {
		this.pappa = pappa;
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
