package server;

import java.io.BufferedReader;
import java.io.PrintWriter;

public interface GameService {
	
	void createSession(String sessionId, String hostNickname, String gui, int numberPlayer, BufferedReader in, PrintWriter out);

	void joinSession(String sessionId, String playerNickname, String gui, BufferedReader in, PrintWriter out);

	void playWithBot(String hostNickname, BufferedReader in, PrintWriter out);

}
