package com.techoffice.util;

import java.util.ArrayList;
import java.util.List;

public class ConsecutiveUppercaseStringUtil {

	private ConsecutiveUppercaseStringUtil(){}
	
	public static List<String> getConsecutiveUppercaseStrList(String str){
		List<String> list = new ArrayList<String>();
		StringBuilder builder = new StringBuilder();
		
		char[] cArr = str.toCharArray();
		boolean isPreviousCharUppercase = false;
		for (int i=0; i<cArr.length; i++){
			char c = cArr[i];
			if (isPreviousCharUppercase){
				if (Character.isUpperCase(c)){
					builder.append(c);
				}else {
					if (builder.length() > 1){
						list.add(builder.toString());
					}
					builder = new StringBuilder();
					isPreviousCharUppercase = false;
				}
			}else {
				if (Character.isUpperCase(c)){
					builder.append(c);
					isPreviousCharUppercase = true;
				}else {
					isPreviousCharUppercase = false;
				}
			}
		}
		return list;
	} 
	
}
