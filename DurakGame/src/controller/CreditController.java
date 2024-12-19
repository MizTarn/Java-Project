package controller;

import java.io.IOException;

import javafx.event.ActionEvent;

public class CreditController {
	public void goBack (ActionEvent e) throws IOException
	{
		SceneLoader.loadScene(e, "/resource/fxml/Durak.fxml");
	}
}
 