package com.sbnz.trud.io.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbnz.trud.io.model.Birth;
import com.sbnz.trud.io.model.Pregnancy;
import com.sbnz.trud.io.repository.BirthRepository;
import com.sbnz.trud.io.repository.PregnancyRepository;
import com.sbnz.trud.io.service.contracts.IBirthService;

@Service
public class BirthService extends GenericService<Birth> implements IBirthService {
	private BirthRepository birthRepository;
	private PregnancyRepository pregnancyRepository;
	
	@Autowired
	public BirthService(BirthRepository birthRepository, PregnancyRepository pregnancyRepository) {
		this.birthRepository = birthRepository;
		this.pregnancyRepository = pregnancyRepository;
	}

	@Override
	public void abortion(Integer id) {
		Birth birth = new Birth();
		birth.setAbortion(true);
		Birth saved = birthRepository.save(birth);
		
		Pregnancy pregnancy = pregnancyRepository.findById(id).orElse(null);
		pregnancy.setBirth(saved);
		pregnancyRepository.save(pregnancy);
	}
	
	@Override
	public Birth create(Birth entity, Integer id) {
		Birth saved = birthRepository.save(entity);
		Pregnancy pregnancy = pregnancyRepository.findById(id).orElse(null);
		pregnancy.setBirth(saved);
		pregnancyRepository.save(pregnancy);
		return saved;
	}
	
	@Override
	public ArrayList<Birth> findAll(){
		return (ArrayList<Birth>) birthRepository.findAll();
	}
}
