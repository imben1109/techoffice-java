package com.techoffice.example.javafx;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class SpringFxmlLoader {
	private static final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

	public Object load(String fxml) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setControllerFactory(new Callback<Class<?>, Object>() {
			public Object call(Class<?> clazz) {
				// TODO Auto-generated method stub
				return applicationContext.getBean(clazz);
			}
		});
		InputStream applFxml = this.getClass().getClassLoader().getResourceAsStream(fxml);
		return loader.load(applFxml);
	}
}
