package goFish;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PlayerPanel extends JPanel {

	// Data fields
	private Player player;
	private PlayerHand hand;
	private JLabel playerName;
	private ArrayList<Book> books;

	// Constructor
	public PlayerPanel(Player p) {
		this.player = p;
		this.hand = this.player.getHand();
		this.books = this.player.getBooks();

		this.playerName = new JLabel(p.getName());
		this.add(this.playerName);

		// Add the player's books to the panel
		BookStack bs;
		for (int i = 0; i < this.books.size(); i++) {
			bs = new BookStack(this.books.get(i).getBookNum());
			this.add(bs);
		}

		// Add the player's cards to the panel
		ArrayList<Card> cards = hand.getList();
		for (int i = 0; i < cards.size(); i++) {
			this.add(cards.get(i));
		}

		this.setBackground(new Color(127, 226, 255));
	}

	// Reset panel
	public void resetPlayerPanel(Player p) {
		this.removeAll();
		this.hand = this.player.getHand();
		this.books = this.player.getBooks();
		this.add(this.playerName);
		BookStack bs;
		for (int i = 0; i < this.books.size(); i++) {
			bs = new BookStack(this.books.get(i).getBookNum());
			this.add(bs);
		}
		ArrayList<Card> cards = hand.getList();
		for (int i = 0; i < cards.size(); i++) {
			this.add(cards.get(i));
		}

	}

	public static void main(String[] args) throws InterruptedException {
		String[] names = { "Naftali", "Miri" };
		Game g = new Game(2, names);
		PlayerPanel p = new PlayerPanel(g.getPlayers().getCurrentPlayer(1));
		JFrame frame = new JFrame();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(p, BorderLayout.CENTER);
		frame.setSize(1200, 600);
		frame.setVisible(true);
		Thread.sleep(3000);
		p.resetPlayerPanel(g.getPlayers().getCurrentPlayer(2));
		p.repaint();
		frame.repaint();
		frame.setVisible(true);

	}
}
