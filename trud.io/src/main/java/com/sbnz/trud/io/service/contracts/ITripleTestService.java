package com.sbnz.trud.io.service.contracts;

import com.sbnz.trud.io.apiContracts.request.UpdateTripleTest;
import com.sbnz.trud.io.model.TripleTest;

public interface ITripleTestService extends IGenericService<TripleTest>{
	TripleTest create(TripleTest tripleTest);
	
	TripleTest addTripleTest(Integer pregnancyId, TripleTest tripleTest);
	
	TripleTest update(Integer preganancyId, UpdateTripleTest updateTripleTest);
}
