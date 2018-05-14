package com.techoffice.generator.freemarker.exception;

public class FreemakerException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public FreemakerException(String message, Throwable t){
		super(message, t);
	}
	
	public FreemakerException(Throwable t){
		super(t);
	}

}
