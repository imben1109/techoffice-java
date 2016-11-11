package com.techoffice.example.log1;

import org.apache.log4j.Logger;

public class Log1 {
	final static Logger logger = Logger.getLogger(Log1.class);
	public static void log(){
		logger.info("Message from Log1");
	}
}
