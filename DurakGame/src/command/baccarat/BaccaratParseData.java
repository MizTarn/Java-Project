package command.baccarat;

import java.util.HashMap;
import java.util.Map;

import command.Command;
import command.ParseData;
import manager.baccarat.BaccaratManager;

public class BaccaratParseData implements ParseData {
	private BaccaratManager gameManager;
	private Map<String, Command> commandMap;

	public BaccaratParseData(BaccaratManager gameManager) {
		this.gameManager = gameManager;
		commandMap = new HashMap<>();
		initCommands();
	}

	public void initCommands() { 
		commandMap.put("play", new PlayCommand(gameManager.getPlayerManager(), gameManager.getTableManager()));
	}
 
	public void parseData(String data) { 
		try {
			String[] params = data.split("#"); 
			String operation = params[0];

			Command command = commandMap.get(operation);
			if (command != null) {
				command.execute(params);
			} else {
				System.out.println("Lệnh không hợp lệ: " + operation);
			}

		} catch (Exception e) {
			System.out.println("Lỗi khi xử lý dữ liệu: " + e.getMessage());
		}
	}
}
