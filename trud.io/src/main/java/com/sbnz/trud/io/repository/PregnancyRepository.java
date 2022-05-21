package com.sbnz.trud.io.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbnz.trud.io.model.Pregnancy;


public interface PregnancyRepository extends JpaRepository<Pregnancy, Integer> {
    
}
