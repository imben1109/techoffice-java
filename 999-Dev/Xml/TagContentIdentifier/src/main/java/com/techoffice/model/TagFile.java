package com.techoffice.model;

import java.io.File;
import java.util.List;

public class TagFile {

	private File file;
	List<TagContent> tagContentList 
	
	public TagFile(File file){
		this.file = file;
	}
	
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}

	public List<TagContent> getTagContentList() {
		return tagContentList;
	}

	public void setTagContentList(List<TagContent> tagContentList) {
		this.tagContentList = tagContentList;
	}

	
}
