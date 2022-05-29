package com.sbnz.trud.io.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "patient")
@PrimaryKeyJoinColumn(name = "users")
public class Patient extends User{

	private int height;
	
	private float weight;
	
	private LocalDateTime dateOfBirth;
	
	private int numberOfMiscarriage;
	
	private boolean alcoholic;
	
	private boolean addict;
	
	private boolean smoker;
	
	private boolean geneticAnomalies;
	
	private boolean problemWithKidneys;
	
	private boolean problemHighBloodPressure;
	
	private boolean diabetic;
	
	@Column(unique = true)
	private String jmbg;
	
	public Patient() {
		super();
	}
	
	
	public Patient(String lastName, String name, String phoneNumber, String emailAddress, String password, int height,
			float weight, LocalDateTime dateOfBirth, int numberOfMiscarriage, boolean alcoholic, boolean addict,
			boolean smoker, boolean geneticAnomalies, boolean problemWithKidneys, boolean problemHighBloodPressure,
			boolean diabetic, String jmbg) {
		super(lastName, name, phoneNumber, emailAddress, password);
		this.height = height;
		this.weight = weight;
		this.dateOfBirth = dateOfBirth;
		this.numberOfMiscarriage = numberOfMiscarriage;
		this.alcoholic = alcoholic;
		this.addict = addict;
		this.smoker = smoker;
		this.geneticAnomalies = geneticAnomalies;
		this.problemWithKidneys = problemWithKidneys;
		this.problemHighBloodPressure = problemHighBloodPressure;
		this.diabetic = diabetic;
		this.jmbg = jmbg;
	}


	public Patient(String lastName, String name, String phoneNumber, String emailAddress, String password, int height,
			float weight, LocalDateTime dateOfBirth, int numberOfMiscarriage, String jmbg) {
		super(lastName, name, phoneNumber, emailAddress, password);
		this.height = height;
		this.weight = weight;
		this.dateOfBirth = dateOfBirth;
		this.numberOfMiscarriage = numberOfMiscarriage;
		this.jmbg = jmbg;
	}
	
	public int getHeight() {
		return height;
	} 
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public float getWeight() {
		return weight;
	}
	
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	public LocalDateTime getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(LocalDateTime dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getNumberOfMiscarriage() {
		return numberOfMiscarriage;
	}

	public void setNumberOfMiscarriage(int numberOfMiscarriage) {
		this.numberOfMiscarriage = numberOfMiscarriage;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public boolean isAlcoholic() {
		return alcoholic;
	}

	public void setAlcoholic(boolean alcoholic) {
		this.alcoholic = alcoholic;
	}

	public boolean isAddict() {
		return addict;
	}

	public void setAddict(boolean addict) {
		this.addict = addict;
	}

	public boolean isSmoker() {
		return smoker;
	}

	public void setSmoker(boolean smoker) {
		this.smoker = smoker;
	}

	public boolean isGeneticAnomalies() {
		return geneticAnomalies;
	}

	public void setGeneticAnomalies(boolean geneticAnomalies) {
		this.geneticAnomalies = geneticAnomalies;
	}

	public boolean isProblemWithKidneys() {
		return problemWithKidneys;
	}

	public void setProblemWithKidneys(boolean problemWithKidneys) {
		this.problemWithKidneys = problemWithKidneys;
	}

	public boolean isProblemHighBloodPressure() {
		return problemHighBloodPressure;
	}

	public void setProblemHighBloodPressure(boolean problemHighBloodPressure) {
		this.problemHighBloodPressure = problemHighBloodPressure;
	}

	public boolean isDiabetic() {
		return diabetic;
	}

	public void setDiabetic(boolean diabetic) {
		this.diabetic = diabetic;
	}
}
