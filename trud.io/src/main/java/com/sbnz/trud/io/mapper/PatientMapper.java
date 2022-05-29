package com.sbnz.trud.io.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbnz.trud.io.apiContracts.request.CreatePatient;
import com.sbnz.trud.io.model.Patient;

@Component
public class PatientMapper {

	@Autowired
	public PatientMapper() {
		
	}
	
	public Patient createPatientToPatient(CreatePatient createPatient) {
		return new Patient(
				createPatient.getLastName(), 
				createPatient.getName(),
				createPatient.getPhoneNumber(),
				createPatient.getEmailAddress(),
				createPatient.getPassword(),
				createPatient.getHeight(),
				createPatient.getWeight(),
				createPatient.getDateOfBirth(),
				createPatient.getNumberOfMiscarriage(),
				createPatient.isAlcoholic(),
				createPatient.isAddict(),
				createPatient.isSmoker(),
				createPatient.isGeneticAnomalies(),
				createPatient.isProblemWithKidneys(),
				createPatient.isProblemHighBloodPressure(),
				createPatient.isDiabetic(),
				createPatient.getJmbg());
	}
}
