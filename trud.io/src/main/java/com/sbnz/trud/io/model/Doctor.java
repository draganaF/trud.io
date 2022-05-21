package com.sbnz.trud.io.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "doctor")
@PrimaryKeyJoinColumn(name = "users")
public class Doctor extends User{

	public Doctor() {
		super();
	}

	public Doctor(String lastName, String name, String phoneNumber, String emailAddress, String password) {
		super(lastName, name, phoneNumber, emailAddress, password);
	}	
}
