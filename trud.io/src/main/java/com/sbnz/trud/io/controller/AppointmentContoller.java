package com.sbnz.trud.io.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sbnz.trud.io.apiContracts.request.UpdateAppointment;
import com.sbnz.trud.io.apiContracts.response.AppointmentInformations;
import com.sbnz.trud.io.mapper.AppointmentMapper;
import com.sbnz.trud.io.model.Appointment;
import com.sbnz.trud.io.model.Pregnancy;
import com.sbnz.trud.io.service.contracts.IAppointmentService;
import com.sbnz.trud.io.service.contracts.IPregnancyService;

@CrossOrigin
@RestController
@RequestMapping(value="/api/v1/appointment")
public class AppointmentContoller {
    private IAppointmentService appointmentService;
    private IPregnancyService pregnancyService;
    private AppointmentMapper appointmentMapper;
    
    @Autowired
    public AppointmentContoller(IAppointmentService appointmentService,
    		IPregnancyService pregnancyService,
    		AppointmentMapper appointmentMapper) {
    	this.appointmentService = appointmentService;
    	this.pregnancyService = pregnancyService;
    	this.appointmentMapper = appointmentMapper;
    }
    
    @PostMapping("/{pregnancyId}")
    public ResponseEntity<?> createNewAppointment(@PathVariable Integer pregnancyId) throws Exception {
    	Pregnancy pregnancy = pregnancyService.findById(pregnancyId);
    	this.appointmentService.create(new Appointment(pregnancy));
    	return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @GetMapping("/not-processed")
    public ResponseEntity<?> findNotProcessed() {
    	List<Appointment> appointments = appointmentService.findNotDoneAppointments();
    	
    	List<AppointmentInformations> appointmetsInformations = new ArrayList<AppointmentInformations>();
    	appointments.forEach(appointment -> appointmetsInformations.add(appointmentMapper.fromAppointmentToAppointmentInfromations(appointment)));
    	
    	return new ResponseEntity<>(appointmetsInformations, HttpStatus.OK);
    }
    
    @GetMapping("/not-processed/by-patient/{jmbg}")
    public ResponseEntity<?> findNotProcessedByPatient(@PathVariable String jmbg) {
    	List<Appointment> appointments = appointmentService.findNotProcessedByPatientJmbg(jmbg);
    	
    	List<AppointmentInformations> appointmetsInformations = new ArrayList<AppointmentInformations>();
    	appointments.forEach(appointment -> appointmetsInformations.add(appointmentMapper.fromAppointmentToAppointmentInfromations(appointment)));
    	
    	return new ResponseEntity<>(appointmetsInformations, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> findAppointment(@PathVariable Integer id) {
    	return new ResponseEntity<>(appointmentMapper.fromAppointmentToAppointmentInfromations(appointmentService.findById(id)), HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAppointment(@RequestBody UpdateAppointment updateAppointment, @PathVariable Integer id) throws Exception {
    	Appointment appointment = appointmentMapper.fromUpdateAppointmentToAppointment(updateAppointment);
    	return new ResponseEntity<>(appointmentMapper.fromAppointmentToAppointmentInfromations(appointmentService.update(appointment, id)), HttpStatus.OK);
    }
}
