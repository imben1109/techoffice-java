package com.techoffice.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

import com.techoffice.util.exception.DateParseException;

/**
 * Date Utility 
 * 
 * @author TechOffice
 *
 */
public class DateUtil {

	private DateUtil(){
		
	}
	
	/**
	 * Parse Date and Truncate Time by specified Date String and Pattern
	 * 
	 * @param dateStr Date String to Parse
	 * @param pattern Date Pattern for Date Parsing
	 * 
	 * @return Parsed Date
	 */
	public static Date parseTruncateDate(String dateStr, String pattern){
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			Date raceDate = simpleDateFormat.parse(dateStr);
			raceDate = DateUtils.truncate(raceDate, Calendar.DATE);
			return raceDate;
		} catch (ParseException e) {
			throw new DateParseException("Fails to parse date: " + dateStr + " by pattern: " + pattern, e); 
		}
	}
	
	/**
	 * Parse Date by Rspecified Date String and Pattern
	 * 
	 * @param dateStr Date String to Parse
	 * @param pattern Date Pattern for Date Parsing
	 * 
	 * @return Parsed Date
	 */
	public static Date parseDate(String dateStr, String pattern){
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			Date raceDate = simpleDateFormat.parse(dateStr);
			return raceDate;
		} catch (ParseException e) {
			throw new DateParseException("Fails to parse date: " + dateStr + " by pattern: " + pattern, e); 
		}
	}
}
