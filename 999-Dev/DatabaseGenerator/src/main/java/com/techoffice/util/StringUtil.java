package com.techoffice.util;

import com.google.common.base.CaseFormat;

public class StringUtil {

	private StringUtil(){}
	
	public static String upperUnderscoreToLowercamel(String str){
		return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, str);
	}


}
