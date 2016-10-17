package com.ittechoffice.example.control;

import java.io.File;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * File Control 
 * 
 * @author Ben_c
 *
 */
public class FxFile extends Pane{
	private String name;
	private String path;
	
	private Label label;
	private TextField textField;
	private FxFileExplorer fileExplorer;
	
	private Status status = Status.VIEW;
	private boolean selected = false;
	
	public static String SELECTED_BLACKGROUND_COLOR = "LightSkyBlue";
	public static String OVER_BLACKGROUND_COLOR = "LightCyan";
	public static String TRANSPARENT_COLOR = "transparent";
	
	public enum Status {
		VIEW, EDIT;
	}
	
	public FxFile(File file, FxFileExplorer fileExplorer){
		this.name = file.getName();
		this.path = file.getPath();
		this.fileExplorer = fileExplorer;
		init();
	}
	
	private void init(){
		label = new Label(name);
		label.setVisible(true);
		textField = new TextField(name);
		textField.setVisible(false);
		this.getChildren().add(label);
		this.getChildren().add(textField);
		label.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>(){
			public void handle(MouseEvent arg0) {
				if (!selected){
					label.setStyle("-fx-background-color: " + OVER_BLACKGROUND_COLOR);
				}
				
			}
		});
		label.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>(){
			public void handle(MouseEvent arg0) {
				if (!selected){
					label.setStyle("-fx-background-color: " + TRANSPARENT_COLOR);
				}
			}
		});
		final FxFile that = this;
		label.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
			public void handle(MouseEvent arg0) {
				fileExplorer.setSelectedFile(that);
				select();
			}
		});

		textField.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>(){
			public void handle(KeyEvent event) {
				if(event.getCode() == KeyCode.ENTER){
					rename();	
				}
				
			}
		});
	}
	
	public void select(){
		selected = true;
		label.setStyle("-fx-background-color: " + SELECTED_BLACKGROUND_COLOR);
	}
	
	public void unselect(){
		selected = false;
		if (status.equals(Status.EDIT)){
			rename();
		}
		label.setStyle("-fx-background-color: " + TRANSPARENT_COLOR);
	}
	
	public void edit(){
		this.label.setVisible(false);
		this.textField.setVisible(true);
		this.status = Status.EDIT;
	}
	
	public void rename(){
		this.label.setVisible(true);
		this.textField.setVisible(false);
		String newFileName = textField.getText();
		if (!newFileName.equals("")){
			this.name = newFileName;
			this.label.setText(newFileName);	
		}
	}
	
	public String getPath(){
		return path;
	}
	
}
