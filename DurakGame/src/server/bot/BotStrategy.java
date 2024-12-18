package server.bot;

import java.util.Collections;
import java.util.Comparator;

import card.Card;
import card.Card.Suit;
import player.DurakPlayer;

public class BotStrategy {
	private DurakPlayer bot;
	public BotStrategy(DurakPlayer bot) {
		this.setBot(bot);
	}
	
	public DurakPlayer getBot() {
		return bot;
	}

	public void setBot(DurakPlayer bot) {
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
