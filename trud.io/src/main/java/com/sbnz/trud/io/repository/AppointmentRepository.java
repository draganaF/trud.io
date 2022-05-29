package com.sbnz.trud.io.repository;

import org.springframework.stereotype.Repository;

import com.sbnz.trud.io.model.Appointment;
import com.sbnz.trud.io.repository.generic.GenericRepository;

@Repository
public interface AppointmentRepository extends GenericRepository<Appointment> {
}
