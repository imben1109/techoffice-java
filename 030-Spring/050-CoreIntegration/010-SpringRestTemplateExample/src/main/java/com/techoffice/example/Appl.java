package com.techoffice.example;

import java.util.HashMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Appl {
	
	public void run(){
		RestTemplate restTemplate = new RestTemplate();
        HashMap result = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", HashMap.class);
        String type = (String) result.get("type");
        System.out.println(type);
	}
	
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Appl helloWorldExample = context.getBean(Appl.class);
		helloWorldExample.run();
	}
}
