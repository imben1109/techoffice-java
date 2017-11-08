package com.techoffice.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techoffice.example.service.ApplService;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

@Component
public class ApplController {
	
	@Autowired
	private ApplService applService;
	
	@FXML
    private TextField inputText1;

	@FXML
	public void doSomething(){
		applService.doSomething();
	}
	
}
