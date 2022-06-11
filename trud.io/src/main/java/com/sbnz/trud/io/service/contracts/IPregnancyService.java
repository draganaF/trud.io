package com.sbnz.trud.io.service.contracts;

import java.util.ArrayList;
import java.util.List;

import com.sbnz.trud.io.model.Illness;
import com.sbnz.trud.io.model.Pregnancy;
import com.sbnz.trud.io.model.Symptom;

public interface IPregnancyService extends IGenericService<Pregnancy>{

    Pregnancy create(Pregnancy entity);
    Pregnancy addSymptom(Integer id, ArrayList<String> symptoms);
	Pregnancy openKieSession(Pregnancy pregnancy);
	Pregnancy update(Pregnancy pregnancy);
	List<Pregnancy> findActivePregnancies();
	void testBackward();
	Pregnancy addSymptomsAndIllnesses(Integer pregnancyId, List<Symptom> symptoms, List<Illness> illnesses);
	void deleteSymptom(Integer id, ArrayList<String> symptoms);
	List<Pregnancy> findPregnanciesWithBirths();
} 
