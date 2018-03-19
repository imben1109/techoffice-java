package com.techoffice.model;

public class TagContent {

	private Integer startLineNumber;
	private Integer endLineNumber;
	private String content;
	
	public TagContent(Integer startLineNumber, Integer endLineNumber, String content){
		this.startLineNumber  = startLineNumber;
		this.endLineNumber  = endLineNumber;
		this.content  = content;
	}
	
	public Integer getStartLineNumber() {
		return startLineNumber;
	}
	public void setStartLineNumber(Integer startLineNumber) {
		this.startLineNumber = startLineNumber;
	}
	public Integer getEndLineNumber() {
		return endLineNumber;
	}
	public void setEndLineNumber(Integer endLineNumber) {
		this.endLineNumber = endLineNumber;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
