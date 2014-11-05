package stein.paint;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Paint extends JFrame {

	public Paint() {
		
		this.setTitle("Paint");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		Canvas canvas = new Canvas();
		add(canvas, BorderLayout.CENTER);
		DrawListener listener = new DrawListener(canvas);
		canvas.addMouseMotionListener(listener);

	}

	public static void main(String[] args) {

		Paint paint = new Paint();
	}

}
