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
	private Collection<Symptom> symptoms;
	
	public Illness() {
		super();
	}
	
	public Illness(String name, Collection<Symptom> symptoms) {
		super();
		this.name = name;
		this.symptoms = symptoms;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Collection<Symptom> getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(Collection<Symptom> symptoms) {
		this.symptoms = symptoms;
	}
	
	
}
