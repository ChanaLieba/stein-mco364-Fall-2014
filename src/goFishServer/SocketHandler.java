package goFishServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.List;
import java.util.Queue;

public class SocketHandler extends Thread {

	private Socket s;
	private Queue<String> messages;
	private SocketEventListener listener;
	
	public SocketHandler( Socket s, SocketEventListener listener, Queue<String> messages ) {
		this.s = s;
		this.messages = messages;
		this.listener = listener;
		listener.onConnect(s);
	}
	
	public void run() {
		
		try {
			InputStream in = s.getInputStream();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			
			String line;
			while( (line = reader.readLine()) != null ) {
				listener.onMessage(s, line);
				messages.add(line);
			}
			
		} catch (java.net.SocketException e) {
			listener.onDisconnect(s);
			messages.add("STOPGAME");
			//e.printStackTrace();
			System.out.println("THE SOCKET EXCEPTION WAS CALLED");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			listener.onDisconnect(s);
			e.printStackTrace();
		}
		
		
	}
	
}
