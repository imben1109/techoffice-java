package com.techoffice.example;

import java.io.InputStream;

import com.techoffice.example.controller.FxmlController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FxmlControllerExample extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream applFxml = Appl.class.getClassLoader().getResourceAsStream("FxmlController.fxml");
        VBox root = (VBox) loader.load(applFxml);
        
        FxmlController fxmlController = (FxmlController) loader.getController();
        fxmlController.setInputText1Value("FXML Controler Example Test Set Value");
        
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("FXML Controller Example");
        primaryStage.show();
	}
	
	public static void main(String[] args){
		launch(args);
	}

}