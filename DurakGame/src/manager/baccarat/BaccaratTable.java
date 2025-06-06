package manager.baccarat;

import java.util.ArrayList;
import card.Card;
import card.Deck;
import manager.Table;

public class BaccaratTable implements Table {
	private ArrayList<Card> table;
	private boolean changeMove;
	private Deck deck;
	
	public BaccaratTable() { 
		this.setTable(new ArrayList<Card>());
		this.setDeck(new Deck());
		this.setChangeMove(false);
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public boolean isChangeMove() {
		return changeMove;
	}

	public void setChangeMove(boolean changeMove) {
		this.changeMove = changeMove;
	}

	public ArrayList<Card> getTable() {
		return table;
	}

	public void setTable(ArrayList<Card> table) {
		this.table = table;
	}
	public void newBaccaratTable() {
		table = new ArrayList<Card>();
	}

}
