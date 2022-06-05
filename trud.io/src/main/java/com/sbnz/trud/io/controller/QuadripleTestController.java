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

import com.sbnz.trud.io.apiContracts.request.CreateQuadripleTest;
import com.sbnz.trud.io.mapper.QuadripleTestMapper;
import com.sbnz.trud.io.model.QuadripleTest;
import com.sbnz.trud.io.service.contracts.IQuadripleTestService;

@CrossOrigin
@RestController
@RequestMapping(value="/api/v1/quadriple-test")
public class QuadripleTestController {
	private QuadripleTestMapper quadripleTestMapper;
	private IQuadripleTestService quadripleTestService;
	
	 @Autowired
	    public QuadripleTestController(IQuadripleTestService quadripleTestService,
	    		QuadripleTestMapper quadripleTestMapper) {
	    	this.quadripleTestService = quadripleTestService;
	    	this.quadripleTestMapper = quadripleTestMapper;
	    }
	    
	
	 @PostMapping("/{id}")
	    public ResponseEntity<?> createNewQuadripleTest(@PathVariable Integer id, @RequestBody CreateQuadripleTest createQuadripleTest) throws Exception {
	    	QuadripleTest quadripleTest = quadripleTestMapper.createQuadripleTestToQuadripleTest(createQuadripleTest);
	    	return new ResponseEntity<>(quadripleTestService.addQuadripleTest(id, quadripleTest), HttpStatus.CREATED);
	    }

}
