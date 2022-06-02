package com.sbnz.trud.io.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;


import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "ogtt_test")
@SQLDelete(sql = "UPDATE ogtt_test SET deleted = true WHERE id=? AND version = ?")
@Where(clause = "deleted=false")
public class OgttTest extends BaseEntity{
	private int primarySampling;
	
	private int firstBloodSampling;
	
	private int secondBloodSampling;
	
	private int thirdBloodSampling;
	
	private int fourthBloodSampling;
	
	private String result;
	
	private LocalDate date;
	
	public OgttTest() {
		super();
	}
	public OgttTest(int id, int primarySampling, int firstBloodSampling, int secondBloodSampling, int thirdBloodSampling, int fourthBloodSampling,
			String result, LocalDate date) {
		super();
		this.setId(id);
		this.primarySampling = primarySampling;
		this.firstBloodSampling = firstBloodSampling;
		this.secondBloodSampling = secondBloodSampling;
		this.thirdBloodSampling = thirdBloodSampling;
		this.fourthBloodSampling = fourthBloodSampling;
		this.result = result;
		this.date = date;
	}
	
	public OgttTest(int primarySampling, int firstBloodSampling, int secondBloodSampling, int thirdBloodSampling, int fourthBloodSampling,
			String result, LocalDate date) {
		super();
		this.primarySampling = primarySampling;
		this.firstBloodSampling = firstBloodSampling;
		this.secondBloodSampling = secondBloodSampling;
		this.thirdBloodSampling = thirdBloodSampling;
		this.fourthBloodSampling = fourthBloodSampling;
		this.result = result;
		this.date = date;
	}
	
	
	public OgttTest(String result) {
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
	public int getPrimarySampling() {
		return primarySampling;
	}
	public void setPrimarySampling(int primarySampling) {
		this.primarySampling = primarySampling;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
}
