package com.techoffice.model;

import java.io.File;
import java.util.List;

public class TagFile {

	private File file;
	private List<String> content;
	
	public TagFile(File file){
		this.file = file;
	}
	
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public List<String> getContent() {
		return content;
	}
	public void setContent(List<String> content) {
		this.content = content;
	}
	
}
