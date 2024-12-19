package controller;

import java.io.IOException;

import javafx.event.ActionEvent;

public class DurakController {
	public void loadCredit (ActionEvent e) throws IOException
	{
		SceneLoader.loadScene(e, "/resource/fxml/Credit.fxml");
	}
	
	public void loadChooseModeScene (ActionEvent e) throws IOException
	{
		SceneLoader.loadScene(e, "/resource/fxml/ChooseModeScene.fxml");
	}
	
	public void goBack (ActionEvent e) throws IOException
	{
		SceneLoader.loadScene(e, "/resource/fxml/WelcomeScene.fxml");
	}
}
