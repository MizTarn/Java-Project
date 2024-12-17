package manager;

public class TurnManager<T> {
	private int currentActivePlayer;
	private PlayerManager<T> playerManager;

	public TurnManager(PlayerManager<T> playerManager) {
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
 