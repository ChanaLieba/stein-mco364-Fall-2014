package stein.paint;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorPanel extends JPanel {

	private JButton red;
	private Color color;
	private Canvas canvas;
	private JFrame frame;

	public ColorPanel(JFrame frame, Canvas canvas) {
		this.canvas = canvas;
		this.frame = frame;
		red = new JButton("COLOR SET");
		red.addActionListener(new ColorButtonListener());
		this.add(red);
		this.setVisible(true);

	}

	private class ColorButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			color = JColorChooser.showDialog(frame, "Select a color", color);
			canvas.setColor(color);
		}

	}

}
