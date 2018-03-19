package com.techoffice.util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.techoffice.model.TagContent;
import com.techoffice.model.TagFile;

public class TagFileUtil {

	public static TagFile getTagFile(File file, String tag) throws IOException{
		TagFile tagFile = new TagFile(file);
		List<TagContent> tagContentList = new ArrayList<TagContent>();
		
		List<String> lines = FileUtils.readLines(file, StandardCharsets.UTF_8);
		int lineNumber = 1;
		for (String line : lines){
			List<TagContent> lineTagContentList = TagContentUtil.getTagContent(line, tag, false, lineNumber, null);
			tagContentList.addAll(lineTagContentList);
			lineNumber++;
		}
		tagFile.setTagContentList(tagContentList);
		return tagFile;
	}
	

	public static void main(String[] args) throws IOException{
		TagFile tagFile = getTagFile(new File("testingData", "test.txt"), "content");
		List<TagContent> tagContentList = tagFile.getTagContentList();
		for (TagContent tagContent: tagContentList){
			
		}
	}
}
