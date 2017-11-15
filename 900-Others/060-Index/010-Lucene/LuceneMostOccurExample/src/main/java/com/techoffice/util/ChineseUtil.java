package com.techoffice.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class ChineseUtil {
	private static int chineseStart = Integer.parseInt(String.valueOf(0x4E00));
	private static int chineseEnd = Integer.parseInt(String.valueOf(0x9FA5));
	
	public static List<String> getChineseContentList(List<String> contentList) {
		List<String> chineseContentList = new ArrayList<String>();
		for (String content: contentList){
			StringBuilder stringBuilder = new StringBuilder();
			for (int i=0 ; i<content.length(); i++){
				String str = content.substring(i, i+1);
				if (ChineseUtil.isChineseStr(str)){
					stringBuilder.append(str);
				}
			}
			chineseContentList.add(stringBuilder.toString());
		}
		return chineseContentList;
	}
	
	public static boolean isChineseStr(String str){
		int strInt = Integer.parseInt(String.valueOf(Character.codePointAt(str, 0)));
		if(strInt >= chineseStart && strInt <= chineseEnd ){
			return true;
		}
		return false;
	}
	

}
