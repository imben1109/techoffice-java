package com.techoffice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Appl {
    
	@Autowired
    private ApplicationContext context;
	
	@RequestMapping("/")
	public String home() {
		return "Hello World";
	}
	
    @RequestMapping(value="/publish")
    public String publish() {
        // each service instance must have a unique context ID
        final String myUniqueId = context.getId(); 
        final AppEvent event = new AppEvent(this, myUniqueId, "hello world");
        context.publishEvent(event);
        return "event published";
    }

	
	public static void main(String[] args){
		SpringApplication.run(Appl.class, args);
	}
}
	