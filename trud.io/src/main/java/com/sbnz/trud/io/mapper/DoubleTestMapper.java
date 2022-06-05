package com.sbnz.trud.io.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbnz.trud.io.apiContracts.request.CreateDoubleTest;
import com.sbnz.trud.io.model.DoubleTest;

@Component
public class DoubleTestMapper {
	@Autowired
	public DoubleTestMapper() {}
	
	public DoubleTest createDoubleTestToDoubleTest(CreateDoubleTest createDoubleTest) {
		return new DoubleTest(
				createDoubleTest.getCrl(),
				createDoubleTest.getNt(),
				createDoubleTest.isNasalBone(),
				createDoubleTest.getFreeBetaHCG(),
				createDoubleTest.getPappa(),
				createDoubleTest.getResult()
				);
	}
}
