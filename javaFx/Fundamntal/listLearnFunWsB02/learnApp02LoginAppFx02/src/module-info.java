module learnApp02LoginAppFx02 {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens application to javafx.graphics, javafx.fxml;
}
