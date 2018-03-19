package com.techoffice.model;

public class TagContent {

	private Integer startLineNumber;
	private Integer endLineNumber;
	private String content;
	private boolean isEnded = false;
	
	public TagContent(String content, Integer startLineNumber, Integer endLineNumber){
		this.content  = content;
		this.startLineNumber  = startLineNumber;
		this.endLineNumber  = endLineNumber;
		this.isEnded = true;
	}
	
	public TagContent(String content, Integer startLineNumber){
		this.content  = content;
		this.startLineNumber  = startLineNumber;
		this.isEnded = false;
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
		this.isEnded = true;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isEnded(){
		return this.isEnded;
	}
	
	
}
