package com.ittechoffice.example;

import com.ittechoffice.example.control.AlertButton;
import com.ittechoffice.example.control.DialogButton;
import com.ittechoffice.example.control.DirControl;
import com.ittechoffice.example.control.DirPickerControl;
import com.ittechoffice.example.control.FileControl;
import com.ittechoffice.example.control.FilePickerControl;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Appl extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox root = new VBox(10);
		Scene scene = new Scene(root, 500, 500, Color.WHITE);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		root.getChildren().add(new Label("FileChooser"));
		root.getChildren().add(new FilePickerControl());
		root.getChildren().add(new Label("DirectoryChooser"));
		root.getChildren().add(new DirPickerControl());
		
		root.getChildren().add(new Label("Custom File Input"));
		root.getChildren().add(new FileControl());
		root.getChildren().add(new Label("Custom Directory Input"));
		root.getChildren().add(new DirControl());
		
		root.getChildren().add(new Label("Alert"));
		root.getChildren().add(new AlertButton());
		
		root.getChildren().add(new Label("Dialog"));
		root.getChildren().add(new DialogButton());
	}
	
	public static void main(String[] args){
		launch(args);
	}
	
}
