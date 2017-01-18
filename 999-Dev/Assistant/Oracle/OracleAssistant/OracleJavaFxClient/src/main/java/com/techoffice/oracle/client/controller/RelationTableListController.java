package com.techoffice.oracle.client.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techoffice.fx.SpringFxmlLoader;
import com.techoffice.fx.util.JavaFxTableViewUtil;
import com.techoffice.oracle.client.model.RelationTable;
import com.techoffice.oracle.client.service.RelationService;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

@Component
public class RelationTableListController {
	
	@Autowired
	private RelationService userTableService; 

	@FXML
	public TableView<RelationTable> tableView;
	
	@FXML
	public TextField tableNameTextField;
	
	private List<RelationTable> relationalTableList; 
	private List<RelationTable> filteredTableList;
	
	@FXML
	public void initialize(){
        relationalTableList = userTableService.getRelationalTableList();
        JavaFxTableViewUtil.tableViewSetBeanList(tableView, relationalTableList, RelationTable.class);
        
        // Mouse Click Event for TableView
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
							stage.setWidth(600);
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
	
	@FXML
	public void search(){
        String tableName = tableNameTextField.getText();
        tableName = tableName.toUpperCase();
        if(!StringUtils.isBlank(tableName)){
        	filteredTableList = new ArrayList<RelationTable>();
        	for(RelationTable relationalTable: relationalTableList){
        		if (relationalTable.getTableName().toUpperCase().contains(tableName)){
        			filteredTableList.add(relationalTable);
        		}
        	}
            JavaFxTableViewUtil.tableViewSetBeanList(tableView, filteredTableList, RelationTable.class);	
        }else{
        	JavaFxTableViewUtil.tableViewSetBeanList(tableView, relationalTableList, RelationTable.class);
        }
		
	}
	
	@FXML
	public void handleTableNameTextFieldKeyReleasedEvent(KeyEvent event){
		if (event.getCode() == KeyCode.ENTER){
			search();
		}
	}
}
