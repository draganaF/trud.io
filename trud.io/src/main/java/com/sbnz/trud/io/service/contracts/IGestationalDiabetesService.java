package com.sbnz.trud.io.service.contracts;

import com.sbnz.trud.io.model.DailyGlucoseLevel;
import com.sbnz.trud.io.model.OgttTest;
import com.sbnz.trud.io.model.Pregnancy;

public interface IGestationalDiabetesService {

	OgttTest earlyOgttTest(OgttTest test) throws Exception;

	OgttTest diagnoseDiabetes(OgttTest test, int pregnancyId);

	Pregnancy setTherapy(DailyGlucoseLevel glucoseLevel, int pregnancyId);

}
