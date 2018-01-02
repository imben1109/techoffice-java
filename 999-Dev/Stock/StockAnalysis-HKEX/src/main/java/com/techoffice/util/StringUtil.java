package com.techoffice.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * String Utility 
 * 
 * @author Tech Office
 *
 */
public class StringUtil {

	private StringUtil(){}
	
	public static List<String> getLineList(String str){
		List<String> lineList = new ArrayList<String>();
		String[] lineArr = str.split("\\r?\\n");
		for (int i=0; i < lineArr.length; i++){
			String line = lineArr[i];
			lineList.add(line);
		}
		return lineList;
	}
	
	public static List<String> getWordList(String str){
		List<String> wordList = new ArrayList<String>();
		String[] wordArr = str.split(" ");
		for (int i=0; i<wordArr.length; i++){
			String word = wordArr[i];
			if (!StringUtils.isEmpty(word)){
				wordList.add(word);
			}
		}
		return wordList;
	}
	
	public static List<String> getSubWordList(String str, int charNum){
		List<String> list = new ArrayList<String>();
		for (int i=0; i<str.length(); i++){
			if (i + charNum < str.length()){
				String subStr = str.substring(i, i+charNum);
				list.add(subStr);
			}else {
				String subStr = str.substring(i);
				list.add(subStr);
			}
		}
		return list;
	}
	
	public static Map<String, Integer> getOccurrenceMap(String str){
		return getOccurrenceMap(str, null);
	}
	
	public static Map<String, Integer> getOccurrenceMap(String str, Integer charNum){
		Map<String, Integer> occurrenceMap = new HashMap<String, Integer>();
		List<String> lineList = getLineList(str);
		for (String line: lineList){
			List<String> wordList = getWordList(line);
			for (String word: wordList){
				if (charNum == null){
					if (occurrenceMap.get(word) == null){
						occurrenceMap.put(word, 1);
					}else {
						occurrenceMap.put(word, occurrenceMap.get(word) + 1);
					}
				}else {
					List<String> subWordList = getSubWordList(word, charNum);
					for (String subWord: subWordList){
						if (occurrenceMap.get(subWord) == null){
							occurrenceMap.put(subWord, 1);
						}else {
							occurrenceMap.put(subWord, occurrenceMap.get(subWord) + 1);
						}
					}
				}
			}
		}
		return occurrenceMap;
	}

	
	public static Map<String, Integer> getOccurrenceMap(List<String> lineList){
		return getOccurrenceMap(lineList, null);
	}
	
	public static Map<String, Integer> getOccurrenceMap(List<String> lineList, Integer charNum){
		String content = StringUtils.join(lineList.iterator(), "\n");
		return MapUtil.sort(getOccurrenceMap(content, charNum));
	}
}
