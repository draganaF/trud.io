package com.sbnz.trud.io.service.contracts;

import java.util.List;

import com.sbnz.trud.io.model.Appointment;

public interface IAppointmentService extends IGenericService<Appointment> {
	Appointment update(Appointment entity, Integer id) throws Exception;
	List<Appointment> findNotDoneAppointments();
	List<Appointment> findNotProcessedByPatientJmbg(String jmbg);
	Appointment createFirstAppointment(Appointment appointment);
}
