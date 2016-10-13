package com.ittechoffice.example.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class FxmlControler {
	
	@FXML
    private TextField inputText1;

	@FXML
	public void setInputText1Value(String value){
		inputText1.setText(value);
	}
}
