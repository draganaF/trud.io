package com.sbnz.trud.io.apiContracts.request;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CreatePregnancy {
	private LocalDate startDate;
	
	private int numberOfPregnancy;
	
	private String jmbg;
	
	private LocalDateTime dataOfFirstAppointment;
	
	public CreatePregnancy() {
		
	}

	public CreatePregnancy(LocalDate startDate, int numberOfPregnancy, String jmbg, LocalDateTime dataOfFirstAppointment) {
		super();
		this.startDate = startDate;
		this.numberOfPregnancy = numberOfPregnancy;
		this.jmbg = jmbg;
		this.dataOfFirstAppointment = dataOfFirstAppointment;
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

	public LocalDateTime getDataOfFirstAppointment() {
		return dataOfFirstAppointment;
	}

	public void setDataOfFirstAppointment(LocalDateTime dataOfFirstAppointment) {
		this.dataOfFirstAppointment = dataOfFirstAppointment;
	}
}
