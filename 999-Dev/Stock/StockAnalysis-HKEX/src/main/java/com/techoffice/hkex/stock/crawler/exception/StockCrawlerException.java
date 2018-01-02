package com.techoffice.hkex.stock.crawler.exception;

public class StockCrawlerException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public StockCrawlerException(Throwable t){
		super(t);
	}
}
