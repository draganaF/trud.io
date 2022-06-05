package com.sbnz.trud.io.service.implementation;

import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbnz.trud.io.dto.ChromosomalDisorderReport;
import com.sbnz.trud.io.dto.IllnessesReport;
import com.sbnz.trud.io.dto.SymptomsReport;
import com.sbnz.trud.io.model.Birth;
import com.sbnz.trud.io.model.Pregnancy;
import com.sbnz.trud.io.service.contracts.IBirthService;
import com.sbnz.trud.io.service.contracts.IPregnancyService;
import com.sbnz.trud.io.service.contracts.IReportService;

@Service
public class ReportService implements IReportService {
	private IPregnancyService pregnancyService;
	private IBirthService birthService;
	private final KieContainer kieContainer;
	
	@Autowired
	public ReportService(IPregnancyService pregnancyService,
			IBirthService birthService,
			KieContainer kieContainer) {
		this.pregnancyService = pregnancyService;
		this.birthService = birthService;
		this.kieContainer = kieContainer;
	}

	@Override
	public SymptomsReport calculateSymptomsReport(SymptomsReport report) throws Exception {
		List<Pregnancy> pregnancies = pregnancyService.findAll();
		KieSession kieSession = kieContainer.newKieSession();
		pregnancies.forEach(pregnancy -> kieSession.insert(pregnancy));
		kieSession.insert(report);
		kieSession.getAgenda().getAgendaGroup("reports").setFocus();
		kieSession.fireAllRules();
		kieSession.dispose();
		
		return report;
	}

	@Override
	public ChromosomalDisorderReport calculateChromosomalDisorderReport(
			ChromosomalDisorderReport chromosomalDisorderReport) throws Exception {
		List<Pregnancy> pregnancies = pregnancyService.findAll();
		List<Birth> births = birthService.findAll();
		KieSession kieSession = kieContainer.newKieSession();
		pregnancies.forEach(pregnancy -> kieSession.insert(pregnancy));
		births.forEach(birth -> kieSession.insert(birth));
		kieSession.insert(chromosomalDisorderReport);
		kieSession.getAgenda().getAgendaGroup("reports").setFocus();
		kieSession.fireAllRules();
		kieSession.dispose();
		
		return chromosomalDisorderReport;
	}

	@Override
	public IllnessesReport calculateIllnessesReport(IllnessesReport illnessesReport) throws Exception {
		List<Pregnancy> pregnancies = pregnancyService.findAll();
		KieSession kieSession = kieContainer.newKieSession();
		pregnancies.forEach(pregnancy -> kieSession.insert(pregnancy));
		kieSession.insert(illnessesReport);
		kieSession.getAgenda().getAgendaGroup("reports").setFocus();
		kieSession.fireAllRules();
		kieSession.dispose();
		
		return illnessesReport;
	}

}
