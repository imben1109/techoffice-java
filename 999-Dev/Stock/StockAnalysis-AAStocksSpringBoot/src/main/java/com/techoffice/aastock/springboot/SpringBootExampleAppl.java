package com.techoffice.aastock.springboot;

import org.springframework.boot.SpringApplication;

import com.techoffice.aastock.springboot.config.Config;

public class SpringBootExampleAppl {
	
    public static void main(String[] args) throws Exception {
    	SpringApplication.run(Config.class, args);
    }
    
}
