package com.sbnz.trud.io.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "appointment")
@SQLDelete(sql = "UPDATE appointment SET deleted = true WHERE id=? AND version = ?")
@Where(clause = "deleted=false")
public class Appointment {
	@Version
	@Column(name = "version", columnDefinition = "integer DEFAULT 0", nullable = false)
	private Long version;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	private LocalDateTime date;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Pregnancy pregnancy;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Patient patient;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Doctor doctor;
	
	private int bloodPressure;
	
	private float weight;
	
	private String therapy;
	
	private boolean deleted = false;
	
	public Appointment() {
		super();
	}
	
	public Appointment(LocalDateTime date, Pregnancy pregnancy, Patient patient, Doctor doctor, int bloodPressure, float weight,
			String therapy) {
		super();
		this.date = date;
		this.pregnancy = pregnancy;
		this.patient = patient;
		this.doctor = doctor;
		this.bloodPressure = bloodPressure;
		this.weight = weight;
		this.therapy = therapy;
	}
	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	public Pregnancy getPregnancy() {
		return pregnancy;
	}
	
	public void setPregnancy(Pregnancy pregnancy) {
		this.pregnancy = pregnancy;
	}
	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public Patient getPatient() {
		return patient;
	} 
	
	public Doctor getDoctor() {
		return doctor;
	}
	
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	public int getBloodPressure() {
		return bloodPressure;
	}
	
	public void setBloodPressure(int bloodPressure) {
		this.bloodPressure = bloodPressure;
	}
	
	public float getWeight() {
		return weight;
	}
	
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	public String getTherapy() {
		return therapy;
	}
	
	public void setTherapy(String therapy) {
		this.therapy = therapy;
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
