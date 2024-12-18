package client;

import view.EndController;
import view.WaitController;
import view.baccarat.BaccaratBaseController;
import view.baccarat.BaccaratGameBaseController;
import view.baccarat.BaccaratGameController;
import view.durak.DurakBaseController;
import view.durak.DurakGameBaseController;
import view.durak.DurakGameController;
import view.durak.DurakMenuController;

public abstract class GameUpdateListener {
	private NetworkManager networkManager;
	private UIManager uiManager;
	private ClientMessage messageHandler;
	private WaitController wc;
	private DurakGameController GameController;
	private EndController ec;
	private String username;
	private BaccaratGameController baccaratGameController;
	private BaccaratGameBaseController baccaratGameBaseController;
	private DurakMenuController mc;
	private boolean isTurn;
	private String idPlayer;
	private DurakGameBaseController GameBaseController;

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

	public void setUIManager(UIManager uiManager) {
		this.uiManager = uiManager;
	}

	public ClientMessage getMessageHandler() {
		return messageHandler;
	}

	public void setMessageHandler(ClientMessage messageHandler) {
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

	public DurakGameController getGame2Controller() {
		return GameController;
	}

	public void setGame2Controller(DurakGameController GameController) {
		this.GameController = GameController;
	}

	public void setMenuController(DurakMenuController mc) {
		this.mc = mc;
	}

	public DurakMenuController getMenuController() {
		return mc;
	}

	public String getIdPlayer() {
		return idPlayer;
	}

	public void setIdPlayer(String idPlayer) {
		this.idPlayer = idPlayer;
	}

	public DurakGameBaseController getGameBaseController() {
		return GameBaseController;
	}

	public void setGameBaseController(DurakGameBaseController GameBaseController) {
		this.GameBaseController = GameBaseController;
	}

	public abstract void setHandFromData(String[] cards_hand, DurakBaseController gameBaseController);

	public abstract void setTableFromData(String[] cards_table, DurakBaseController baccaratGameController);

	public void setTableFromData(String[] cards_table, BaccaratBaseController baccaratGameController) {

	}

	public BaccaratGameController getBaccaratGameController() {
		return baccaratGameController;
	}

	public void setBaccaratGameController(BaccaratGameController baccaratGameController) {
		this.baccaratGameController = baccaratGameController;
	}

	public void setPlayer(DurakGameController game2Controller) {

	}

	public abstract void setHandFromData(String[] cards_hand, BaccaratBaseController baccaratGameController);

	public BaccaratGameBaseController getBaccaratGameBaseController() {
		return baccaratGameBaseController;
	}

	public void setBaccaratGameBaseController(BaccaratGameBaseController baccaratGameBaseController) {
		this.baccaratGameBaseController = baccaratGameBaseController;
	}
	
	public void receive() {
		// TODO Auto-generated method stub

	}

}
