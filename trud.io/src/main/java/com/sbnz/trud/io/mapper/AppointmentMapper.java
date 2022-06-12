package com.sbnz.trud.io.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sbnz.trud.io.apiContracts.request.UpdateAppointment;
import com.sbnz.trud.io.apiContracts.response.AppointmentInformations;
import com.sbnz.trud.io.model.Appointment;
import com.sbnz.trud.io.model.Illness;

@Component
public class AppointmentMapper {
	public AppointmentInformations fromAppointmentToAppointmentInfromations(Appointment appointment) {
		return new AppointmentInformations(appointment.getDate(), 
											appointment.getId(), 
											appointment.getPatient().getJmbg(),
											appointment.getPatient().getName(),
											appointment.getPatient().getLastName(),
											appointment.getPregnancy().getId(),
											appointment.getPatient().getTherapies(),
											appointment.getPregnancy().getIllnesses(),
											appointment.getPregnancy().isHighRiskPregnancy(),
											appointment.getPregnancy().isPrematureLabor());
	}
	
	public Appointment fromUpdateAppointmentToAppointment(UpdateAppointment updateAppointment) {
		List<Illness> illnesses = new ArrayList<>();
		updateAppointment.getIllnesseesNames().forEach(name -> illnesses.add(new Illness(name)));
		return new Appointment(updateAppointment.getBloodPressureLower(), 
								updateAppointment.getBloodPressureUpper(), 
								updateAppointment.getWeight(), 
								updateAppointment.getReport(),
								updateAppointment.getSymptoms(),
								illnesses);
	}
}
