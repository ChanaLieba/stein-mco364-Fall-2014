package stein.paint;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.OutputStream;

import stein.paint.message.PaintMessage;

public class PaintClient {

	private Socket socket;
	private OutputStream output;

	public PaintClient(Canvas canvas) throws UnknownHostException, IOException {
		socket = new Socket("192.168.10.119", 3773);
		output = socket.getOutputStream();
		PaintClientThread thr = new PaintClientThread(socket, canvas);
		thr.start();
	}

	public void sendMessage(PaintMessage message) throws IOException {
		output.write(message.toString().getBytes());
		output.flush();
	}

}
