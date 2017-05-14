package com.techoffice.util.exception;

public class DocumentConversionException extends Exception{
	
	private static final long serialVersionUID = -4228513797924838988L;

	public DocumentConversionException(String message){
		super(message);	
	}
	
	public DocumentConversionException(String message, Throwable e){
		super(message, e);
	}
}
