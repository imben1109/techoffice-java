package com.techoffice.aastock.stock.exception;

public class JobException extends Exception{

	private static final long serialVersionUID = -928967502207567939L;

	public JobException(String message, Exception e) {
		super(message, e);
	}


}
