package com.sbnz.trud.io.model;

import java.util.Collection;

import javax.persistence.*;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "illness")
@SQLDelete(sql = "UPDATE illness SET deleted = true WHERE id=? AND version = ?")
@Where(clause = "deleted=false")
public class Illness extends BaseEntity {
	private String name;
	
	@ElementCollection(targetClass = Symptom.class)
	@JoinTable(name = "illnessSymptoms", joinColumns = @JoinColumn(name = "id"))
	@Column(name = "symptom", nullable = false, unique = true)
	@Enumerated(EnumType.STRING)
	private Collection<Symptom> symptomList;
	
	public Illness() {
		super();
	}
	
	public Illness(String name, Collection<Symptom> symptomList) {
		super();
		this.name = name;
		this.symptomList = symptomList;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Collection<Symptom> getSymptomList() {
		return symptomList;
	}
	
	public void setSymptomList(Collection<Symptom> symptomList) {
		this.symptomList = symptomList;
	}
}
