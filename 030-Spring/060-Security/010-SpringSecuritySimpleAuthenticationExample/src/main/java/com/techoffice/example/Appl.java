package com.techoffice.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class Appl {
	
	private static AuthenticationManager authenticationManager = new SampleAuthenticationManager();
	
	public static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

	public void run(){
		// Principal: 	TEST_USER
		// Credential: 	TEST_PASSWORD
		Authentication request = new UsernamePasswordAuthenticationToken("TEST_USER", "TEST_USER");
		Authentication result = authenticationManager.authenticate(request);
		SecurityContextHolder.getContext().setAuthentication(result);
		if (result.isAuthenticated()){
			System.out.println(result.getPrincipal() + " is Authenticated");
		}
		Authentication threadAuthentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("The User of Current Thread is " + threadAuthentication.getPrincipal());
	}
	
	public static void main(String[] args){
		Appl appl = context.getBean(Appl.class);
		appl.run();
	}
	
}

