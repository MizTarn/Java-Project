package game.base;

import javafx.application.Platform;
import view.BaseController;
import view.MenuController;
import java.io.*;
import java.util.ArrayList;
import card.Card;
import card.HandForDurak;

public class Client extends GameUpdateListener {
	private NetworkManager networkManager;
	private MessageHandler messageHandler;
	private String username;
	private MenuController mc;
	private String idPlayer;
	public Client() {
		try {
			networkManager = new NetworkManager("localhost", 12345); 
			this.setUiManager(new UIManager());
			messageHandler = new MessageHandler(this);
			new Thread(this::receive, "Client Receive Thread").start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void receive() {
		while (true) {
			try {
				String data = networkManager.readData();
				if (data == null)
					break;
				Platform.runLater(() -> messageHandler.parseData(data));
			} catch (IOException e) {
				System.err.println("Error in receive thread: " + e.getMessage());
				break;
			}
		}
	}

	public String getIdPlayer() {
		return idPlayer;
	}


	public void setIdPlayer(String idPlayer) {
		this.idPlayer = idPlayer;
	}


	public void setHandFromData(String[] data, BaseController controller) {
		ArrayList<Card> cards = new ArrayList<>();
		for (String str : data) {
			cards.add(new Card(str));
		}
		controller.setCardsInHand(new HandForDurak(cards));
	}
	
	

	public void setTableFromData(String[] data, BaseController controller) {
		for (int i = 0; i < data.length; i++) {
			data[i] = data[i].strip();
		}
		ArrayList<Card> cards = new ArrayList<>();
		for (String str : data) {
			cards.add(new Card(str));
		}
//        table = cards;
		controller.setTable(cards); 
	}

	public void sendGameMove(String operation, Card card) {
		String data = operation;
		if (card != null) {
			data += "#" + card.toString() + "#" + idPlayer;
		} else {
			data += "#null" + "#" + idPlayer;
		}
		networkManager.sendData(data);
	}
	

	public void createSession(String name, String s_id) throws NumberFormatException {
		if (name == null) {
			Platform.runLater(() -> mc.showJoinFailedDialog());
		} else {
			this.username = name;
			String data = "create_session" + "#" + name + "#" + s_id;
			networkManager.sendData(data);
			System.out.println(s_id);
		}
	}

	public void joinSession(String username, String session_id) throws ClassCastException {
		if (username == null || session_id == null) {
//    		Platform.runLater(() -> mc.showJoinFailedDialog());
		} else {
			this.username = username;
			String data = "join_session#" + this.username + "#" + session_id;
			networkManager.sendData(data);
			System.out.println(data);
		}

	}



}
