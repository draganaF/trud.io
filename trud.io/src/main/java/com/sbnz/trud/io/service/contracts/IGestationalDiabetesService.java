package com.sbnz.trud.io.service.contracts;

import java.util.List;

import com.sbnz.trud.io.model.DailyGlucoseLevel;
import com.sbnz.trud.io.model.OgttTest;
import com.sbnz.trud.io.model.Pregnancy;

public interface IGestationalDiabetesService {
	List<DailyGlucoseLevel> findAll();

	List<DailyGlucoseLevel> findPatients(int pregnancyId);

	OgttTest earlyOgttTest(OgttTest test) throws Exception;

	OgttTest diagnoseDiabetes(OgttTest test, int pregnancyId);

	Pregnancy setTherapy(DailyGlucoseLevel glucoseLevel, int pregnancyId);

}
