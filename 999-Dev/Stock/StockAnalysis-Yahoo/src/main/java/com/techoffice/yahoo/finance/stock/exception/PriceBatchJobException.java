package com.techoffice.yahoo.finance.stock.exception;

public class PriceBatchJobException extends Exception{
	
	private static final long serialVersionUID = -781930528664482500L;
	
	private static final String message = "Price Batch Job is already running";
	
	public PriceBatchJobException(){
		super(message);
	}
	
	public PriceBatchJobException(Throwable e){
		super(e);
	}
}
