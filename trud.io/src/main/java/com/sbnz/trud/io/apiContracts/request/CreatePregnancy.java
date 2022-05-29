package com.sbnz.trud.io.apiContracts.request;

import java.time.LocalDate;

public class CreatePregnancy {
	private LocalDate startDate;
	
	private int numberOfPregnancy;
	
	private String jmbg;
	
	public CreatePregnancy() {
		
	}

	public CreatePregnancy(LocalDate startDate, int numberOfPregnancy, String jmbg) {
		super();
		this.startDate = startDate;
		this.numberOfPregnancy = numberOfPregnancy;
		this.jmbg = jmbg;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
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
