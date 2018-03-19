package com.techoffice.model;

import java.io.File;
import java.util.List;

public class ConsecutiveUppercaseFile {

	private File file;
	private List<ConsecutiveUppercaseLine> consecutiveUppercaseLineList;
	private boolean isConsecutiveUppercase;
	
	
	public ConsecutiveUppercaseFile(File file){
		this.file = file;
	}
	
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public List<ConsecutiveUppercaseLine> getConsecutiveUppercaseLineList() {
		return consecutiveUppercaseLineList;
	}
	public void setConsecutiveUppercaseLineList(List<ConsecutiveUppercaseLine> consecutiveUppercaseLineList) {
		this.consecutiveUppercaseLineList = consecutiveUppercaseLineList;
	}
	public boolean isConsecutiveUppercase() {
		return isConsecutiveUppercase;
	}
	public void setConsecutiveUppercase(boolean isConsecutiveUppercase) {
		this.isConsecutiveUppercase = isConsecutiveUppercase;
	}
	
	
	
}
