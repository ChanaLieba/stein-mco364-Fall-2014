package stein.paint;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Paint extends JFrame {

	public Paint() {
		
		this.setTitle("Paint");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		Canvas canvas = new Canvas();
		ColorPanel cPanel = new ColorPanel(this, canvas);
		//PencilListener listener = new PencilListener(canvas);
		RectangleListener listener = new RectangleListener(canvas);
		ChangeLineSizeListener listener2 = new ChangeLineSizeListener(canvas);
		canvas.addMouseMotionListener(listener);
		canvas.addMouseListener(listener);
		canvas.addMouseWheelListener(listener2);
		add(canvas, BorderLayout.CENTER);
		add(cPanel, BorderLayout.SOUTH);
		this.setVisible(true);

	}

	public static void main(String[] args) {

		Paint paint = new Paint();
	}

}
