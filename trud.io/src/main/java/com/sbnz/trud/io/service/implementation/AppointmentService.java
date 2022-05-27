package com.sbnz.trud.io.service.implementation;


import java.time.LocalDateTime;
import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbnz.trud.io.model.Appointment;
import com.sbnz.trud.io.model.Pregnancy;
import com.sbnz.trud.io.repository.AppointmentRepository;
import com.sbnz.trud.io.repository.PregnancyRepository;
import com.sbnz.trud.io.service.contracts.IAppointmentService;

@Service
public class AppointmentService extends GenericService<Appointment> implements IAppointmentService {
    private AppointmentRepository appointmentRepository;
    private final KieContainer kieContainer;
    private PregnancyRepository pregnancyRepository;
    
    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository, 
    		KieContainer kieContainer, 
    		PregnancyRepository pregnancyRepository) {
    	this.appointmentRepository = appointmentRepository;
    	this.kieContainer = kieContainer;
    	this.pregnancyRepository = pregnancyRepository;
    }
    
    @Override
    public Appointment save(Appointment entity) throws Exception {
    	KieSession kieSession = kieContainer.newKieSession();
    	Pregnancy pregnancy = pregnancyRepository.findById(1).orElse(null);
    	System.out.println(pregnancy.isHighRiskPregnancy());
    	kieSession.insert(pregnancy);
    	List<Appointment> appointments = appointmentRepository.findAll();
    	appointments.add(entity);
    	appointments.forEach(app -> kieSession.insert(app));
		kieSession.getAgenda().getAgendaGroup("appointments").setFocus();
		kieSession.setGlobal("countScheduledDaysForTwoWeeks", 0);
		kieSession.setGlobal("countScheduledDaysForFourWeeks", 0);
		kieSession.setGlobal("countScheduledDaysForWeek", 0);
		kieSession.fireAllRules();
		kieSession.dispose();
		
		return appointmentRepository.save(entity);
    }
}