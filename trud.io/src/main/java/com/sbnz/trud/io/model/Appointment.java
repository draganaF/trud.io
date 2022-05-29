package com.sbnz.trud.io.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "appointment")
@SQLDelete(sql = "UPDATE appointment SET deleted = true WHERE id=? AND version = ?")
@Where(clause = "deleted=false")
public class Appointment extends BaseEntity{
	private LocalDateTime date;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Pregnancy pregnancy;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Patient patient;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Doctor doctor;
	
	private int bloodPressure;
	
	private float weight;
	
	private String report;
	
	private boolean deleted = false;
	
	public Appointment() {
		super();
	}
	
	public Appointment(LocalDateTime date, Pregnancy pregnancy, Patient patient, Doctor doctor, int bloodPressure, float weight,
			String report) {
		super();
		this.date = date;
		this.pregnancy = pregnancy;
		this.patient = patient;
		this.doctor = doctor;
		this.bloodPressure = bloodPressure;
		this.weight = weight;
		this.report = report;
	}
	
	public Appointment(LocalDateTime date, Pregnancy pregnancy, Patient patient) {
		super();
		this.date = date;
		this.pregnancy = pregnancy;
		this.patient = patient;
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
	
	public String getReport() {
		return report;
	}
	
	public void setReport(String report) {
		this.report = report;
	}
}
