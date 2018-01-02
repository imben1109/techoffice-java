package com.techoffice.util;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

import com.techoffice.util.exception.UrlUtilException;
import com.techoffice.util.exception.WebDriverUtilException;

/**
 * URL Utility
 * 
 * @author TechOffice
 *
 */
public class UrlUtil {
	
	/**
	 * Get Param Map from URL
	 * 
	 * The Get Param following Url by "?"
	 * 
	 * @param url
	 * @return Map of Get Param 
	 */
	public static Map<String, String> getGetParamMap(String url){
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
	
	public static String getDomainUrl(String str){
		try{
			URL url = new URL(str);
			return url.getProtocol()+ "://" + url.getHost();
		} catch(Exception e){
			throw new WebDriverUtilException(e);
		}
	}
	
	public static String getUrl(String urlStr, String path){
		try {
			URL context = new URL(urlStr);
			URL url = new URL(context, path);
			return url.toString();
		} catch (Exception e) {
			throw new UrlUtilException(e);
		}
	}
	
	public static File downloadToFile(String urlStr, File file){
		try {
			URL url = new URL(urlStr);
			FileUtils.copyURLToFile(url, file);
			return file;
		} catch (Exception e) {
			throw new UrlUtilException(e);
		}
	}
}
