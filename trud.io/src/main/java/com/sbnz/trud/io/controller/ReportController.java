package com.sbnz.trud.io.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sbnz.trud.io.dto.CTGChartReport;
import com.sbnz.trud.io.dto.CTGResultReport;
import com.sbnz.trud.io.dto.ChromosomalDisorderReport;
import com.sbnz.trud.io.dto.IllnessesReport;
import com.sbnz.trud.io.dto.SymptomsReport;
import com.sbnz.trud.io.model.CTGStatus;
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
    public ResponseEntity<?> symptomsReport(@RequestParam List<Symptom> symptoms) throws Exception {
//    	List<Symptom> symptomsEnums = new ArrayList<Symptom>();
//    	symptoms.forEach(symptom -> symptomsEnums.add(Symptom.values()[symptom]));
    	return new ResponseEntity<>(this.reportService.calculateSymptomsReport(new SymptomsReport(symptoms)), HttpStatus.OK);
    }
    
    @GetMapping("/disorders-report")
    public ResponseEntity<?> disorderReport(@RequestParam ChromosomalDisorders chromosomalDisorder) throws Exception {
    	return new ResponseEntity<>(this.reportService.calculateChromosomalDisorderReport(new ChromosomalDisorderReport(chromosomalDisorder)), HttpStatus.OK);
    }
    
    @GetMapping("/illnesses-report")
    public ResponseEntity<?> illnessesReport(@RequestParam List<String> illnessesNames) throws Exception {
    	return new ResponseEntity<>(this.reportService.calculateIllnessesReport(new IllnessesReport(illnessesNames)), HttpStatus.OK);
    }
   
    @GetMapping("/ctg-result-report")
    public ResponseEntity<?> ctgStatusReport(@RequestParam CTGStatus status) throws Exception {
    	return new ResponseEntity<>(this.reportService.calculateCTGResultReport(new CTGResultReport(status)), HttpStatus.OK);
    }
    
	@GetMapping("/ctg-chart")
    public ResponseEntity<?> ctgChartReport() throws Exception {
    	CTGResultReport abnormal = this.reportService.calculateCTGResultReport(new CTGResultReport(CTGStatus.ABNORMAL));
    	CTGResultReport nonreassuring = this.reportService.calculateCTGResultReport(new CTGResultReport(CTGStatus.NON_REASSURING));
    	CTGResultReport normal = this.reportService.calculateCTGResultReport(new CTGResultReport(CTGStatus.REASSURING));
    	List<CTGChartReport> chartlist = new ArrayList<CTGChartReport>();
    	chartlist.add(new CTGChartReport(abnormal.getNumberOfCtgs(), abnormal.getStatus()));
    	chartlist.add(new CTGChartReport(nonreassuring.getNumberOfCtgs(), nonreassuring.getStatus()));
    	chartlist.add(new CTGChartReport(normal.getNumberOfCtgs(), normal.getStatus()));

		return new ResponseEntity<>(chartlist, HttpStatus.OK);
    }
}
