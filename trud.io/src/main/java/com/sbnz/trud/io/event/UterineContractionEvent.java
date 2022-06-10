package com.sbnz.trud.io.event;

import java.util.Date;

import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

@Role(Role.Type.EVENT)
@Timestamp("contractionTime")
public class UterineContractionEvent {
	private Date contractionTime;
	private boolean processed;
	
	public UterineContractionEvent() {
		
	}

	public UterineContractionEvent(Date contractionTime) {
		super();
		this.contractionTime = contractionTime;
		this.processed = false;
	}

	public Date getContractionTime() {
		return contractionTime;
	}

	public void setContractionTime(Date contractionTime) {
		this.contractionTime = contractionTime;
	}

	public boolean isProcessed() {
		return processed;
	}

	public void setProcessed(boolean processed) {
		this.processed = processed;
	}
	
}
