package client;

import controller.EndController;
import controller.WaitController;
import controller.baccarat.BaccaratBaseController;
import controller.baccarat.BaccaratGameBaseController;
import controller.baccarat.BaccaratGameController;
import controller.durak.DurakBaseController;
import controller.durak.DurakGameBaseController;
import controller.durak.DurakGameController;
import controller.durak.DurakMenuController;

public abstract class GameUpdateListener {
	private NetworkManager networkManager;
	private UIManager uiManager;
	private ClientMessage messageHandler;
	private WaitController wc;
	private DurakGameController durakGameController;
	private EndController ec;
	private BaccaratGameController baccaratGameController;
	private BaccaratGameBaseController baccaratGameBaseController;
	private DurakMenuController mc;
	private DurakGameBaseController durakGameBaseController;
	private String username;
	private boolean isTurn;
	private String idPlayer;

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

	public DurakGameController getDurakGameController() {
		return durakGameController;
	}

	public void setDurakGameController(DurakGameController gameController) {
		this.durakGameController = gameController;
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

	public DurakGameBaseController getDurakGameBaseController() {
		return durakGameBaseController;
	}

	public void setDurakGameBaseController(DurakGameBaseController gameBaseController) {
		this.durakGameBaseController = gameBaseController;
	}

	public BaccaratGameController getBaccaratGameController() {
		return baccaratGameController;
	}

	public void setBaccaratGameController(BaccaratGameController baccaratGameController) {
		this.baccaratGameController = baccaratGameController;
	}

	public void setPlayer(DurakBaseController controller) {

	}

	public BaccaratGameBaseController getBaccaratGameBaseController() {
		return baccaratGameBaseController;
	}

	public void setBaccaratGameBaseController(BaccaratGameBaseController baccaratGameBaseController) {
		this.baccaratGameBaseController = baccaratGameBaseController;
	}

	public abstract void setHandFromData(String[] cards_hand, DurakBaseController gameBaseController);

	public abstract void setTableFromData(String[] cards_table, DurakBaseController baccaratGameController);

	public abstract void setTableFromData(String[] cards_table, BaccaratBaseController baccaratGameController);

	public abstract void setHandFromData(String[] cards_hand, BaccaratBaseController baccaratGameController);

	public void receive() {
		// TODO Auto-generated method stub

	}

}
