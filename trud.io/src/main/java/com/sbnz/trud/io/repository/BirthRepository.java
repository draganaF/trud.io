package com.sbnz.trud.io.repository;

import org.springframework.stereotype.Repository;

import com.sbnz.trud.io.model.Birth;
import com.sbnz.trud.io.repository.generic.GenericRepository;

@Repository
public interface BirthRepository extends GenericRepository<Birth> {
}
