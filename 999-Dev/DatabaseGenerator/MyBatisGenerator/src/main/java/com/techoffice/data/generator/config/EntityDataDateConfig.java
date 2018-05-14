package com.techoffice.data.generator.config;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EntityDataDateConfig {

	private static final String jdbcDateFormatStr = "YYYY/MM/DD";
	private static final String javaDateFormatStr = "yyyy/MM/dd";
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat(javaDateFormatStr);
	
	private EntityDataDateConfig(){}
	
	public static String format(Date date){
		return dateFormat.format(date);
	}
	
	public static String getJavaDateFormatStr(){
		return javaDateFormatStr;
	}
	
	public static String getJdbcDateFormatStr(){
		return jdbcDateFormatStr;
	}
	
	public static String getJdbcToDateString(Date date){
		return "TO_DATE(" + format(date) + ", '" + jdbcDateFormatStr +  "')";
	}
	
}
