package com.sbnz.trud.io.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbnz.trud.io.model.Illness;
import com.sbnz.trud.io.repository.IllnessRepository;
import com.sbnz.trud.io.service.contracts.IIllnessService;

@Service
public class IllnessService extends GenericService<Illness> implements IIllnessService{

	private IllnessRepository illnessRepository;
	
	@Autowired
	public IllnessService(IllnessRepository illnessRepository) {
		this.illnessRepository = illnessRepository;
	}

	@Override
	public Illness findByName(String name) {
		Illness illness = illnessRepository.findByName(name);
		
		return illness;
	}
}
