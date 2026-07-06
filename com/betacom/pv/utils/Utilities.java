package com.betacom.pv.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

import com.betacom.pv.exceptions.AcademyException;


public class Utilities {
	private final static String PATTERN_DATE_1 = "dd/MM/yyyy";
	/*
	 * transform date to format string
	 */
		
	public static LocalDate stringToDate(String myDate) throws AcademyException{
		LocalDate r = null;
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN_DATE_1, Locale.ITALIAN);
			r=  LocalDate.parse(myDate, formatter);
			
		} catch (DateTimeParseException e) {
			throw new AcademyException("Formato della data invalido:" + myDate + " formato previsto:" + PATTERN_DATE_1);
		}
		return r;
	}
	
	

}
