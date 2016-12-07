package com.ittechoffice.example.helper;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class DateTimeHelper {
	private static SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static String parseInt(int integer){
		Date date = new Date(integer * 1000L);
		String dateStr = dateFormatter.format(date);
		return dateStr;
	}
}
