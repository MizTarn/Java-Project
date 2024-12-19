package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class EndGameController implements Initializable, EndController{
	@FXML
	private VBox rootPane;
	
	@FXML
	private StackPane buttonContainer;
	
	@FXML
	private Button replay;
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub
		rootPane.setOpacity(0);
		buttonContainer.setOpacity(0);
		SceneLoader.makeFadeTransition(1, rootPane);
		PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(event -> SceneLoader.makeFadeTransition(1, buttonContainer)); // Gọi hàm thứ hai sau 1 giây
        pause.play();
	}

	public void loadMainMenu(ActionEvent e) throws IOException 
	{
		SceneLoader.loadScene(e, "/resource/fxml/Durak.fxml");
	}
	
	public void loadChooseModeScene (ActionEvent e) throws IOException
	{
		SceneLoader.loadScene(e, "/resource/fxml/ChooseModeScene.fxml");
	}
}
