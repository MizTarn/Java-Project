package controller.durak;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.Objects;

import card.Card;
import card.HandForDurak;
import client.GameApplication;

public abstract class DurakBaseController {

	@FXML
	private Button btnAction;

	@FXML
	private HBox hand;

	@FXML
	private Label sizeDeck;

	@FXML
	private FlowPane table;

	@FXML
	private Label labelTrumpCard; 
	@FXML
	private Label labelMove;

	public void setDisableActions(boolean flag) {
		btnAction.setDisable(!flag);
		for (Node nd : hand.getChildren()) {
			nd.setDisable(!flag);
		}
		labelMove.setVisible(flag);
	}

	public void setTextAction(String str) {
		btnAction.setText(str);
		if (Objects.equals(str, "Discard")) {
			btnAction.setOnAction(this::discard);
		} else if (Objects.equals(str, "Take")) {
			btnAction.setOnAction(this::take);
		} else if (Objects.equals(str, "Pass")) {
			btnAction.setOnAction(this::pass);
		} else {
			btnAction.setDisable(true);
		}
	}


	public void setSize(int i) {
		sizeDeck.setText(Integer.toString(i));
	}

	public void take(ActionEvent event) {
		GameApplication.client.sendGameMove("take_card", null);
		 labelMove.setText("You have taken the card!");

	}

	public void discard(ActionEvent event) {
		GameApplication.client.sendGameMove("discard", null);
	}

	public void pass(ActionEvent event) {
		GameApplication.client.sendGameMove("pass", null);
	}

	public void setCardsInHand(HandForDurak handForDurak) {
	}

	public void setTable(ArrayList<Card> cards) {
		
	}
	
	public void setTrumpCardImage(Card cd) {
	}

	public void trumpCardUsed() {
	}

	public abstract void setDisablePlayer3Image();

	public abstract void setDisablePlayer4Image();
}
