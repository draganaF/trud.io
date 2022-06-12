package com.sbnz.trud.io.controller;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sbnz.trud.io.model.DailyGlucoseLevel;
import com.sbnz.trud.io.service.contracts.IGestationalDiabetesService;


@CrossOrigin
@RestController
@RequestMapping(value="/api/v1/glucose-levels")
public class DailyGlucoseLevelController {
	
	private IGestationalDiabetesService diabetesService;
	
	@Autowired
	public DailyGlucoseLevelController(IGestationalDiabetesService diabetesService) {
		this.diabetesService = diabetesService;
	}
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		return new ResponseEntity<>(diabetesService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/patients-level/{pregnancyId}")
	public ResponseEntity<?> getPatients(@PathVariable int pregnancyId){
		return new ResponseEntity<>(diabetesService.findPatients(pregnancyId), HttpStatus.OK);
	}
	
	@PostMapping("{pregnancyId}")
	public ResponseEntity<?> createDailyGlucoseLevel(@RequestBody DailyGlucoseLevel glucoseLevel, @PathVariable int pregnancyId) {
		glucoseLevel.setDate(LocalDate.now());
		return new ResponseEntity<>(diabetesService.setTherapy(glucoseLevel, pregnancyId), HttpStatus.OK);
	}
}
