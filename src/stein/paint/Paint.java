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
		ButtonPanel bPanel = new ButtonPanel(this,canvas);
		ChangeLineSizeListener listener2 = new ChangeLineSizeListener(canvas, cPanel);
		canvas.addMouseWheelListener(listener2);
		add(canvas, BorderLayout.CENTER);
		add(cPanel, BorderLayout.SOUTH);
		add(bPanel,BorderLayout.NORTH);
		this.setVisible(true);

	}

	public static void main(String[] args) {

		Paint paint = new Paint();
	}

}
