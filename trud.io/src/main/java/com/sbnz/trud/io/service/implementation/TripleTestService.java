package com.sbnz.trud.io.service.implementation;

import java.util.Collection;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbnz.trud.io.apiContracts.request.UpdateTripleTest;
import com.sbnz.trud.io.model.Amniocentesis;
import com.sbnz.trud.io.model.Pregnancy;
import com.sbnz.trud.io.model.TripleTest;
import com.sbnz.trud.io.repository.AgeRiskRepository;
import com.sbnz.trud.io.repository.AmniocentesisRepository;
import com.sbnz.trud.io.repository.PregnancyRepository;
import com.sbnz.trud.io.repository.TripleTestRepository;
import com.sbnz.trud.io.repository.WeeklyParametersRepository;
import com.sbnz.trud.io.service.contracts.ITripleTestService;

@Service
public class TripleTestService extends GenericService<TripleTest> implements ITripleTestService{
	 private TripleTestRepository tripleTestRepository;
	 private AmniocentesisRepository amniocentesisRepository;
	 private PregnancyRepository pregnancyRepository;
	 private AgeRiskRepository ageRiskRepository;
	 private WeeklyParametersRepository weeklyParametersRepository;
	 private final KieContainer kieContainer;
	
	@Autowired
	public TripleTestService(TripleTestRepository tripleTestRepository, 
			PregnancyRepository pregnancyRepository, AgeRiskRepository ageRiskRepository,
			WeeklyParametersRepository weeklyParametersRepository, KieContainer kieContainer, AmniocentesisRepository amniocentesisRepository) {
		this.tripleTestRepository = tripleTestRepository;
		this.pregnancyRepository = pregnancyRepository;
		this.ageRiskRepository = ageRiskRepository;
		this.weeklyParametersRepository = weeklyParametersRepository;
		this.kieContainer = kieContainer;
		this.amniocentesisRepository = amniocentesisRepository;
	}
	
	@Override
	public TripleTest create(TripleTest tripleTest) {
		return tripleTestRepository.save(tripleTest);
	}

	@Override
	public TripleTest addTripleTest(Integer pregnancyId, TripleTest tripleTest) {
		TripleTest createdTripleTest = create(tripleTest);
		Pregnancy pregnancy = pregnancyRepository.findById(pregnancyId).orElse(null);
		pregnancy.setTripleTest(createdTripleTest);
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(pregnancy);
		kieSession.insert(createdTripleTest);
		ageRiskRepository.findAll().forEach(age -> kieSession.insert(age));
		weeklyParametersRepository.findAll().forEach(week -> kieSession.insert(week));
		kieSession.getAgenda().getAgendaGroup("tripleTest").setFocus();
		kieSession.getAgenda().getAgendaGroup("highRisk").setFocus();
		kieSession.fireAllRules();
		kieSession.dispose();
		Collection<Object> ruleOutputObjects = (Collection<Object>) kieSession.getObjects();
		for(Object o : ruleOutputObjects) {
			if( o instanceof Amniocentesis) {
				Amniocentesis amniocentesis = amniocentesisRepository.save((Amniocentesis)o);
				pregnancy.setAmniocentesis(amniocentesis);
			}
		}
		
		
		return tripleTestRepository.save(createdTripleTest);
	}

	@Override
	public TripleTest update(Integer pregnancyId, UpdateTripleTest updateTripleTest) {
		TripleTest tripleTest = tripleTestRepository.findById(updateTripleTest.getId()).orElse(null);
		tripleTest.setAfp(updateTripleTest.getAfp());
		tripleTest.setHcg(updateTripleTest.getHcg());
		tripleTest.setUe3(updateTripleTest.getUe3());
		tripleTest.setResult("Not yet processed");
		
		Pregnancy pregnancy = pregnancyRepository.findById(pregnancyId).orElse(null);
		pregnancy.setTripleTest(tripleTest);
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(pregnancy);
		kieSession.insert(tripleTest);
		ageRiskRepository.findAll().forEach(age -> kieSession.insert(age));
		weeklyParametersRepository.findAll().forEach(week -> kieSession.insert(week));
		kieSession.getAgenda().getAgendaGroup("tripleTest").setFocus();
		kieSession.getAgenda().getAgendaGroup("highRisk").setFocus();
		kieSession.fireAllRules();
		kieSession.dispose();
		Collection<Object> ruleOutputObjects = (Collection<Object>) kieSession.getObjects();
		for(Object o : ruleOutputObjects) {
			if( o instanceof Amniocentesis) {
				Amniocentesis amniocentesis = amniocentesisRepository.save((Amniocentesis)o);
				pregnancy.setAmniocentesis(amniocentesis);
			}
		}
		
		
		return tripleTestRepository.save(tripleTest);
		
		
	}

}
