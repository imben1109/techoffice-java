package com.techoffice.wordpress.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class Appl {
	
    public static void main(String[] args) throws Exception {
    	SpringApplication.run(Appl.class, args);
    }
}
