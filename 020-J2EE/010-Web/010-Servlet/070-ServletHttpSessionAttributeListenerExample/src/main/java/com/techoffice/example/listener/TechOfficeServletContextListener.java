package com.techoffice.example.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TechOfficeServletContextListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("Context Destroyed");
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("Context Created");
	}

}
