package com.techoffice.util.exception;

public class WebDriverUtilException extends RuntimeException{
	
	private static final long serialVersionUID = -4228513797924838988L;

	public WebDriverUtilException(Throwable e){
		super(e);
	}
	
	public WebDriverUtilException(String message){
		super(message);	
	}
	
	public WebDriverUtilException(String message, Throwable e){
		super(message, e);
	}
}
