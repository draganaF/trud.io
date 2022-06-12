package com.sbnz.trud.io.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sbnz.trud.io.apiContracts.request.CreateOgtt;
import com.sbnz.trud.io.mapper.OgttMapper;
import com.sbnz.trud.io.model.OgttTest;
import com.sbnz.trud.io.service.contracts.IGestationalDiabetesService;
import com.sbnz.trud.io.service.contracts.IOgttTestService;
import com.sbnz.trud.io.service.contracts.IPregnancyService;


@CrossOrigin
@RestController
@RequestMapping(value="/api/v1/ogtt-test")
public class OgttTestController {
	private IGestationalDiabetesService diabetesService;
	private IOgttTestService ogttService;
	private IPregnancyService pregnancyService;
    private OgttMapper ogttMapper;
    
    @Autowired
    public OgttTestController(IGestationalDiabetesService diabetesService,IOgttTestService ogttService, IPregnancyService pregnancyService, OgttMapper ogttMapper) {
    	this.diabetesService = diabetesService;
    	this.ogttService = ogttService;
    	this.pregnancyService = pregnancyService;
    	this.ogttMapper = ogttMapper;
    }
    
    @GetMapping("")
    public ResponseEntity<?> createNewOgttTest() throws Exception {
    	diabetesService.earlyOgttTest(new OgttTest());
    	return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<?> getOgttTest(@PathVariable int id) {
    	return new ResponseEntity<>(ogttService.findById(id), HttpStatus.OK);
    }
    @GetMapping("patient/{pregnancyId}")
    public ResponseEntity<?> getTestsForPatient(@PathVariable int pregnancyId) throws Exception{
    	return new ResponseEntity<>(ogttMapper.pregnancyToOgttWithPregnancy(pregnancyService.findById(pregnancyId)), HttpStatus.OK);
    }
    
    @GetMapping("/all")
    public ResponseEntity<?> getTestsForDoctor() throws Exception{
    	return new ResponseEntity<>(ogttMapper.pregnanciesToOgttWithPregnancies(pregnancyService.findAll()), HttpStatus.OK);
    }
    
    @PostMapping("/{pregnancyId}/{id}")
    public ResponseEntity<?> createOgttTest(@RequestBody CreateOgtt createTest, @PathVariable int pregnancyId, @PathVariable int id) throws Exception {
    	OgttTest test = ogttMapper.createOgttToOgttTest(createTest);
    	test.setId(id);
    	return new ResponseEntity<>(diabetesService.diagnoseDiabetes(test, pregnancyId), HttpStatus.OK);
    }
    
    @PostMapping("/{pregnancyId}/extendedOgtt/{id}")
    public ResponseEntity<?> updateOgttTest(@RequestBody CreateOgtt createTest, @PathVariable int pregnancyId, @PathVariable int id) {
    	OgttTest test = ogttMapper.createOgttToOgttTest(createTest);
    	test.setId(id);
    	
    	return new ResponseEntity<>(diabetesService.diagnoseDiabetes(test, pregnancyId), HttpStatus.OK);
    }
}
