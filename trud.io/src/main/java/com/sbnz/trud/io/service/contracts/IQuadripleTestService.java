package com.sbnz.trud.io.service.contracts;

import com.sbnz.trud.io.model.QuadripleTest;

public interface IQuadripleTestService extends IGenericService<QuadripleTest>{
	QuadripleTest create(QuadripleTest quadripleTest);
	
	QuadripleTest addQuadripleTest(Integer pregnancyId, QuadripleTest quadripleTest);
}
