package com.sbnz.trud.io.service.contracts;

import com.sbnz.trud.io.model.Birth;
import com.sbnz.trud.io.model.Patient;

public interface IPatientService extends IGenericService<Patient> {
    Patient findByJmbg(String jmbg);
	Patient update(Patient patient);
	Patient checkAndUpdateMiscarriage(Patient patient, Birth birth);
}
