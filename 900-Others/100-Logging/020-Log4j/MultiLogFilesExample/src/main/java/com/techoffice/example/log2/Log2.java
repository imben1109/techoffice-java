package com.techoffice.example.log2;

import org.apache.log4j.Logger;

public class Log2 {
	final static Logger logger = Logger.getLogger(Log2.class);
	public static void log(){
		logger.info("Message from Log2");
	}

}
