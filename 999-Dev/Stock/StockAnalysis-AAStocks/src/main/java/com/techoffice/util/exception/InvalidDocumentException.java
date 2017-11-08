package com.techoffice.util.exception;

public class InvalidDocumentException extends Exception{
	
	private static final long serialVersionUID = -4228513797924838988L;

	public InvalidDocumentException(String message){
		super(message);
	}
	
	public InvalidDocumentException(String message, Throwable e){
		super(message, e);
	}
}
