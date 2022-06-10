package com.sbnz.trud.io.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sbnz.trud.io.model.Appointment;
import com.sbnz.trud.io.repository.generic.GenericRepository;

@Repository
public interface AppointmentRepository extends GenericRepository<Appointment> {
	List<Appointment> findByIsDone(boolean isDone);
	
	@Query("select a from Appointment a where a.patient.jmbg = ?1 and isDone = false")
	List<Appointment> findByPatientJmbg(String jmbg);
}
