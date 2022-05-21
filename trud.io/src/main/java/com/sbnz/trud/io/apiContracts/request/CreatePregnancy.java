package com.sbnz.trud.io.apiContracts.request;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

public class CreatePregnancy {
	private Date startDate;
	
	private int numberOfPregnancy;
	
	private String jmbg;
	
	public CreatePregnancy() {
		
	}

	public CreatePregnancy(Date startDate, int numberOfPregnancy, String jmbg) {
		super();
		this.startDate = startDate;
		this.numberOfPregnancy = numberOfPregnancy;
		this.jmbg = jmbg;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public int getNumberOfPregnancy() {
		return numberOfPregnancy;
	}

	public void setNumberOfPregnancy(int numberOfPregnancy) {
		this.numberOfPregnancy = numberOfPregnancy;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
}
