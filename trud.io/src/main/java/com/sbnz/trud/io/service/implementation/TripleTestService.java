package com.sbnz.trud.io.service.implementation;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbnz.trud.io.model.Pregnancy;
import com.sbnz.trud.io.model.TripleTest;
import com.sbnz.trud.io.repository.AgeRiskRepository;
import com.sbnz.trud.io.repository.PregnancyRepository;
import com.sbnz.trud.io.repository.TripleTestRepository;
import com.sbnz.trud.io.repository.WeeklyParametersRepository;
import com.sbnz.trud.io.service.contracts.ITripleTestService;

@Service
public class TripleTestService extends GenericService<TripleTest> implements ITripleTestService{
	 private TripleTestRepository tripleTestRepository;
	 private PregnancyRepository pregnancyRepository;
	 private AgeRiskRepository ageRiskRepository;
	 private WeeklyParametersRepository weeklyParametersRepository;
	 private final KieContainer kieContainer;
	
	@Autowired
	public TripleTestService(TripleTestRepository tripleTestRepository, 
			PregnancyRepository pregnancyRepository, AgeRiskRepository ageRiskRepository,
			WeeklyParametersRepository weeklyParametersRepository, KieContainer kieContainer) {
		this.tripleTestRepository = tripleTestRepository;
		this.pregnancyRepository = pregnancyRepository;
		this.ageRiskRepository = ageRiskRepository;
		this.weeklyParametersRepository = weeklyParametersRepository;
		this.kieContainer = kieContainer;
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
		kieSession.fireAllRules();
		kieSession.dispose();
		return createdTripleTest;
	}

}
