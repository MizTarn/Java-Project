package command.durak;

import command.Command;
import manager.PlayerManager;
import manager.durak.DurakTable;
import player.DurakPlayer;

public class TakeCardCommand implements Command {

	private PlayerManager<DurakPlayer> playerManager;
	private DurakTable tableManager;

	public TakeCardCommand(PlayerManager<DurakPlayer> playerManager, DurakTable tableManager) {
		this.playerManager = playerManager;
		this.tableManager = tableManager;
	}

	@Override
	public boolean execute(String[] params) throws Exception { // take_card#card#idPlayer
		int idPlayer = Integer.parseInt(params[2]);
		System.out.println("Rút bài...");
		DurakPlayer currentPlayer = playerManager.getPlayers().get(idPlayer);
		currentPlayer.getHand().addCards(tableManager.getTable());
		tableManager.clearTable();
		tableManager.getDefendingCards().clear();
		tableManager.drawCardsForPlayers(playerManager.getPlayers());
		tableManager.setChangeMove(true);
		
		return true; 
 
	}

}
