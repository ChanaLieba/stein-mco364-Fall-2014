package goFish;

import javax.swing.JLabel;

public class NextTurnThread extends Thread {

	// Data fields
	private Game game;
	private DropdownsPanel drops;
	private JLabel statCurrentPlayer;
	private JLabel statTurnChoices;
	private JLabel statTurnResult;
	private JLabel statDeal;
	private JLabel statBook;
	private JLabel statBookResult;
	private JLabel statTurnConclusion;
	private GameStatusPanel frame;

	// Constructor
	public NextTurnThread(Game game, DropdownsPanel drops,
			JLabel statCurrentPlayer, JLabel statTurnChoices,
			JLabel statTurnResult, JLabel statDeal, JLabel statBook,
			JLabel statBookResult, JLabel statTurnConclusion,
			GameStatusPanel frame) {
		this.game = game;
		this.drops = drops;
		this.statCurrentPlayer = statCurrentPlayer;
		this.statTurnChoices = statTurnChoices;
		this.statTurnResult = statTurnResult;
		this.statDeal = statDeal;
		this.statBook = statBook;
		this.statBookResult = statBookResult;
		this.statTurnConclusion = statTurnConclusion;
		this.frame = frame;
	}

	@Override
	public void run() {

		// Get the current Player
		Player current = game.getCurrentPlayer();

		// Set the statCurrenPlayer panel to reflect the current player and
		// clear all other panels
		this.statTurnResult.setText("");
		this.statDeal.setText("");
		this.statBook.setText("");
		this.statBookResult.setText("");
		this.statTurnConclusion.setText("");
		this.statCurrentPlayer.setText("The current player is: "
				+ current.toString() + ".");

		// First check that the player hand is not empty!
		if (current.getHand().getList().size() == 0) {
			statTurnChoices
					.setText("<html>You have no cards, and so you cannot make a request.<br/Press BEGIN TURN to proceed.</html>");
		} else {
			this.statTurnChoices
					.setText("<html>Choose a player to request cards from.<br/>Choose a card number to request.<br/>Then press BEGIN TURN.</html>");

			// Set the dropdown panels to reflect the player info.
			drops.resetDropdownsPanel(
					game.getPlayers().allPlayersExcept(current),
					current.allCardNumbersInHand());
			drops.setVisible(true);
			frame.revalidate();
			frame.repaint();
		}
	}
}
