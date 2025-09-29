package application;

import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

public class MainController implements Initializable{

	@FXML
	public ComboBox<String> cbx;
	
	@FXML
	public Label lblText;
	
	@FXML
	public ListView<String> listView;
	
	ObservableList<String> list = FXCollections.observableArrayList("Mark", "Tom", "Alice", "Jack");
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		cbx.setItems(list);
		listView.setItems(list);
		listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}

	public void comboChanged(ActionEvent event) {
		lblText.setText(cbx.getValue());
	}
	
	public void buttonAction(ActionEvent event) {
//		cbx.getItems().addAll("Ram", "Peter", "Marry", "Sam");
//		listView.getItems().addAll("Ram01", "Peter", "Marry", "Sam");
		
		ObservableList<String> names;
		names = listView.getSelectionModel().getSelectedItems();
		for (String name : names) {
			System.out.println(name);
		}
	}
}
