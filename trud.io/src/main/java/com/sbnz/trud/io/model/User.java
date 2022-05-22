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
public abstract class User {
    @Version
    @Column(name = "version", columnDefinition = "integer DEFAULT 0", nullable = false)
    private Long version;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    private String lastName;

    private String name;

    private String phoneNumber;

    @Column(unique = true, nullable = false)
    private String emailAddress;

    private String password;

    private boolean deleted = false;


    public User(String lastName, String name, String phoneNumber, String emailAddress, String password) {
        this.lastName = lastName;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public User() {

    }

    public Long getVersion() {
        return version;
    }

    public Integer getId() {
        return id;
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

    public void setVersion(Long version) {
        this.version = version;
    }

    public void setId(Integer id) {
        this.id = id;
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

	public boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}



}
