package com.sbnz.trud.io.dto;

import com.sbnz.trud.io.model.ChromosomalDisorders;

public class ChromosomalDisorderReport {
	private ChromosomalDisorders chromosomalDisorder;
	
	private float percentage;

	public ChromosomalDisorderReport(ChromosomalDisorders chromosomalDisorder, float percentage) {
		super();
		this.chromosomalDisorder = chromosomalDisorder;
		this.percentage = percentage;
	}
	
	public ChromosomalDisorderReport(ChromosomalDisorders chromosomalDisorder) {
		super();
		this.chromosomalDisorder = chromosomalDisorder;
	}
	
	public ChromosomalDisorderReport() {
		
	}

	public ChromosomalDisorders getChromosomalDisorder() {
		return chromosomalDisorder;
	}

	public void setChromosomalDisorder(ChromosomalDisorders chromosomalDisorder) {
		this.chromosomalDisorder = chromosomalDisorder;
	}

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}
}