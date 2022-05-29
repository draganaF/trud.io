package com.sbnz.trud.io.repository;

import org.springframework.stereotype.Repository;

import com.sbnz.trud.io.model.Illness;
import com.sbnz.trud.io.repository.generic.GenericRepository;

@Repository
public interface IllnessRepository extends GenericRepository<Illness>{
	Illness findByName(String name);
}
