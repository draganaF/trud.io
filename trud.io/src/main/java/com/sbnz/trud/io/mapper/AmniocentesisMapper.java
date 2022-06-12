package com.sbnz.trud.io.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbnz.trud.io.apiContracts.request.CreateAmniocentesis;
import com.sbnz.trud.io.apiContracts.response.ViewAmniocentesis;
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
	
	public ViewAmniocentesis amniocentesisToViewAmniocentesis(Amniocentesis amniocentesis) {
		return new ViewAmniocentesis(
				amniocentesis.getId(),
				amniocentesis.getAfp() == null ? 0 : amniocentesis.getAfp(),
				amniocentesis.getResult() == null ? " " : amniocentesis.getResult(),
				amniocentesis.getTrisomy21() == null ? 0 : amniocentesis.getTrisomy21(),
				amniocentesis.getResultT21() == null ? " " : amniocentesis.getResultT21(),
				amniocentesis.getTrisomy13() == null ? 0 : amniocentesis.getTrisomy13(),
				amniocentesis.getResultT13() == null ? " " : amniocentesis.getResultT13(),
				amniocentesis.getTrisomy18() == null ? 0 : amniocentesis.getTrisomy18(),
				amniocentesis.getResultT18() == null ? " " : amniocentesis.getResultT18(),
				amniocentesis.getNeuralDefects()
		);
	}

}
