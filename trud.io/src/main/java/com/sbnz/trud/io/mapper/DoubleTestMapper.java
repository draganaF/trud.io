package com.sbnz.trud.io.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbnz.trud.io.apiContracts.request.CreateDoubleTest;
import com.sbnz.trud.io.apiContracts.response.ViewDoubleTest;
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
				createDoubleTest.getResult(),
				""
				);
	}
	
	public ViewDoubleTest doubleTestToViewDoubleTest(DoubleTest doubleTest) {
		return new ViewDoubleTest(
				doubleTest.getCrl(),
				doubleTest.getNt(),
				doubleTest.isNasalBone(),
				doubleTest.getFreeBetaHCG(),
				doubleTest.getPappa(),
				doubleTest.getTrisomy21() == null ? 0 : doubleTest.getTrisomy21(),
				doubleTest.getResultT21() == null ? " " : doubleTest.getResultT21(),
				doubleTest.getTrisomy13() == null ? 0 : doubleTest.getTrisomy13(),
				doubleTest.getResultT13() == null ? " " : doubleTest.getResultT13(),
				doubleTest.getTrisomy18() == null ? 0 : doubleTest.getTrisomy18(),
				doubleTest.getResultT18() == null ? " " : doubleTest.getResultT18(),
				doubleTest.getResult()
		);
	}
}
