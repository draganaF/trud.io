package com.sbnz.trud.io.apiContracts.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OgttWithPregnancy {
	private int id;
	
	private int primarySampling;
	
	private int firstBloodSampling;
	
	private int secondBloodSampling;
	
	private int thirdBloodSampling;
	
	private int fourthBloodSampling;
	
	private String result;
	
	private int pregnancyId;
	
	private LocalDate date;

	
	public OgttWithPregnancy() {
		super();
	}

	public OgttWithPregnancy(int id, int primarySampling, int firstBloodSampling, int secondBloodSampling,
			int thirdBloodSampling, int fourthBloodSampling, String result, int pregnancyId, LocalDate date) {
		super();
		this.id = id;
		this.primarySampling = primarySampling;
		this.firstBloodSampling = firstBloodSampling;
		this.secondBloodSampling = secondBloodSampling;
		this.thirdBloodSampling = thirdBloodSampling;
		this.fourthBloodSampling = fourthBloodSampling;
		this.result = result;
		this.pregnancyId = pregnancyId;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrimarySampling() {
		return primarySampling;
	}

	public void setPrimarySampling(int primarySampling) {
		this.primarySampling = primarySampling;
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

	public int getPregnancyId() {
		return pregnancyId;
	}

	public void setPregnancyId(int pregnancyId) {
		this.pregnancyId = pregnancyId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
}
