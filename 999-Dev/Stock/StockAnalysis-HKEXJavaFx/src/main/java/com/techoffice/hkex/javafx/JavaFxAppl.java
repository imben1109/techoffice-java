package com.techoffice.hkex.javafx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.techoffice.javafx.SpringFxmlLoader;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

@Component
public class JavaFxAppl extends Application{
	
	private static final double HEIGHT = 300;
	private static final double WIDTH = 500;
	
	public static final String TITLE = "Stock Analysis - HKEX";
	public static final String APP_FXML_PATH = "fxml/appl.fxml";
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		SpringFxmlLoader springFxmlLoader = new SpringFxmlLoader();
        VBox root = (VBox) springFxmlLoader.load(APP_FXML_PATH);
        Scene scene = new Scene(root);
        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle(TITLE);
        primaryStage.show();
	}
	
	public void run(String[] args){
		launch(args);
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		JavaFxAppl javaFxAppl = context.getBean(JavaFxAppl.class);
		javaFxAppl.run(args);
	}
}
