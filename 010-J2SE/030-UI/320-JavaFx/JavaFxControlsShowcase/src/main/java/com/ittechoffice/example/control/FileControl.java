package com.ittechoffice.example.control;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.DirectoryChooser;

public class FileControl extends HBox{
	public static final String Label = "File: ";
	public static final String BUTTON_LABEL = "SELECT";
	private Label label;
	private TextField textField;
	private Button dirChooserBtn;
	
	public FileControl(){
		init();
	}
	
	private void init(){
		initLabel();
		initTextField();
		initDirChooserBtn();
		this.getChildren().add(label);
		this.getChildren().add(textField);
		this.getChildren().add(dirChooserBtn);
	}
	
	private void initLabel(){
		label = new Label(Label);
	}
	
	private void initTextField(){
		textField = new TextField();
	}
	
	private void initDirChooserBtn(){
		dirChooserBtn = new Button();
		dirChooserBtn.setText(BUTTON_LABEL);
		dirChooserBtn.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				DirectoryChooser dirChooser = new DirectoryChooser();
				File selectedFile = dirChooser.showDialog(null);
				if (selectedFile != null){
					textField.setText(selectedFile.getPath());	
				}
			}
		});
	}
	

}
