package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class MainController {

	@FXML
	private RadioButton rBtnMale;

	@FXML
	private RadioButton rBtnFemale;

	@FXML
	private Label lblText;
	
	public void radioSelect(ActionEvent event) {
		String message = "";
		if (rBtnMale.isSelected()) {
			message += rBtnMale.getText() + "\n";
		}
		
		if (rBtnFemale.isSelected()) {
			message += rBtnFemale.getText() + "\n";
		}
		lblText.setText(message);
	}
}
