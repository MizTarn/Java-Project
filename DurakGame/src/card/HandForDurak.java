package card;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class HandForDurak extends BaseHand {


 
	public HandForDurak(ArrayList<Card> cardsInHand) {
		super(cardsInHand);
	}
 
	public HandForDurak() {
		super();
	}

	// Tra ve va loai bo la bai cd ra khoi tay nguoi choi
	public Card getCard(Card cd) throws Exception {
		for (Card card : getCardsInHand()) {
			if (Objects.equals(card.toString(), cd.toString())) {
				this.getCardsInHand().remove(card);
				setCurrentNumOfCard(getCurrentNumOfCard() - 1);
				return cd;
			}
		}
		throw new Exception("Lỗi không lấy được bài");
	}


	public void addCards(Collection<Card> cds) throws Exception {
		if (cds != null) {
			this.getCardsInHand().addAll(cds);
			setCurrentNumOfCard(getCurrentNumOfCard() + cds.size());
		} else {
			throw new Exception("Lỗi không thêm được nhiều lá bài");
		}
	}

}
