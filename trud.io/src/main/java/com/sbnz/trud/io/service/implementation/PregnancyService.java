package com.sbnz.trud.io.service.implementation;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbnz.trud.io.model.Pregnancy;
import com.sbnz.trud.io.repository.PregnancyRepository;
import com.sbnz.trud.io.service.contracts.IPregnancyService;

@Service
public class PregnancyService implements IPregnancyService {
    private PregnancyRepository pregnancyRepository;
    private final KieContainer kieContainer;
    
    @Autowired
    public PregnancyService(PregnancyRepository pregnancyRepository,
    		KieContainer kieContainer) {
    	this.pregnancyRepository = pregnancyRepository;
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
}
