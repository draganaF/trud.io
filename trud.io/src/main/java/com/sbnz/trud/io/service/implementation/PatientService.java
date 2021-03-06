package com.sbnz.trud.io.service.implementation;


import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbnz.trud.io.exeption.MissingEntityException;
import com.sbnz.trud.io.model.Birth;
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
			throw new MissingEntityException("Pacijet sa unesenim jmbg-om ne postoji u sistemu.");
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
	
	public Patient checkAndUpdateMiscarriage(Patient patient, Birth birth) {
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(patient);
		kieSession.insert(birth);
		kieSession.getAgenda().getAgendaGroup("miscarriage").setFocus();
		kieSession.fireAllRules();
		kieSession.dispose();
		
		return this.update(patient);
	}
	
	@Override
	public Patient findById(Integer id) {
		return patientRepository.findById(id).orElse(null);	
	}
	@Override
	public List<Patient> findAll() {
		return patientRepository.findAll();
	}
}
