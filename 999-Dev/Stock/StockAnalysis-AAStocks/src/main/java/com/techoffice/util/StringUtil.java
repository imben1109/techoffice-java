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
	
	public static Map<String, Integer> getOccurrenceMap(String str){
		Map<String, Integer> occurrenceMap = new HashMap<String, Integer>();
		List<String> lineList = getLineList(str);
		for (String line: lineList){
			List<String> wordList = getWordList(line);
			for (String word: wordList){
				if (occurrenceMap.get(word) == null){
					occurrenceMap.put(word, 1);
				}else {
					occurrenceMap.put(word, occurrenceMap.get(word) + 1);
				}
			}
		}
		return occurrenceMap;
	}
	
	public static Map<String, Integer> getOccurrenceMap(List<String> lineList){
		String content = StringUtils.join(lineList.iterator(), "\n");
		return MapUtil.sort(getOccurrenceMap(content));
	}
}
