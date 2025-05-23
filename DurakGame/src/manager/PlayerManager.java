package manager;

import java.util.ArrayList;

public class PlayerManager<T> {
	private ArrayList<T> players; // Danh sách người chơi

	public PlayerManager() {
		this.players = new ArrayList<T>();
	}

	public PlayerManager(ArrayList<T> players) {
		this.players = players;
//	        this.currentActivePlayer = 0;
	}

	// Thêm người chơi
	public void addPlayer(T player) {
		players.add(player);
	}

	// Xóa người chơi
	public void removePlayer(T player) {
		players.remove(player);
	}

	// Lấy danh sách người chơi
	public ArrayList<T> getPlayers() {
		return players;
	}

	// Kiểm tra người chơi thắng
//	public boolean isWinner(Player player) {
//		return player.getHand().getCardsInHand().isEmpty();
//	}

	
}
