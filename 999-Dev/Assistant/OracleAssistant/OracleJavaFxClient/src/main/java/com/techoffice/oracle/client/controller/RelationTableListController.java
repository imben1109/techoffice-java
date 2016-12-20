package com.techoffice.oracle.client.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techoffice.fx.SpringFxmlLoader;
import com.techoffice.fx.util.JavaFxTableViewUtil;
import com.techoffice.oracle.client.model.RelationTable;
import com.techoffice.oracle.client.service.SqlService;
import com.techoffice.oracle.client.service.RelationService;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TableView;
import javafx.util.Callback;

@Component
public class RelationTableListController {
	
	@Autowired
	private RelationService userTableService; 

	@FXML
	public TableView<RelationTable> tableView;
	
	@FXML
	public void initialize(){
        List<RelationTable> results = userTableService.getRelationTableList();
        JavaFxTableViewUtil.tableViewSetBeanList(tableView, results, RelationTable.class);
        tableView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent mouseEvent) {
				if (mouseEvent.getClickCount() > 1){
					try {
						if (tableView.getSelectionModel().getSelectedItem() != null ){
							String tableName = tableView.getSelectionModel().getSelectedItem().getTableName();
							SpringFxmlLoader loader = new SpringFxmlLoader();
							VBox root = (VBox) loader.load("fxml/relation.fxml");
							Stage stage = new Stage();
					        Scene scene = new Scene(root);
					        stage.setScene(scene);
					        stage.setTitle("Table Relationship");
					        RelationController dependencyListController = (RelationController) loader.getController();
					        dependencyListController.setTableName(tableName);
					        stage.show();	
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
}
