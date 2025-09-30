package application;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class MainController implements Initializable {

	@FXML
	public MediaView mediaView;
	
	public MediaPlayer mp;
	
	public Media me;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		String path = new File("src/media/testVid01.mp4").getAbsolutePath();
		me = new Media(new File(path).toURI().toString());
		mp = new MediaPlayer(me);
		mediaView.setMediaPlayer(mp);
		mp.setAutoPlay(true);
		DoubleProperty width = mediaView.fitWidthProperty();
		DoubleProperty height = mediaView.fitHeightProperty();
		width.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
		height.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));
	}
	
	public void play(ActionEvent event) {
		mp.play();
	}
	
	public void pause(ActionEvent event) {
		mp.pause();
	}
	
	public void fast(ActionEvent event) {
		mp.setRate(2);
	}
	
	public void slow(ActionEvent event) {
		mp.setRate(0.5);
	}
	
	public void reload(ActionEvent event) {
		mp.seek(mp.getStartTime());
		mp.play();
	}
	
	public void start(ActionEvent event) {
		mp.seek(mp.getStartTime());
		mp.stop();
	}
	
	public void last(ActionEvent event) {
		mp.seek(mp.getTotalDuration());
		mp.stop();
	}

}
