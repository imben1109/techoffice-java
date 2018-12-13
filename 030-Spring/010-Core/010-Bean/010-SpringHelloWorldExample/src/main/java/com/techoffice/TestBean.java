package com.techoffice;

public class TestBean {

	private String message;
	
	public TestBean(){
		System.out.println("Testing");
	}
	
	public void setMessage(String message){
		this.message = message;
	}
	
	public String getMessage(){
		return message;
	}
	
}
