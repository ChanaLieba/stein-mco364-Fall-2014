package stein.paint;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import stein.paint.message.*;
import stein.paint.message.PaintMessageFactory;

public class PaintClientThread extends Thread {

	private Socket socket;
	private Canvas canvas;

	public PaintClientThread(Socket socket, Canvas canvas) {
		this.socket = socket;
		this.canvas = canvas;
	}

	public void run() {
		try {
			InputStream input;
			BufferedReader reader;
			String text;
			PaintMessageFactory factory = new PaintMessageFactory(canvas);
			input = socket.getInputStream();
			reader = new BufferedReader(new InputStreamReader(input));

			while ((text = reader.readLine()) != null) {
				try {
					PaintMessage msg = factory.getMessage(text);
					msg.apply((Graphics2D) canvas.getImg().getGraphics());
				} catch (Exception e) {
					e.printStackTrace();
					continue;
				}
				canvas.repaint();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
