package com.sbnz.trud.io.repository;

import org.springframework.stereotype.Repository;

import com.sbnz.trud.io.model.Patient;
import com.sbnz.trud.io.repository.generic.GenericRepository;

@Repository
public interface PatientRepository extends GenericRepository<Patient> {
    Patient findByJmbg(String jmbg);
}
