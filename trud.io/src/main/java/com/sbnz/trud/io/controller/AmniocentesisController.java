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

import com.sbnz.trud.io.apiContracts.request.CreateAmniocentesis;
import com.sbnz.trud.io.mapper.AmniocentesisMapper;
import com.sbnz.trud.io.model.Amniocentesis;
import com.sbnz.trud.io.service.contracts.IAmniocentesisService;

@CrossOrigin
@RestController
@RequestMapping(value="/api/v1/amniocentesis")
public class AmniocentesisController {
	private AmniocentesisMapper amniocentesisMapper;
	private IAmniocentesisService amniocentesisService;
	
	 @Autowired
	 public AmniocentesisController(IAmniocentesisService amniocentesisService,
	    		AmniocentesisMapper amniocentesisMapper) {
	    	this.amniocentesisService = amniocentesisService;
	    	this.amniocentesisMapper = amniocentesisMapper;
	}
	    
	
	 @PostMapping("/{id}")
	 public ResponseEntity<?> createNewAmniocentesis(@PathVariable Integer id, @RequestBody CreateAmniocentesis createAmniocentesis) throws Exception {
	    	Amniocentesis amniocentesis = amniocentesisMapper.createAmniocentesisToAmniocentesis(createAmniocentesis);
	    	return new ResponseEntity<>(amniocentesisService.addAmniocentesis(id, amniocentesis), HttpStatus.CREATED);
	    }

}

