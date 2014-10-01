package stein.chatroom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;

public class SocketHandler extends Thread {
	// this thread is only for reading - 
	//you've gathered all the messages that everyone
	// has sent - this thread is for reading messages
	private Socket s;
	private BlockingQueue<String> messages;

	public SocketHandler(Socket s, BlockingQueue<String> messages) {
		this.s = s;
		this.messages = messages;
	}

	public void run() {
		try {
			InputStream in = s.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));

			String line;
			while ((line = reader.readLine()) != null) {
				// write to all the clients
				messages.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
