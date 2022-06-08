package com.sbnz.trud.io.apiContracts.request;

import java.util.Date;

public class FetalHartRateValue {
	private int bpm;
	private Date timestamp;
	
	public FetalHartRateValue() {
		super();
	}

	public FetalHartRateValue(int bpm, Date timestamp) {
		super();
		this.bpm = bpm;
		this.timestamp = timestamp;
	}

	public int getBpm() {
		return bpm;
	}

	public void setBpm(int bpm) {
		this.bpm = bpm;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}
