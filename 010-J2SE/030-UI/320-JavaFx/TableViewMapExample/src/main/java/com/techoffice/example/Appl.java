package com.techoffice.example;

import com.techoffice.example.model.Person;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Appl extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
        Scene scene = new Scene(root);
        
        // Construct Table View
        TableView table = new TableView();
        
        // Table Columns
        TableColumn firstName = new TableColumn("First Name");
        firstName.setCellValueFactory(new PropertyValueFactory("firstName"));
        TableColumn lastName = new TableColumn("Last Name");
        lastName.setCellValueFactory(new PropertyValueFactory("lastName"));
        TableColumn email = new TableColumn("Email");
        email.setCellValueFactory(new PropertyValueFactory("email"));
        
        table.getColumns().addAll(firstName, lastName, email);
        
        // data for tableview
        ObservableList<Person> data =
                FXCollections.observableArrayList(
                    new Person("Jacob", "Smith", "jacob.smith@example.com"),
                    new Person("Isabella", "Johnson", "isabella.johnson@example.com"),
                    new Person("Ethan", "Williams", "ethan.williams@example.com"),
                    new Person("Emma", "Jones", "emma.jones@example.com"),
                    new Person("Michael", "Brown", "michael.brown@example.com")
                );
        table.setItems(data);

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
