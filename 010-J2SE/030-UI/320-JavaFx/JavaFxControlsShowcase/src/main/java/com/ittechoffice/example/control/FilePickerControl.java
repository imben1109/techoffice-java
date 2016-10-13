package com.ittechoffice.example.control;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;

public class FilePickerControl extends Button{
	
	private static final String LABEL = "File";
	
	public FilePickerControl(){
		this.setText(LABEL);
		this.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				FileChooser fileChooser = new FileChooser();
				fileChooser.setTitle("Open Dialog");
				fileChooser.showOpenDialog(null);				
			}
		});
	}
}
