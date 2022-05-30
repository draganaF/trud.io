package com.sbnz.trud.io.apiContracts.response;

import java.time.LocalDate;
import java.util.Collection;
import com.sbnz.trud.io.model.Symptom;

public class UpdatePregnancy {
	private LocalDate startDate;
	
	private int numberOfPregnancies;
	
	private boolean highRiskPregnancy;
	
	
	private boolean prematureLabor;
	
	private Collection<Symptom> symptoms;
	
	public UpdatePregnancy() {}

	public UpdatePregnancy(LocalDate startDate, int numberOfPregnancies, boolean highRiskPregnancy, boolean prematureLabor,
			Collection<Symptom> symptoms) {
		super();
		this.startDate = startDate;
		this.numberOfPregnancies = numberOfPregnancies;
		this.highRiskPregnancy = highRiskPregnancy;
		this.prematureLabor = prematureLabor;
		this.symptoms = symptoms;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public int getNumberOfPregnancies() {
		return numberOfPregnancies;
	}

	public void setNumberOfPregnancies(int numberOfPregnancies) {
		this.numberOfPregnancies = numberOfPregnancies;
	}

	public boolean isHighRiskPregnancy() {
		return highRiskPregnancy;
	}

	public void setHighRiskPregnancy(boolean highRiskPregnancy) {
		this.highRiskPregnancy = highRiskPregnancy;
	}

	public boolean isPrematureLabor() {
		return prematureLabor;
	}

	public void setPrematureLabor(boolean prematureLabor) {
		this.prematureLabor = prematureLabor;
	}

	public Collection<Symptom> getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(Collection<Symptom> symptoms) {
		this.symptoms = symptoms;
	}
	
	
	
	

}
