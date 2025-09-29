package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class MainController {

	@FXML
	private CheckBox chkb1;
	
	@FXML
	private CheckBox chkb2;
	
	@FXML
	private CheckBox chkb3;
	
	@FXML
	private CheckBox chkb4;
	
	@FXML
	private Label lblList;
	
	@FXML
	private Label lblCount;
	
	public void checkEvent(ActionEvent event) {
		int count = 0;
		String message = "";
		if (chkb1.isSelected()) {
			count++;
			message += chkb1.getText() + "\n";
		}
		
		if (chkb2.isSelected()) {
			count++;
			message += chkb2.getText() + "\n";
		}
		
		if (chkb3.isSelected()) {
			count++;
			message += chkb3.getText() + "\n";
		}
		
		if (chkb4.isSelected()) {
			count++;
			message += chkb4.getText() + "\n";
		}
		
		lblCount.setText("Items selected: "+count);
		lblList.setText(message);
	}
}
