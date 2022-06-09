package com.sbnz.trud.io.apiContracts.request;

import java.time.LocalDateTime;

public class UpdateAppointment {
	private Integer bloodPressureLower;
	
	private Integer bloodPressureUpper;
	
	private float weight;
	
	private String report;
	
	public UpdateAppointment(Integer bloodPressureLower, Integer bloodPressureUpper, float weight, String report) {
		super();
		this.bloodPressureLower = bloodPressureLower;
		this.bloodPressureUpper = bloodPressureUpper;
		this.weight = weight;
		this.report = report;
	}

	public UpdateAppointment() {
		super();
	}

	public Integer getBloodPressureLower() {
		return bloodPressureLower;
	}

	public void setBloodPressureLower(Integer bloodPressureLower) {
		this.bloodPressureLower = bloodPressureLower;
	}

	public Integer getBloodPressureUpper() {
		return bloodPressureUpper;
	}

	public void setBloodPressureUpper(Integer bloodPressureUpper) {
		this.bloodPressureUpper = bloodPressureUpper;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}
}
