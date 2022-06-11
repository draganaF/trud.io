package com.sbnz.trud.io.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	
	private int bloodPressureUpper;
	
	private int bloodPressureLower;
	
	private float weight;
	
	private String report;
	
	private boolean deleted = false;
	
	private boolean isDone = false;
	
	@ElementCollection(targetClass = Symptom.class)
	@JoinTable(name = "appointmentSymptoms", joinColumns = @JoinColumn(name = "id"))
	@Column(name = "addedSymptom", nullable = false, unique = true)
	@Enumerated(EnumType.STRING)
	private List<Symptom> symptoms;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name = "appointmentIllnesses", joinColumns = @JoinColumn(name = "appointment_id"), inverseJoinColumns = @JoinColumn(name = "illness_id"))
	private List<Illness> illnesses;
	
	public Appointment() {
		super();
	}
	
	public Appointment(LocalDateTime date, Pregnancy pregnancy, Patient patient, Doctor doctor, int bloodPressure, float weight,
			String report, int bloodPressureLower) {
		super();
		this.date = date;
		this.pregnancy = pregnancy;
		this.patient = patient;
		this.doctor = doctor;
		this.bloodPressureUpper = bloodPressure;
		this.weight = weight;
		this.report = report;
		this.bloodPressureLower = bloodPressureLower;
	}
	
	public Appointment(LocalDateTime date, Pregnancy pregnancy, Patient patient) {
		super();
		this.date = date;
		this.pregnancy = pregnancy;
		this.patient = patient;
	}
	
	public Appointment(Pregnancy pregnancy) {
		super();
		this.pregnancy = pregnancy;
	}
	
	public Appointment(Integer bloodPressureLower, Integer bloodPressureUpper, float weight, String report, List<Symptom> symptoms, List<Illness> illnessesNames) {
		this.bloodPressureLower = bloodPressureLower;
		this.bloodPressureUpper = bloodPressureUpper;
		this.weight = weight;
		this.report = report;
		this.symptoms = symptoms;
		this.illnesses = illnessesNames;
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

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	public int getBloodPressureUpper() {
		return bloodPressureUpper;
	}

	public void setBloodPressureUpper(int bloodPressureUpper) {
		this.bloodPressureUpper = bloodPressureUpper;
	}

	public int getBloodPressureLower() {
		return bloodPressureLower;
	}

	public void setBloodPressureLower(int bloodPressureLower) {
		this.bloodPressureLower = bloodPressureLower;
	}

	public List<Symptom> getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(List<Symptom> symptoms) {
		this.symptoms = symptoms;
	}

	public List<Illness> getIllnessesNames() {
		return illnesses;
	}

	public void setIllnessesNames(List<Illness> illnessesNames) {
		this.illnesses = illnessesNames;
	}
}
