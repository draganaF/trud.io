package com.sbnz.trud.io.service.contracts;

import java.util.List;

import com.sbnz.trud.io.model.Birth;
import com.sbnz.trud.io.model.Patient;

public interface IPatientService extends IGenericService<Patient> {
    Patient findByJmbg(String jmbg);
	Patient update(Patient patient);
	Patient checkAndUpdateMiscarriage(Patient patient, Birth birth);
	Patient findById(Integer id);
	List<Patient> findAll();
}
