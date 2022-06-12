package com.sbnz.trud.io.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbnz.trud.io.apiContracts.response.ViewCTG;
import com.sbnz.trud.io.model.CTG;

@Component
public class CTGMapper {

	@Autowired
	public CTGMapper() {
		
	}
	
	public ViewCTG fromCTGtoViewCTG(CTG ctg) {
		return new ViewCTG(
				ctg.getId(),
				ctg.isTachycardia(),
				ctg.isBradycardia(), 
				ctg.getFetalHartRate(),
				ctg.getVaribilty(),
				ctg.getContractions(),
				ctg.getFhrStatus(),
				ctg.getVariabiltyStatus(),
				ctg.getResult());
	}
}
