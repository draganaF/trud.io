package com.sbnz.trud.io.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbnz.trud.io.apiContracts.request.FetalHartRateValue;
import com.sbnz.trud.io.service.contracts.ICTGService;

@CrossOrigin
@RestController
@RequestMapping(value="/api/v1/ctg")
public class CTGController {

	private ICTGService ctgService;
	
	@Autowired
	public CTGController(ICTGService ctgService) {
		this.ctgService = ctgService;
	}
	
	@PostMapping("/{pregnancyId}")
	public ResponseEntity<?> hartRateMonitoring(@RequestBody FetalHartRateValue fhr, @PathVariable int pregnancyId) throws Exception {
		ctgService.monitorCtg(pregnancyId, fhr.getBpm(), fhr.getTimestamp());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/endCtg/{pregnancyId}")
	public ResponseEntity<?> stopCtg(@PathVariable int pregnancyId) throws Exception {
		return new ResponseEntity<>(ctgService.endCtg(pregnancyId), HttpStatus.OK);
	}
}
