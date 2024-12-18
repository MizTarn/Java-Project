package command.durak;

import command.Command;
import manager.PlayerManager;
import manager.durak.DurakTable;
import player.DurakPlayer;

public class DiscardCommand implements Command {
	private PlayerManager<DurakPlayer> playerManager;
	private DurakTable tableManager;

	public DiscardCommand(PlayerManager<DurakPlayer> playerManager, DurakTable tableManager) {
		this.playerManager = playerManager;
		this.tableManager = tableManager;
	}
 
	@Override
	public boolean execute(String[] params) throws Exception {
		try {
			System.out.println("bo bai (discard connection)");
			tableManager.getTable().clear();
			tableManager.drawCardsForPlayers(playerManager.getPlayers());
			for (DurakPlayer player : playerManager.getPlayers()) {
				player.setAttacker(false);
			}
			tableManager.setChangeMove(false);
			return true;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
 
	}

}
