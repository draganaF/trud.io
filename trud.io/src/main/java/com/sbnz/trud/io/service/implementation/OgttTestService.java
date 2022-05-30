package com.sbnz.trud.io.service.implementation;


import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbnz.trud.io.model.OgttTest;
import com.sbnz.trud.io.repository.OgttTestRepository;
import com.sbnz.trud.io.service.contracts.IOgttTestService;

@Service
public class OgttTestService extends GenericService<OgttTest> implements IOgttTestService {
    private OgttTestRepository ogttTestRepository;
    private final KieContainer kieContainer;
    
    @Autowired
    public OgttTestService(OgttTestRepository ogttTestRepository, KieContainer kieContainer) {
    	this.ogttTestRepository = ogttTestRepository;
    	this.kieContainer = kieContainer;
    }
    
    @Override
    public OgttTest create(OgttTest test) {
    	KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(test);
		kieSession.getAgenda().getAgendaGroup("ogtt").setFocus();
		kieSession.fireAllRules();
		kieSession.dispose();
    	
    	return ogttTestRepository.save(test);
    }
    
    public OgttTest update(OgttTest test) {
    	KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(test);
		kieSession.getAgenda().getAgendaGroup("ogtt").setFocus();
		kieSession.fireAllRules();
		kieSession.dispose();

    	return ogttTestRepository.save(test);
    }
}
