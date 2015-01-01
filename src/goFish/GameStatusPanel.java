package goFish;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameStatusPanel extends JPanel {

	// Data fields

	// JLabels to display information about game status
	private JLabel statCurrentPlayer;
	private JLabel statTurnChoices;
	private JLabel statTurnResult;
	private JLabel statDeal;
	private JLabel statBook;
	private JLabel statBookResult;
	private JLabel statTurnConclusion;

	// Dropdown menus for user choices
	private DropdownsPanel drops;

	// Buttons to submit user choices and continue to next turn
	private JButton beginTurn;
	private JButton nextTurn;

	// Game object
	private Game game;

	// Main frame
	private GameFrame frame;

	// Stores a reference to itself.
	// Necessary in order to pass itself as a reference in the private classes,
	// which won't recognize
	// "this" keyword as referring to this object itself.
	private GameStatusPanel me;

	// Constructor
	public GameStatusPanel(GameFrame frame, Game game) {

		// The GameFrame...
		this.frame = frame;

		// Set the Game object
		this.game = game;

		// Set all the status labels
		this.statCurrentPlayer = new JLabel("The current player is: "
				+ this.game.getCurrentPlayer().toString() + ".");
		this.statTurnChoices = new JLabel(
				"<html>Choose a player to request cards from.<br/>Choose a card number to request.<br/>Then press BEGIN TURN.</html>");
		this.statTurnResult = new JLabel("");
		this.statDeal = new JLabel("");
		this.statBook = new JLabel("");
		this.statBookResult = new JLabel("");
		this.statTurnConclusion = new JLabel("");

		// Create a panel with all the status labels
		JPanel labels = new JPanel();
		labels.setLayout(new GridLayout(7, 1));
		labels.add(this.statCurrentPlayer);
		labels.add(this.statTurnChoices);
		labels.add(this.statTurnResult);
		labels.add(this.statDeal);
		labels.add(this.statBook);
		labels.add(this.statBookResult);
		labels.add(this.statTurnConclusion);

		// Create the BEGIN TURN button
		this.beginTurn = new JButton("BEGIN TURN");
		this.beginTurn.addActionListener(new BeginTurnListener());

		// Create the NEXT TURN button
		this.nextTurn = new JButton("CONTINUE");
		this.nextTurn.addActionListener(new NextTurnListener());

		// Add the two buttons to a JPanel
		JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
		buttonPanel.add(this.beginTurn);
		buttonPanel.add(this.nextTurn);

		// Create the initial dropdown menus
		this.drops = new DropdownsPanel(this.game.getPlayers()
				.allPlayersExcept(this.game.getCurrentPlayer()), this.game
				.getCurrentPlayer().allCardNumbersInHand());

		// Add the dropdown menu and the buttons to a panel
		JPanel menuAndButtons = new JPanel();
		menuAndButtons.setLayout(new BorderLayout());
		menuAndButtons.add(this.drops, BorderLayout.NORTH);
		menuAndButtons.add(buttonPanel, BorderLayout.SOUTH);

		// Add all components to this GameStatusPanel
		this.setLayout(new BorderLayout());
		this.add(labels, BorderLayout.NORTH);
		this.add(menuAndButtons, BorderLayout.SOUTH);

		// Set "me" to refer to this object
		this.me = this;
	}

	// ActionListener for BEGIN TURN button
	private class BeginTurnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			beginTurn.setEnabled(false);
			nextTurn.setEnabled(true);
			PlayerTurnThread turn = new PlayerTurnThread(statTurnChoices,
					statTurnResult, statDeal, statBook, statBookResult,
					statTurnConclusion, drops, frame.getGameCardsPanel()
							.getPanels(), game, frame.getGameCardsPanel(),
					nextTurn, beginTurn, me);
			turn.start();
		}
	}

	// ActionListener for NEXT TURN button
	private class NextTurnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			nextTurn.setEnabled(false);
			beginTurn.setEnabled(true);
			NextTurnThread next = new NextTurnThread(game, drops,
					statCurrentPlayer, statTurnChoices, statTurnResult,
					statDeal, statBook, statBookResult, statTurnConclusion, me);
			next.start();
		}
	}

	// Method to clear all labels
	public void clearLabels() {
		this.statCurrentPlayer.setText("");
		this.statTurnChoices.setText("");
		this.statTurnResult.setText("");
		this.statDeal.setText("");
		this.statBook.setText("");
		this.statBookResult.setText("");
		this.statTurnConclusion.setText("");
	}
}
