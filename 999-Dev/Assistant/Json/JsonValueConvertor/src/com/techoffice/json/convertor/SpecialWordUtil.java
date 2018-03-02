package com.techoffice.json.convertor;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.WordUtils;

public class SpecialWordUtil {

	private static List<String> specialWordList = new ArrayList<String>();
	
	static {
		InputStream inputStream = SpecialWordUtil.class.getResourceAsStream("SpecialWord.txt");
		try {
			specialWordList = IOUtils.readLines(inputStream);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e); 
		}
	}
	
	public static String keepSpecialWord(String value){
		for (String specialWord: specialWordList){
			String generalizeSpringWord = JsonStringValueConvertor.generalize(specialWord);
			value = value.replace(generalizeSpringWord, specialWord);
		}
		return value;
	}
	
}
