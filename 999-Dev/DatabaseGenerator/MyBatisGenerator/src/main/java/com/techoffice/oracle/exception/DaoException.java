package com.techoffice.oracle.exception;

public class DaoException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public DaoException(Throwable t){
		super(t);
	}
}
