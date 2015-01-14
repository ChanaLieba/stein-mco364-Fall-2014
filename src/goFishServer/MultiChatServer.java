package goFishServer;

import goFish.Deck;
import goFish.GameStartInfo;
import goFish.Players;
import goFish.Pool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MultiChatServer {

	private ServerSocket serverSocket;
	private List<Socket> sockets;
	private BlockingQueue<String> messages;
	private MessageSenderThread sender;
	private SocketEventListener listener;
	//Keeps track of how many connected
	private int numConnected;
	//Game stuff
	private Deck deck;
	private Players players;
	private Pool pool;
	private int currentTurnNumber;
	private String[]names;

	public MultiChatServer(int port, SocketEventListener listener) throws IOException {
		this.numConnected = 0;
		this.names = new String[3];
		serverSocket = new ServerSocket(port);
		sockets = new ArrayList<Socket>();
		messages = new LinkedBlockingQueue<String>();
		sender = new MessageSenderThread(sockets, messages, listener);
		sender.start();
		this.listener = listener;
		listener.onServerStart(serverSocket);
	}

	public void run() throws Exception {

		try {
			
			//This loop allows the first three clients to connect.
			while (this.numConnected<3) {
				Socket socket = serverSocket.accept();
				sockets.add(socket);
				this.numConnected++;
				System.out.println(this.numConnected+" Num Connected");
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		int numInNames = 0;
		for(Socket s:sockets){
			//System.out.println("ENTERED FOR LOOP");
			InputStream in = s.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			//System.out.println("CREATED READER");
			String name = reader.readLine().trim();
			//System.out.println("READ LINE");
			//System.out.println("Name: "+name);
			names[numInNames]=name;
			numInNames++;
		}
		
		//Block until all three names are set
		while(this.names[2]==null){
			//System.out.println("Waiting for names");
		}
		
		//Now, the server will set up the game.
		startGame();
		sendGameToClients();
		
		//Now sets up the sockets with handlers for messages
		for(Socket s: sockets){
			SocketHandler handler = new SocketHandler(
				s, listener, messages);
			handler.start();
		}

	}

	//Set up the game
		private void startGame(){
			//Initialize the deck
			this.deck = new Deck();
			//System.out.println("Deck Created");
			//Pass the deck to create the Players
			this.players = new Players(3, this.names, this.deck);
			//System.out.println("Players Created");
			//Create the pool with the remaining cards
			this.pool = deck.createPool();
			//System.out.println("Pool Created");
			//Set the current turn number
			this.currentTurnNumber = 1;
		}
		
		//Send the game
		private void sendGameToClients() throws Exception{
			GameStartInfo info = new GameStartInfo(this.pool, this.players);
			for(Socket s: sockets){
				info.sendInfo(s);
			}
		}
}
