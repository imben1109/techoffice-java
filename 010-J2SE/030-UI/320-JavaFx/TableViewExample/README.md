# JavaFX FXML Example

## JXML
JavaFX provide FXML, a XML-based lanaugage for building user interface. It could make application logic separated from user interface.

## Example


### Appl.java

Appl.fxml
```
<?xml version="1.0" encoding="UTF-8"?>

<?import java.net.*?>
<?import javafx.geometry.*?>
<?import javafx.scene.control.*?>
<?import javafx.scene.layout.*?>
<?import javafx.scene.text.*?>

<VBox xmlns:fx="http://javafx.com/fxml/1">
	<children>
		<Label text="Hell World" />
	</children>
</VBox>

```

```
FXMLLoader loader = new FXMLLoader();
InputStream applFxml = Appl.class.getClassLoader().getResourceAsStream("Appl.fxml");
VBox root = (VBox) loader.load(applFxml);
```

### Controller

```
<?xml version="1.0" encoding="UTF-8"?>

<?import java.net.*?>
<?import javafx.geometry.*?>
<?import javafx.scene.control.*?>
<?import javafx.scene.layout.*?>
<?import javafx.scene.text.*?>

<VBox xmlns:fx="http://javafx.com/fxml/1" fx:controller="com.ittechoffice.example.controller.FxmlControler">
	<children>
		<Label text="Hell World" />
		<TextField fx:id="inputText1"/>
	</children>
</VBox>

```

FxmlControler.java
```
public class FxmlControler {
	
	@FXML
    private TextField inputText1;

	@FXML
	public void setInputText1Value(String value){
		inputText1.setText(value);
	}
}
```