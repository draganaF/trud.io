package com.sbnz.trud.io.service.contracts;

import com.sbnz.trud.io.model.DoubleTest;

public interface IDoubleTestService extends IGenericService<DoubleTest>{
	DoubleTest create(DoubleTest doubleTest);
	
	DoubleTest addDoubleTest(Integer pregnancyId, DoubleTest doubleTest);

}
