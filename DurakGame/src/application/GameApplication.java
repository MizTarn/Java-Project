package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import view.MenuController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import game.base.Client;

public class GameApplication extends Application { 
	@SuppressWarnings("exports")
	public static Stage stage;
	public static Client client;

	@Override
	public void start(@SuppressWarnings("exports") Stage primaryStage) throws Exception {
		new Thread(() -> {
			client = new Client();
			System.out.println(client);
		}).start();
		stage = primaryStage;
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/menu.fxml"));
		Parent root = fxmlLoader.load();
		MenuController controller = fxmlLoader.getController();
		client.setMenuController(controller); 
		stage.setResizable(false);
		stage.setScene(new Scene(root)); 
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
