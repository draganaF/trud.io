package com.sbnz.trud.io.apiContracts.request;

import java.util.Date;

public class UterineContractionValue {
	private int value;
	private Date timestamp;
	
	
	public UterineContractionValue() {
		super();
	}
	public UterineContractionValue(int value, Date timestamp) {
		super();
		this.value = value;
		this.timestamp = timestamp;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}
