package com.techoffice.yahoo.finance.springboot;

import org.springframework.boot.SpringApplication;

import com.techoffice.yahoo.finance.springboot.config.Config;

public class SpringBootExampleAppl {
	
    public static void main(String[] args) throws Exception {
    	SpringApplication.run(Config.class, args);
    }
    
}
