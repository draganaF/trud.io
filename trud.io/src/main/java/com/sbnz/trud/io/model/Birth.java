package com.sbnz.trud.io.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "birth")
@SQLDelete(sql = "UPDATE birth SET deleted = true WHERE id=? AND version = ?")
@Where(clause = "deleted=false")
public class Birth extends BaseEntity{
	
	private Float weight;
	
	private Integer gestationalAge;
	
	private boolean miscarriage;
	
	private boolean complications;
	
	private boolean cSection;
	
	private boolean abortion;
	
	@Enumerated(EnumType.STRING)
	private ChromosomalDisorders chromosomalDisorder;
	
	private LocalDateTime birthDateTime;
	
	public Birth() {
		super();
	}
	
	public Birth(Float weight, Integer gestationalAge, boolean miscarriage, boolean complications, boolean cSection, ChromosomalDisorders chromosomalDisorders, LocalDateTime birthDateTime) {
		super();
		this.weight = weight;
		this.gestationalAge = gestationalAge;
		this.miscarriage = miscarriage;
		this.complications = complications;
		this.cSection = cSection;
		this.chromosomalDisorder = chromosomalDisorders;
		this.birthDateTime = birthDateTime;
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
	public ChromosomalDisorders getChromosomalDisorder() {
		return chromosomalDisorder;
	}
	public void setChromosomalDisorder(ChromosomalDisorders chromosomalDisorder) {
		this.chromosomalDisorder = chromosomalDisorder;
	}

	public boolean isAbortion() {
		return abortion;
	}

	public void setAbortion(boolean abortion) {
		this.abortion = abortion;
	}

	public LocalDateTime getBirthDateTime() {
		return birthDateTime;
	}

	public void setBirthDateTime(LocalDateTime birthDateTime) {
		this.birthDateTime = birthDateTime;
	}
	
	
}
