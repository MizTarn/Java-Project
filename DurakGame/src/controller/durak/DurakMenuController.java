package controller.durak;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import client.GameApplication;
import controller.ErrorController;
import controller.SceneLoader;

public class DurakMenuController {

	@FXML
	private Button btnConnect;

	@FXML
	private Button btnCreate;

	@FXML
	private Button btnNext;

	@FXML
	private TextField fieldName;

	@FXML
	private TextField fieldSessionId;

	@FXML
	private Label labelName;

	@FXML
	private Label labelSessionId;
	
	@FXML
	private Button btnNext1;

	private SimpleBooleanProperty connecting = new SimpleBooleanProperty(false);
	private SimpleBooleanProperty actionHapping = new SimpleBooleanProperty(false);
	private String sending;

	private String nameText;
	private String idText;

	@FXML
	void initialize() {
		fieldName.visibleProperty().bind(actionHapping);
		labelName.visibleProperty().bind(actionHapping);
		fieldSessionId.visibleProperty().bind(connecting);
		labelSessionId.visibleProperty().bind(connecting);
		btnNext.visibleProperty().bind(new SimpleBooleanProperty(true));
	}

	@FXML
	void connectRoom(ActionEvent event) {
		actionHapping.set(true);
		connecting.set(true);
		sending = "join_session";
	}

	@FXML
	void createRoom(ActionEvent event) {
		actionHapping.set(true);
		connecting.set(false);
		sending = "create_session";
	}

	@FXML
	void handleNext(ActionEvent event) {
		if (Objects.equals(sending, "join_session")) {
			nameText = fieldName.getText();
			idText = fieldSessionId.getText();
			if (nameText == null || idText == null) {
				ErrorController.showJoinFailedDialog();
			} else {
				try {
					GameApplication.client.joinSession(nameText, idText, "gui");
				} catch (NumberFormatException ex) {
					System.out.println("error");
				}

			}
		} else if (Objects.equals(sending, "create_session")) {
			nameText = fieldName.getText();
			idText = UUID.randomUUID().toString();
			if (nameText == null) {
				ErrorController.showJoinFailedDialog();
			} else {
				try {
					GameApplication.client.createSession(nameText, idText, "gui");
				} catch (NumberFormatException ex) {
					System.out.println("error");
				}
			}
		}
	}
	@FXML
	void handleNext1(ActionEvent event) {
		if (Objects.equals(sending, "join_session")) {
			nameText = fieldName.getText();
			idText = fieldSessionId.getText();
			if (nameText == null || idText == null) {
				ErrorController.showJoinFailedDialog();
			} else {
				try {
					GameApplication.client.joinSession(nameText, idText, "base");
				} catch (NumberFormatException ex) {
					System.out.println("error");
				}

			}
		} else if (Objects.equals(sending, "create_session")) {
			nameText = fieldName.getText();
			idText = UUID.randomUUID().toString();
			if (nameText == null) {
				ErrorController.showJoinFailedDialog();
			} else {
				try {
					GameApplication.client.createSession(nameText, idText, "base");
				} catch (NumberFormatException ex) {
					System.out.println("error");
				}
			}
		}
	}

	// hàm quay lại
	public void goBack(ActionEvent e) throws IOException {
		SceneLoader.loadScene(e, "/resource/fxml/ChoosePlayers.fxml");
	}

}
