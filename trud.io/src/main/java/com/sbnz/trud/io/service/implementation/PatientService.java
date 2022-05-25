package com.sbnz.trud.io.service.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbnz.trud.io.exeption.MissingEntityException;
import com.sbnz.trud.io.model.Patient;
import com.sbnz.trud.io.repository.PatientRepository;
import com.sbnz.trud.io.service.contracts.IPatientService;

@Service
public class PatientService extends GenericService<Patient> implements IPatientService {
    private PatientRepository patientRepository;
    
    @Autowired
    public PatientService(PatientRepository patientRepository) {
    	this.patientRepository = patientRepository;
    }

	@Override
	public Patient findByJmbg(String jmbg) {
		Patient patient = patientRepository.findByJmbg(jmbg);
		
		if(patient == null) {
			throw new MissingEntityException("The patient with given jmbg does not exist in the system.");
		}
		
		return patient;
	}
}
