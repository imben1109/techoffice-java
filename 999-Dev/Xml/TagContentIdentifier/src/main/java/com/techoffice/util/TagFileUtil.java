package com.techoffice.util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.techoffice.model.TagFile;

public class TagFileUtil {

	public TagFile getTagFile(File file, String tag) throws IOException{
		TagFile tagFile = new TagFile(file);
		
		String startTag = "<" + tag;
		String endTag = "</" + tag;
		
		List<String> contents = new ArrayList<String>();
		
		boolean tagStart = false;
		List<String> lines = FileUtils.readLines(file, StandardCharsets.UTF_8);
		int lineNumber = 1;
		int startLineNumber = 1;
		int endLineNumber = 1;
		for (String line : lines){
			String[] words = line.split("\\ ");
			for (int i=0; i<words.length; i++){
				String word = words[i];
				if (!tagStart){
					if (word.startsWith(startTag)){
						
					}
				}else {
					
				}
			}
			lineNumber++;
		}
		
		return tagFile;
	}
}
