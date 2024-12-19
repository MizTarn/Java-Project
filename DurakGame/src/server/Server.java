package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Objects;

public class Server {
	private static ServerSocket server;
	private static HashMap<String, ServerConnection> connections = new HashMap<>();
	private static GameService durakService;
	private static GameService baccaratService;
	private static int numberPlayer = 0;

	public static void main(String[] args) {
		try {
			server = new ServerSocket(12345);
			durakService = new DurakService(connections);
			baccaratService = new BaccaratService(connections);

			while (true) {
				Socket socket = server.accept();
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				while (true) {
					String[] data = in.readLine().split("#");
					String operation = data[0];
					if (operation != null) {
						if (Objects.equals(operation, "create_session")) {
							durakService.createSession(data[2], data[1], data[3], numberPlayer, in, out);
							break;
						} else if (Objects.equals(operation, "join_session")) {
							durakService.joinSession(data[2], data[1], data[3], in, out);
							break;
						} else if (Objects.equals(operation, "play_with_bot")) {
							durakService.playWithBot(data[1], in, out);
							break;
						} else if (Objects.equals(operation, "create_session_baccarat")) {
							baccaratService.createSession(data[2], data[1], data[3], numberPlayer, in, out);
							break;
						} else if (Objects.equals(operation, "join_session_baccarat")) {
							baccaratService.joinSession(data[2], data[1], data[3], in, out);
							break;
						} else {
							numberPlayer = Integer.parseInt(operation);
						}
					} else {
						socket.close();
					}
				}
			}
		} catch (IOException ex) {
			System.err.println("Server error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

}
