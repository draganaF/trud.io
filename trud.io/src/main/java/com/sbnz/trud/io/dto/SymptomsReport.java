package com.sbnz.trud.io.dto;

import java.util.List;

import com.sbnz.trud.io.model.Symptom;

public class SymptomsReport {
	private List<Symptom> symptoms;
	
	private float percentage;

	public SymptomsReport(List<Symptom> symptoms, float percentage) {
		super();
		this.symptoms = symptoms;
		this.percentage = percentage;
	}
	
	public SymptomsReport(List<Symptom> symptoms) {
		super();
		this.symptoms = symptoms;
	}
	
	public SymptomsReport() {
		
	}

	public List<Symptom> getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(List<Symptom> symptoms) {
		this.symptoms = symptoms;
	}

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}
}