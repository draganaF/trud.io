package com.sbnz.trud.io.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbnz.trud.io.apiContracts.request.CreateTripleTest;
import com.sbnz.trud.io.model.TripleTest;

@Component
public class TripleTestMapper {
	@Autowired
	public TripleTestMapper() {}
	
	public TripleTest createTripleTestToTripleTest(CreateTripleTest createTripleTest) {
		return new TripleTest(
				createTripleTest.getHcg(),
				createTripleTest.getAfp(),
				createTripleTest.getUe3(),
				createTripleTest.getResult()
				);
	}
}
