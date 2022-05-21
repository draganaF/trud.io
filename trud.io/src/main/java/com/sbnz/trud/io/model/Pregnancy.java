package com.sbnz.trud.io.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "pregnancy")
@SQLDelete(sql = "UPDATE pregnancy SET deleted = true WHERE id=? AND version = ?")
@Where(clause = "deleted=false")
public class Pregnancy {

	@Version
	@Column(name = "version", columnDefinition = "integer DEFAULT 0", nullable = false)
	private Long version;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	private Date startDate;
	
	private int numberOfPregnancies;
	
	private boolean highRiskPregnancy;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Appointment> appointments;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private DoubleTest doubleTest;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private TripleTest tripleTest;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private QuadripleTest quadripleTest;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Amniocentesis amniocentesis;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<CTG> ctg;
	
	public Pregnancy() {
		super();
	}

	public Pregnancy(Date startDate, int numberOfPregnancies, boolean highRiskPregnancy) {
		super();
		this.startDate = startDate;
		this.numberOfPregnancies = numberOfPregnancies;
		this.highRiskPregnancy = highRiskPregnancy;
	}

	
	public Pregnancy(Long version, Integer id, Date startDate, int numberOfPregnancies, boolean highRiskPregnancy,
			List<Appointment> appointments, DoubleTest doubleTest, TripleTest tripleTest, QuadripleTest quadripleTest,
			Amniocentesis amniocentesis, List<CTG> ctg) {
		super();
		this.version = version;
		this.id = id;
		this.startDate = startDate;
		this.numberOfPregnancies = numberOfPregnancies;
		this.highRiskPregnancy = highRiskPregnancy;
		this.appointments = appointments;
		this.doubleTest = doubleTest;
		this.tripleTest = tripleTest;
		this.quadripleTest = quadripleTest;
		this.amniocentesis = amniocentesis;
		this.ctg = ctg;
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
