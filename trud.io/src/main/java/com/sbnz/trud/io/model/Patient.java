package com.sbnz.trud.io.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "patient")
@PrimaryKeyJoinColumn(name = "users")
public class Patient extends User {

	private int height;
	
	private float weight;
	
	private LocalDateTime dateOfBirth;
	
	public Patient() {
		super();
	}
	
	public Patient(String lastName, String name, String phoneNumber, String emailAddress, String password, int height,
			float weight, LocalDateTime dateOfBirth) {
		super(lastName, name, phoneNumber, emailAddress, password);
		this.height = height;
		this.weight = weight;
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
	
	public LocalDateTime getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(LocalDateTime dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}
