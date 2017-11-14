package com.techoffice.util;

import java.util.ArrayList;
import java.util.List;

public class ChineseUtil {
	private static int chineseStart = Integer.parseInt(String.valueOf(0x4E00));
	private static int chineseEnd = Integer.parseInt(String.valueOf(0x9FA5));
	
	public static boolean isChineseStr(String str){
		int strInt = Integer.parseInt(String.valueOf(Character.codePointAt(str, 0)));
		if(strInt >= chineseStart && strInt <= chineseEnd ){
			return true;
		}
		return false;
	}
	
	public static List<String> getSubstrList(String str, int length){
		List<String> strList = new ArrayList<String>();
		for (int i=0; i<str.length()-1; i++){
			String subStr = str.substring(i, i + length);
			strList.add(subStr);
		}
		return strList;
	}
}
