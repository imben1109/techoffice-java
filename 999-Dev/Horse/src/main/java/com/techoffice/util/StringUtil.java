package com.techoffice.util;

public class StringUtil {
	
	public static String replaceNewLineToSpace(String str){
		String newStr = str.replace("\n", " ");
		return newStr;
	}
	
	public static String doubleSpaceToSingle(String str){
		String newStr = str.replace("  ", " ");
		if (newStr.contains("  ")){
			newStr = doubleSpaceToSingle(newStr);
		}
		return newStr;
	}
	
	public static String newLineToSpaceNoDoubleSpace(String str){
		String newStr = replaceNewLineToSpace(str);
		newStr = doubleSpaceToSingle(newStr);
		return newStr;
	}
	
}
