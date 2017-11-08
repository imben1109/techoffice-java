package com.techoffice.util.exception;

public class WebCrawlerException extends Exception{

	private static final long serialVersionUID = -4282814521239167404L;

	private static final String MESSAGE = "Failed to Retrieve Information!";
	
	public WebCrawlerException(Throwable cause){
		super(MESSAGE, cause);
	}
	
	public WebCrawlerException(String info, Throwable cause){
		super(MESSAGE + " " + info, cause);
	}
}
