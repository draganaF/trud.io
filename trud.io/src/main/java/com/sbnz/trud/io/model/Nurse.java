package com.sbnz.trud.io.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "nurse")
@PrimaryKeyJoinColumn(name = "users")
public class Nurse extends User {

	public Nurse() {
		super();
	}

	public Nurse(String lastName, String name, String phoneNumber, String emailAddress, String password, Role role) {
		super(lastName, name, phoneNumber, emailAddress, password, role);
	}
}
