package com.techoffice.hkex.javafx.controller;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.techoffice.javafx.SpringFxmlLoader;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

@Component
public class ApplController {
	
	@FXML
	public void showStock() throws IOException{
		SpringFxmlLoader springFxmlLoader = new SpringFxmlLoader();
		Stage stage = new Stage();
        VBox root = (VBox) springFxmlLoader.load("fxml/stock.fxml");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("FXML Controller Example");
        stage.show();		
	}
	
}
