package com.sbnz.trud.io.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "pregnancy")
@SQLDelete(sql = "UPDATE pregnancy SET deleted = true WHERE id=? AND version = ?")
@Where(clause = "deleted=false")
public class Pregnancy extends BaseEntity{
	private Date startDate;
	
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
	
	
	public Pregnancy() {
		super();
	}

	public Pregnancy(Date startDate, int numberOfPregnancies, boolean highRiskPregnancy) {
		super();
		this.startDate = startDate;
		this.numberOfPregnancies = numberOfPregnancies;
		this.highRiskPregnancy = highRiskPregnancy;
	}
	
	public Pregnancy(Date startDate, int numberOfPregnancy, Patient patient) {
		super();
		this.startDate = startDate;
		this.numberOfPregnancies = numberOfPregnancy;
		this.patient = patient;
	}

	
	public Pregnancy(Long version, Integer id, Date startDate, int numberOfPregnancies, boolean highRiskPregnancy,
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
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
}
