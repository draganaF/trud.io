package com.sbnz.trud.io.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbnz.trud.io.model.Patient;


public interface PatientRepository extends JpaRepository<Patient, Integer> {
    Patient findByJmbg(String jmbg);
}
