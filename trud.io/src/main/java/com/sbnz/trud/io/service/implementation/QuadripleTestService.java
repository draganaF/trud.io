package com.sbnz.trud.io.service.implementation;

import java.util.Collection;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbnz.trud.io.model.Amniocentesis;
import com.sbnz.trud.io.model.Pregnancy;
import com.sbnz.trud.io.model.QuadripleTest;
import com.sbnz.trud.io.repository.AgeRiskRepository;
import com.sbnz.trud.io.repository.AmniocentesisRepository;
import com.sbnz.trud.io.repository.PregnancyRepository;
import com.sbnz.trud.io.repository.QuadripleTestRepository;
import com.sbnz.trud.io.repository.WeeklyParametersRepository;
import com.sbnz.trud.io.service.contracts.IQuadripleTestService;

@Service
public class QuadripleTestService extends GenericService<QuadripleTest> implements IQuadripleTestService{
	 private QuadripleTestRepository quadripleTestRepository;
	 private AmniocentesisRepository amniocentesisRepository;
	 private PregnancyRepository pregnancyRepository;
	 private AgeRiskRepository ageRiskRepository;
	 private WeeklyParametersRepository weeklyParametersRepository;
	 private final KieContainer kieContainer;
	
	@Autowired
	public QuadripleTestService(QuadripleTestRepository quadripleTestRepository, 
			PregnancyRepository pregnancyRepository, AgeRiskRepository ageRiskRepository,
			WeeklyParametersRepository weeklyParametersRepository, KieContainer kieContainer, AmniocentesisRepository amniocentesisRepository) {
		this.quadripleTestRepository = quadripleTestRepository;
		this.pregnancyRepository = pregnancyRepository;
		this.ageRiskRepository = ageRiskRepository;
		this.weeklyParametersRepository = weeklyParametersRepository;
		this.kieContainer = kieContainer;
		this.amniocentesisRepository = amniocentesisRepository;
	}
	
	@Override
	public QuadripleTest create(QuadripleTest quadripleTest) {
		return quadripleTestRepository.save(quadripleTest);
	}

	@Override
	public QuadripleTest addQuadripleTest(Integer pregnancyId, QuadripleTest quadripleTest) {
		QuadripleTest createdQuadripleTest = create(quadripleTest);
		Pregnancy pregnancy = pregnancyRepository.findById(pregnancyId).orElse(null);
		pregnancy.setQuadripleTest(createdQuadripleTest);
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(pregnancy);
		kieSession.insert(createdQuadripleTest);
		ageRiskRepository.findAll().forEach(age -> kieSession.insert(age));
		weeklyParametersRepository.findAll().forEach(week -> kieSession.insert(week));
		kieSession.getAgenda().getAgendaGroup("quadripleTest").setFocus();
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
		return quadripleTestRepository.save(createdQuadripleTest);
	}
}
