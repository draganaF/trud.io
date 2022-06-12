package com.sbnz.trud.io.dto;

import com.sbnz.trud.io.model.CTGStatus;

public class CTGResultReport {
	private CTGStatus status;
	private int numberOfCtgs;
	private float percentage;

	
	public CTGResultReport() {
		super();
	}

	public CTGResultReport(CTGStatus status) {
		super();
		this.status = status;
	}

	public CTGResultReport(CTGStatus status, float percentage, int numberOfCtgs) {
		super();
		this.status = status;
		this.numberOfCtgs = numberOfCtgs;
	}
	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	public CTGStatus getStatus() {
		return status;
	}

	public void setStatus(CTGStatus status) {
		this.status = status;
	}

	public int getNumberOfCtgs() {
		return numberOfCtgs;
	}

	public void setNumberOfCtgs(int numberOfCtgs) {
		this.numberOfCtgs = numberOfCtgs;
	}
}
