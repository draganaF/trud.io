package com.sbnz.trud.io.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbnz.trud.io.model.Birth;
import com.sbnz.trud.io.repository.BirthRepository;
import com.sbnz.trud.io.service.contracts.IBirthService;

@Service
public class BirthService extends GenericService<Birth> implements IBirthService {
	private BirthRepository birthRepository;
	
	@Autowired
	public BirthService(BirthRepository birthRepository) {
		this.birthRepository = birthRepository;
	}
	
}
