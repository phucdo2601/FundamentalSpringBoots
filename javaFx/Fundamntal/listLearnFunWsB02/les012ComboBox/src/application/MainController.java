package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class MainController implements Initializable{

	@FXML
	public ComboBox<String> cbx;
	
	@FXML
	public Label lblText;
	
	ObservableList<String> list = FXCollections.observableArrayList("Mark", "Tom", "Alice", "Jack");
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		cbx.setItems(list);
	}

	public void comboChanged(ActionEvent event) {
		lblText.setText(cbx.getValue());
	}
	
	public void buttonAction(ActionEvent event) {
		cbx.getItems().addAll("Ram", "Peter", "Marry", "Sam");
	}
}
