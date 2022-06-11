package com.sbnz.trud.io.apiContracts.response;

import java.time.LocalDate;
import java.util.Collection;

import com.sbnz.trud.io.model.Illness;
import com.sbnz.trud.io.model.Symptom;
import com.sbnz.trud.io.model.Therapy;

public class ViewPregnancy {
	private Integer id;
	private LocalDate startDate;
	
	private Collection<Symptom> symptoms;
	
	private ViewPatient patient;
	
	private ViewDoubleTest doubleTest;
	
	private Integer week;
	
	private ViewTripleTest tripleTest;
	
	private ViewQuadripleTest quadripleTest;
	
	private ViewAmniocentesis amniocentesis;
	
	private Collection<Therapy> therapies;
	
	private Collection<Illness> illnesses;
	
	public ViewPregnancy() {}

	public ViewPregnancy(int id, LocalDate startDate, Collection<Symptom> symptoms, ViewPatient patient, ViewDoubleTest doubleTest, Integer week,
			ViewTripleTest tripleTest, ViewQuadripleTest quadripleTest, ViewAmniocentesis amniocentesis, Collection<Therapy> therapies,
			Collection<Illness> illnesses) {
		super();
		this.startDate = startDate;
		this.id = id;
		this.symptoms = symptoms;
		this.patient = patient;
		this.doubleTest = doubleTest;
		this.week = week;
		this.tripleTest = tripleTest;
		this.quadripleTest = quadripleTest;
		this.amniocentesis = amniocentesis;
		this.therapies = therapies;
		this.illnesses = illnesses;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Collection<Symptom> getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(Collection<Symptom> symptoms) {
		this.symptoms = symptoms;
	}

	public ViewPatient getPatient() {
		return patient;
	}

	public void setPatient(ViewPatient patient) {
		this.patient = patient;
	}

	public ViewDoubleTest getDoubleTest() {
		return doubleTest;
	}

	public void setDoubleTest(ViewDoubleTest doubleTest) {
		this.doubleTest = doubleTest;
	}

	public Integer getWeek() {
		return week;
	}

	public void setWeek(Integer week) {
		this.week = week;
	}

	public ViewTripleTest getTripleTest() {
		return tripleTest;
	}

	public void setTripleTest(ViewTripleTest tripleTest) {
		this.tripleTest = tripleTest;
	}

	public ViewQuadripleTest getQuadripleTest() {
		return quadripleTest;
	}

	public void setQuadripleTest(ViewQuadripleTest quadripleTest) {
		this.quadripleTest = quadripleTest;
	}

	public ViewAmniocentesis getAmniocentesis() {
		return amniocentesis;
	}

	public void setAmniocentesis(ViewAmniocentesis amniocentesis) {
		this.amniocentesis = amniocentesis;
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
}
