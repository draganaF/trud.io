package com.sbnz.trud.io.mapper;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbnz.trud.io.apiContracts.request.CreateBirth;
import com.sbnz.trud.io.apiContracts.response.ViewBirth;
import com.sbnz.trud.io.model.Birth;
import com.sbnz.trud.io.model.ChromosomalDisorders;

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
				birth.iscSection(),
				ChromosomalDisorders.valueOf(birth.getChromosomalDisorder()),
				LocalDateTime.now());
	}
	
	public ViewBirth birthToViewBirth(Birth birth) {
		return new ViewBirth(birth.getWeight() == null ? 0 : birth.getWeight() ,
							 birth.getGestationalAge() == null ? 0 : birth.getGestationalAge(),
							 birth.isMiscarriage(),
							 birth.isComplications(),
							 birth.iscSection(),
							 birth.getChromosomalDisorder() == null ? "" : birth.getChromosomalDisorder().name(),
							 birth.isAbortion(),
							 birth.getBirthDateTime() == null ? null : birth.getBirthDateTime());
	}
}
