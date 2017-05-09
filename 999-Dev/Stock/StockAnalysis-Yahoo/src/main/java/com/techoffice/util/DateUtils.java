package com.techoffice.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	public static boolean isToday(Date date){
		return org.apache.commons.lang3.time.DateUtils.isSameDay(date, new Date());
	}

	public static String format(Date date){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return dateFormat.format(date);
	}
	
}
