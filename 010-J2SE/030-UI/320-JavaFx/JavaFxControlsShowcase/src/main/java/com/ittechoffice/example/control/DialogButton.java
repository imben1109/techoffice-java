package com.ittechoffice.example.control;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

public class DialogButton extends Button{
	
	public static final String BUTTON_LABEL = "Dialog";
	
	public DialogButton(){
		this.setText(BUTTON_LABEL);
		this.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				Dialog<String> dialog = new Dialog<String>();
				HBox hbox = new HBox();
				dialog.getDialogPane().setContent(hbox);
				final TextField textField = new TextField();
				hbox.getChildren().add(textField);
				final ButtonType buttonType = new ButtonType("OK", ButtonData.OK_DONE);
				dialog.getDialogPane().getButtonTypes().addAll(buttonType, ButtonType.CANCEL);
				dialog.setResultConverter(new Callback<ButtonType, String>(){
					public String call(ButtonType param) {
						if (buttonType == param){
							String input = textField.getText();
							System.out.println("The Input: " + input);
							return input;
						}
						return null;
					}
				});
				dialog.showAndWait();
			}
		});
	}
}
