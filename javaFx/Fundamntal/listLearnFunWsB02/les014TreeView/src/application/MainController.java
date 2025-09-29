package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;

public class MainController implements Initializable{
	
	@FXML
	public TreeView<String> treeView;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		TreeItem<String> root = new TreeItem<String>("Root");
		root.setExpanded(true);
		
		TreeItem<String> nodeA = new TreeItem<>("nodeA");
		TreeItem<String> nodeB = new TreeItem<>("nodeB");
		TreeItem<String> nodeC = new TreeItem<>("nodeC");
		TreeItem<String> nodeD = new TreeItem<>("nodeD");
//		root.getChildren().add(nodeA);
//		root.getChildren().add(nodeB);
//		root.getChildren().add(nodeC);
//		root.getChildren().add(nodeD);
		root.getChildren().addAll(nodeA, nodeB, nodeC, nodeD);
		nodeA.setExpanded(true);
		
		TreeItem<String> nodeA1 = new TreeItem<>("nodeA1");
		TreeItem<String> nodeB1 = new TreeItem<>("nodeB1");
		TreeItem<String> nodeC1 = new TreeItem<>("nodeC1");
		TreeItem<String> nodeD1 = new TreeItem<>("nodeD1");
		
		nodeA.getChildren().addAll(nodeA1, nodeB1, nodeC1, nodeD1);
		
		treeView.setRoot(root);
		
	}

	public void mouseClick(MouseEvent mouseEvent) {
		if (mouseEvent.getClickCount() == 2) {
			TreeItem<String> item = treeView.getSelectionModel().getSelectedItem();
			System.out.println(item.getValue());
		}
	}
}
