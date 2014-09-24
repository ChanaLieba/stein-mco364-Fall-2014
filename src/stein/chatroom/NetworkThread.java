package stein.chatroom;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class NetworkThread extends Thread {

	private Socket socket;
	private ChatGUI chat;

	public NetworkThread(Socket socket, ChatGUI chat) {
		this.socket = socket;
		this.chat = chat;
	}

	@Override
	public void run() {
		try {
			//InputStream in = socket.getInputStream();
			// the server socket is the part that listens,
			// you listen by calling serverSocket.accept();
			// when someone connects to you, the server is returned.
			// client initiate connections to server
			OutputStream out = socket.getOutputStream();
			System.out.println(chat.getText());
			out.write((chat.getText() + "\n").getBytes());
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
