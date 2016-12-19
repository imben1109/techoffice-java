package com.techoffice.oracle.client.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techoffice.oracle.client.service.ApplService;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

@Component
public class TableListController {
	
	@Autowired
	private ApplService applService;

	@FXML
	public TableView tableView;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@FXML
	public void initialize(){
        TableColumn tableColumn = new TableColumn("Table Name");
        tableColumn.setCellValueFactory(new Callback<CellDataFeatures<String, String>, ObservableValue<String>>(){
			public ObservableValue<String> call(CellDataFeatures<String, String> param) {
				SimpleStringProperty simpleStringProperty = new SimpleStringProperty(param.getValue());
				return simpleStringProperty;
			}
		});
        
        List<String> results = applService.selectTableList();
        ObservableList<String> items = FXCollections.observableArrayList(results);
        tableView.getColumns().add(tableColumn);
        tableView.setItems(items);
	}
	
}
