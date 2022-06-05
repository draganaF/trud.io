package com.sbnz.trud.io.dto;

import java.util.List;

import com.sbnz.trud.io.model.Symptom;

public class IllnessesReport {
	private List<String> illnessesNames;
	
	private float percentage;

	public IllnessesReport(List<String> illnessesNames, float percentage) {
		super();
		this.illnessesNames = illnessesNames;
		this.percentage = percentage;
	}
	
	public IllnessesReport(List<String> illnessesNames) {
		super();
		this.illnessesNames = illnessesNames;
	}

	public IllnessesReport() {
		
	}

	public List<String> getIllnessesNames() {
		return illnessesNames;
	}

	public void setIllnessesNames(List<String> illnessesNames) {
		this.illnessesNames = illnessesNames;
	}

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}
}