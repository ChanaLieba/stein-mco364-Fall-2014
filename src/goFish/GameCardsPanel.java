package goFish;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameCardsPanel extends JPanel {

	// Data fields

	// An arraylist of all the individual PlayerPanels
	private ArrayList<PlayerPanel> panels;
	private Game game;

	// Constructor
	public GameCardsPanel(Game game) {
		// The Game object
		this.game = game;

		// The arraylist
		this.panels = new ArrayList<PlayerPanel>();

		// Set the layout of this panel
		this.setLayout(new GridLayout(this.game.getNumberOfPlayers(), 1));

		// Create the individual PlayerPanels and add them to this panel.
		PlayerPanel p;
		Player[] list = this.game.getPlayers().getPlayerList();
		for (int i = 0; i < this.game.getNumberOfPlayers(); i++) {
			p = new PlayerPanel(list[i]);
			this.panels.add(p);
			this.add(p);
		}
	}

	// Get the list of panels... necessary to pass components to ActionListeners
	// in other classes
	public ArrayList<PlayerPanel> getPanels() {
		return panels;
	}

}
