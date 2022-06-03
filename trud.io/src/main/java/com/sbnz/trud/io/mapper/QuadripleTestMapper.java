package com.sbnz.trud.io.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbnz.trud.io.apiContracts.request.CreateQuadripleTest;
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
				createQuadripleTest.getInhibinA()
				);
	}
}
