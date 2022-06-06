package com.sbnz.trud.io.service.implementation;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sbnz.trud.io.model.DoubleTest;
import com.sbnz.trud.io.model.Pregnancy;
import com.sbnz.trud.io.repository.AgeRiskRepository;
import com.sbnz.trud.io.repository.DoubleTestRepository;
import com.sbnz.trud.io.repository.PregnancyRepository;
import com.sbnz.trud.io.repository.WeeklyParametersRepository;
import com.sbnz.trud.io.service.contracts.IDoubleTestService;

@Service
public class DoubleTestService extends GenericService<DoubleTest> implements IDoubleTestService{

	 private DoubleTestRepository doubleTestRepository;
	 private PregnancyRepository pregnancyRepository;
	 private AgeRiskRepository ageRiskRepository;
	 private WeeklyParametersRepository weeklyParametersRepository;
	 private final KieContainer kieContainer;
	 @Value("${templatePath}")
	 private String templatePath;
	 @Value("${projectPath}")
	 private String projectPath;
	 @Value("${kjarPath}")
	 private String kjarPath;
	
	@Autowired
	public DoubleTestService(DoubleTestRepository doubleTestRepository, 
			PregnancyRepository pregnancyRepository, AgeRiskRepository ageRiskRepository,
			WeeklyParametersRepository weeklyParametersRepository, KieContainer kieContainer) {
		this.doubleTestRepository = doubleTestRepository;
		this.pregnancyRepository = pregnancyRepository;
		this.ageRiskRepository = ageRiskRepository;
		this.weeklyParametersRepository = weeklyParametersRepository;
		this.kieContainer = kieContainer;
	}
	
	@Override
	public DoubleTest create(DoubleTest doubleTest) {
		return doubleTestRepository.save(doubleTest);
	}

	@Override
	public DoubleTest addDoubleTest(Integer pregnancyId, DoubleTest doubleTest) {
		DoubleTest createdDoubleTest = create(doubleTest);
		Pregnancy pregnancy = pregnancyRepository.findById(pregnancyId).orElse(null);
		pregnancy.setDoubleTest(createdDoubleTest);
		pregnancyRepository.save(pregnancy);
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(pregnancy);
		kieSession.insert(createdDoubleTest);
		ageRiskRepository.findAll().forEach(age -> kieSession.insert(age));
		weeklyParametersRepository.findAll().forEach(week -> kieSession.insert(week));
		kieSession.getAgenda().getAgendaGroup("doubleTest").setFocus();
		kieSession.fireAllRules();
		kieSession.dispose();
		return doubleTestRepository.save(createdDoubleTest);
	}
}
