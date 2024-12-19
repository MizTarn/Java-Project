package server;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.HashMap;

import command.durak.DurakParseData;
import manager.PlayerManager;
import manager.TurnManager;
import manager.durak.DurakManager;
import manager.durak.DurakTable;
import player.DurakPlayer;
import server.bot.BotConnection;

public class DurakService implements GameService {
	
	  private final HashMap<String, ServerConnection> connections;

	    public DurakService(HashMap<String, ServerConnection> connections) {
	        this.connections = connections;
	    }
	
	@Override
	public void createSession(String sessionId, String hostNickname, String gui, int numberPlayer, BufferedReader in, PrintWriter out) {
		DurakTable tableManager = new DurakTable();
		PlayerManager<DurakPlayer> playerManager = new PlayerManager<>();
		TurnManager<DurakPlayer> turnManager = new TurnManager<>(playerManager);
		ConnectionManager connectionManager = new ConnectionManager();
		DurakManager gameManager = new DurakManager(tableManager, playerManager, turnManager);
		DurakParseData parseAndSendData = new DurakParseData(gameManager);

		DurakPlayer host = new DurakPlayer(hostNickname, sessionId);
		host.setGui(gui);

		ServerConnection connection = new ServerConnection(connectionManager, gameManager, parseAndSendData, numberPlayer);
		connection.addPlayer(in, out, host, gameManager);
		connections.put(sessionId, connection);

		Thread con = new Thread(connection);
		con.setDaemon(true);
		con.start();

	}

	@Override
	 public void joinSession(String sessionId, String playerNickname, String gui, BufferedReader in, PrintWriter out) {
        DurakPlayer player = new DurakPlayer(playerNickname);
        player.setGui(gui);

        if (connections.containsKey(sessionId)) {
            connections.get(sessionId).addStreams(in, out, player);
        } else {
            out.println("join_session_failed");
        }
    }

	@Override
	public void playWithBot(String hostNickname, BufferedReader in, PrintWriter out) {
        DurakTable tableManager = new DurakTable();
        PlayerManager<DurakPlayer> playerManager = new PlayerManager<>();
        TurnManager<DurakPlayer> turnManager = new TurnManager<>(playerManager);
        ConnectionManager connectionManager = new ConnectionManager();
        DurakManager gameManager = new DurakManager(tableManager, playerManager, turnManager);
        DurakParseData parseAndSendData = new DurakParseData(gameManager);

        DurakPlayer host = new DurakPlayer(hostNickname);
        host.setGui("gui");

        BotConnection connection = new BotConnection(connectionManager, gameManager, parseAndSendData, 1);
        connection.add(in, out, host);

        Thread con = new Thread(connection);
        con.setDaemon(true);
        con.start();
    }

}
