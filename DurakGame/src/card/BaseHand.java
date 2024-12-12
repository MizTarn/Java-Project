package card;

import java.util.ArrayList;

public class BaseHand {
	private ArrayList<Card> cardsInHand;
	private int currentNumOfCard;
 
	public BaseHand(ArrayList<Card> cardsInHand) {
		this.cardsInHand = cardsInHand;
		this.setCurrentNumOfCard(cardsInHand.size());
	}

	public BaseHand() {
		this.cardsInHand = new ArrayList<>();
		this.setCurrentNumOfCard(0);
	}


	public void addCard(Card cd) throws Exception {
		if (cd != null) {
			cardsInHand.add(cd);
			setCurrentNumOfCard(getCurrentNumOfCard() + 1);
		} else {
			throw new Exception("Lỗi không thêm được bài");
		}
	}

	public void reset() {
		cardsInHand.clear();
		setCurrentNumOfCard(0);
	}

	public ArrayList<Card> getCardsInHand() {
		return cardsInHand;
	}

	@Override
	public String toString() {
		String data = "#";
		for (Card cd : getCardsInHand()) {
			data += cd.toString() + "#";
		}
		return data;
	}

	public int getCurrentNumOfCard() {
		return currentNumOfCard;
	}

	public void setCurrentNumOfCard(int currentNumOfCard) {
		this.currentNumOfCard = currentNumOfCard;
	}
}
