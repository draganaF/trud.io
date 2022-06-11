package com.sbnz.trud.io.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbnz.trud.io.apiContracts.request.CreateTripleTest;
import com.sbnz.trud.io.apiContracts.response.ViewTripleTest;
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
				createTripleTest.getResult(),
				""
				);
	}
	
	public ViewTripleTest tripleTestToViewTripleTest(TripleTest tripleTest) {
		return new ViewTripleTest(
				tripleTest.getId() == null ? 0 : tripleTest.getId(),
				tripleTest.getHcg() == null ? 0 : tripleTest.getHcg(),
				tripleTest.getAfp() == null ? 0 : tripleTest.getAfp(),
				tripleTest.getUe3() == null ? 0 : tripleTest.getUe3(),
				tripleTest.getResult() == null ? " ": tripleTest.getResult(),
				tripleTest.getTrisomy21() == null ? 0 : tripleTest.getTrisomy21(),
				tripleTest.getResultT21() == null ? " " : tripleTest.getResultT21(),
				tripleTest.getTrisomy13() == null ? 0 : tripleTest.getTrisomy13(),
				tripleTest.getResultT13() == null ? " " : tripleTest.getResultT13(),
				tripleTest.getTrisomy18() == null ? 0 : tripleTest.getTrisomy18(),
				tripleTest.getResultT18() == null ? " " : tripleTest.getResultT18()
		);
	}
}
