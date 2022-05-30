package com.sbnz.trud.io.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    
    @Autowired
    public AppointmentContoller(IAppointmentService appointmentService,
    		IPregnancyService pregnancyService) {
    	this.appointmentService = appointmentService;
    	this.pregnancyService = pregnancyService;
    }
    
    @GetMapping("/{pregnancyId}")
    public ResponseEntity<?> createNewAppointment(@PathVariable Integer pregnancyId) throws Exception {
    	Pregnancy pregnancy = pregnancyService.findById(pregnancyId);
    	this.appointmentService.create(new Appointment(pregnancy));
    	return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
}
