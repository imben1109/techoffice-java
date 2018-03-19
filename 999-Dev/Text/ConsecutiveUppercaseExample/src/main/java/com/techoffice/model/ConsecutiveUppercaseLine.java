package com.techoffice.model;

import java.util.List;

public class ConsecutiveUppercaseLine {

	private Integer line;
	private List<String> uppercaseStrList;
	
	public ConsecutiveUppercaseLine(Integer line, List<String> uppercaseStrList){
		this.line = line;
		this.uppercaseStrList = uppercaseStrList;
	}
	
	public Integer getLine() {
		return line;
	}
	public void setLine(Integer line) {
		this.line = line;
	}
	public List<String> getUppercaseStrList() {
		return uppercaseStrList;
	}
	public void setUppercaseStrList(List<String> uppercaseStrList) {
		this.uppercaseStrList = uppercaseStrList;
	}
	
	
}
