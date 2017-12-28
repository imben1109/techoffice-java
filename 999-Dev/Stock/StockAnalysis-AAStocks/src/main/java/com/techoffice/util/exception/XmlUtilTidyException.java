package com.techoffice.util.exception;

public class XmlUtilTidyException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public XmlUtilTidyException(Throwable e){
		super(e);
	}

	public XmlUtilTidyException(String message) {
		super(message);
	}
}
