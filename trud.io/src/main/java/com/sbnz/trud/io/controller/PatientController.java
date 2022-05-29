package com.sbnz.trud.io.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbnz.trud.io.apiContracts.request.CreatePatient;
import com.sbnz.trud.io.mapper.PatientMapper;
import com.sbnz.trud.io.model.Patient;
import com.sbnz.trud.io.service.contracts.IPatientService;

@CrossOrigin
@RestController
@RequestMapping(value="/api/v1/patient")
public class PatientController {

	private IPatientService patientService;
	private PatientMapper patientMapper;
	
	@Autowired
	public PatientController(
			IPatientService patientService,
			PatientMapper patientMapper) 
	{
		this.patientService = patientService;
		this.patientMapper = patientMapper;
	}
	
	@PostMapping("")
    public ResponseEntity<?> createNewPatient(@RequestBody CreatePatient createPatient) throws Exception {
    	Patient patient = patientMapper.createPatientToPatient(createPatient);
    	return new ResponseEntity<>(patientService.create(patient), HttpStatus.CREATED);
    }
}
