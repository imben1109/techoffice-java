package com.ittechoffice.example.fx;


import java.io.InputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FxAppl extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream applFxml = FxAppl.class.getClassLoader().getResourceAsStream("MavenProjectManager.fxml");
        VBox root = (VBox) loader.load(applFxml);
        
        Scene scene = new Scene(root, 500, 500, Color.WHITE);
        primaryStage.setScene(scene);
        primaryStage.setTitle("FXML Controller Example");
        primaryStage.show();
	}
	
	public static void main(String[] args){
		launch(args);
	}

}
