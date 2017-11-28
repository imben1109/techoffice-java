package com.techoffice.example;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Appl {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

	public static void main(String[] args) throws IOException{


	}
}
