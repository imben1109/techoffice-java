package com.techoffice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExceptionLogging {

    final static Logger logger = LoggerFactory.getLogger(Appl.class);

    public static void main(String[] args) {
        try {
            throw new RuntimeException("Testing");
        } catch (Exception e) {
            logger.error("testing content: {}", e.getMessage(), e);
        }
    }
}
