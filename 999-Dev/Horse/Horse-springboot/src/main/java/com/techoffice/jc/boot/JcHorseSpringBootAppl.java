package com.techoffice.jc.boot;

import org.springframework.boot.SpringApplication;

import com.techoffice.jc.boot.config.Config;

public class JcHorseSpringBootAppl {
	
    public static void main(String[] args) throws Exception {
    	SpringApplication.run(Config.class, args);
    }
    
}
