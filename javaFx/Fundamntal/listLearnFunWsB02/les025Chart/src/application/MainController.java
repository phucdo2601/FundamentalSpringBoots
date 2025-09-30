package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class MainController {

	@FXML
	public PieChart pieChart;
	
	@FXML
	public Label lblStatus;

	public void btn(ActionEvent event) {
		ObservableList<Data> list = FXCollections.observableArrayList(
				new PieChart.Data("Java", 50),
				new PieChart.Data("C#", 20),
				new PieChart.Data("C", 30),
				new PieChart.Data("C++", 10),
				new PieChart.Data("PHP", 15)
				);
		
		pieChart.setData(list);
		
		for (final PieChart.Data data: pieChart.getData()) {
			data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent arg0) {
					// TODO Auto-generated method stub
					lblStatus.setText(String.valueOf(data.getPieValue()) + "%");
				}
			});
		}
	}
}
