package client;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UIManager {
	public <T> T openWait() {
		return loadFXML("/resource/fxml/waiting.fxml", "WAITING ROOM", GameApplication.stage);

	}

	public <T> T openGameGUI() {
		return loadFXML("/resource/fxml/game2.fxml", "GAME", GameApplication.stage);
	}

	public <T> T openGameBase() {
		return loadFXML("/resource/fxml/gamebase.fxml", "GAME", GameApplication.stage);
	}

	public <T> T openEnd() {
		return loadFXML("/resource/fxml/end.fxml", "ENDING", GameApplication.stage);
	}

	public <T> T openBaccaratGame() {
		return loadFXML("/resource/fxml/BaccaratGame.fxml", "BaccaratGame", GameApplication.stage);
	}
	
	public <T> T openBaccaratGameBase() {
		return loadFXML("/resource/fxml/BaccaratBase.fxml", "BaccaratGame", GameApplication.stage);
	}
	public <T> T openWin() {
		return loadFXML("/resource/fxml/WinningScene.fxml", "Win", GameApplication.stage);
	}
	public <T> T openLose() {
		return loadFXML("/resource/fxml/LosingScene.fxml", "Lose", GameApplication.stage);
	}

	public <T> T loadFXML(String fxmlFile, String title, Stage stage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
			Parent root = loader.load();
			stage.close();
			stage.setTitle(title);
			stage.setScene(new Scene(root));
			stage.show();
//            return loader;
			return loader.getController(); // Trả về Controller
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Error loading " + fxmlFile);
		}
		return null;
	}
	
	

}
