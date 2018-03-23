package com.techoffice.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Appl {
	final static Logger logger = LogManager.getLogger(Appl.class);
		
	public static void main(String[] args){
		logger.info("Hello Log4j Example");
	}
}
