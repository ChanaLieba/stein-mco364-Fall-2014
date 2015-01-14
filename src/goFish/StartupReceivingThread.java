package goFish;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import javax.swing.JFrame;

public class StartupReceivingThread extends Thread {

	// Fields
	private Socket socket;
	private String me;
	private GameSetupPanel panel;

	public StartupReceivingThread(Socket socket, String name, GameSetupPanel panel) {
		this.socket = socket;
		this.me = name;
		this.panel = panel;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		try {
			ObjectInputStream in = new ObjectInputStream(
					this.socket.getInputStream());
			GameStartInfo gs = (GameStartInfo) in.readObject();
			Pool pool = gs.getPool();
			Players players = gs.getPlayers();
			Game game = new Game(pool, players, this.me, this.socket);
			GameFrame gf = new GameFrame(game);
			panel.setVisible(false);
			//setting the panel to invisible once the game frame is up
			// System.out.println("OBJECT READ! YAY!");
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
