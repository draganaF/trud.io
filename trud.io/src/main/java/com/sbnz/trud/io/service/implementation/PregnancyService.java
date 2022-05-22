package com.sbnz.trud.io.service.implementation;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbnz.trud.io.model.Patient;
import com.sbnz.trud.io.model.Pregnancy;
import com.sbnz.trud.io.repository.PatientRepository;
import com.sbnz.trud.io.repository.PregnancyRepository;
import com.sbnz.trud.io.service.contracts.IPregnancyService;

@Service
public class PregnancyService implements IPregnancyService {
    private PregnancyRepository pregnancyRepository;
    private PatientRepository patientRepository;
    private final KieContainer kieContainer;
    
    @Autowired
    public PregnancyService(PregnancyRepository pregnancyRepository,
    		PatientRepository patientRepository,
    		KieContainer kieContainer) {
    	this.pregnancyRepository = pregnancyRepository;
    	this.kieContainer = kieContainer;
    	this.patientRepository = patientRepository;
    }

	@Override
	public Pregnancy create(Pregnancy entity) {
		//Moramo da mu stavimo pacijenta da bi pravilo znalo kako da radi samo nesto pametnije nam treba, i opet baca error zbog nullxD
		//Tj nece da mi nadje patienta sa tim jmbg
		Patient p = patientRepository.findByJmbg("12345678912345");
		entity.setPatient(p);
		
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(entity);
		kieSession.fireAllRules();
		kieSession.dispose();
		
		pregnancyRepository.save(entity);
		
		return entity;
	}
}
