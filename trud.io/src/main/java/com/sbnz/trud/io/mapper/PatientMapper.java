package com.sbnz.trud.io.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbnz.trud.io.apiContracts.request.AddIllnessToPatient;
import com.sbnz.trud.io.apiContracts.request.CreatePatient;
import com.sbnz.trud.io.model.Illness;
import com.sbnz.trud.io.model.Patient;
import com.sbnz.trud.io.model.Role;
import com.sbnz.trud.io.service.contracts.IIllnessService;
import com.sbnz.trud.io.service.contracts.IPatientService;

@Component
public class PatientMapper {

	private IIllnessService illnessService;
	private IPatientService patientService;
	
	@Autowired
	public PatientMapper(IIllnessService illnessService, IPatientService patientService ) {
		this.illnessService = illnessService;
		this.patientService = patientService;
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
				createPatient.getJmbg(),
				Role.PATIENT);
	}
	
	//Ovde videti sta ce biti sad
	public Patient addIllnessToPatientToPatient(AddIllnessToPatient patientIllness) {
		Patient patient = patientService.findById(patientIllness.getUserId());
//		List<Illness> illnesses = patient.getIllnesses();
		
//		for(String illnessName : patientIllness.getIllnessNames()) {
//			illnesses.add(illnessService.findByName(illnessName));
//		}
		
//		patient.setIllnesses(illnesses);
		return patient;
	}
}
