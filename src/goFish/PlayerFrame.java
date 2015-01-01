package goFish;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class PlayerFrame extends JFrame {

	// Data fields
	private PlayerPanel panel;
	private JButton change;

	// Testing fields
	private String[] names = { "Naftali", "Miri" };
	private Game g = new Game(2, names);

	// Constructor
	public PlayerFrame() {
		this.panel = new PlayerPanel(g.getPlayers().getCurrentPlayer(2));
		this.change = new JButton("CHANGE");
		this.change.addActionListener(new ChangePlayerActionListener());
		this.setLayout(new BorderLayout());
		this.add(panel, BorderLayout.NORTH);
		this.add(change, BorderLayout.SOUTH);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	private class ChangePlayerActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Player revised = g.getPlayers().getCurrentPlayer(2);
			revised.getHand().insert(new Card(6,'s'));
			panel.resetPlayerPanel(revised);
			panel.repaint();
			repaint();
			setVisible(true);
		}

	}
}
