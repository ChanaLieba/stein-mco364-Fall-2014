package stein.paint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {

	private JButton Pencil;
	private JButton Rectangle;
	private JButton FillRectangle;
	private JButton Oval;
	private JButton FillOval;
	private JButton ClearScreen;
	private Canvas canvas;
	private JButton BucketFill;
	private JButton Line;

	public ButtonPanel(Canvas canvas) {
		this.canvas = canvas;
		Pencil = new JButton("Pencil");
		Line = new JButton("Line");
		Rectangle = new JButton("Rectangle");
		FillRectangle = new JButton("Fill Rectangle");
		Oval = new JButton("Oval");
		FillOval = new JButton("Fill Oval");
		ClearScreen = new JButton("Clear Screen");
		BucketFill = new JButton("Bucket Fill");
		Pencil.addActionListener(new PencilThisListener());
		Rectangle.addActionListener(new RectangleThisListener());
		FillRectangle.addActionListener(new FillRectangleThisListener());
		Oval.addActionListener(new OvalThisListener());
		FillOval.addActionListener(new FillOvalThisListener());
		ClearScreen.addActionListener(new ClearScreenListener());
		BucketFill.addActionListener(new BucketFillThisListener());
		Line.addActionListener(new LineThisListener());
		this.add(Pencil);
		this.add(Rectangle);
		this.add(FillRectangle);
		this.add(Oval);
		this.add(FillOval);
		this.add(Line);
		this.add(ClearScreen);
		this.add(BucketFill);

	}

	private class LineThisListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent a) {
			canvas.setDrawListener(new LineListener(canvas));
		}
	}

	private class BucketFillThisListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent a) {
			canvas.setDrawListener(new BucketFillListener(canvas));
		}
	}

	private class ClearScreenListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			canvas.clearCanvas();
		}
	}

	private class PencilThisListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			canvas.setDrawListener(new PencilListener(canvas));
		}
	}

	private class RectangleThisListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			canvas.setDrawListener(new RectangleListener(canvas));
		}
	}

	private class FillRectangleThisListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			canvas.setDrawListener(new FillRectangleListener(canvas));
		}
	}

	private class FillOvalThisListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			canvas.setDrawListener(new FillOvalListener(canvas));
		}
	}

	private class OvalThisListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			canvas.setDrawListener(new OvalListener(canvas));
		}
	}
}