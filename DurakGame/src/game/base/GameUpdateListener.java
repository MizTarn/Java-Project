package game.base;

import javafx.application.Platform;
import view.BaseController;
import view.EndController;
import view.Game2Controller;
import view.GameBaseController;
import view.MenuController;
import view.WaitController;

import java.io.*;
import java.util.ArrayList;
import card.Card;
import card.HandForDurak;

	public abstract class GameUpdateListener{
	private NetworkManager networkManager;
	private UIManager uiManager;
	private MessageHandler messageHandler;
	private WaitController wc;
	private Game2Controller GameController;
	private EndController ec;
	private String username;
	private MenuController mc;
	private boolean isTurn;
	private String idPlayer;
	private GameBaseController GameBaseController;

	
	public EndController getEndController() {
		return ec;
	}

	public void setEndController(EndController ec) {
		this.ec = ec;
	}

	public WaitController getWaitController() {
		return wc;
	}

	public void setWaitController(WaitController wc) {
		this.wc = wc;
	}

	public NetworkManager getNetworkManager() {
		return networkManager;
	}

	public void setNetworkManager(NetworkManager networkManager) {
		this.networkManager = networkManager;
	}

	public UIManager getUiManager() {
		return uiManager;
	}

	public void setUiManager(UIManager uiManager) {
		this.uiManager = uiManager;
	}

	public MessageHandler getMessageHandler() {
		return messageHandler;
	}

	public void setMessageHandler(MessageHandler messageHandler) {
		this.messageHandler = messageHandler;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isTurn() {
		return isTurn;
	}

	public void setTurn(boolean isTurn) {
		this.isTurn = isTurn;
	}

	public UIManager getUIManager() {
		return uiManager;
	}

	public Game2Controller getGame2Controller() {
		return GameController;
	}

	public void setGame2Controller(Game2Controller GameController) {
		this.GameController = GameController;
	}

	public void setMenuController(MenuController mc) {
		this.mc = mc;
	}

	public MenuController getMenuController() {
		return mc;
	}

	public String getIdPlayer() {
		return idPlayer;
	}

	public void setIdPlayer(String idPlayer) {
		this.idPlayer = idPlayer;
	}
	
	public GameBaseController getGameBaseController() {
		return GameBaseController;
	}

	public void setGameBaseController(GameBaseController GameBaseController) {
		this.GameBaseController = GameBaseController;
	}
	
	public void receive() {
		// TODO Auto-generated method stub
		
	}

	public abstract void setHandFromData(String[] cards_hand, BaseController gameBaseController);

	public abstract void setTableFromData(String[] cards_table, BaseController gameBaseController);
	




}
