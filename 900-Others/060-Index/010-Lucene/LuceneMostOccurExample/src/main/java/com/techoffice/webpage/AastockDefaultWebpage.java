package com.techoffice.webpage;

import java.util.Map;

import com.techoffice.util.WebpageUtil;

public class AastockDefaultWebpage {

	private static final String AASTOCK_DEGAUL_URL = "http://www.aastocks.com/tc/default.aspx";
	
	public static void main(String[] args){
		Map<String, Integer> topContentMap = WebpageUtil.getTopContentMap(AASTOCK_DEGAUL_URL, 2, 100);
		for (Map.Entry<String, Integer> entry: topContentMap.entrySet()){
			System.out.println(entry.getKey() + " " + entry.getValue() );
		}	
	}
}
