package com.sbnz.trud.io.apiContracts.request;

import java.util.List;

import com.sbnz.trud.io.model.Symptom;

public class UpdateAppointment {
	private Integer bloodPressureLower;
	
	private Integer bloodPressureUpper;
	
	private float weight;
	
	private String report;
	
	private List<Symptom> symptoms;
	
	private List<String> illnesseesNames;
	
	public UpdateAppointment(Integer bloodPressureLower, Integer bloodPressureUpper, float weight, String report,
			List<Symptom> symptoms, List<String> illnesseesNames) {
		super();
		this.bloodPressureLower = bloodPressureLower;
		this.bloodPressureUpper = bloodPressureUpper;
		this.weight = weight;
		this.report = report;
		this.symptoms = symptoms;
		this.illnesseesNames = illnesseesNames;
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

	public List<Symptom> getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(List<Symptom> symptoms) {
		this.symptoms = symptoms;
	}

	public List<String> getIllnesseesNames() {
		return illnesseesNames;
	}

	public void setIllnesseesNames(List<String> illnesseesNames) {
		this.illnesseesNames = illnesseesNames;
	}
}
