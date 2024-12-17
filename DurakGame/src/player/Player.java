package player;

import java.io.Serializable;

import card.HandForDurak;

public class Player extends BasePlayer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	boolean attacker;
	private boolean isDefender;
	private HandForDurak hand;
	
	public Player(String nickname, String session_id) {
		super(nickname, session_id);
		hand = new HandForDurak();
	}

	public Player(String nickname) {
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
