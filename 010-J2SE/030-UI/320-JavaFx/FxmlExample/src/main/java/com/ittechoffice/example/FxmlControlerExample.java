package com.ittechoffice.example;

import java.io.InputStream;

import com.ittechoffice.example.controller.FxmlControler;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FxmlControlerExample extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream applFxml = Appl.class.getClassLoader().getResourceAsStream("FxmlControler.fxml");
        VBox root = (VBox) loader.load(applFxml);
        
        FxmlControler fxmlControler = (FxmlControler) loader.getController();
        fxmlControler.setInputText1Value("FXML Controler Example Test Set Value");
        
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("FXML Controller Example");
        primaryStage.show();
	}
	
	public static void main(String[] args){
		launch(args);
	}

}