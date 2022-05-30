package com.sbnz.trud.io.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbnz.trud.io.apiContracts.request.CreateBirth;
import com.sbnz.trud.io.model.Birth;

@Component
public class BirthMapper {
	
	@Autowired
	public BirthMapper() {
	}
	
	public Birth createBirthToBirth(CreateBirth birth) {
		return new Birth(
				birth.getWeight(),
				birth.getGestationalAge(),
				birth.isMiscarriage(),
				birth.isComplications(),
				birth.iscSection()
				);
	}
}
