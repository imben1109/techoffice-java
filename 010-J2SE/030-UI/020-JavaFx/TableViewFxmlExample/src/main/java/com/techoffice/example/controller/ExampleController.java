package com.techoffice.example.controller;

import com.techoffice.example.model.Person;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class ExampleController {
	
	@FXML
	private TableView<Person> tableView;
	
	@FXML
	public void initialize(){
		ObservableList<Person> list = tableView.getItems();
		for (int i=1; i<6; i++){
			String content = "Test " + i;
			list.add(new Person(content, content, content));
		}
	}


}
