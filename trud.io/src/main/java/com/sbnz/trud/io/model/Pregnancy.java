package com.sbnz.trud.io.model;

import java.time.LocalDate;

import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "pregnancy")
@SQLDelete(sql = "UPDATE pregnancy SET deleted = true WHERE id=? AND version = ?")
@Where(clause = "deleted=false")
public class Pregnancy extends BaseEntity{
	private LocalDate startDate;
	
	private int numberOfPregnancies;
	
	private boolean highRiskPregnancy;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Appointment> appointments;
	
	@OneToOne(fetch = FetchType.LAZY)
	private DoubleTest doubleTest;
	
	@OneToOne(fetch = FetchType.LAZY)
	private TripleTest tripleTest;
	
	@OneToOne(fetch = FetchType.LAZY)
	private QuadripleTest quadripleTest;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Amniocentesis amniocentesis;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<CTG> ctg;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Patient patient;
	
	private boolean prematureLabor;
	
	@ElementCollection(targetClass = Symptom.class)
	@JoinTable(name = "pregnancySymptoms", joinColumns = @JoinColumn(name = "id"))
	@Column(name = "symptom", nullable = false, unique = true)
	@Enumerated(EnumType.STRING)
	private Collection<Symptom> symptoms;

	@OneToOne(fetch = FetchType.LAZY)
	private Birth birth;

	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private List<OgttTest> ogttTests;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<DailyGlucoseLevel> glucoseLevels;
	
	public Pregnancy() {
		super();
	}

	public Pregnancy(LocalDate startDate, int numberOfPregnancies, boolean highRiskPregnancy) {
		super();
		this.startDate = startDate;
		this.numberOfPregnancies = numberOfPregnancies;
		this.highRiskPregnancy = highRiskPregnancy;
	}
	
	public Pregnancy(LocalDate startDate, int numberOfPregnancy, Patient patient) {
		super();
		this.startDate = startDate;
		this.numberOfPregnancies = numberOfPregnancy;
		this.patient = patient;
	}

	public Pregnancy(LocalDate startDate, int numberOfPregnancies, boolean highRiskPregnancy, List<Appointment> appointments,
			DoubleTest doubleTest, TripleTest tripleTest, QuadripleTest quadripleTest, Amniocentesis amniocentesis,
			List<CTG> ctg, Patient patient, Birth birth) {
		super();
		this.startDate = startDate;
		this.numberOfPregnancies = numberOfPregnancies;
		this.highRiskPregnancy = highRiskPregnancy;
		this.appointments = appointments;
		this.doubleTest = doubleTest;
		this.tripleTest = tripleTest;
		this.quadripleTest = quadripleTest;
		this.amniocentesis = amniocentesis;
		this.ctg = ctg;
		this.patient = patient;
		this.birth = birth;
	}

	public Pregnancy(Long version, Integer id, LocalDate startDate, int numberOfPregnancies, boolean highRiskPregnancy,
			List<Appointment> appointments, DoubleTest doubleTest, TripleTest tripleTest, QuadripleTest quadripleTest,
			Amniocentesis amniocentesis, List<CTG> ctg, Patient patient) {
		super();
		this.startDate = startDate;
		this.numberOfPregnancies = numberOfPregnancies;
		this.highRiskPregnancy = highRiskPregnancy;
		this.appointments = appointments;
		this.doubleTest = doubleTest;
		this.tripleTest = tripleTest;
		this.quadripleTest = quadripleTest;
		this.amniocentesis = amniocentesis;
		this.ctg = ctg;
		this.patient = patient;
	}

	public Pregnancy(LocalDate startDate, int numberOfPregnancies, boolean highRiskPregnancy,
			List<Appointment> appointments, DoubleTest doubleTest, TripleTest tripleTest, QuadripleTest quadripleTest,
			Amniocentesis amniocentesis, List<CTG> ctg, Patient patient, boolean prematureLabor,
			Collection<Symptom> symptoms, Birth birth, List<OgttTest> ogttTests,
			List<DailyGlucoseLevel> glucoseLevels) {
		super();
		this.startDate = startDate;
		this.numberOfPregnancies = numberOfPregnancies;
		this.highRiskPregnancy = highRiskPregnancy;
		this.appointments = appointments;
		this.doubleTest = doubleTest;
		this.tripleTest = tripleTest;
		this.quadripleTest = quadripleTest;
		this.amniocentesis = amniocentesis;
		this.ctg = ctg;
		this.patient = patient;
		this.prematureLabor = prematureLabor;
		this.symptoms = symptoms;
		this.birth = birth;
		this.ogttTests = ogttTests;
		this.glucoseLevels = glucoseLevels;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public int getNumberOfPregnancies() {
		return numberOfPregnancies;
	}

	public void setNumberOfPregnancies(int numberOfPregnancies) {
		this.numberOfPregnancies = numberOfPregnancies;
	}

	public boolean isHighRiskPregnancy() {
		return highRiskPregnancy;
	}

	public void setHighRiskPregnancy(boolean highRiskPregnancy) {
		this.highRiskPregnancy = highRiskPregnancy;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	
	public DoubleTest getDoubleTest() {
		return doubleTest;
	}

	public void setDoubleTest(DoubleTest doubleTest) {
		this.doubleTest = doubleTest;
	}

	public TripleTest getTripleTest() {
		return tripleTest;
	}

	public void setTripleTest(TripleTest tripleTest) {
		this.tripleTest = tripleTest;
	}

	public QuadripleTest getQuadripleTest() {
		return quadripleTest;
	}

	public void setQuadripleTest(QuadripleTest quadripleTest) {
		this.quadripleTest = quadripleTest;
	}

	public Amniocentesis getAmniocentesis() {
		return amniocentesis;
	}

	public void setAmniocentesis(Amniocentesis amniocentesis) {
		this.amniocentesis = amniocentesis;
	}

	public List<CTG> getCtg() {
		return ctg;
	}

	public void setCtg(List<CTG> ctg) {
		this.ctg = ctg;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}


	public boolean isPrematureLabor() {
		return prematureLabor;
	}

	public void setPrematureLabor(boolean prematureLabor) {
		this.prematureLabor = prematureLabor;
	}

	public Collection<Symptom> getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(Collection<Symptom> symptoms) {
		this.symptoms = symptoms;
	}
	
	
	public Birth getBirth() {
		return birth;
	}

	public void setBirth(Birth birth) {
		this.birth = birth;
	}

	public List<OgttTest> getOgttTests() {
		return ogttTests;
	}

	public void setOgttTests(List<OgttTest> ogttTests) {
		this.ogttTests = ogttTests;
	}

	public List<DailyGlucoseLevel> getGlucoseLevels() {
		return glucoseLevels;
	}

	public void setGlucoseLevels(List<DailyGlucoseLevel> glucoseLevels) {
		this.glucoseLevels = glucoseLevels;
	}
}
