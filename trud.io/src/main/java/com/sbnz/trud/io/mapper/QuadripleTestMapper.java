package com.sbnz.trud.io.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbnz.trud.io.apiContracts.request.CreateQuadripleTest;
import com.sbnz.trud.io.apiContracts.response.ViewQuadripleTest;
import com.sbnz.trud.io.model.QuadripleTest;

@Component
public class QuadripleTestMapper {
	@Autowired
	public QuadripleTestMapper() {}
	
	public QuadripleTest createQuadripleTestToQuadripleTest(CreateQuadripleTest createQuadripleTest) {
		return new QuadripleTest(
				createQuadripleTest.getHcg(),
				createQuadripleTest.getAfp(),
				createQuadripleTest.getUe3(),
				createQuadripleTest.getResult(),
				createQuadripleTest.getInhibinA(),
				""
				);
	}
	
	public ViewQuadripleTest quadripleTestToViewQuadripleTest(QuadripleTest quadripleTest) {
		return new ViewQuadripleTest(
				quadripleTest.getId() == null ? 0 : quadripleTest.getId(),
				quadripleTest.getHcg() == null ? 0 : quadripleTest.getHcg(),
				quadripleTest.getAfp() == null ? 0 : quadripleTest.getAfp(),
				quadripleTest.getUe3() == null ? 0 : quadripleTest.getUe3(),
				quadripleTest.getResult() == null ? " ": quadripleTest.getResult(),
				quadripleTest.getTrisomy21() == null ? 0 : quadripleTest.getTrisomy21(),
				quadripleTest.getResultT21() == null ? " " : quadripleTest.getResultT21(),
				quadripleTest.getTrisomy13() == null ? 0 : quadripleTest.getTrisomy13(),
				quadripleTest.getResultT13() == null ? " " : quadripleTest.getResultT13(),
				quadripleTest.getTrisomy18() == null ? 0 : quadripleTest.getTrisomy18(),
				quadripleTest.getResultT18() == null ? " " : quadripleTest.getResultT18(),
				quadripleTest.getInhibinA() == null ? 0 : quadripleTest.getInhibinA()
		);
	}
}
