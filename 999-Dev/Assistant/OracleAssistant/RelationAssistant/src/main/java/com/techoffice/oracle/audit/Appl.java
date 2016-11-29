package com.techoffice.oracle.audit;


import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import freemarker.template.TemplateException;


@Component
public class Appl {

	static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	
	@Transactional()
	public void run() throws URISyntaxException, IOException, TemplateException{
		
	}
	
	public static void main(String[] args) throws URISyntaxException, IOException, TemplateException{
		Appl appl = context.getBean(Appl.class);
		appl.run();
	}
}
