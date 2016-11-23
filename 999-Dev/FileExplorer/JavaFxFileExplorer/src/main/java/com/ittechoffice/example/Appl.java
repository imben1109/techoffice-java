package com.ittechoffice.example;

import com.ittechoffice.example.control.FxFileExplorer;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Appl extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		 VBox root = new VBox();
		 Scene scene = new Scene(root, 500, 500, Color.WHITE);
		 
		 final FxFileExplorer fileExplorer = new FxFileExplorer("D://");
		 root.getChildren().add(fileExplorer);
		 scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>(){
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.F2){
					fileExplorer.renameFile();
				}
				if(event.getCode() == KeyCode.DOWN){
					fileExplorer.nextFile();
				}
				if(event.getCode() == KeyCode.UP){
					fileExplorer.previousFile();
				}
			}
		 });
		 primaryStage.setTitle("Hellow World JavaFX");
		 primaryStage.setScene(scene);
		 primaryStage.show();		
	}

	public static void main(String[] args){
		launch(args);
	}
	
}
