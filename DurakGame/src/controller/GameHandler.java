package controller;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameHandler {
	public static void Initialize(Node e, Text t, String s1, String s2, String s3)
	{
		e.setOnMouseEntered (event -> t.setText(s1));
		e.setOnMouseExited (event -> t.setText(s2));
		e.setOnMouseClicked(event -> {
			try {
                Parent root = FXMLLoader.load(GameHandler.class.getResource(s3));
                Stage stage = (Stage) e.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
		});
	}
}
