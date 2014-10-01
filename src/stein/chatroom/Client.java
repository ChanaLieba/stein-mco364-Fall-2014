package stein.chatroom;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {

		Socket socket = new Socket("192.168.117.80", 8080);
		ChatGUI chat = new ChatGUI();
		chat.setVisible(true);
		//NetworkThread nt = new NetworkThread(socket, chat);
		//nt.start();

	}
}