package com.sbnz.trud.io.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sbnz.trud.io.apiContracts.request.CreateOgtt;
import com.sbnz.trud.io.mapper.OgttMapper;
import com.sbnz.trud.io.model.OgttTest;
import com.sbnz.trud.io.service.contracts.IOgttTestService;


@CrossOrigin
@RestController
@RequestMapping(value="/api/v1/ogtt-test")
public class OgttTestController {
    private IOgttTestService ogttTestService;
    private OgttMapper ogttMapper;
    
    @Autowired
    public OgttTestController(IOgttTestService ogttTestService, OgttMapper ogttMapper) {
    	this.ogttTestService = ogttTestService;
    	this.ogttMapper = ogttMapper;
    }
    
    @GetMapping("")
    public ResponseEntity<?> createNewOgttTest() throws Exception {
    	ogttTestService.create(new OgttTest());
    	return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @PostMapping("{id}")
    public ResponseEntity<?> createOgttTest(@RequestBody CreateOgtt createTest, @PathVariable int id) throws Exception {
    	OgttTest test = ogttMapper.createOgttToOgttTest(createTest);
      test.setId(id);
      
    	return new ResponseEntity<>(ogttTestService.update(test), HttpStatus.CREATED);
    }
    
    @PostMapping("extdendedOgtt/{id}")
    public ResponseEntity<?> updateOgttTest(@RequestBody CreateOgtt createTest, @PathVariable int id) {
    	OgttTest test = ogttMapper.createOgttToOgttTest(createTest);
    	test.setId(id);
    	
    	return new ResponseEntity<>(ogttTestService.update(test), HttpStatus.OK);
    }
}
