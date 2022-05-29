package com.sbnz.trud.io.service.implementation;

import java.util.ArrayList;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbnz.trud.io.model.Patient;
import com.sbnz.trud.io.model.Pregnancy;
import com.sbnz.trud.io.model.Symptom;
import com.sbnz.trud.io.repository.PregnancyRepository;
import com.sbnz.trud.io.repository.TherapyRepository;
import com.sbnz.trud.io.service.contracts.IPregnancyService;

@Service
public class PregnancyService extends GenericService<Pregnancy> implements IPregnancyService {
    private PregnancyRepository pregnancyRepository;
    private TherapyRepository therapyRepository;
    private final KieContainer kieContainer;
    
    @Autowired
    public PregnancyService(PregnancyRepository pregnancyRepository, TherapyRepository therapyRepository,
    		KieContainer kieContainer) {
    	this.pregnancyRepository = pregnancyRepository;
    	this.therapyRepository = therapyRepository;
    	this.kieContainer = kieContainer;
    }

	@Override
	public Pregnancy create(Pregnancy entity) {
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(entity);
		kieSession.fireAllRules();
		kieSession.dispose();

		pregnancyRepository.save(entity);
		
		return entity;
	}

	@Override
	public Pregnancy addSymptom(Integer id, ArrayList<Integer> symptoms) {
		Pregnancy pregnancy = pregnancyRepository.findById(id).orElse(null);
		Patient patient = pregnancy.getPatient();
		symptoms.forEach(symptom -> pregnancy.getSymptoms().add(Symptom.values()[symptom]));
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(pregnancy);
		kieSession.insert(patient);
		kieSession.getAgenda().getAgendaGroup("prematureLabor").setFocus();
		kieSession.fireAllRules();
		kieSession.dispose();
		patient.getTherapies().forEach(therapy -> therapyRepository.save(therapy));
		pregnancyRepository.save(pregnancy);
		
		return pregnancy;
		
	}
}
