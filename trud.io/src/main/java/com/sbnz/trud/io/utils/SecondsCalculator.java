package com.sbnz.trud.io.utils;

import java.util.Date;

public class SecondsCalculator {

	public static int calculateSeconds(Date date1, Date date2) {
		return (int)((date1.getTime()-date2.getTime())/1000);
	}
}
