package com.sbnz.trud.io.apiContracts.request;

import java.util.Date;


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
