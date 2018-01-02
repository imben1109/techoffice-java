package com.techoffice.util.exception;

public class DateParseException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public DateParseException(String message){
		super(message);	
	}
	
	public DateParseException(String message, Throwable e){
		super(message, e);
	}
}
