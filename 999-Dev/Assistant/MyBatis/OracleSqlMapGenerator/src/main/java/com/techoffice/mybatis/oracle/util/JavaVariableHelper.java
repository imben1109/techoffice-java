package com.techoffice.mybatis.oracle.util;

import com.google.common.base.CaseFormat;

public class JavaVariableHelper {
	
	public static String covert(String columnName){
		String javaVariable = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, columnName);
		return javaVariable;
	}
}
