package com.techoffice.oracle.client.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;

import com.techoffice.fx.SpringFxmlLoader;
import com.techoffice.fx.util.JavaFxTableViewUtil;
import com.techoffice.oracle.client.service.SqlService;
import com.techoffice.oracle.client.util.SqlUtil;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

@Component
public class ApplController {
	
	@Autowired
	private SqlService applService;
	
	@FXML
	private TextArea sqlTextArea;
	
	@FXML
	private TableView tableView;
	
	private boolean isCtrlPressed = false;

	@FXML
	public void initialize(){
	}
	
	@FXML
	public void executeSql(){
		String formatSql = SqlUtil.formatSql(sqlTextArea.getText());
		if (!StringUtils.isEmpty(formatSql)){
			try{
				List<Map<String, Object>> results = applService.executeSql(formatSql);
				JavaFxTableViewUtil.tableViewSetListOfMap(tableView, results);
			}catch(BadSqlGrammarException e){
				JavaFxTableViewUtil.tableViewSetBadSqlGrammarException(tableView, e);
				e.printStackTrace();
			}
		}
	}
	
	@FXML
	public void callTableRelationShipWindow() throws IOException{
		SpringFxmlLoader loader = new SpringFxmlLoader();
        VBox root = (VBox) loader.load("fxml/relationTableList.fxml");
		Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Table Relationship");
        stage.setWidth(600);
        stage.show();
	}
	
	@FXML
	public void callModelGenerationWindow() throws IOException{
		SpringFxmlLoader loader = new SpringFxmlLoader();
        VBox root = (VBox) loader.load("fxml/entityTableList.fxml");
		Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Table Relationship");
        stage.setWidth(600);
        stage.show();
	}
	
	@FXML
	public void handleSqlTextAreaKeyPressedEvent(KeyEvent event){
		if (event.getCode() == KeyCode.CONTROL){
			isCtrlPressed = true;
		}
		if (isCtrlPressed){
			if (event.getCode() == KeyCode.ENTER){
				executeSql();
			}
		}
	}
	
	@FXML
	public void handleSqlTextAreaKeyReleasedEvent(KeyEvent event){
		if (event.getCode() == KeyCode.CONTROL){
			isCtrlPressed = false;
		}	
	}
}
