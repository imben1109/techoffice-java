package com.techoffice.github.util;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

public class StringUtil {
	
	public static Map<String, String> convertQueryStringToMap(String queryString){
		Map<String, String> queryMap = new HashMap<String, String>();
		List<NameValuePair> nameValuePairList = URLEncodedUtils.parse(queryString, Charset.defaultCharset());
		for (NameValuePair nameValuePair: nameValuePairList){
			queryMap.put(nameValuePair.getName(), nameValuePair.getValue());
		}
		return queryMap;
	}
}
