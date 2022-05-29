package com.sbnz.trud.io.service.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbnz.trud.io.exeption.MissingEntityException;
import com.sbnz.trud.io.model.OgttTest;
import com.sbnz.trud.io.model.Patient;
import com.sbnz.trud.io.repository.OgttTestRepository;
import com.sbnz.trud.io.repository.PatientRepository;
import com.sbnz.trud.io.service.contracts.IOgttTestService;
import com.sbnz.trud.io.service.contracts.IPatientService;

@Service
public class OgttTestService extends GenericService<OgttTest> implements IOgttTestService {
    private OgttTestRepository ogttTestRepository;
    
    @Autowired
    public OgttTestService(OgttTestRepository ogttTestRepository) {
    	this.ogttTestRepository = ogttTestRepository;
    }
}
