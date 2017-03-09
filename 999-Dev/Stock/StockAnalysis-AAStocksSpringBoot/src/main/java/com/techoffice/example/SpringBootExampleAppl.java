package com.techoffice.example;

import org.springframework.boot.SpringApplication;

import com.techoffice.example.config.Config;

public class SpringBootExampleAppl {
	
    public static void main(String[] args) throws Exception {
    	SpringApplication.run(Config.class, args);
    }
    
}
