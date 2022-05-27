package com.sbnz.trud.io.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sbnz.trud.io.model.Appointment;
import com.sbnz.trud.io.service.contracts.IAppointmentService;

@CrossOrigin
@RestController
@RequestMapping(value="/api/v1/appointment")
public class AppointmentContoller {
    private IAppointmentService appointmentService;
    
    @Autowired
    public AppointmentContoller(IAppointmentService appointmentService) {
    	this.appointmentService = appointmentService;
    }
    
    @GetMapping("")
    public ResponseEntity<?> createNewAppointment() throws Exception {
    	this.appointmentService.save(new Appointment());
    	return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
}
