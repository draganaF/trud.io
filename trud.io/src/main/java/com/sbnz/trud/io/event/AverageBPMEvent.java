package com.sbnz.trud.io.event;

import org.kie.api.definition.type.Role;

@Role(Role.Type.EVENT)
public class AverageBPMEvent {
	private double value;
	
	public AverageBPMEvent() {
		super();
	}

	public AverageBPMEvent(double value) {
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
