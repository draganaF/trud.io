package com.sbnz.trud.io.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sbnz.trud.io.apiContracts.request.CreateBirth;
import com.sbnz.trud.io.apiContracts.request.CreatePregnancy;
import com.sbnz.trud.io.apiContracts.response.ViewPregnancy;
import com.sbnz.trud.io.mapper.BirthMapper;
import com.sbnz.trud.io.mapper.PregnancyMapper;
import com.sbnz.trud.io.model.Birth;
import com.sbnz.trud.io.model.Patient;
import com.sbnz.trud.io.model.Pregnancy;
import com.sbnz.trud.io.service.contracts.IBirthService;
import com.sbnz.trud.io.service.contracts.IPatientService;
import com.sbnz.trud.io.service.contracts.IPregnancyService;


@CrossOrigin
@RestController
@RequestMapping(value="/api/v1/pregnancy")
public class PregnancyController {
    private IPregnancyService pregnancyService;
    private IBirthService birthService;
    private IPatientService patientService;
    private PregnancyMapper pregnancyMapper;
    private BirthMapper birthMapper;
    
    
    @Autowired
    public PregnancyController(IPregnancyService pregnancyService,
    		IPatientService patientService,
    		PregnancyMapper pregnancyMapper,
    		IBirthService birthService,
    		BirthMapper birthMapper) {
    	this.pregnancyService = pregnancyService;
    	this.patientService = patientService;
    	this.pregnancyMapper = pregnancyMapper;
    	this.birthService = birthService;
    	this.birthMapper = birthMapper;
    }
    
    @PostMapping("")
    public ResponseEntity<?> createNewPregnancy(@RequestBody CreatePregnancy createPregnancy) throws Exception {
    	Pregnancy pregnancy = pregnancyMapper.createPragnancyToPragnancy(createPregnancy);
    	return new ResponseEntity<>(pregnancyService.create(pregnancy), HttpStatus.CREATED);
    }
    
    @PostMapping("/birth")
    public ResponseEntity<?> addBirth(@RequestBody CreateBirth createBirth) throws Exception {
    	Pregnancy pregnancy = pregnancyService.findById(createBirth.getPregnancyId());
    	
    	Birth birth = birthMapper.createBirthToBirth(createBirth);
    	birth = birthService.create(birth);
    	
    	Patient patient = pregnancy.getPatient();

    	patientService.checkAndUpdateMiscarriage(patient, birth);
    	
    	pregnancy.setBirth(birth);
    	
    	return new ResponseEntity<>(pregnancyService.update(pregnancy), HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePregnancy(@PathVariable Integer id) throws Exception {
    	pregnancyService.delete(id);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping("/symptoms/{id}")
    public ResponseEntity<?> addNewSymptoms(@PathVariable Integer id, @RequestBody ArrayList<String> symptoms) {
    	pregnancyService.deleteSymptom(id, symptoms);
    	return new ResponseEntity<>(pregnancyMapper.pregnancyToUpdatePregnancy(pregnancyService.addSymptom(id, symptoms)), HttpStatus.OK);
    }
    
    @GetMapping("/backward")
    public ResponseEntity<?> testBackward() {
    	this.pregnancyService.testBackward();
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getPregnancy(@PathVariable Integer id) throws Exception {
    	Pregnancy pregnancy = pregnancyService.findById(id);
    	return new ResponseEntity<>(pregnancyMapper.pregnancyToViewPregnancy(pregnancy), HttpStatus.OK);
    }
    
    @GetMapping("")
    public ResponseEntity<?> getActivePregnancies() throws Exception {
    	List<ViewPregnancy> viewPregnancies = new ArrayList<>();
    	pregnancyService.findActivePregnancies().forEach(pregnancy -> viewPregnancies.add(pregnancyMapper.pregnancyToViewPregnancy(pregnancy)));
    	return new ResponseEntity<>(viewPregnancies, HttpStatus.OK);
    }
    
    @GetMapping("/with-birth")
    public ResponseEntity<?> getPregnanciesWithBirths() throws Exception {
    	List<ViewPregnancy> viewPregnancies = new ArrayList<>();
    	pregnancyService.findPregnanciesWithBirths().forEach(pregnancy -> viewPregnancies.add(pregnancyMapper.pregnancyToViewPregnancy(pregnancy)));
    	return new ResponseEntity<>(viewPregnancies, HttpStatus.OK);
    }
}
