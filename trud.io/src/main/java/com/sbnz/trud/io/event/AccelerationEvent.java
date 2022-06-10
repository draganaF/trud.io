package com.sbnz.trud.io.event;

import java.time.LocalDateTime;

import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

@Role(Role.Type.EVENT)
@Timestamp( "timestamp" )
public class AccelerationEvent {
	private double variablity;
	private LocalDateTime timestamp;
	
	public AccelerationEvent() {
		super();
	}
	public AccelerationEvent(double variablity, LocalDateTime timestamp) {
		super();
		this.variablity = variablity;
		this.timestamp = timestamp;
	}
	public double getVariablity() {
		return variablity;
	}
	public void setVariablity(double variablity) {
		this.variablity = variablity;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
}
