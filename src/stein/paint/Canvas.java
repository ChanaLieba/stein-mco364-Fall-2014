package stein.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public class Canvas extends JComponent {

	int x;
	int y;
	int px;
	int py;
	BufferedImage img;
	Graphics2D g2;
	Color color = Color.BLACK;
	int strokeInt = 5;
	Stroke stroke = new BasicStroke(strokeInt);

	public Canvas() {
		img = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, null);
	}

	public void setXandY(int x, int y) {

		g2 = (Graphics2D) img.getGraphics();
		g2.setColor(color);
		g2.setStroke(stroke);
		if (this.x != -1 && this.y != -1) {
			g2.drawLine(this.x, this.y, x, y);
		}

		this.x = x;
		this.y = y;

	}

	public void setPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public void setStrokeInt(int strokeInt) {
		stroke = new BasicStroke(strokeInt);
	}

	public int getStrokeInt() {
		return strokeInt;
	}

}
