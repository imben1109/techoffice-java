package com.techoffice.oracle.audit.exception;

public class TableNotExistException extends RuntimeException{

	public TableNotExistException(String tableName){
		super(tableName + " cannot be found in database.");
	}
	
	public TableNotExistException(String schmea, String tableName){
		super(schmea + "." + tableName + " cannot be found in database.");
	}
}
