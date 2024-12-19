package controller;

import java.io.IOException;

import client.GameApplication;
import javafx.event.ActionEvent;

public class BaccaratController {
	public void goBack(ActionEvent e) throws IOException {
		SceneLoader.loadScene(e, "/resource/fxml/WelcomeScene.fxml");
	}

	public void chooseTwo(ActionEvent e) throws IOException {
		SceneLoader.loadScene(e, "/resource/fxml/BaccaratMenu.fxml");
		GameApplication.client.numberPlayer("2");
	}

	public void chooseThree(ActionEvent e) throws IOException {
		SceneLoader.loadScene(e, "/resource/fxml/BaccaratMenu.fxml");
		GameApplication.client.numberPlayer("3");
	}

	public void chooseFour(ActionEvent e) throws IOException {
		SceneLoader.loadScene(e, "/resource/fxml/BaccaratMenu.fxml");
		GameApplication.client.numberPlayer("4");
	}
}
