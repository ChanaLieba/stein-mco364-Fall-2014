package stein.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ResponseServer {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(8080);
		int counter = 0;
		while (true) {
			Socket socket = serverSocket.accept();
			NetworkThread nt = new NetworkThread(socket, counter);
			nt.start();

		}
	}
}
