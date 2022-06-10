package com.sbnz.trud.io.mapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbnz.trud.io.apiContracts.request.CreateOgtt;
import com.sbnz.trud.io.apiContracts.response.OgttWithPregnancy;
import com.sbnz.trud.io.model.OgttTest;
import com.sbnz.trud.io.model.Pregnancy;

@Component
public class OgttMapper {

	@Autowired
	public OgttMapper() {
		
	}
	
	public OgttTest createOgttToOgttTest(CreateOgtt createOgtt) {
		return new OgttTest(
				createOgtt.getPrimarySampling(),
				createOgtt.getFirstBloodSampling(),
				createOgtt.getSecondBloodSampling(),
				createOgtt.getThirdBloodSampling(),
				createOgtt.getFourthBloodSampling(),
				createOgtt.getResult(),
				LocalDate.now()
				);
	}
	
	public List<OgttWithPregnancy> pregnanciesToOgttWithPregnancies(List<Pregnancy> pregnancies) {
		List<OgttWithPregnancy> ogtts = new ArrayList<OgttWithPregnancy>();
		for(Pregnancy p: pregnancies) {
			List<OgttTest> tests = p.getOgttTests();
			for(OgttTest t: tests) {
				ogtts.add(new OgttWithPregnancy(
						t.getId(), 
						t.getPrimarySampling(),
						t.getFirstBloodSampling(),
						t.getSecondBloodSampling(),
						t.getThirdBloodSampling(),
						t.getFourthBloodSampling(),
						t.getResult(),
						p.getId(),
						t.getDate()));
			}
		}
		
		return ogtts;
	}
	
	public List<OgttWithPregnancy> pregnancyToOgttWithPregnancy(Pregnancy pregnancy) {
		List<OgttWithPregnancy> ogtts = new ArrayList<OgttWithPregnancy>();
		List<OgttTest> tests = pregnancy.getOgttTests();
		for(OgttTest t: tests) {
			ogtts.add(new OgttWithPregnancy(
					t.getId(), 
					t.getPrimarySampling(),
					t.getFirstBloodSampling(),
					t.getSecondBloodSampling(),
					t.getThirdBloodSampling(),
					t.getFourthBloodSampling(),
					t.getResult(),
					pregnancy.getId(),
					t.getDate()));
		}
		
		return ogtts;
	}
}
