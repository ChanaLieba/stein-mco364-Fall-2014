package stein.paint;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Stack;

public class BucketFillListener implements DrawListener {
	private Canvas canvas;
	private Graphics2D g;
	
	public BucketFillListener(Canvas canvas) {
		this.canvas = canvas;
		this.g = canvas.getG2();
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		BufferedImage image = canvas.getImg();
		int replaceColor = canvas.getColor().getRGB();
		int targetColor = image.getRGB(e.getX(), e.getY());
		if (targetColor != replaceColor) {
			Stack<Point> stack = new Stack<Point>();
			stack.push(new Point(e.getX(), e.getY()));
			Point point;
			while (!stack.isEmpty()) {
				point = stack.pop();

				if (image.getRGB(point.x, point.y) == targetColor) {
					image.setRGB(point.x, point.y, replaceColor);

					if (point.x + 1 < image.getWidth()) {
						stack.push(new Point(point.x + 1, point.y));
					}
					if (point.x - 1 >= 0) {
						stack.push(new Point(point.x - 1, point.y));
					}
					if (point.y + 1 < image.getHeight()) {
						stack.push(new Point(point.x, point.y + 1));
					}
					if (point.y - 1 >= 0) {
						stack.push(new Point(point.x, point.y - 1));
					}
				}
			}
		}
		canvas.repaint();

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void drawPreview(Graphics2D g) {
		// TODO Auto-generated method stub

	}

}
