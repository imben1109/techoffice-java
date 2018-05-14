package com.techoffice.database.dao.util;

import com.google.common.base.CaseFormat;

public class StringUtil {

	private StringUtil(){}
	
	public static String upperUnderscoreToLowerCamel(String str){
		return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, str);
	}

	public static String upperUnderscoreToUpperCamel(String str){
		return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, str);
	}

	public static String upperCamelToUpperUnderscore(String str){
		return CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, str);
	}
	
	public static String lowerCamelToUpperUnderscore(String str){
		return CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, str);
	}
}
