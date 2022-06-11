package com.sbnz.trud.io.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbnz.trud.io.apiContracts.request.CreateBirth;
import com.sbnz.trud.io.apiContracts.response.ViewBirth;
import com.sbnz.trud.io.mapper.BirthMapper;
import com.sbnz.trud.io.model.Birth;
import com.sbnz.trud.io.service.contracts.IBirthService;

@CrossOrigin
@RestController
@RequestMapping(value="/api/v1/birth")
public class BirthController {

	private IBirthService birthService;
	private BirthMapper birthMapper;
	
	 @Autowired
	 public BirthController(IBirthService birthService, BirthMapper birthMapper) {
	    	this.birthService = birthService;
	    	this.birthMapper = birthMapper;
	}
	 @PostMapping("")
	    public ResponseEntity<?> createBirth(@RequestBody CreateBirth createBirth) throws Exception {
		 	Birth birth = birthMapper.createBirthToBirth(createBirth);
	    	return new ResponseEntity<>(birthService.create(birth, createBirth.getPregnancyId()), HttpStatus.OK);
	    }
	 
	 @PutMapping("/abortion/{id}")
	    public ResponseEntity<?> abortion(@PathVariable Integer id) throws Exception {
		 	birthService.abortion(id);
	    	return new ResponseEntity<>(HttpStatus.OK);
	    }
	 
	 @GetMapping("")
	    public ResponseEntity<?> getAllBirths() throws Exception {
		 ArrayList<ViewBirth> births = new ArrayList<ViewBirth>();
		 birthService.findAll().forEach(birth -> births.add(birthMapper.birthToViewBirth(birth)));
	    return new ResponseEntity<>(births, HttpStatus.OK);
	    }
}
