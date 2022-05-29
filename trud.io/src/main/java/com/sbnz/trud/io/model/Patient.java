package com.sbnz.trud.io.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
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
	
	@Column(unique = true)
	private String jmbg;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Therapy> therapies;
	
	public Patient() {
		super();
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

	public List<Therapy> getTherapies() {
		return therapies;
	}

	public void setTherapies(List<Therapy> therapies) {
		this.therapies = therapies;
	}
	
}
