package manager;

public class TurnManager {
	private int currentActivePlayer;
	private PlayerManager playerManager;

	public TurnManager(PlayerManager playerManager) {
		this.playerManager = playerManager;
		this.currentActivePlayer = 0;
	}

	public int getCurrentActivePlayer() {
		return currentActivePlayer;
	}

	public void setCurrentActivePlayer(int playerIndex) {
		this.currentActivePlayer = playerIndex;
	}

	public void nextPlayer() {
		currentActivePlayer = (currentActivePlayer + 1) % playerManager.getPlayers().size();
	}

}
