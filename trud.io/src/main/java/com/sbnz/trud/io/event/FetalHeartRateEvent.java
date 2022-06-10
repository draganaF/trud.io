package com.sbnz.trud.io.event;

import java.util.Date;

import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

@Role(Role.Type.EVENT)
@Timestamp( "timestamp" )
public class FetalHeartRateEvent {
	private float value;
	private boolean processed;
	private Date timestamp;
	
	public FetalHeartRateEvent() {
		super();
	}

	public FetalHeartRateEvent(float value, boolean processed, Date timestamp) {
		super();
		this.value = value;
		this.processed = processed;
		this.timestamp = timestamp;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
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
