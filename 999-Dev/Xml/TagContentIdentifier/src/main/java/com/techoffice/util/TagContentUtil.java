package com.techoffice.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.techoffice.model.TagContent;

public class TagContentUtil {

	private TagContentUtil(){}
	
	public static List<TagContent> getTagContent(String str, String tag, boolean tagStart, Integer lineNumber, TagContent lastTagContent){
		List<TagContent> tagContentList = new ArrayList<TagContent>();		
		StringBuilder stringBuilder = new StringBuilder();
		StringTokenizer stringTokenizer = new StringTokenizer(str, "<");
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
						if (lastTagContent != null && !lastTagContent.isEnded()){
							lastTagContent.setEndLineNumber(lineNumber);
						}else {
							TagContent tagContent = new TagContent(stringBuilder.toString(), lineNumber, lineNumber);
							tagContentList.add(tagContent);
							stringBuilder = new StringBuilder();
						}
					}
				}else {
					stringBuilder.append("<" + token);
				}
			}
		}	
		
		if (tagStart){
			TagContent tagContent = new TagContent(stringBuilder.toString(), lineNumber);
			tagContentList.add(tagContent);
		}
		
		return tagContentList;
	}
}
