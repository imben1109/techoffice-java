package com.techoffice.example.exception;

public class ExampleException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ExampleException(Throwable t){
		super(t);
	}
	
	public ExampleException(String message){
		super(message);
	}
	
}
