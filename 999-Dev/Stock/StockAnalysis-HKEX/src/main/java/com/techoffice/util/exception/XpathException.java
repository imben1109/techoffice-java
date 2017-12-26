package com.techoffice.util.exception;

public class XpathException extends RuntimeException{

	private static final long serialVersionUID = 7329008795716981701L;

	public static final String NOT_UNIQUE_PATTERN = "xPath \"{0}\" is not unique. More than two node position can be found.";
	
	public static final String NOT_FOUND_PATTERN = "xPath \"{0}\" cannot be found.";
	
	public static final String INVALID_XPATH_PATTERN = "xPath \'{0}\" is invalid. ";
	
	public XpathException(String message, Throwable e){
		super(message, e);
	}
	
	public XpathException(String message){
		super(message);
	}
	
	public XpathException(Throwable e){
		super(e);
	}
}
