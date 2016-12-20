package com.techoffice.oracle.client.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techoffice.fx.SpringFxmlLoader;
import com.techoffice.oracle.client.service.SqlService;
import com.techoffice.oracle.client.service.UserTableService;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

@Component
public class TableListController {
	
	@Autowired
	private SqlService sqlService;
	
	@Autowired
	private UserTableService userTableService; 

	@FXML
	public TableView<String> tableView;
	
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
        
        List<String> results = userTableService.selectTableList();
        ObservableList<String> items = FXCollections.observableArrayList(results);
        tableView.getColumns().add(tableColumn);
        tableView.setItems(items);
        tableView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent mouseEvent) {
				if (mouseEvent.getClickCount() > 1){
					try {
						String tableName = tableView.getSelectionModel().getSelectedItem();
						SpringFxmlLoader loader = new SpringFxmlLoader();
						VBox root = (VBox) loader.load("fxml/dependencyList.fxml");
						Stage stage = new Stage();
				        Scene scene = new Scene(root);
				        stage.setScene(scene);
				        stage.setTitle("Table Relationship");
				        DependencyListController dependencyListController = (DependencyListController) loader.getController();
				        dependencyListController.setTableName(tableName);
				        stage.show();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
}
