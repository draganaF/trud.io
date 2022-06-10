package com.sbnz.trud.io.apiContracts.response;

import java.time.LocalDateTime;

public class ViewPatient {
	private String lastName;

	private String name;
	    
    private String emailAddress;
	    
	private String jmbg;
	
	private LocalDateTime dateOfBirth;
	
	private int height;
	
	private float weight;
	
	private boolean alcoholic;
	
	private boolean addict;
	
	private boolean smoker;
	
	private boolean geneticAnomalies;
	
	public ViewPatient() {}

	public ViewPatient(String lastName, String name, String emailAddress, String jmbg, LocalDateTime dateOfBirth,
			int height, float weight, boolean alcoholic, boolean addict, boolean smoker, boolean geneticAnomalies) {
		super();
		this.lastName = lastName;
		this.name = name;
		this.emailAddress = emailAddress;
		this.jmbg = jmbg;
		this.dateOfBirth = dateOfBirth;
		this.height = height;
		this.weight = weight;
		this.alcoholic = alcoholic;
		this.addict = addict;
		this.smoker = smoker;
		this.geneticAnomalies = geneticAnomalies;
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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public LocalDateTime getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDateTime dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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


	  
	  
}
