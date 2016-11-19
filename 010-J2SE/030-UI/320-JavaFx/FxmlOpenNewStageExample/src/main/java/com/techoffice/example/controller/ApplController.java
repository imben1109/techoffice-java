package com.techoffice.example.controller;

import java.io.IOException;
import java.io.InputStream;

import com.techoffice.example.Appl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ApplController {
	
	@FXML
	public void action(ActionEvent event) throws IOException{
		Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        InputStream applFxml = Appl.class.getClassLoader().getResourceAsStream("Stage.fxml");
        VBox root = (VBox) loader.load(applFxml);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("FXML Controller Example");
        stage.show();	
	}
}
