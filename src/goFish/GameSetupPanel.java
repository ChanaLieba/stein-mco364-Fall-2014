package goFish;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class GameSetupPanel extends JFrame {

	// Data fields
	private JComboBox<Integer> numberOfPlayers;
	private JLabel numPlayersInstructions;
	private JButton submitNumPlayers;
	private JLabel playerNameInstructions;
	private JTextField playerNameField;
	private JButton submitNameButton;
	private int players;
	private String[] playerNames;
	private int playerNamesNumClicked;
	private HeaderPanel hp;

	// Constructor
	public GameSetupPanel() {

		// Initialize playerNames to null; will be set up later
		this.playerNames = null;
		this.playerNamesNumClicked = 0;

		Integer[] numPlayers = { 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		this.numberOfPlayers = new JComboBox<Integer>(numPlayers);
		this.numPlayersInstructions = new JLabel(
				"Choose the number of players from the drop down menu.");
		this.submitNumPlayers = new JButton("Proceed with game setup...");
		this.submitNumPlayers.addActionListener(new SubmitNumActionListener());
		JPanel top = new JPanel();
		top.add(this.numPlayersInstructions);
		top.add(this.numberOfPlayers);
		top.add(this.submitNumPlayers);
		JPanel bottom = new JPanel();
		this.playerNameInstructions = new JLabel(
				"Do not proceed to this section of game setup until you have selected the number of players.");
		this.playerNameInstructions
				.setHorizontalAlignment(SwingConstants.CENTER);
		this.playerNameInstructions.setVerticalAlignment(SwingConstants.CENTER);
		this.playerNameField = new JTextField(20);
		this.submitNameButton = new JButton("Submit Player Name");
		this.submitNameButton.addActionListener(new SubmitNameActionListener());
		bottom.setLayout(new BorderLayout());
		bottom.add(this.playerNameInstructions, BorderLayout.NORTH);
		bottom.add(this.playerNameField, BorderLayout.CENTER);
		bottom.add(this.submitNameButton, BorderLayout.SOUTH);

		this.setLayout(new BorderLayout());
		this.hp = new HeaderPanel();
		JPanel content = new JPanel();
		content.setLayout(new BorderLayout());
		content.add(this.hp, BorderLayout.NORTH);
		content.add(top, BorderLayout.CENTER);
		content.add(bottom, BorderLayout.SOUTH);
		this.add(content, BorderLayout.CENTER);

		this.setSize(660, 360);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	// ActionListener for submitNumPlayers button
	private class SubmitNumActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			players = numberOfPlayers.getSelectedIndex() + 2;
			playerNames = new String[players];
			playerNameInstructions.setText("Enter the name of PLAYER 1");
			numberOfPlayers.setEnabled(false);
		}

	}

	// ActionListener for submitName button
	private class SubmitNameActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String name = playerNameField.getText().toUpperCase();
			if (name.length() == 0 || name.substring(0, 1).equals(" ")) {
				JOptionPane.showMessageDialog(null, "You must enter a name.");
			} else {
				playerNames[playerNamesNumClicked] = name;
				if (playerNames[players - 1] != null) {
					JOptionPane.showMessageDialog(null,
							"Setup complete. Proceeding to game.");
					// Create new game object and pass to GameFrame constructor
					Game game = new Game(players, playerNames);
					@SuppressWarnings("unused")
					GameFrame gf = new GameFrame(game);
					setVisible(false);
				} else {
					playerNameInstructions.setText("Enter the name of PLAYER "
							+ (playerNamesNumClicked + 2));
					playerNameField.setText("");
					playerNamesNumClicked++;
				}
			}
		}
	}

}
