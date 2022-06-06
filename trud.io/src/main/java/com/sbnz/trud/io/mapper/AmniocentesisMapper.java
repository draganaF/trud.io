package com.sbnz.trud.io.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbnz.trud.io.apiContracts.request.CreateAmniocentesis;
import com.sbnz.trud.io.model.Amniocentesis;

@Component
public class AmniocentesisMapper {
	
	@Autowired
	public AmniocentesisMapper() {}
	
	public Amniocentesis createAmniocentesisToAmniocentesis(CreateAmniocentesis createAmniocentesis) {
		return new Amniocentesis(
				createAmniocentesis.getAfp(),
				createAmniocentesis.getResult()
				);
	}

}
