package com.sbnz.trud.io.event;

import java.util.Date;

import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

@Role(Role.Type.EVENT)
@Timestamp("timestamp")
public class PossibleUterineContractionEvent {
	private int min;
	private int max;
	private boolean processed;
	private Date timestamp;
	
	public PossibleUterineContractionEvent() {
		
	}
	
	public PossibleUterineContractionEvent(int min, int max, Date timestamp, boolean processed) {
		super();
		this.min = min;
		this.max = max;
		this.timestamp = timestamp;
		this.processed = processed;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public boolean isProcessed() {
		return processed;
	}
	public void setProcessed(boolean processed) {
		this.processed = processed;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
}
