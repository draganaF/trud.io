package com.sbnz.trud.io.mapper;

import org.springframework.stereotype.Component;

import com.sbnz.trud.io.apiContracts.request.UpdateAppointment;
import com.sbnz.trud.io.apiContracts.response.AppointmentInformations;
import com.sbnz.trud.io.model.Appointment;

@Component
public class AppointmentMapper {
	public AppointmentInformations fromAppointmentToAppointmentInfromations(Appointment appointment) {
		return new AppointmentInformations(appointment.getDate(), 
											appointment.getId(), 
											appointment.getPatient().getJmbg(),
											appointment.getPatient().getName(),
											appointment.getPatient().getLastName(),
											appointment.getPregnancy().getId());
	}
	
	public Appointment fromUpdateAppointmentToAppointment(UpdateAppointment updateAppointment) {
		return new Appointment(updateAppointment.getBloodPressureLower(), updateAppointment.getBloodPressureUpper(), updateAppointment.getWeight(), 
				updateAppointment.getReport());
	}
}
