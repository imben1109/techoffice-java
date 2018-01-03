package com.techoffice.dao.base;

public class BaseDaoException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public BaseDaoException(Throwable t){
		super(t);
	}
	
	public BaseDaoException(String message, Throwable t){
		super(message, t);
	}
	
	public BaseDaoException(String message){
		super(message);
	}
}
