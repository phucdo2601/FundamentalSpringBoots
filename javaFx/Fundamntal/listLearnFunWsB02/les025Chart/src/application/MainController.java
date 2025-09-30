package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;

public class MainController {

	@FXML
	public PieChart pieChart;

	public void btn(ActionEvent event) {
		ObservableList<Data> list = FXCollections.observableArrayList(
				new PieChart.Data("Java", 50),
				new PieChart.Data("C#", 20),
				new PieChart.Data("C", 30),
				new PieChart.Data("C++", 10),
				new PieChart.Data("PHP", 15)
				);
		
		pieChart.setData(list);
	}
}
