package com.ittechoffice.example.control;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;

public class AlertButton extends Button{
	
	public static final String BUTTON_LABEL = "Alert";
	
	public AlertButton(){
		this.setText(BUTTON_LABEL);
		this.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.showAndWait();
			}
		});
	}
}
