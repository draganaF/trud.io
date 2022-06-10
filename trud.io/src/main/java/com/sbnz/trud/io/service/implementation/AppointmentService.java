package com.sbnz.trud.io.service.implementation;


import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbnz.trud.io.model.Appointment;
import com.sbnz.trud.io.repository.AppointmentRepository;
import com.sbnz.trud.io.service.contracts.IAppointmentService;
import com.sbnz.trud.io.service.contracts.IPatientService;
import com.sbnz.trud.io.service.contracts.IPregnancyService;

@Service
public class AppointmentService extends GenericService<Appointment> implements IAppointmentService {
    private AppointmentRepository appointmentRepository;
    private final KieContainer kieContainer;
    private IPatientService patientService;
    private IPregnancyService pregnancyService;
    
    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository, 
    		KieContainer kieContainer,
    		IPatientService patientService,
    		IPregnancyService pregnancyService) {
    	this.appointmentRepository = appointmentRepository;
    	this.kieContainer = kieContainer;
    	this.patientService = patientService;
    	this.pregnancyService = pregnancyService;
    }
    
    @Override
    public Appointment create(Appointment entity) throws Exception {
    	KieSession kieSession = kieContainer.newKieSession();
    	entity.setPatient(entity.getPregnancy().getPatient());
    	entity = appointmentRepository.save(entity);
    	kieSession.insert(entity.getPregnancy().getPatient());
    	List<Appointment> appointments = appointmentRepository.findAll();
    	appointments.add(entity);
    	appointments.forEach(app -> kieSession.insert(app));
		kieSession.getAgenda().getAgendaGroup("appointments").setFocus();
		kieSession.fireAllRules();
		kieSession.dispose();
		
		return appointmentRepository.save(entity);
    }
    
    @Override
    public Appointment update(Appointment entity, Integer id) throws Exception {
    	Appointment appointmentForUpdate = findById(id);
    	
    	appointmentForUpdate.setBloodPressureLower(entity.getBloodPressureLower());
    	appointmentForUpdate.setBloodPressureUpper(entity.getBloodPressureUpper());
    	appointmentForUpdate.setDone(true);
    	appointmentForUpdate.setReport(entity.getReport());
    	appointmentForUpdate.setWeight(entity.getWeight());
    	appointmentForUpdate.setSymptoms(entity.getSymptoms());
    	appointmentForUpdate.setIllnessesNames(entity.getIllnessesNames());
    	
    	pregnancyService.addSymptomsAndIllnesses(appointmentForUpdate.getPregnancy().getId(), entity.getSymptoms(), entity.getIllnessesNames());
    	
    	return appointmentRepository.save(appointmentForUpdate);
    }

	@Override
	public List<Appointment> findNotDoneAppointments() {
		return appointmentRepository.findByIsDone(false);
	}

	@Override
	public List<Appointment> findNotProcessedByPatientJmbg(String jmbg) {
		this.patientService.findByJmbg(jmbg);
		return appointmentRepository.findByPatientJmbg(jmbg);
	}
}
