package com.techoffice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableConfigServer
@SpringBootApplication
@RestController
public class Appl {

	@RequestMapping("/")
	public String home(){
		return "Hello";
	}
	
	public static void main(String[] args){
		SpringApplication.run(Appl.class, args);
	}
	
}
