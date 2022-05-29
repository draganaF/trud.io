package com.sbnz.trud.io.service.implementation;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbnz.trud.io.model.Pregnancy;
import com.sbnz.trud.io.repository.PregnancyRepository;
import com.sbnz.trud.io.service.contracts.IPregnancyService;

@Service
public class PregnancyService extends GenericService<Pregnancy> implements IPregnancyService {
    private PregnancyRepository pregnancyRepository;
    private final KieContainer kieContainer;
    
    @Autowired
    public PregnancyService(PregnancyRepository pregnancyRepository,
    		KieContainer kieContainer) {
    	this.pregnancyRepository = pregnancyRepository;
    	this.kieContainer = kieContainer;
    }

    @Override
	public Pregnancy openKieSession(Pregnancy pregnancy) {
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(pregnancy);
		
		kieSession.getAgenda().getAgendaGroup("highRisk").setFocus();
		kieSession.fireAllRules();
		kieSession.dispose();
		System.out.println("=============================================");
		System.out.println(pregnancy.isHighRiskPregnancy());
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
}
