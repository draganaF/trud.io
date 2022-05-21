package com.sbnz.trud.io.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "illness")
@SQLDelete(sql = "UPDATE illness SET deleted = true WHERE id=? AND version = ?")
@Where(clause = "deleted=false")
public class Illness {

	@Version
	@Column(name = "version", columnDefinition = "integer DEFAULT 0", nullable = false)
	private Long version;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	private String name;

	private ArrayList<Symptom> symptomList;
	
	public Illness() {
		super();
	}
	
	public Illness(String name, ArrayList<Symptom> symptomList) {
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
	
	public ArrayList<Symptom> getSymptomList() {
		return symptomList;
	}
	
	public void setSymptomList(ArrayList<Symptom> symptomList) {
		this.symptomList = symptomList;
	}
	
	public Long getVersion() {
	    return version;
	}

	public void setVersion(Long version) {
	    this.version = version;
	}
	
	public Integer getId() {
	    return id;
	}

	public void setId(Integer id) {
	    this.id = id;
	}
}
