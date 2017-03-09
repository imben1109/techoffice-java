package com.techoffice.util;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class UrlUtil {
	
	public static Map<String, String> getParam(String url){
		Map<String, String> param = new HashMap<String, String>();
		if (containParam(url)){
			String[] urlArr = url.split(Pattern.quote("?"));
			if (urlArr.length > 1){
				String paramStr = urlArr[1];
				param = convertTokenMap(paramStr);
			}
		}
		return param;
	}
	
	public static Map<String, String> convertTokenMap(String str){
		Map<String, String> map = new HashMap<String, String>();
		String[] tokenPairs= str.split("&");
		for (int i=0; i<tokenPairs.length; i++){
			String tokenPair = tokenPairs[i];
			String[] tokenPairArr = tokenPair.split("=");
			String key = tokenPairArr[0];
			String value = "";
			if (tokenPairArr.length > 1){
				value = tokenPairArr[1];
			}
			map.put(key, value);
		}
		return map;
	}
	

	public static boolean containParam(String url){
		if (url.contains("?")){
			return true;
		}
		return false;
	}
}
