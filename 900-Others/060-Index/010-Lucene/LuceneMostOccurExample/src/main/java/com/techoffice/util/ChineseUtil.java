package com.techoffice.util;

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
}
