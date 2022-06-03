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

import com.sbnz.trud.io.apiContracts.request.CreateTripleTest;
import com.sbnz.trud.io.mapper.TripleTestMapper;
import com.sbnz.trud.io.model.TripleTest;
import com.sbnz.trud.io.service.contracts.ITripleTestService;

@CrossOrigin
@RestController
@RequestMapping(value="/api/v1/triple-test")
public class TripleTestController {
	private TripleTestMapper tripleTestMapper;
	private ITripleTestService tripleTestService;
	
	 @Autowired
	    public TripleTestController(ITripleTestService tripleTestService,
	    		TripleTestMapper tripleTestMapper) {
	    	this.tripleTestService = tripleTestService;
	    	this.tripleTestMapper = tripleTestMapper;
	    }
	    
	
	 @PostMapping("/{id}")
	    public ResponseEntity<?> createNewTripleTest(@PathVariable Integer id, @RequestBody CreateTripleTest createTripleTest) throws Exception {
	    	TripleTest tripleTest = tripleTestMapper.createTripleTestToTripleTest(createTripleTest);
	    	return new ResponseEntity<>(tripleTestService.addTripleTest(id, tripleTest), HttpStatus.CREATED);
	    }

}
