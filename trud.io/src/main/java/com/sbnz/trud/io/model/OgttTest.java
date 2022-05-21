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
@Table(name = "ogtt_test")
@SQLDelete(sql = "UPDATE ogtt_test SET deleted = true WHERE id=? AND version = ?")
@Where(clause = "deleted=false")
public class OgttTest {

	@Version
	@Column(name = "version", columnDefinition = "integer DEFAULT 0", nullable = false)
	private Long version;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	private int firstBloodSampling;
	
	private int secondBloodSampling;
	
	private int thirdBloodSampling;
	
	private int fourthBloodSampling;
	
	private String result;
	
	
	public OgttTest() {
		super();
	}
	public OgttTest(int firstBloodSampling, int secondBloodSampling, int thirdBloodSampling, int fourthBloodSampling,
			String result) {
		super();
		this.firstBloodSampling = firstBloodSampling;
		this.secondBloodSampling = secondBloodSampling;
		this.thirdBloodSampling = thirdBloodSampling;
		this.fourthBloodSampling = fourthBloodSampling;
		this.result = result;
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
