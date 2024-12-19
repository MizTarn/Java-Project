package manager;

import java.util.ArrayList;

import card.Card;
import card.Deck;

public interface Table {
	public Deck getDeck();

	public void setDeck(Deck deck);
	
	public ArrayList<Card> getTable();

}
