package com.techoffice.generator.util;

import com.google.common.base.CaseFormat;

public class StringUtil {

	public static String lowerCamelcaseToUpperUnderscore(String str){
		return CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, str);
	}
}
