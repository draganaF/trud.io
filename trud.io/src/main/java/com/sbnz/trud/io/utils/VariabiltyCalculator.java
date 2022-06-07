package com.sbnz.trud.io.utils;

import java.util.ArrayList;
import java.lang.Math;

import com.sbnz.trud.io.event.FetalHeartRateEvent;

public class VariabiltyCalculator {

	public static double calculateVariability(ArrayList<FetalHeartRateEvent> fetalHartRates) {
		double averageBpm = 0;
		int n = fetalHartRates.size();
		for(int i = 1; i < n; i++) {
			averageBpm += Math.abs((fetalHartRates.get(i-1).getValue() - fetalHartRates.get(i).getValue()));
		}
		
		return averageBpm/n;
	}
}
