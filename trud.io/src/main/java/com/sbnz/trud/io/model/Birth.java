package com.sbnz.trud.io.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "birth")
@SQLDelete(sql = "UPDATE birth SET deleted = true WHERE id=? AND version = ?")
@Where(clause = "deleted=false")
public class Birth extends BaseEntity{
	
	private float weight;
	
	private int gestationalAge;
	
	private boolean miscarriage;
	
	private boolean complications;
	
	private boolean cSection;
	
	public Birth() {
		super();
	}
	
	public Birth(float weight, int gestationalAge, boolean miscarriage, boolean complications, boolean cSection) {
		super();
		this.weight = weight;
		this.gestationalAge = gestationalAge;
		this.miscarriage = miscarriage;
		this.complications = complications;
		this.cSection = cSection;
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
}
