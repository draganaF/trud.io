package com.sbnz.trud.io.service.contracts;

import com.sbnz.trud.io.dto.ChromosomalDisorderReport;
import com.sbnz.trud.io.dto.SymptomsReport;

public interface IReportService {
	SymptomsReport calculateSymptomsReport(SymptomsReport report) throws Exception;
	ChromosomalDisorderReport calculateChromosomalDisorderReport(ChromosomalDisorderReport chromosomalDisorderReport) throws Exception;
}
