package com.sbnz.trud.io.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sbnz.trud.io.dto.ChromosomalDisorderReport;
import com.sbnz.trud.io.dto.IllnessesReport;
import com.sbnz.trud.io.dto.SymptomsReport;
import com.sbnz.trud.io.model.ChromosomalDisorders;
import com.sbnz.trud.io.model.Symptom;
import com.sbnz.trud.io.service.contracts.IReportService;


@CrossOrigin
@RestController
@RequestMapping(value="/api/v1/report")
public class ReportController {
    private IReportService reportService;
    
    
    @Autowired
    public ReportController(IReportService reportService) {
    	this.reportService = reportService;
    }
    
    @GetMapping("/symptoms-report")
    public ResponseEntity<?> symptomsReport(@RequestParam List<Integer> symptoms) throws Exception {
    	List<Symptom> symptomsEnums = new ArrayList<Symptom>();
//    	symptoms.forEach(symptom -> symptomsEnums.add(Symptom.values()[symptom]));
    	return new ResponseEntity<>(this.reportService.calculateSymptomsReport(new SymptomsReport(symptomsEnums)), HttpStatus.OK);
    }
    
    @GetMapping("/disorders-report")
    public ResponseEntity<?> disorderReport(@RequestParam ChromosomalDisorders chromosomalDisorder) throws Exception {
    	return new ResponseEntity<>(this.reportService.calculateChromosomalDisorderReport(new ChromosomalDisorderReport(chromosomalDisorder)), HttpStatus.OK);
    }
    
    @GetMapping("/illnesses-report")
    public ResponseEntity<?> illnessesReport(@RequestParam List<String> illnessesNames) throws Exception {
    	return new ResponseEntity<>(this.reportService.calculateIllnessesReport(new IllnessesReport(illnessesNames)), HttpStatus.OK);
    }
}
