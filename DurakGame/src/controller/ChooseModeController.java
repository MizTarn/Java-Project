package controller;

import java.io.IOException;

import client.GameApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ChooseModeController {
	public void loadChoosePlayers(ActionEvent e) throws IOException
	{
		SceneLoader.loadScene(e, "/resource/fxml/ChoosePlayers.fxml");
	}
	
	public void goBack (ActionEvent e) throws IOException
	{
		SceneLoader.loadScene(e, "/resource/fxml/Durak.fxml");
	}
	
	@FXML
	public void playWithBot(ActionEvent event) {
		try {
			System.out.println("Khong bi loi dau nhe");
			GameApplication.client.joinBotSession("you");
		} catch (NumberFormatException ex) {
			System.out.println("DA BI LOI 123");
		}
	}
}
