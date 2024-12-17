package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WelcomeSceneController implements Initializable{
	@FXML
	private ImageView durakGame;
	
	@FXML
	private Text durakText;
	
	@FXML
	private ImageView threeCardsGame;
	
	@FXML
	private Text threeCardsText;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		durakGame.setOnMouseEntered(e -> {
			durakText.setText("DURAK");
		});
		
		durakGame.setOnMouseExited(e -> {
			durakText.setText("");
		});
		durakGame.setOnMouseClicked(event -> {
			try {
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/Durak.fxml"));
                Stage stage = (Stage) durakGame.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
		});
		
		threeCardsGame.setOnMouseEntered(e -> {
			threeCardsText.setText("3-CARD");
		});
		
		threeCardsGame.setOnMouseExited(e -> {
			threeCardsText.setText("");
		});
		threeCardsGame.setOnMouseClicked(event -> {
			try {
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/ChoosePlayersThreeCards.fxml"));
                Stage stage = (Stage) threeCardsGame.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
		});
	}
}
