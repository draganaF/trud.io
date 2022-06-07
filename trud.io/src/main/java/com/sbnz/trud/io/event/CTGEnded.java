package com.sbnz.trud.io.event;

import org.kie.api.definition.type.Role;

@Role(Role.Type.EVENT)
public class CTGEnded {
	private boolean ended;

	
	public CTGEnded() {
		super();
	}

	public CTGEnded(boolean ended) {
		super();
		this.ended = ended;
	}

	public boolean isEnded() {
		return ended;
	}

	public void setEnded(boolean ended) {
		this.ended = ended;
	}
}
