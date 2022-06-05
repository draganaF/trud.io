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

import com.sbnz.trud.io.apiContracts.request.CreateDoubleTest;
import com.sbnz.trud.io.apiContracts.request.TemplateTestRule;
import com.sbnz.trud.io.mapper.DoubleTestMapper;
import com.sbnz.trud.io.model.DoubleTest;
import com.sbnz.trud.io.service.contracts.IDoubleTestService;

@CrossOrigin
@RestController
@RequestMapping(value="/api/v1/double-test")
public class DoubleTestController {
	private DoubleTestMapper doubleTestMapper;
	private IDoubleTestService doubleTestService;
	
	 @Autowired
	 public DoubleTestController(IDoubleTestService doubleTestService,
	    		DoubleTestMapper doubleTestMapper) {
	    	this.doubleTestService = doubleTestService;
	    	this.doubleTestMapper = doubleTestMapper;
	 }
	    
	
	 @PostMapping("/{id}")
	  public ResponseEntity<?> createNewDoubleTest(@PathVariable Integer id, @RequestBody CreateDoubleTest createDoubleTest) throws Exception {
	    	DoubleTest doubleTest = doubleTestMapper.createDoubleTestToDoubleTest(createDoubleTest);
	    	return new ResponseEntity<>(doubleTestService.addDoubleTest(id, doubleTest), HttpStatus.CREATED);
	  }
	 
	 @PostMapping("/template")
	  public ResponseEntity<?> createNewDoubleTest(@RequestBody TemplateTestRule doubleTestRule) throws Exception {
	    	doubleTestService.template(doubleTestRule);
	    	return new ResponseEntity<>( HttpStatus.OK);
	  }
	 
}
