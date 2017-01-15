package com.techoffice.javafx;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javafx.fxml.FXMLLoader;
import javafx.util.Callback;

public class SpringFxmlLoader extends FXMLLoader{
	
	private static final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
	
	public SpringFxmlLoader(){
		this.setControllerFactory(new Callback<Class<?>, Object>() {
			public Object call(Class<?> clazz) {
				return applicationContext.getBean(clazz);
			}
		});
	}
	
	public Object load(String fxml) throws IOException {
		InputStream applFxml = this.getClass().getClassLoader().getResourceAsStream(fxml);
		return load(applFxml);
	}
}
