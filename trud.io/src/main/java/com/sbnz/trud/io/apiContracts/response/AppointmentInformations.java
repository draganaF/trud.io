package com.sbnz.trud.io.apiContracts.response;

import java.time.LocalDateTime;

public class AppointmentInformations {
	private LocalDateTime date;
	
	private Integer id;
	
	private String patientJmbg;
	
	private String patientName;
	
	private String patientLastName;
	
	private Integer pregnancyId;

	public AppointmentInformations(LocalDateTime date, Integer id, String patientJmbg, String patientName, String patientLastName, Integer pregnancyId) {
		super();
		this.date = date;
		this.id = id;
		this.patientJmbg = patientJmbg;
		this.patientName = patientName;
		this.patientLastName = patientLastName;
		this.pregnancyId = pregnancyId;
	}
	
	public AppointmentInformations() {
		super();
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPatientJmbg() {
		return patientJmbg;
	}

	public void setPatientJmbg(String patientJmbg) {
		this.patientJmbg = patientJmbg;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientLastName() {
		return patientLastName;
	}

	public void setPatientLastName(String patientLastName) {
		this.patientLastName = patientLastName;
	}

	public Integer getPregnancyId() {
		return pregnancyId;
	}

	public void setPregnancyId(Integer pregnancyId) {
		this.pregnancyId = pregnancyId;
	}
}
