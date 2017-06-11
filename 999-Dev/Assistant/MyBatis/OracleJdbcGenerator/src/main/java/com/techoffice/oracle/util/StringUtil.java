package com.techoffice.oracle.util;

public class StringUtil {
	public static String convertFirstCharToLowerCase(String str){
		String firstChar = str.substring(0, 1);
		String convertedStr = firstChar.toLowerCase() + str.substring(1);
		return convertedStr;
	}
}
