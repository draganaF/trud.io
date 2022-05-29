package com.sbnz.trud.io.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbnz.trud.io.apiContracts.request.AddIllnessToPatient;
import com.sbnz.trud.io.apiContracts.request.CreatePatient;
import com.sbnz.trud.io.mapper.PatientMapper;
import com.sbnz.trud.io.model.Patient;
import com.sbnz.trud.io.model.Pregnancy;
import com.sbnz.trud.io.service.contracts.IPatientService;
import com.sbnz.trud.io.service.contracts.IPregnancyService;

@CrossOrigin
@RestController
@RequestMapping(value="/api/v1/patient")
public class PatientController {

	private IPatientService patientService;
	private IPregnancyService pregnancyService;
	private PatientMapper patientMapper;
	
	@Autowired
	public PatientController(
			IPatientService patientService,
			PatientMapper patientMapper,
			IPregnancyService pregnancyService) 
	{
		this.patientService = patientService;
		this.pregnancyService = pregnancyService;
		this.patientMapper = patientMapper;
	}
	
	@PostMapping("")
    public ResponseEntity<?> createNewPatient(@RequestBody CreatePatient createPatient) throws Exception {
    	Patient patient = patientMapper.createPatientToPatient(createPatient);
    	return new ResponseEntity<>(patientService.create(patient), HttpStatus.CREATED);
    }
	
	@PostMapping("/addIllness/{pregnancyId}")
	public ResponseEntity<?> addIllnessToPatient(@RequestBody AddIllnessToPatient patientIllnesses, @PathVariable Integer pregnancyId) {
		Patient patient = patientMapper.addIllnessToPatientToPatient(patientIllnesses);
		patient = patientService.update(patient);
		
		if(pregnancyId != 0) {
			Pregnancy pregnancy = pregnancyService.findById(pregnancyId);
			pregnancy.setPatient(patient);
			pregnancyService.update(pregnancy);
		}
		
		return new ResponseEntity<>(patient, HttpStatus.OK);
	}
	
	
}
