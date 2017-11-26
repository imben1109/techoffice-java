package com.techoffice.util.exception;

public class UrlUtilException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public UrlUtilException(String message){
		super(message);
	}
	
	public UrlUtilException(String message, Exception e){
		super(message, e);
	}
	
	public UrlUtilException(Exception e){
		super(e);
	}
}
