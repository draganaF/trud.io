package com.sbnz.trud.io.model;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.*;


@Entity
@Table(name = "users")
@Inheritance(strategy=InheritanceType.JOINED)
@SQLDelete(sql = "UPDATE users SET deleted = true WHERE id=? AND version = ?")
@Where(clause = "deleted=false")
public abstract class User extends BaseEntity {
    private String lastName;

    private String name;

    private String phoneNumber;

    @Column(unique = true, nullable = false)
    private String emailAddress;

    private String password;
    
    private Role role;

    public User(String lastName, String name, String phoneNumber, String emailAddress, String password, Role role) {
        this.lastName = lastName;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.password = password;
        this.role = role;
    }

    public User() {

    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return emailAddress;
    }

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
