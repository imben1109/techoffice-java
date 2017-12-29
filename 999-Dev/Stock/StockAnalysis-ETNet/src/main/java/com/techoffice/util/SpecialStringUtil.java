package com.techoffice.util;

import java.util.ArrayList;
import java.util.List;

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
		newStr = replaceSpecialAuotationMark(newStr);
		newStr = newStr.trim();
		return newStr;
	}
	
	public static String removeQuestionMark(String str){
		String newStr = str.replace("?", " ");
		return newStr;
	}
	
	public static String replaceSpecialAuotationMark(String str){
		String newStr = str.replace("’", "'");
		return newStr;
	} 
	
	public static String removeIllegalXml(String xml){
		String xml10pattern = "[^"
                + "\u0009\r\n"
                + "\u0020-\uD7FF"
                + "\uE000-\uFFFD"
                + "\ud800\udc00-\udbff\udfff"
                + "]";
		xml = xml.replaceAll(xml10pattern, "");
		return xml;
	}
	
	public static String replaceNonWordCharacter(String str){
		return str.replaceAll("\\W", " ");
	}
	
	public static List<String> replaceNonWordCharacter(List<String> strList){
		List<String> list = new ArrayList<String>();
		for (String str: strList){
			String wordStr = replaceNonWordCharacter(str);
			list.add(wordStr);	
		}
		return list;
	}
}
