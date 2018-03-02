package com.techoffice.json.convertor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;

public class JsonStringValueConvertor {

	public static final char[] delimiters = new char[]{'(', ' ', '/', '-', '\'', '=', '&'};
	public static final String jsonKeyStringValuePatternStr = "(.*):(.*)\"(.*)\"(.*)";
	public static final Pattern jsonKeyStringValuePattern = Pattern.compile(jsonKeyStringValuePatternStr);
	
		
	public static String generalize(String value){
		String capitalizedString =  WordUtils.capitalize(StringUtils.lowerCase(value), delimiters);
		return capitalizedString;
	}
	
	public static List<String> covert(List<String> inputLineList){
		List<String> outputLines = new ArrayList<String>();
		for (String inputLine: inputLineList){
			Matcher matcher = jsonKeyStringValuePattern.matcher(inputLine);
			if(matcher.matches()){
				String keyStr = matcher.group(1);
				String valueStrPrefix = matcher.group(2);
				String valueStr = matcher.group(3);
				String valueStrSuffix = matcher.group(4);
				String capitalizedValueStr = generalize(valueStr);
				capitalizedValueStr = SpecialWordUtil.keepSpecialWord(capitalizedValueStr);
				String covertedLine = keyStr + ":" + valueStrPrefix + "\"" + capitalizedValueStr + "\"" + valueStrSuffix ;
				outputLines.add(covertedLine);
			}else {
				outputLines.add(inputLine);
			}
		}
		return outputLines; 
	}
	

	
}
