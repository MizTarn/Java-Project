package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class WelcomeSceneController implements Initializable{
	@FXML
	private ImageView durakGame;
	
	@FXML
	private Text durakText;
	
	@FXML
	private ImageView baccaratGame;
	
	@FXML
	private Text baccaratText;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		GameHandler.Initialize(durakGame, durakText, "Durak", "", "/resource/fxml/Durak.fxml");
		GameHandler.Initialize(baccaratGame, baccaratText, "Baccarat", "", "/resource/fxml/ChoosePlayersBaccarat.fxml");
	}
}
