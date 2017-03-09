package com.techoffice.util;

public class SpecialStringUtil {
	
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
	
	public static String removeSpecialCharacter(String str){
		String newStr = removeQuestionMark(str);
		newStr = replaceNewLineToSpace(newStr);
		newStr = doubleSpaceToSingle(newStr);
		return newStr;
	}
	
	public static String removeQuestionMark(String str){
		String newStr = str.replace("?", " ");
		return newStr;
	}
	
}
