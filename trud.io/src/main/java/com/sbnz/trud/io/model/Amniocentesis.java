package com.sbnz.trud.io.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "amniocentesis")
@SQLDelete(sql = "UPDATE amniocentesis SET deleted = true WHERE id=? AND version = ?")
@Where(clause = "deleted=false")
public class Amniocentesis {

	@Version
	@Column(name = "version", columnDefinition = "integer DEFAULT 0", nullable = false)
	private Long version;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	    
	private int afp;
	
	private String result;
	
	
	public Amniocentesis() {
		super();
	}

	public Amniocentesis(int afp, String result) {
		this.afp = afp;
		this.result = result;
	}

	public int getAfp() {
		return afp;
	}

	public void setAfp(int afp) {
		this.afp = afp;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
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
