package server;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.HashMap;

import command.baccarat.BaccaratParseData;
import manager.PlayerManager;
import manager.TurnManager;
import manager.baccarat.BaccaratManager;
import manager.baccarat.BaccaratTable;
import player.BaccaratPlayer;

public class BaccaratService implements GameService {

	private final HashMap<String, ServerConnection> connections;

    public BaccaratService(HashMap<String, ServerConnection> connections) {
        this.connections = connections;
    }
	
	@Override
	public void createSession(String sessionId, String hostNickname, String gui, int numberPlayer, BufferedReader in, PrintWriter out) {
		BaccaratTable tableManager = new BaccaratTable();
		PlayerManager<BaccaratPlayer> playerManager = new PlayerManager<BaccaratPlayer>();
		TurnManager<BaccaratPlayer> turnManager = new TurnManager<BaccaratPlayer>(playerManager);
		ConnectionManager connectionManager = new ConnectionManager();
		BaccaratManager gameManager = new BaccaratManager(tableManager, playerManager, turnManager);
		BaccaratParseData parseAndSendData = new BaccaratParseData(gameManager);
		BaccaratPlayer host = new BaccaratPlayer(hostNickname, sessionId);
		host.setGui(gui);
		ServerConnection connection = new ServerConnection(connectionManager, gameManager,
				parseAndSendData, numberPlayer);
		connection.addPlayer(in, out, host, gameManager);
		connections.put(host.getId(), connection);
		Thread con = new Thread(connection);
		con.setDaemon(true);
		con.start();
		
	}

	@Override
	public void joinSession(String sessionId, String playerNickname, String gui, BufferedReader in, PrintWriter out) {
		BaccaratPlayer member = new BaccaratPlayer(playerNickname);
		member.setGui(gui);
		if (connections.containsKey(sessionId)) {
			connections.get(sessionId).addStreams(in, out, member);
		} else {
			out.println("join_session_failed");
		}
		
	}

	@Override
	public void playWithBot(String hostNickname, BufferedReader in, PrintWriter out) {
		// TODO Auto-generated method stub
		
	}

}
