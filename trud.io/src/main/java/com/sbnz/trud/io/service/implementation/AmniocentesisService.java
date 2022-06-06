package com.sbnz.trud.io.service.implementation;

import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbnz.trud.io.model.Amniocentesis;
import com.sbnz.trud.io.model.Pregnancy;
import com.sbnz.trud.io.repository.AgeRiskRepository;
import com.sbnz.trud.io.repository.AmniocentesisRepository;
import com.sbnz.trud.io.repository.PregnancyRepository;
import com.sbnz.trud.io.repository.WeeklyParametersRepository;
import com.sbnz.trud.io.service.contracts.IAmniocentesisService;


@Service
public class AmniocentesisService extends GenericService<Amniocentesis> implements IAmniocentesisService {

	 private AmniocentesisRepository amniocentesisRepository;
	 private PregnancyRepository pregnancyRepository;
	 private AgeRiskRepository ageRiskRepository;
	 private WeeklyParametersRepository weeklyParametersRepository;
	 private final KieContainer kieContainer;
	
	@Autowired
	public AmniocentesisService(AmniocentesisRepository amniocentesisRepository, 
			PregnancyRepository pregnancyRepository, AgeRiskRepository ageRiskRepository,
			WeeklyParametersRepository weeklyParametersRepository, KieContainer kieContainer) {
		this.amniocentesisRepository = amniocentesisRepository;
		this.pregnancyRepository = pregnancyRepository;
		this.ageRiskRepository = ageRiskRepository;
		this.weeklyParametersRepository = weeklyParametersRepository;
		this.kieContainer = kieContainer;
	}
	
	@Override
	public Amniocentesis create(Amniocentesis amniocentesis) {
		return amniocentesisRepository.save(amniocentesis);
	}

	@Override
	public Amniocentesis addAmniocentesis(Integer pregnancyId, Amniocentesis amniocentesis) {
		Amniocentesis createdAmniocentesis = create(amniocentesis);
		Pregnancy pregnancy = pregnancyRepository.findById(pregnancyId).orElse(null);
		pregnancy.setAmniocentesis(createdAmniocentesis);
		List<Pregnancy> pregnancies = pregnancyRepository.findPregnancyByPatient(pregnancy.getPatient().getId());
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(pregnancy);
		kieSession.insert(createdAmniocentesis);
		pregnancies.forEach(p-> kieSession.insert(p));
		pregnancies.forEach(p -> kieSession.insert(p.getBirth()));
		ageRiskRepository.findAll().forEach(age -> kieSession.insert(age));
		weeklyParametersRepository.findAll().forEach(week -> kieSession.insert(week));
		kieSession.getAgenda().getAgendaGroup("amniocentesis").setFocus();
		kieSession.fireAllRules();
		kieSession.dispose();
		return amniocentesisRepository.save(createdAmniocentesis);
	}

}
