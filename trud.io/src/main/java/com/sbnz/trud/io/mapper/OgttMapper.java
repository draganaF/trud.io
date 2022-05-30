package com.sbnz.trud.io.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbnz.trud.io.apiContracts.request.CreateOgtt;
import com.sbnz.trud.io.model.OgttTest;

@Component
public class OgttMapper {

	@Autowired
	public OgttMapper() {
		
	}
	
	public OgttTest createOgttToOgttTest(CreateOgtt createOgtt) {
		return new OgttTest(
				createOgtt.getPrimarySampling(),
				createOgtt.getFirstBloodSampling(),
				createOgtt.getSecondBloodSampling(),
				createOgtt.getThirdBloodSampling(),
				createOgtt.getFourthBloodSampling(),
				createOgtt.getResult()
				);
	}
	
}
