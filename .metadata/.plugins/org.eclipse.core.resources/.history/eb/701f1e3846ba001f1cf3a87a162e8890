package manager;

import java.util.ArrayList;

import player.Player;

public class PlayerManager {
	private ArrayList<Player> players; // Danh sách người chơi

	public PlayerManager() {
		this.players = new ArrayList<Player>();
	}

	public PlayerManager(ArrayList<Player> players) {
		this.players = players;
//	        this.currentActivePlayer = 0;
	}

	// Thêm người chơi
	public void addPlayer(Player player) {
		players.add(player);
	}

	// Xóa người chơi
	public void removePlayer(Player player) {
		players.remove(player);
	}

	// Lấy danh sách người chơi
	public ArrayList<Player> getPlayers() {
		return players;
	}

	// Kiểm tra người chơi thắng
	public boolean isWinner(Player player) {
		return player.getHand().getCardsInHand().isEmpty();
	}

	public void setDefendPlayer(int idPlayer) {
		for (int i = 0; i < players.size(); i++) {
			if (i == idPlayer) {
				players.get(i).setAttacker(false);
			} else {
				players.get(i).setAttacker(true);
			}
		}
	}
}
