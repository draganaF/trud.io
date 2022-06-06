package com.sbnz.trud.io.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbnz.trud.io.apiContracts.request.TemplateTestRule;
import com.sbnz.trud.io.service.implementation.TemplateTestService;

@CrossOrigin
@RestController
@RequestMapping(value="/api/v1/test")
public class TestController {
	private TemplateTestService templateTestService;
	
	 @Autowired
	 public TestController(TemplateTestService templateTestService) {
	    	this.templateTestService = templateTestService;
	 }
	
	@PostMapping("/template")
	  public ResponseEntity<?> createNewTestRule(@RequestBody TemplateTestRule templateTestRule) throws Exception {
		templateTestService.template(templateTestRule);
	    	return new ResponseEntity<>( HttpStatus.OK);
	  }

}
