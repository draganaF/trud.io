package com.sbnz.trud.io.repository;

import org.springframework.stereotype.Repository;

import com.sbnz.trud.io.model.Pregnancy;
import com.sbnz.trud.io.repository.generic.GenericRepository;

@Repository
public interface PregnancyRepository extends GenericRepository<Pregnancy> {
    
}
