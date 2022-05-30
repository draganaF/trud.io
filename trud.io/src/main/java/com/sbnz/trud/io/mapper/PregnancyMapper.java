package com.sbnz.trud.io.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbnz.trud.io.apiContracts.request.CreatePregnancy;
import com.sbnz.trud.io.apiContracts.response.UpdatePregnancy;
import com.sbnz.trud.io.model.Patient;
import com.sbnz.trud.io.model.Pregnancy;
import com.sbnz.trud.io.service.contracts.IPatientService;

@Component
public class PregnancyMapper {
	private IPatientService patientService;
	
	@Autowired
	public PregnancyMapper(IPatientService patientService) {
		this.patientService = patientService;
	}
	
	
    public Pregnancy createPragnancyToPragnancy(CreatePregnancy createPregnancy) {
    	Patient patient = patientService.findByJmbg(createPregnancy.getJmbg());
        return new Pregnancy(createPregnancy.getStartDate(), createPregnancy.getNumberOfPregnancy(), patient);
    }
    
   
    public UpdatePregnancy pregnancyToUpdatePregnancy(Pregnancy pregnancy) {
        return new UpdatePregnancy(pregnancy.getStartDate(), pregnancy.getNumberOfPregnancies(), pregnancy.isHighRiskPregnancy(), pregnancy.isPrematureLabor(),
    			pregnancy.getSymptoms());
    }
}
