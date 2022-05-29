package com.sbnz.trud.io.service.implementation;


import org.kie.api.runtime.KieContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbnz.trud.io.exeption.MissingEntityException;
import com.sbnz.trud.io.model.Patient;
import com.sbnz.trud.io.repository.PatientRepository;
import com.sbnz.trud.io.service.contracts.IPatientService;

@Service
public class PatientService extends GenericService<Patient> implements IPatientService {
    private PatientRepository patientRepository;
    private final KieContainer kieContainer;
    
    
    @Autowired
    public PatientService(
    		PatientRepository patientRepository,
    		KieContainer kieContainer) {
    	this.patientRepository = patientRepository;
    	this.kieContainer = kieContainer;
    }

	@Override
	public Patient findByJmbg(String jmbg) {
		Patient patient = patientRepository.findByJmbg(jmbg);
		
		if(patient == null) {
			throw new MissingEntityException("The patient with given jmbg does not exist in the system.");
		}
		
		return patient;
	}
	
	@Override
	public Patient create(Patient patient) {
		return patientRepository.save(patient);	
	}
	
	public Patient update(Patient patient) {
		return patientRepository.save(patient);
	}
}
