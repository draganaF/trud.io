package com.sbnz.trud.io.event;

import org.kie.api.definition.type.Role;

@Role(Role.Type.EVENT)
public class VariabilityEvent {
	private double value;

	public VariabilityEvent() {
		super();
	}

	public VariabilityEvent(double value) {
		super();
		this.value = value;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}	
}
