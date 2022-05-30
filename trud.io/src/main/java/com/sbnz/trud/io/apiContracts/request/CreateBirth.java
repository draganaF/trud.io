package com.sbnz.trud.io.apiContracts.request;

public class CreateBirth {

private float weight;
	
	private int gestationalAge;
	
	private boolean miscarriage;
	
	private boolean complications;
	
	private boolean cSection;
	
	private int pregnancyId;
	
	public CreateBirth() {
		
	}

	public CreateBirth(float weight, int gestationalAge, boolean miscarriage, boolean complications, boolean cSection,
			int pregnancyId) {
		super();
		this.weight = weight;
		this.gestationalAge = gestationalAge;
		this.miscarriage = miscarriage;
		this.complications = complications;
		this.cSection = cSection;
		this.pregnancyId = pregnancyId;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public int getGestationalAge() {
		return gestationalAge;
	}

	public void setGestationalAge(int gestationalAge) {
		this.gestationalAge = gestationalAge;
	}

	public boolean isMiscarriage() {
		return miscarriage;
	}

	public void setMiscarriage(boolean miscarriage) {
		this.miscarriage = miscarriage;
	}

	public boolean isComplications() {
		return complications;
	}

	public void setComplications(boolean complications) {
		this.complications = complications;
	}

	public boolean iscSection() {
		return cSection;
	}

	public void setcSection(boolean cSection) {
		this.cSection = cSection;
	}

	public int getPregnancyId() {
		return pregnancyId;
	}

	public void setPregnancyId(int pregnancyId) {
		this.pregnancyId = pregnancyId;
	}
}
