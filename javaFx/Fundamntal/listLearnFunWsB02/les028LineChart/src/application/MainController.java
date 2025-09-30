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
		series.setName("Month Pay 1");
		
		XYChart.Series<String, Number> series2 = new XYChart.Series<String, Number>();
		series2.getData().add(new XYChart.Data<String, Number>("Jan", 100));
		series2.getData().add(new XYChart.Data<String, Number>("Feb", 200));
		series2.getData().add(new XYChart.Data<String, Number>("Mar", 200));
		series2.getData().add(new XYChart.Data<String, Number>("Apr", 400));
		series2.getData().add(new XYChart.Data<String, Number>("May", 100));
		series2.setName("Month Pay 2");
		
		XYChart.Series<String, Number> series3 = new XYChart.Series<String, Number>();
		series3.getData().add(new XYChart.Data<String, Number>("Jan", 500));
		series3.getData().add(new XYChart.Data<String, Number>("Feb", 100));
		series3.getData().add(new XYChart.Data<String, Number>("Mar", 400));
		series3.getData().add(new XYChart.Data<String, Number>("Apr", 300));
		series3.getData().add(new XYChart.Data<String, Number>("May", 600));
		series3.setName("Month Pay 3");
		
		lineChart.getData().addAll(series, series2, series3);
	}
}
