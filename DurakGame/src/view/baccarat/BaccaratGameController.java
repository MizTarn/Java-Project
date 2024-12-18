package view.baccarat;

import java.util.ArrayList;

import card.Card;
import card.HandForBaccarat;
import cardprocessor.CardComparator;
import client.GameApplication;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

public class BaccaratGameController extends BaccaratBaseController {
	@FXML
	private HBox hand;

	@FXML
	private FlowPane table;

	
	
	private final CardComparator<Node> comparator = new CardComparator<>();

	@Override
	public void setCardsInHand(HandForBaccarat updating) {
		hand.getChildren().clear();
		if (updating != null) {
			for (Card cd : updating.getCardsInHand()) { 
				ImageView iv = new ImageView(cd.getImage()); 
				iv.setFitHeight(175);
				iv.setFitWidth(100); 
				iv.setUserData(cd);
//				iv.setOnMouseClicked(this::drop);
				System.out.println("DROP CAI NAY (O TRONG Baccarat)");
				hand.getChildren().add(iv);
			}
			FXCollections.sort(hand.getChildren(), comparator);
		}
	}

	@Override
	public void setTable(ArrayList<Card> t) {
		table.getChildren().clear();
		if (!t.isEmpty()) {
			for (Card cd : t) {
				ImageView iv = new ImageView(cd.getImage());
				iv.setFitHeight(175);
				iv.setFitWidth(100);
				iv.setUserData(cd);
				iv.setDisable(true);
				table.getChildren().add(iv);
			}
		}
	}
	
	@FXML
	public void play(ActionEvent event) {
		System.out.println("gui du lieu play");
		GameApplication.client.sendGameMove("play", null);
	}
	
	
}
