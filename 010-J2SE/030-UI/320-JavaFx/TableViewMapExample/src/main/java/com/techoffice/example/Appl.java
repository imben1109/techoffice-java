package com.techoffice.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;

public class Appl extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
        Scene scene = new Scene(root);
        
        // Construct Table View
        TableView<Map<String, String>> table = new TableView<Map<String, String>>();
        
        // Table Columns
        TableColumn<Map<String, String>, String> firstName = new TableColumn<Map<String, String>, String>("First Name");
        firstName.setCellValueFactory(new Callback<CellDataFeatures<Map<String, String>, String>, ObservableValue<String>>(){
			@Override
			public ObservableValue<String> call(CellDataFeatures<Map<String, String>, String> param) {
				return new SimpleStringProperty(param.getValue().get("firstName"));
			}
		});
        table.getColumns().addAll(firstName);
        
        // data
        List<Map<String,String>> list = new ArrayList<Map<String,String>>();
        Map<String, String> data1 = new HashMap<String, String>();
        data1.put("firstName", "Tech Office");
        list.add(data1);
        ObservableList<Map<String, String>> items = FXCollections.observableArrayList(list);
        table.setItems(items);

        // add tableview to root
        root.getChildren().add(table);


        primaryStage.setScene(scene);
        primaryStage.setTitle("FXML Example");
        primaryStage.show();
	}
	
	public static void main(String[] args){
		launch(args);
	}

}
