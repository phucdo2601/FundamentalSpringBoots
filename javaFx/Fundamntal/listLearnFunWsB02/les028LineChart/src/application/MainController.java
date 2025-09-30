package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class MainController {
	@FXML
	public LineChart<String, Number> lineChart;
	
	public void btn(ActionEvent event) {
		lineChart.getData().clear();
		XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
		series.getData().add(new XYChart.Data<String, Number>("Jan", 200));
		series.getData().add(new XYChart.Data<String, Number>("Feb", 300));
		series.getData().add(new XYChart.Data<String, Number>("Mar", 100));
		series.getData().add(new XYChart.Data<String, Number>("Apr", 500));
		series.getData().add(new XYChart.Data<String, Number>("May", 400));
		series.setName("Month Pay");
		lineChart.getData().add(series);
	}
}
