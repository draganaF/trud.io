package com.sbnz.trud.io.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sbnz.trud.io.apiContracts.request.CreatePregnancy;
import com.sbnz.trud.io.mapper.PregnancyMapper;
import com.sbnz.trud.io.model.Pregnancy;
import com.sbnz.trud.io.service.contracts.IPregnancyService;


@CrossOrigin
@RestController
@RequestMapping(value="/api/v1/pregnancy")
public class PregnancyController {
    private IPregnancyService pregnancyService;
    private PregnancyMapper pregnancyMapper;
    
    @Autowired
    public PregnancyController(IPregnancyService pregnancyService,
    		PregnancyMapper pregnancyMapper) {
    	this.pregnancyService = pregnancyService;
    	this.pregnancyMapper = pregnancyMapper;
    }
    
    @PostMapping("")
    public ResponseEntity<?> createNewPregnancy(@RequestBody CreatePregnancy createPregnancy) throws Exception {
    	Pregnancy pregnancy = pregnancyMapper.createPragnancyToPragnancy(createPregnancy);
    	return new ResponseEntity<>(pregnancyService.create(pregnancy), HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePregnancy(@PathVariable Integer id) throws Exception {
    	pregnancyService.delete(id);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping("/symptoms/{id}")
    public ResponseEntity<?> addNewSymptoms(@PathVariable Integer id, @RequestBody ArrayList<Integer> symptoms) {
    	return new ResponseEntity<>(pregnancyMapper.pregnancyToUpdatePregnancy(pregnancyService.addSymptom(id, symptoms)), HttpStatus.OK);
    }
    
}
