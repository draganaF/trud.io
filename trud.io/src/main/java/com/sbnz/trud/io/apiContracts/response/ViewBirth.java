package com.sbnz.trud.io.apiContracts.response;

import java.time.LocalDateTime;

public class ViewBirth {
	private Float weight;
	
	private Integer gestationalAge;
	
	private boolean miscarriage;
	
	private boolean complications;
	
	private boolean cSection;
	
	private String chromosomalDisorder;
	
	private boolean abortion;
	private  LocalDateTime birthdateTime;
	
	public ViewBirth() {}

	public ViewBirth(Float weight, Integer gestationalAge, boolean miscarriage, boolean complications, boolean cSection,
			String chromosomalDisorder, boolean abortion, LocalDateTime birthDateTime) {
		super();
		this.weight = weight;
		this.gestationalAge = gestationalAge;
		this.miscarriage = miscarriage;
		this.complications = complications;
		this.cSection = cSection;
		this.chromosomalDisorder = chromosomalDisorder;
		this.abortion = abortion;
		this.birthdateTime = birthDateTime;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public Integer getGestationalAge() {
		return gestationalAge;
	}

	public void setGestationalAge(Integer gestationalAge) {
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

	public String getChromosomalDisorder() {
		return chromosomalDisorder;
	}

	public void setChromosomalDisorder(String chromosomalDisorder) {
		this.chromosomalDisorder = chromosomalDisorder;
	}

	public boolean isAbortion() {
		return abortion;
	}

	public void setAbortion(boolean abortion) {
		this.abortion = abortion;
	}

	public LocalDateTime getBirthdateTime() {
		return birthdateTime;
	}

	public void setBirthdateTime(LocalDateTime birthdateTime) {
		this.birthdateTime = birthdateTime;
	}
	
	

}
