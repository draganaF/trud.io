package com.sbnz.trud.io.event;

import org.kie.api.definition.type.Role;

@Role(Role.Type.EVENT)
public class MaxBPMEvent {
	private float maxValue;
	private int numberOfValuesAgrigated;
	
	public MaxBPMEvent() {
		super();
	}
	public MaxBPMEvent(float maxValue, int numberOfValuesAgrigated) {
		super();
		this.maxValue = maxValue;
		this.numberOfValuesAgrigated = numberOfValuesAgrigated;
	}
	
	public float getMaxValue() {
		return maxValue;
	}
	public void setMaxValue(float maxValue) {
		this.maxValue = maxValue;
	}
	public int getNumberOfValuesAgrigated() {
		return numberOfValuesAgrigated;
	}
	public void setNumberOfValuesAgrigated(int numberOfValuesAgrigated) {
		this.numberOfValuesAgrigated = numberOfValuesAgrigated;
	}
}
