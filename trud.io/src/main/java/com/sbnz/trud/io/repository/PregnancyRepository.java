package com.sbnz.trud.io.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sbnz.trud.io.model.Pregnancy;
import com.sbnz.trud.io.repository.generic.GenericRepository;

@Repository
public interface PregnancyRepository extends GenericRepository<Pregnancy> {
	
	@Query("select p from Pregnancy p where p.patient.id =?1")
	List<Pregnancy> findPregnancyByPatient(Integer id);
	
	@Query("select p from Pregnancy p where p.birth = null")
	List<Pregnancy> findActivePregnancies();
    
}
