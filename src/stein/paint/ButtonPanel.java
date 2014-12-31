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
	private JFrame frame;
	private Canvas canvas;
	private JButton BucketFill;
	
	public ButtonPanel(JFrame frame, Canvas canvas){
		this.canvas = canvas;
		this.frame = frame;
		Pencil = new JButton("Pencil");
		Rectangle = new JButton("Rectangle");
		FillRectangle = new JButton("Fill Rectangle");
		Oval = new JButton("Oval");
		FillOval = new JButton("Fill Oval");
		ClearScreen = new JButton("Clear Screen");
		BucketFill = new JButton("Bucket Fill");
		Pencil.addActionListener(new PencilListener());
		Rectangle.addActionListener(new RectangleThisListener());
		FillRectangle.addActionListener(new FillRectangleThisListener());
		Oval.addActionListener(new OvalThisListener());
		FillOval.addActionListener(new FillOvalThisListener());
		ClearScreen.addActionListener(new ClearScreenListener());
		BucketFill.addActionListener(new BucketFillListener());
		this.add(Pencil);
		this.add(Rectangle);
		this.add(FillRectangle);
		this.add(Oval);
		this.add(FillOval);
		this.add(ClearScreen);
		this.add(BucketFill);
		
	}
	
	private class BucketFillListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent a){
			canvas.setDrawListenerToBucketFill();
		}
	}
	private class ClearScreenListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0){
			canvas.clearCanvas();
			//canvas.repaint();
		}
	}

	private class PencilListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			canvas.setDrawListenerToPencil();
		}
		
	}
	
	private class RectangleThisListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			canvas.setDrawListenerToRectangle();
		}
		
	}
	
	private class FillRectangleThisListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			canvas.setDrawListenerToFillRectangle();
			
		}
		
	}
	private class FillOvalThisListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			canvas.setDrawListenerToOval();
			
		}
		
	}
	private class OvalThisListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			canvas.setDrawListenerToFillOVal();
			
		}
		
	}
}