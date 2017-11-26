package com.techoffice.util.exception;

public class RssUtilException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public RssUtilException(String message){
		super(message);
	}
	
	public RssUtilException(String message, Exception e){
		super(message, e);
	}
	
	public RssUtilException(Exception e){
		super(e);
	}
}
