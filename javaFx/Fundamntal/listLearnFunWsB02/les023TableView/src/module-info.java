module les023TableView {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens application to javafx.base, javafx.graphics, javafx.fxml;
}
