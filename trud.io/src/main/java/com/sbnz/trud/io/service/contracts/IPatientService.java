package com.sbnz.trud.io.service.contracts;

import com.sbnz.trud.io.model.Patient;

public interface IPatientService extends IGenericService<Patient> {
    Patient findByJmbg(String jmbg);
}
