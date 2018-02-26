package com.techoffice.listener;

import java.net.URL;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.logging.log4j.core.config.Configurator;

public class LoggerConfigListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
        try {
			final URL url = sce.getServletContext().getResource("/WEB-INF/log4j.properties");
			Configurator.initialize("TechOffice", this.getClass().getClassLoader(), url.toURI(), sce.getServletContext());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
