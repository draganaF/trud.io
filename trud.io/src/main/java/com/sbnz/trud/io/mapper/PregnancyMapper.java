package com.sbnz.trud.io.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbnz.trud.io.apiContracts.request.CreatePregnancy;
import com.sbnz.trud.io.apiContracts.response.UpdatePregnancy;
import com.sbnz.trud.io.apiContracts.response.ViewPregnancy;
import com.sbnz.trud.io.model.Patient;
import com.sbnz.trud.io.model.Pregnancy;
import com.sbnz.trud.io.service.contracts.IPatientService;

@Component
public class PregnancyMapper {
	private IPatientService patientService;
	private PatientMapper patientMapper;
	private DoubleTestMapper doubleTestMapper;
	private TripleTestMapper tripleTestMapper;
	private QuadripleTestMapper quadripleTestMapper;
	private AmniocentesisMapper amniocentesisMapper;
	
	@Autowired
	public PregnancyMapper(IPatientService patientService, PatientMapper patientMapper, DoubleTestMapper doubleTestMapper,
			TripleTestMapper tripleTestMapper, QuadripleTestMapper quadripleTestMapper, AmniocentesisMapper amniocentesisMapper) {
		this.patientService = patientService;
		this.patientMapper = patientMapper;
		this.doubleTestMapper = doubleTestMapper;
		this.tripleTestMapper = tripleTestMapper;
		this.quadripleTestMapper = quadripleTestMapper;
		this.amniocentesisMapper = amniocentesisMapper;
	}
	
	
    public Pregnancy createPragnancyToPragnancy(CreatePregnancy createPregnancy) {
    	Patient patient = patientService.findByJmbg(createPregnancy.getJmbg());
        return new Pregnancy(createPregnancy.getStartDate(), createPregnancy.getNumberOfPregnancy(), patient);
    }
    
   
    public UpdatePregnancy pregnancyToUpdatePregnancy(Pregnancy pregnancy) {
        return new UpdatePregnancy(pregnancy.getStartDate(), pregnancy.getNumberOfPregnancies(), pregnancy.isHighRiskPregnancy(), pregnancy.isPrematureLabor(),
    			pregnancy.getSymptoms());
    }
    
    public ViewPregnancy pregnancyToViewPregnancy(Pregnancy pregnancy) {
    	return new ViewPregnancy(pregnancy.getId(), pregnancy.getStartDate(),pregnancy.getSymptoms() ,
    			patientMapper.patientToViewPatient(pregnancy.getPatient()), 
    			pregnancy.getDoubleTest() == null ? null : doubleTestMapper.doubleTestToViewDoubleTest(pregnancy.getDoubleTest()), pregnancy.getWeek(),
    			pregnancy.getTripleTest() == null ? null : tripleTestMapper.tripleTestToViewTripleTest(pregnancy.getTripleTest()),
    			pregnancy.getQuadripleTest() == null ? null : quadripleTestMapper.quadripleTestToViewQuadripleTest(pregnancy.getQuadripleTest()),
    			pregnancy.getAmniocentesis() == null ? null : amniocentesisMapper.amniocentesisToViewAmniocentesis(pregnancy.getAmniocentesis()));
    }
}
