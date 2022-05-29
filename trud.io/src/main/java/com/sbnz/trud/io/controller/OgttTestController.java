package com.sbnz.trud.io.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sbnz.trud.io.model.OgttTest;
import com.sbnz.trud.io.service.contracts.IOgttTestService;


@CrossOrigin
@RestController
@RequestMapping(value="/api/v1/ogtt-test")
public class OgttTestController {
    private IOgttTestService ogttTestService;
    
    @Autowired
    public OgttTestController(IOgttTestService ogttTestService) {
    	this.ogttTestService = ogttTestService;
    }
    
    @GetMapping("")
    public ResponseEntity<?> createNewPregnancy() throws Exception {
    	ogttTestService.create(new OgttTest());
    	return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
