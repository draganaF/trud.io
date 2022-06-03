package com.sbnz.trud.io.service.implementation;



import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbnz.trud.io.model.OgttTest;
import com.sbnz.trud.io.repository.OgttTestRepository;

import com.sbnz.trud.io.model.Birth;
import com.sbnz.trud.io.model.Pregnancy;
import com.sbnz.trud.io.repository.BirthRepository;
import com.sbnz.trud.io.repository.PregnancyRepository;

import com.sbnz.trud.io.service.contracts.IOgttTestService;

@Service
public class OgttTestService extends GenericService<OgttTest> implements IOgttTestService {
    private OgttTestRepository ogttTestRepository;
    private KieContainer kieContainer;
    private PregnancyRepository pregnancyRepository;
    private BirthRepository birthRepository;
    
    @Autowired
    public OgttTestService(OgttTestRepository ogttTestRepository,
    		KieContainer kieContainer, 
    		PregnancyRepository pregnancyRepository,
    		BirthRepository birthRepository) {
    	this.ogttTestRepository = ogttTestRepository;
    	this.kieContainer = kieContainer;
    	this.pregnancyRepository = pregnancyRepository;
    	this.birthRepository = birthRepository;
    }
    
    public OgttTest update(OgttTest test) {
    	KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(test);
		kieSession.getAgenda().getAgendaGroup("ogtt").setFocus();
		kieSession.fireAllRules();
		kieSession.dispose();

    	return ogttTestRepository.save(test);

    }
    
    @Override
    public OgttTest create(OgttTest entity) throws Exception {
    	KieSession kieSession = kieContainer.newKieSession();
    	List<Pregnancy> pregnancies = pregnancyRepository.findAll();
    	pregnancies.forEach(pregnancy -> kieSession.insert(pregnancy));
    	
    	List<Birth> births = birthRepository.findAll();
    	births.forEach(birth -> kieSession.insert(birth));
    	
    	List<OgttTest> ogttTests = ogttTestRepository.findAll();
    	ogttTests.forEach(ogttTest -> kieSession.insert(ogttTest));
    	
		kieSession.getAgenda().getAgendaGroup("ogttTest").setFocus();
		kieSession.fireAllRules();
		kieSession.dispose();
		
		pregnancies.forEach(pregnancy -> pregnancyRepository.save(pregnancy));
		
		return entity;
    }
}
