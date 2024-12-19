package player;

import card.HandForDurak;

public class DurakPlayer extends BasePlayer {
	
	private boolean attacker;
	private boolean isDefender;
	private HandForDurak hand;
	
	public DurakPlayer(String nickname, String session_id) {
		super(nickname, session_id);
		hand = new HandForDurak();
	}

	public DurakPlayer(String nickname) {
		super(nickname);
		hand = new HandForDurak();
	}

	public void setAttacker(boolean b) {
		attacker = b;
	}

	public boolean isAttacker() { 
		return attacker;
	}

	public boolean isDefender() {
		return isDefender;
	}

	public void setDefender(boolean isDefender) {
		this.isDefender = isDefender;
	}
	
	public HandForDurak getHand() {
		return hand;
	}

	public void setHand(HandForDurak hand) {
		this.hand = hand;
	}

}
