package com.techoffice.jc.springboot;

import org.springframework.boot.SpringApplication;

import com.techoffice.jc.springboot.config.Config;

public class JcHorseSpringBootAppl {
	
    public static void main(String[] args) throws Exception {
    	SpringApplication.run(Config.class, args);
    }
    
}
