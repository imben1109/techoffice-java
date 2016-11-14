package com.techoffice.example.controller;

import org.springframework.stereotype.Component;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

@Component
public class FxmlController {
	
	@FXML
    private TextField inputText1;

	@FXML
	public void setInputText1Value(String value){
		inputText1.setText(value);
	}
}
