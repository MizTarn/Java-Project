package view.durak;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.util.ArrayList;

import application.GameApplication;
import card.Card;
import card.HandForDurak;
import cardprocessor.CardComparator;

public class DurakGameBaseController extends DurakBaseController {

	@FXML
	private Button btnAction;

	@FXML
	private HBox hand;

	@FXML
	private Label sizeDeck;

	@FXML
	private FlowPane table;

	@FXML
	private Label textCard;

	@FXML
	private Label labelTrumpCard; 
	@FXML
	private Label labelMove;
	private final CardComparator<Node> comparator = new CardComparator<>();

	@Override
	public void setCardsInHand(HandForDurak updating) {
		hand.getChildren().clear();
		if (updating != null) {
			for (Card cd : updating.getCardsInHand()) { 
				Text iv = new Text(cd.toString() + "  "); 
				iv.setStyle("-fx-font-size: 18px; -fx-fill: blue;"); // Định dạng văn bản
				iv.setUserData(cd);
				iv.setOnMouseClicked(this::drop);
				System.out.println("DROP CAI NAY (O TRONG GAME2CONTROLLER)");
				hand.getChildren().add(iv);
			}
			FXCollections.sort(hand.getChildren(), comparator);
		}
	}

	public void setTrumpCardImage(Card cd) {
		textCard.setText(cd.toString());
	}


	public void trumpCardUsed() {
		textCard.setText(null);
		labelTrumpCard.setVisible(false);
	}

	public void setTable(ArrayList<Card> t) {
		table.getChildren().clear();
		if (!t.isEmpty()) {
			for (Card cd : t) {
				Text iv = new Text(cd.toString() + "  ");
				iv.setStyle("-fx-font-size: 18px; -fx-fill: blue;"); // Định dạng văn bản
				iv.setUserData(cd);
				iv.setDisable(true);
				table.getChildren().add(iv);
			}
		}
	}

	
	public void drop(MouseEvent event) {
	    Text text = (Text) event.getSource();
	    Card cd = (Card) text.getUserData();
	    GameApplication.client.sendGameMove("drop_card", cd);
	    System.out.println("Đã gửi drop_card(controller): " + cd.toString());
	}

}
