package com.sbnz.trud.io.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.sbnz.trud.io.apiContracts.request.UterineContractionValue;
import com.sbnz.trud.io.apiContracts.response.ViewCTG;
import com.sbnz.trud.io.mapper.CTGMapper;
import com.sbnz.trud.io.model.CTG;
import com.sbnz.trud.io.model.Pregnancy;
import com.sbnz.trud.io.service.contracts.ICTGService;
import com.sbnz.trud.io.service.contracts.IPregnancyService;

@CrossOrigin
@RestController
@RequestMapping(value="/api/v1/ctg")
public class CTGController {

	private ICTGService ctgService;
	private IPregnancyService pregnancyService;
	private CTGMapper mapper;
	
	@Autowired
	public CTGController(ICTGService ctgService,IPregnancyService pregnancyService, CTGMapper mapper) {
		this.ctgService = ctgService;
		this.pregnancyService = pregnancyService;
		this.mapper = mapper;
	}
	@GetMapping("/all")
	public ResponseEntity<?> getAll() throws Exception {
		List<CTG> ctgs = ctgService.findAll();
		
		List<ViewCTG> viewCTGS = new ArrayList<ViewCTG>();
		
		ctgs.forEach(ctg -> viewCTGS.add(mapper.fromCTGtoViewCTG(ctg)));
		
		return new ResponseEntity<>(viewCTGS, HttpStatus.OK);
	}
	
	@GetMapping("/pregnancy-ctgs/{id}")
	public ResponseEntity<?> getPregnancyCtgs(@PathVariable int id) throws Exception {
		Pregnancy pregnancy = pregnancyService.findById(id);
		
		List<CTG> ctgs = pregnancy.getCtg();
		
		List<ViewCTG> viewCTGS = new ArrayList<ViewCTG>();
		
		ctgs.forEach(ctg -> viewCTGS.add(mapper.fromCTGtoViewCTG(ctg)));
		
		return new ResponseEntity<>(viewCTGS, HttpStatus.OK);
	}
	@GetMapping("/patient-ctgs")
	public ResponseEntity<?> getPatientsCtgs() throws Exception {
		List<CTG> ctgs = ctgService.findAll();
		
		List<ViewCTG> viewCTGS = new ArrayList<ViewCTG>();
		
		ctgs.forEach(ctg -> viewCTGS.add(mapper.fromCTGtoViewCTG(ctg)));
		
		return new ResponseEntity<>(viewCTGS, HttpStatus.OK);
	}
	
	@GetMapping("/startCtg/{pregnancyId}")
	public ResponseEntity<?> startCtg(@PathVariable int pregnancyId) throws Exception {
		ctgService.startCtg(pregnancyId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/{pregnancyId}")
	public ResponseEntity<?> hartRateMonitoring(@RequestBody FetalHartRateValue fhr, @PathVariable int pregnancyId) throws Exception {
		ctgService.monitorCtg(pregnancyId, fhr.getBpm(), fhr.getTimestamp());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/contractions/{pregnancyId}")
	public ResponseEntity<?> contractionsMonitoring(@RequestBody UterineContractionValue ucv, @PathVariable int pregnancyId) {
		ctgService.monitorMother(pregnancyId, ucv.getValue(), ucv.getTimestamp());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/endCtg/{pregnancyId}")
	public ResponseEntity<?> stopCtg(@PathVariable int pregnancyId) throws Exception {
		return new ResponseEntity<>(ctgService.endCtg(pregnancyId), HttpStatus.OK);
	}
}
