package com.techoffice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ConfigClientAppl {

    @Value("${user.password}")
    private String password;
    
    public static void main(String[] args){
    	SpringApplication.run(ConfigClientAppl.class, args);
    }
    
    @RequestMapping(value="/")
    public String getPassword(){
    	return password;
    }
}
