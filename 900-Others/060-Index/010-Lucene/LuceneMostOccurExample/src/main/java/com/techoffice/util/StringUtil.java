package com.techoffice.util;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {
	
	private StringUtil(){}
	
	public static List<String> getSubstrList(String str, int length){
		List<String> strList = new ArrayList<String>();
		for (int i=0; i<str.length()-1; i++){
			String subStr = str.substring(i, i + length);
			strList.add(subStr);
		}
		return strList;
	}


}
