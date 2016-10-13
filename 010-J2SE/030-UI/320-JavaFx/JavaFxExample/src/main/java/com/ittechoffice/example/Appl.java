package com.ittechoffice.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * JavaFx Hello World Example
 * 
 * JavaFx provide a abstract class of Application. You can write a class extending Application then you can write your own custom start function provided primary stage object. 
 * launch function is also provided for you to execute your JavaFx Application.
 * 
 * @author Ben_c
 *
 */
public class Appl extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		
		// VBox is a layout container of JavaFX Control
		VBox root = new VBox();
		
		// Scene is a container for a page  
		Scene scene = new Scene(root, 500, 500, Color.WHITE);

		// JavaFx Control
		Label helloWorldLabel = new Label();
		
		root.getChildren().add(helloWorldLabel);
		
		// stage is primary container for JavaFx Application
		stage.setTitle("JavaFx Example");
		
		stage.setScene(scene);
		
		stage.show();
		
	}
	
	public static void main(String[] args){
		launch(args);
	}

}
