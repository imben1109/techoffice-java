package com.techoffice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Appl {
		
	public static void main(String[] args) throws IOException {
		String str = "<asd><asdasd> <abc> </asd><asd>123</asd>";
		String tag = "asd";

		List<String> contents = new ArrayList<String>();
		StringBuilder stringBuilder = new StringBuilder();
		StringTokenizer stringTokenizer = new StringTokenizer(str, "<");
		boolean tagStart = false;
		System.out.println("token count: " + stringTokenizer.countTokens());
		while(stringTokenizer.hasMoreTokens()){
			String token = stringTokenizer.nextToken();
			if (!tagStart){
				if (token.startsWith(tag)){
					if(token.indexOf(">") > -1){
						tagStart = true;
						if (token.indexOf(">") != token.length() - 1){
							stringBuilder.append(token.substring(token.indexOf(">") + 1, token.length()));
						}
					}
				}
			}else {
				if (token.startsWith("/" + tag)){
					if (token.endsWith(">")){
						tagStart = false;
						contents.add(stringBuilder.toString());
						stringBuilder = new StringBuilder();
					}
				}else {
					stringBuilder.append("<" + token);
				}
			}
		}	
		
		for(String content: contents){
			System.out.println(content);
		}
	}


}
