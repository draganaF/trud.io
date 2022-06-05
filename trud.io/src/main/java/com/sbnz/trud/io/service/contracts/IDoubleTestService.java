package com.sbnz.trud.io.service.contracts;

import java.io.IOException;

import com.sbnz.trud.io.apiContracts.request.TemplateTestRule;
import com.sbnz.trud.io.model.DoubleTest;

public interface IDoubleTestService extends IGenericService<DoubleTest>{
	DoubleTest create(DoubleTest doubleTest);
	
	DoubleTest addDoubleTest(Integer pregnancyId, DoubleTest doubleTest);
	
	void template(TemplateTestRule doubleTestRule) throws IOException;

}
