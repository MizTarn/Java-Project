package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter; 
import java.net.InetAddress;
import java.net.Socket;

public class NetworkManager {
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;

	public NetworkManager(String host, int port) throws IOException { 
		socket = new Socket(InetAddress.getByName(host), port);
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);
	}

	public void sendData(String data) {
		out.println(data); 
		out.flush();
	}

	public String readData() throws IOException {
		return in.readLine();
	}

	public void close() throws IOException {
		in.close();
		out.close();
		socket.close();
	}
}
