package stein.paint.message;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.Stack;

import stein.paint.Canvas;

public class BucketFillMessage implements PaintMessage {

	private int x;
	private int y;
	private int color;
	private Canvas canvas;

	public BucketFillMessage(Canvas canvas, Integer x, Integer y, Integer color) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.canvas = canvas;
	}

	@Override
	public void apply(Graphics2D g) {
		BufferedImage img = canvas.getImg();	
		int targetColor = img.getRGB(x,y);
		if (targetColor != color) {
			Stack<Point> stack = new Stack<Point>();
			stack.push(new Point(x, y));
			Point point;
			while (!stack.isEmpty()) {
				point = stack.pop();

				if (img.getRGB(point.x, point.y) == targetColor) {
					img.setRGB(point.x, point.y, color);

					if (point.x + 1 < img.getWidth()) {
						stack.push(new Point(point.x + 1, point.y));
					}
					if (point.x - 1 >= 0) {
						stack.push(new Point(point.x - 1, point.y));
					}
					if (point.y + 1 < img.getHeight()) {
						stack.push(new Point(point.x, point.y + 1));
					}
					if (point.y - 1 >= 0) {
						stack.push(new Point(point.x, point.y - 1));
					}
				}
			}
		}
		

	}

	@Override
	public String toString() {
		return "BUCKET_FILL " + x + " " + y + " " + color + "\n";
	}

}
