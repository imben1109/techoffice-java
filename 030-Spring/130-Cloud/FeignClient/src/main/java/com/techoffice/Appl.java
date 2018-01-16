package com.techoffice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@EnableFeignClients
@RestController
@SpringBootApplication
public class Appl {

	@Autowired
	private GreetingClient greetingClient;
	
	public static void main(String[] args){
		SpringApplication.run(Appl.class, args);
	}
	
	@RequestMapping("/greeting")
	public String greeting(){
		return greetingClient.greeting();
	}
}
