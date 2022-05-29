package com.sbnz.trud.io.apiContracts.request;

import java.time.LocalDateTime;

public class CreatePatient {
	private String lastName;

    private String name;

    private String phoneNumber;

	private String jmbg;
	
    private String emailAddress;

    private String password;
	
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
	

	
	public CreatePatient() {
		super();
	}

	public CreatePatient(String lastName, String name, String phoneNumber, String emailAddress, String password,
			int height, float weight, LocalDateTime dateOfBirth, int numberOfMiscarriage, boolean alcoholic,
			boolean addict, boolean smoker, boolean geneticAnomalies, boolean problemWithKidneys,
			boolean problemHighBloodPressure, boolean diabetic, String jmbg) {
		super();
		this.lastName = lastName;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.password = password;
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
}
