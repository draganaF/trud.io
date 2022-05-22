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
@Table(name = "ctg")
@SQLDelete(sql = "UPDATE ctg SET deleted = true WHERE id=? AND version = ?")
@Where(clause = "deleted=false")
public class CTG {

	@Version
	@Column(name = "version", columnDefinition = "integer DEFAULT 0", nullable = false)
	private Long version;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	    
	private String result;
	
	private String description;
	
	private boolean deleted = false;
	
	public CTG() {
		super();
	}
	
	public CTG(String result, String description) {
		super();
		this.result = result;
		this.description = description;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
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

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
}
