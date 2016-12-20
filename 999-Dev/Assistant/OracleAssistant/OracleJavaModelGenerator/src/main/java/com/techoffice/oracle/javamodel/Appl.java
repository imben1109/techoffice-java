package com.techoffice.oracle.javamodel;


import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class Appl {

	static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	
	@Transactional()
	public void run() throws URISyntaxException, IOException{

	}
	
	public static void main(String[] args) throws URISyntaxException, IOException{
		Appl appl = context.getBean(Appl.class);
		appl.run();
	}
}
