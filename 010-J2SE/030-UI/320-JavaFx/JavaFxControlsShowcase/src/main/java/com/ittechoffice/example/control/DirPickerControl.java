package com.ittechoffice.example.control;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.DirectoryChooser;

public class DirPickerControl extends Button{
	
	private static final String LABEL = "Directory";
	
	public DirPickerControl(){
		this.setText(LABEL);
		this.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				DirectoryChooser directoryChooser = new DirectoryChooser();
				directoryChooser.setTitle("Open Dialog");
				directoryChooser.showDialog(null);				
			}
		});
	}
}
