package com.sbnz.trud.io.service.implementation;


import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbnz.trud.io.model.Birth;
import com.sbnz.trud.io.model.DailyGlucoseLevel;
import com.sbnz.trud.io.model.OgttTest;
import com.sbnz.trud.io.model.Patient;
import com.sbnz.trud.io.model.Pregnancy;
import com.sbnz.trud.io.repository.DailyGlucoseLevelRepository;
import com.sbnz.trud.io.service.contracts.IBirthService;
import com.sbnz.trud.io.service.contracts.IGestationalDiabetesService;
import com.sbnz.trud.io.service.contracts.IIllnessService;
import com.sbnz.trud.io.service.contracts.IOgttTestService;
import com.sbnz.trud.io.service.contracts.IPatientService;
import com.sbnz.trud.io.service.contracts.IPregnancyService;
import com.sbnz.trud.io.service.contracts.ITherapyService;


@Service
public class GestationalDiabetesService implements IGestationalDiabetesService{
	private IOgttTestService ogttTestService;
	private IPregnancyService pregnancyService;
	private IPatientService patientService;
	private IIllnessService illnessService;
	private ITherapyService therapyService;
	private KieContainer kieContainer;
	private IBirthService birthService;
	private DailyGlucoseLevelRepository glucoseRepository;
	
	@Autowired
	public GestationalDiabetesService(
			IOgttTestService ogttTestService,
			IPregnancyService pregnancyService,
			IPatientService patientService,
			IBirthService birthService,
			ITherapyService therapyService,
			IIllnessService illnessService,
			DailyGlucoseLevelRepository glucoseRepository,
			KieContainer kieContainer) 
	{
		this.ogttTestService = ogttTestService;
		this.pregnancyService = pregnancyService;
		this.patientService = patientService;
		this.birthService = birthService;
		this.illnessService = illnessService;
		this.therapyService = therapyService;
		this.kieContainer = kieContainer;
		this.glucoseRepository = glucoseRepository;
	}
	
	@Override
	public OgttTest earlyOgttTest(OgttTest test) throws Exception {
		KieSession kieSession = kieContainer.newKieSession();
    	List<Pregnancy> pregnancies = pregnancyService.findAll();
    	pregnancies.forEach(pregnancy -> kieSession.insert(pregnancy));
    	
    	List<Birth> births = birthService.findAll();
    	births.forEach(birth -> kieSession.insert(birth));
    	
    	List<OgttTest> ogttTests = ogttTestService.findAll();
    	ogttTests.forEach(ogttTest -> kieSession.insert(ogttTest));
    	
		kieSession.getAgenda().getAgendaGroup("ogttTest").setFocus();
		kieSession.fireAllRules();
		kieSession.dispose();
		
		pregnancies.forEach(pregnancy -> pregnancyService.update(pregnancy));
		
		return test;
	}
	
	@Override
	public OgttTest diagnoseDiabetes(OgttTest test, int pregnancyId) {
		OgttTest existingTest = ogttTestService.findById(test.getId());
		
		existingTest.setDate(test.getDate());
		existingTest.setPrimarySampling(test.getPrimarySampling());
		existingTest.setFirstBloodSampling(test.getFirstBloodSampling());
		existingTest.setSecondBloodSampling(test.getSecondBloodSampling());
		existingTest.setThirdBloodSampling(test.getThirdBloodSampling());
		existingTest.setFourthBloodSampling(test.getFourthBloodSampling());
		existingTest.setResult(test.getResult());
		
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.setGlobal("illnessService", illnessService);
		kieSession.insert(existingTest);
		
		Pregnancy pregnancy = pregnancyService.findById(pregnancyId);
		kieSession.insert(pregnancy);
		
		Patient patient = patientService.findById(pregnancy.getPatient().getId());
		kieSession.insert(patient);
		
		kieSession.getAgenda().getAgendaGroup("ogtt").setFocus();
		kieSession.fireAllRules();
		kieSession.dispose();
		
		existingTest = ogttTestService.update(existingTest);
		
		patientService.update(patient);
		pregnancy.setPatient(patient);
		/*
		List<OgttTest> tests = pregnancy.getOgttTests();
		tests.add(existingTest);
		pregnancy.setOgttTests(tests);
		*/
		pregnancyService.update(pregnancy);
		
		return existingTest;
	}
	
	@Override
	public Pregnancy setTherapy(DailyGlucoseLevel glucoseLevel, int pregnancyId) {
		KieSession kieSession = kieContainer.newKieSession();
		Pregnancy pregnancy = pregnancyService.findById(pregnancyId);
		
		glucoseLevel = glucoseRepository.save(glucoseLevel);
		List<DailyGlucoseLevel> glucoseLevels = pregnancy.getGlucoseLevels();
		glucoseLevels.add(glucoseLevel);
		pregnancy.setGlucoseLevels(glucoseLevels);
		
		kieSession.insert(pregnancy);
		
		Patient patient = patientService.findById(pregnancy.getPatient().getId());
		kieSession.insert(patient);
		
		kieSession.getAgenda().getAgendaGroup("metforminTherapy").setFocus();
		kieSession.fireAllRules();
		kieSession.dispose();
	
		patient.getTherapies().forEach(therapy -> {
			try {
				therapyService.create(therapy);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		patientService.update(patient);
		
		pregnancy.setPatient(patient);
		
		return pregnancyService.update(pregnancy);
	}
	
}
