package com.techoffice.util.exception;

public class TaskExecutorException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public TaskExecutorException(Throwable t){
		super(t);
	}

}
