package stein.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class NetworkThread extends Thread {

	private Socket socket;
	private int counter;

	public NetworkThread(Socket socket, int counter) {
		this.socket = socket;
		this.counter = counter;
	}

	public void run() {
		try {
			InputStream in = socket.getInputStream();
			// the server socket is the part that listens,
			// you listen by calling serverSocket.accept();
			// when someone connects to you, the server is returned.
			// client initiate connections to server
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String line;
			while (!"".equals(line = reader.readLine())) {
				System.out.println(line);
			}
			OutputStream out = socket.getOutputStream();
			String response = "<h2>This is the " + counter + "th request</h2>";
			out.write("HTTP/1.1 200 OK\n".getBytes());
			out.write("Content-Type: text/html; charset=utf-8\n".getBytes());
			out.write(("Content-Length: " + response.length() + "\n\n").getBytes());
			out.write(response.getBytes());
			out.flush();
			out.close();
			counter++;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
