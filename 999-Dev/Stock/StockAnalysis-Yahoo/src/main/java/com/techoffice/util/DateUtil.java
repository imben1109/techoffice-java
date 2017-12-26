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
	
	/**
	 * Format Date to String by specified date pattern
	 * 
	 * @param date Date to format
	 * @param pattern 
	 * @return Formatted Date
	 */
	public static String format(Date date, String pattern){
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		return dateFormat.format(date);
	}
	
	/**
	 * Check if date is Today
	 * @param date to check
	 * @return true if today, otherwise false
	 */
	public static boolean isToday(Date date){
		return DateUtils.isSameDay(date, new Date());
	}
}
