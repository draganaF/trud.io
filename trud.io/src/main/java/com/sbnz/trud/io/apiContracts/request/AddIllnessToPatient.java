package com.sbnz.trud.io.apiContracts.request;

import java.util.List;

public class AddIllnessToPatient {

	private int userId;
	private List<String> illnessNames;
	
	public AddIllnessToPatient() {
		
	}

	
	public AddIllnessToPatient(int userId, List<String> illnessNames) {
		super();
		this.userId = userId;
		this.illnessNames = illnessNames;
	}


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<String> getIllnessNames() {
		return illnessNames;
	}

	public void setIllnessNames(List<String> illnessNames) {
		this.illnessNames = illnessNames;
	}
}
