package stein.paint;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ColorPanel extends JPanel {

	private JButton red;
	private Color color;
	private Canvas canvas;
	private JFrame frame;
	private JLabel strokeint;
	private JLabel currentcolor;
	private String s;

	public ColorPanel(JFrame frame, Canvas canvas) {
		this.canvas = canvas;
		this.frame = frame;
		red = new JButton("COLOR SET");
		red.addActionListener(new ColorButtonListener());
		s = "Stroke size: " + canvas.getStrokeInt();
		strokeint = new JLabel(s);
		currentcolor = new JLabel("Current Color ");
		currentcolor.setText("Current color");
		currentcolor.setOpaque(true);
		currentcolor.setBackground(canvas.getColor());
		strokeint.setText(s);
		this.add(red);
		this.add(strokeint);
		this.add(currentcolor);

	}

	private class ColorButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			color = JColorChooser.showDialog(frame, "Select a color", color);
			canvas.setColor(color);
			currentcolor.setBackground(canvas.getColor());
		}

	}
	
	public JLabel getStrokeInt(){
		return strokeint;
	}

}
