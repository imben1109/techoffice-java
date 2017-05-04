package com.techoffice.yahoo.finance.boot;

import org.springframework.boot.SpringApplication;

import com.techoffice.yahoo.finance.boot.config.Config;

public class SpringBootExampleAppl {
	
    public static void main(String[] args) throws Exception {
    	SpringApplication.run(Config.class, args);
    }
    
}
