package server.bot;

import java.util.Collections;
import java.util.Comparator;

import card.Card;
import card.Card.Suit;
import player.Player;

public class BotStrategy {
	private Player bot;
	public BotStrategy(Player bot) {
		this.setBot(bot);
	}
	
	public Player getBot() {
		return bot;
	}

	public void setBot(Player bot) {
		this.bot = bot;
	}
	
	public Card chooseCardToAttack() {
		Card minCard = Collections.min(bot.getHand().getCardsInHand(), Comparator.comparingInt(c -> c.getValue().getRank()));
		return minCard;
	}
	
	public Card chooseCardToDefend(Card cardToDefend, Suit trump) {
		for(Card cd : bot.getHand().getCardsInHand()) {
			if(cd.getSuit().equals(cardToDefend.getSuit()) && cd.getValue().getRank() > cardToDefend.getValue().getRank()) {
				return cd;
			}
			else if(cd.getSuit().equals(trump) && !cardToDefend.getSuit().equals(trump)) {
				return cd;
			}
		}
		return null;
	}
}
