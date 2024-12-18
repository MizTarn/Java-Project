package server.bot;

import java.io.BufferedReader;
import java.io.PrintWriter;

import command.durak.DurakParseData;
import manager.durak.DurakManager;
import player.DurakPlayer;
import server.ConnectionManager;

public class BotConnection implements Runnable {
	private DurakManager gameManager;
	private DurakPlayer botPlayer;
	private DurakParseData parseAndSendData;
	private ConnectionManager connectionManager;
	private BotTurnProcessor botTurnProcessor;
	private BotStrategy botStrategy;
	private boolean initializeGame = false;

	private int numPlayer;

	public BotConnection(ConnectionManager connectionManager, DurakManager gameManager, DurakParseData parseAndSendData,
			int numPlayer) {
		this.connectionManager = connectionManager;
		this.gameManager = gameManager;
		this.parseAndSendData = parseAndSendData;
		this.setNumPlayer(numPlayer);
		this.botPlayer = new DurakPlayer("botplayer");
		this.botPlayer.setGui("gui");
		this.botStrategy = new BotStrategy(botPlayer);
		this.botTurnProcessor = new BotTurnProcessor(botStrategy, gameManager);
		System.out.println("start1");
//		this.connectionManager.addConnection(in, out);
//		this.gameManager.getPlayerManager().addPlayer(player);
//		this.connectionManager.sendDataToAll("started");
//		this.gameManager.setGameStarted(true);
//		System.out.println("start");
//		this.gameManager.getPlayerManager().addPlayer(botPlayer);

	}

	public void add(BufferedReader in, PrintWriter out, DurakPlayer player) {
		this.connectionManager.addConnection(in, out);
		this.gameManager.getPlayerManager().addPlayer(player);
		this.connectionManager.sendDataToAll("started");
		this.gameManager.setGameStarted(true);
		System.out.println("start");
		this.gameManager.getPlayerManager().addPlayer(botPlayer);
	}

	public DurakManager getGameManager() {
		return gameManager;
	}

	public void setGameManager(DurakManager gameManager) {
		this.gameManager = gameManager;
	}

	public DurakPlayer getBotPlayer() {
		return botPlayer;
	}

	public void setBotPlayer(DurakPlayer botPlayer) {
		this.botPlayer = botPlayer;
	}

	public int getNumPlayer() {
		return numPlayer;
	}

	public void setNumPlayer(int numPlayer) {
		this.numPlayer = numPlayer;
	}

	public BotStrategy getbotStrategy() {
		return botStrategy;
	}

	public void setbotStrategy(BotStrategy botStrategy) {
		this.botStrategy = botStrategy;
	}

	public void processAndUpdateGameState(String data) {
		parseAndSendData.parseData(data);
		gameManager.changeMove();
		connectionManager.sendData(gameManager.getGameStateAndPermission(0), connectionManager.getOutputs().get(0));
	}

	@Override
	public void run() {
		System.out.println("Bắt đầu chạy vòng lặp chính của trò chơi với bot ....");

		while (true) {
			try {
				if (gameManager.isGameStarted()) {
					if (!initializeGame) {
						gameManager.startGame();
						connectionManager.sendData(gameManager.getGameStart(0), connectionManager.getOutputs().get(0));
						initializeGame = true;
					}
					int currentPlayer = gameManager.getTurnManager().getCurrentActivePlayer();
					System.out.println("Đang chờ dữ liệu từ người chơi: " + currentPlayer);
					if (currentPlayer == 0) {
						System.out.println("nhan nao");
						String data = connectionManager.readData(0);
						System.out.println("da nhan tu read data");
						if (data != null && !data.isEmpty()) {
							System.out.println("Dữ liệu nhận được: " + data);
							processAndUpdateGameState(data);
						} else {
							System.out.println("Không nhận được dữ liệu từ người chơi: " + currentPlayer);
						}
					} else {
						if (!gameManager.getTableManager().getDefendingCards().isEmpty() && botStrategy
								.chooseCardToDefend(gameManager.getTableManager().getDefendingCards().peek(),
										gameManager.getTableManager().getTrumpCard().getSuit()) != null) {
							processAndUpdateGameState(botTurnProcessor.defendAction());
						} else if (gameManager.getTableManager().getDefendingCards().isEmpty()) {
							System.out.println("con bot dang : " + gameManager.getTurn(1));
							if ("attacker".equals(gameManager.getTurn(1))
									&& !gameManager.getTableManager().getTable().isEmpty()) {
								processAndUpdateGameState(botTurnProcessor.passAction());
							} else if ("attacker".equals(gameManager.getTurn(1))
									&& gameManager.getTableManager().getTable().isEmpty()) {
								processAndUpdateGameState(botTurnProcessor.attackAction());
							} else {
								processAndUpdateGameState(botTurnProcessor.discardAction());
								processAndUpdateGameState(botTurnProcessor.attackAction());
							}
						} else {
							processAndUpdateGameState(botTurnProcessor.takeAction());
						}
					}
					if (gameManager.checkWin()) {
						System.out.println("Trò chơi kết thúc!");
						connectionManager.sendDataToAll("end_game#");
						break;
					}
				}
				Thread.sleep(1000);
			} catch (Exception e) {
				System.err.println("Lỗi trong vòng lặp chính: " + e.getMessage());
				e.printStackTrace();
			}
		}
	}

}
