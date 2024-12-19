package controller;

import javafx.application.Platform;
import javafx.scene.control.Alert;

public class ErrorController {
	public static void showJoinFailedDialog() {
		Platform.runLater(() -> {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Error");
			alert.showAndWait();
			Platform.exit();
		});
	}
}
