package com.techoffice.hkex.javafx.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techoffice.javafx.SpringFxmlLoader;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

@Component
public class ApplController {
	
	@Autowired
	private SpringFxmlLoader springFxmlLoader;
	
	@FXML
    private TextField inputText1;

	@FXML
	public void doSomething() throws IOException{
		Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        VBox root = (VBox) springFxmlLoader.load("fxml/Stage.fxml");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("FXML Controller Example");
        stage.show();		}
	
}
