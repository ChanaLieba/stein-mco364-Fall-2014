package goFish;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PlayerTurnThread extends Thread {

	// Data fields
	private JLabel statTurnChoices;
	private JLabel statTurnResult;
	private JLabel statDeal;
	private JLabel statBook;
	private JLabel statBookResult;
	private JLabel statTurnConclusion;

	private DropdownsPanel drops;
	private Game game;
	private ArrayList<PlayerPanel> panels;
	private GameCardsPanel frame;

	private JButton nextTurnButton;
	private JButton beginTurnButton;

	private GameStatusPanel statusPanel;

	// Constructor
	public PlayerTurnThread(JLabel statTurnChoices, JLabel statTurnResult,
			JLabel statDeal, JLabel statBook, JLabel statBookResult,
			JLabel statTurnConclusion, DropdownsPanel drops,
			ArrayList<PlayerPanel> panels, Game game, GameCardsPanel frame,
			JButton nextTurnButton, JButton beginTurnButton,
			GameStatusPanel stats) {
		this.statTurnChoices = statTurnChoices;
		this.statTurnResult = statTurnResult;
		this.statDeal = statDeal;
		this.statBook = statBook;
		this.statBookResult = statBookResult;
		this.statTurnConclusion = statTurnConclusion;
		this.drops = drops;
		this.game = game;
		this.panels = panels;
		this.frame = frame;
		this.nextTurnButton = nextTurnButton;
		this.beginTurnButton = beginTurnButton;
		this.statusPanel = stats;
	}

	// Run method
	@Override
	public void run() {
		// Get the current player
		Player current = game.getCurrentPlayer();

		// Set the drop down panels to invisible, as the player has already made
		// his choice.
		drops.setVisible(false);

		// First check that the player hand is not empty!
		// If the player has no cards, he cannot make a request and so he must
		// deal from the pool.
		if (current.getHand().getList().size() == 0) {
			this.statTurnResult.setText("");
			this.statDeal.setText("");
			this.statBook.setText("");
			this.statBookResult.setText("");
			this.statTurnConclusion.setText("");
			statTurnChoices
					.setText("You have no cards, and so you cannot make a request.");
			statDeal.setText("Dealing a card from the pool...");
			Card c = null;
			try {
				c = game.getPool().deal();
				current.getHand().insert(c);
				panels.get(current.getIndexInPlayers()).resetPlayerPanel(
						current);
				frame.revalidate();
				frame.repaint();
			} catch (EmptyPoolException e) {
				// TODO Auto-generated catch block
				statDeal.setText("Sorry, pool is empty. No cards to deal.");
			}
			statTurnConclusion
					.setText("<html>Your turn is over. <br/>Press CONTINUE to proceed to the next turn.</html>");
			int turns = game.getCurrentTurnNum() + 1;
			game.setCurrentTurnNum(turns);
		} else {
			Player playerToAsk = (Player) drops.getPlayers().getSelectedItem();
			int numToAsk = (Integer) drops.getNumbers().getSelectedItem();
			statTurnChoices.setText(game.getCurrentPlayer().toString()
					+ ", you chose to ask " + playerToAsk.toString()
					+ " for all cards of the value " + numToAsk + ".");

			// First ask a player for all cards of a specific kind...

			try {
				game.getPlayers().cardExchange(current,
						playerToAsk.getIndexInPlayers(), numToAsk);
				statTurnResult.setText(playerToAsk.toString()
						+ " gave all cards with the value " + numToAsk + ".");
				panels.get(current.getIndexInPlayers()).resetPlayerPanel(
						current);
				panels.get(playerToAsk.getIndexInPlayers()).resetPlayerPanel(
						playerToAsk);
				frame.revalidate();
				frame.repaint();
				statBook.setText("Does your hand currently contain a book?");
				if (current.getHand().checkBook()) {
					int bookNum = current.getHand().numOfBook();
					statBookResult
							.setText("<html>YES! Your hand contains a book!<br/> You have four cards of the value "
									+ bookNum + "!</html>");
					Book b = current.getHand().createBook(bookNum);
					current.getBooks().add(b);
					panels.get(current.getIndexInPlayers()).resetPlayerPanel(
							current);
					frame.revalidate();
					frame.repaint();

					// Check if game has been won
					boolean gameOver = game.getGameOver();
					if (gameOver) {
						ArrayList<Player> winners = game.getPlayers()
								.mostBooks();
						String winnerNames = winners.get(0).toString()
								.toUpperCase();
						if (winners.size() > 1) {
							for (int i = 1; i < winners.size(); i++) {
								winnerNames += " and "
										+ winners.get(i).toString()
												.toUpperCase();
							}
						}
						winnerNames += "!";
						this.statusPanel.clearLabels();
						this.nextTurnButton.setEnabled(false);
						this.beginTurnButton.setEnabled(false);
						this.statTurnChoices.setText("GAME OVER!");
						JOptionPane.showMessageDialog(null,
								"This round of GO FISH has been won by... "
										+ winnerNames);
						return;
					}
				} else {
					statBookResult
							.setText("No, your hand does not contain a book.");
				}
				statTurnConclusion
						.setText("<html>Your turn is over. <br/>Press CONTINUE to proceed to the next turn.</html>");
				int turns = game.getCurrentTurnNum() + 1;
				game.setCurrentTurnNum(turns);

			} catch (NoMatchInHandException ex) {
				// If the player asked does not have any of those cards...
				statTurnResult.setText(playerToAsk.toString()
						+ " does not have any cards with the selected value.");
				statDeal.setText("Dealing a card from the pool to your hand...");
				Card c = null;
				try {
					c = game.getPool().deal();
					current.getHand().insert(c);
					panels.get(current.getIndexInPlayers()).resetPlayerPanel(
							current);
					frame.revalidate();
					frame.repaint();
				} catch (EmptyPoolException e) {
					// TODO Auto-generated catch block
					statDeal.setText("Sorry, pool is empty. No cards to deal.");
				}

				statBook.setText("Does your hand currently contain a book?");
				if (current.getHand().checkBook()) {
					int bookNum = current.getHand().numOfBook();
					statBookResult
							.setText("<html>YES! Your hand contains a book!<br/> You have four cards of the value "
									+ bookNum + "!</html>");
					Book b = current.getHand().createBook(bookNum);
					current.getBooks().add(b);
					panels.get(current.getIndexInPlayers()).resetPlayerPanel(
							current);
					frame.revalidate();
					frame.repaint();

					// Check if game has been won
					boolean gameOver = game.getGameOver();
					if (gameOver) {
						ArrayList<Player> winners = game.getPlayers()
								.mostBooks();
						String winnerNames = winners.get(0).toString()
								.toUpperCase();
						if (winners.size() > 1) {
							for (int i = 1; i < winners.size(); i++) {
								winnerNames += " and "
										+ winners.get(i).toString()
												.toUpperCase();
							}
						}
						winnerNames += "!";
						this.statusPanel.clearLabels();
						this.nextTurnButton.setEnabled(false);
						this.beginTurnButton.setEnabled(false);
						this.statTurnChoices.setText("GAME OVER!");
						JOptionPane.showMessageDialog(null,
								"This round of GO FISH has been won by... "
										+ winnerNames);
						return;
					}

				} else {
					statBookResult
							.setText("No, your hand does not contain a book.");
				}

				// Check if the card dealt matches the number requested
				if (c.getCardNum() == numToAsk) {
					statTurnConclusion
							.setText("<html>The value of the card dealt("
									+ c.getCardNum()
									+ ") <br/>matches the value of the card you requested.<br/> Press CONTINUE to take another turn!</html>");

				} else {
					statTurnConclusion
							.setText("<html>Your turn is over. <br/>Press CONTINUE to proceed to the next turn.</html>");
					int turns = game.getCurrentTurnNum() + 1;
					game.setCurrentTurnNum(turns);

				}
			}

		}
	}// close run method
}// close class
