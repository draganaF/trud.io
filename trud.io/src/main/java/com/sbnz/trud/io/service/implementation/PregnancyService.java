package com.sbnz.trud.io.service.implementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbnz.trud.io.model.Fact;
import com.sbnz.trud.io.model.Illness;
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
	public Pregnancy openKieSession(Pregnancy pregnancy) {
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(pregnancy);
		kieSession.getAgenda().getAgendaGroup("highRisk").setFocus();
		kieSession.fireAllRules();
		kieSession.dispose();
		return pregnancy;
	}
    
	@Override
	public Pregnancy create(Pregnancy pregnancy) {
		pregnancyRepository.save(openKieSession(pregnancy));
		return pregnancy;
	}
	
	public Pregnancy update(Pregnancy pregnancy) {
		pregnancyRepository.save(openKieSession(pregnancy));
		return pregnancy;
	}
	
	@Override
	public Pregnancy addSymptom(Integer id, ArrayList<String> symptoms) {
		Pregnancy pregnancy = pregnancyRepository.findById(id).orElse(null);
		Patient patient = pregnancy.getPatient();
		symptoms.forEach(symptom -> { if((!pregnancy.getSymptoms().contains(Symptom.valueOf(symptom)))) 
		{pregnancy.getSymptoms().add(Symptom.valueOf(symptom));} });
		
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(pregnancy);
		kieSession.insert(patient);
		kieSession.setGlobal("pregnancy", pregnancy);
		kieSession.getAgenda().getAgendaGroup("prematureLabor").setFocus();
		kieSession.getAgenda().getAgendaGroup("backward").setFocus();
		kieSession.fireAllRules();
		kieSession.dispose();
		patient.getTherapies().forEach(therapy -> therapyRepository.save(therapy));
		return pregnancyRepository.save(pregnancy);
		
		
	}
	
	@Override
	public void testBackward() {
		Pregnancy pregnancy = pregnancyRepository.findById(1).orElse(null);
		pregnancy.getSymptoms().add(Symptom.HIGH_BLOOD_PRESSURE);
		pregnancy.getSymptoms().add(Symptom.WEIGHT_GAIN);
		pregnancy.getSymptoms().add(Symptom.SWELLING);
		
		KieSession kieSession = kieContainer.newKieSession();
//		kieSession.insert(new Fact("Druga grupa simptoma", "Prva grupa simptoma"));
//		kieSession.insert(new Fact("Treca grupa simptoma", "Druga grupa simptoma"));
//		kieSession.insert(new Fact("Broj nedelje < 20", "Druga grupa simptoma"));
//		kieSession.insert(new Fact("Broj nedelje > 20", "Druga grupa simptoma"));
		kieSession.insert(new Fact("Preeklampsija", "Broj nedelje > 20"));
		kieSession.insert(new Fact("Eklampsija", "Treca grupa simptoma"));
		kieSession.insert(new Fact("Bolest bubrega", "Broj nedelje < 20"));
		kieSession.setGlobal("pregnancy", pregnancy);
		kieSession.getAgenda().getAgendaGroup("backward").setFocus();
		kieSession.fireAllRules();
		kieSession.dispose();
		
		pregnancyRepository.save(pregnancy);
	}

	@Override
	public List<Pregnancy> findActivePregnancies() {
		return pregnancyRepository.findActivePregnancies();
	}
	
	@Override
	public Pregnancy addSymptomsAndIllnesses(Integer pregnancyId, List<Symptom> symptoms, List<Illness> illnesses) {
		Pregnancy pregnancy = findById(pregnancyId);
		
		symptoms.forEach(symptom -> {
			if(!pregnancy.getSymptoms().contains(symptom)) {
				pregnancy.getSymptoms().add(symptom);
			}
		});
		
		illnesses.forEach(illness -> pregnancy.getIllnesses().add(illness));
		
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(pregnancy);
		kieSession.insert(pregnancy.getPatient());
		kieSession.setGlobal("pregnancy", pregnancy);
		kieSession.getAgenda().getAgendaGroup("prematureLabor").setFocus();
		kieSession.getAgenda().getAgendaGroup("highRisk").setFocus();
		kieSession.getAgenda().getAgendaGroup("backward").setFocus();
		kieSession.fireAllRules();
		kieSession.dispose();
		pregnancy.getPatient().getTherapies().forEach(therapy -> therapyRepository.save(therapy));
		
		return pregnancyRepository.save(pregnancy);
	}

	@Override
	public Pregnancy findCurrentPregnancyByPatientId(Integer id) {
		return pregnancyRepository.findCurrentPregnancyByPatientId(id);
	}
}
