package com.sbnz.trud.io.apiContracts.response;

import java.time.LocalDateTime;
import java.util.Collection;

import com.sbnz.trud.io.model.Illness;
import com.sbnz.trud.io.model.Therapy;

public class AppointmentInformations {
	private LocalDateTime date;
	
	private Integer id;
	
	private String patientJmbg;
	
	private String patientName;
	
	private String patientLastName;
	
	private Integer pregnancyId;
	
	private Collection<Therapy> therapies;
	
	private Collection<Illness> illnesses;
	
	private boolean isHihgRiskPregnancy;
	
	private boolean isPermatureLabor;

	public AppointmentInformations(LocalDateTime date, Integer id, String patientJmbg, String patientName, String patientLastName, Integer pregnancyId,
			Collection<Therapy> therapies, Collection<Illness> illnesses, boolean isHihgRiskPregnancy, boolean isPermatureLabor) {
		super();
		this.date = date;
		this.id = id;
		this.patientJmbg = patientJmbg;
		this.patientName = patientName;
		this.patientLastName = patientLastName;
		this.pregnancyId = pregnancyId;
		this.therapies = therapies;
		this.illnesses = illnesses;
		this.isHihgRiskPregnancy = isHihgRiskPregnancy;
		this.isPermatureLabor = isPermatureLabor;
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

	public Collection<Therapy> getTherapies() {
		return therapies;
	}

	public void setTherapies(Collection<Therapy> therapies) {
		this.therapies = therapies;
	}

	public Collection<Illness> getIllnesses() {
		return illnesses;
	}

	public void setIllnesses(Collection<Illness> illnesses) {
		this.illnesses = illnesses;
	}

	public boolean isHihgRiskPregnancy() {
		return isHihgRiskPregnancy;
	}

	public void setHihgRiskPregnancy(boolean isHihgRiskPregnancy) {
		this.isHihgRiskPregnancy = isHihgRiskPregnancy;
	}

	public boolean isPermatureLabor() {
		return isPermatureLabor;
	}

	public void setPermatureLabor(boolean isPermatureLabor) {
		this.isPermatureLabor = isPermatureLabor;
	}
}
