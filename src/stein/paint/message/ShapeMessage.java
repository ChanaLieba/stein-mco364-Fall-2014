package stein.paint.message;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class ShapeMessage implements PaintMessage {

	String type;
	int x;
	int y;
	int w;
	int h;
	int color;
	int stroke;
	boolean fill;

	public ShapeMessage(String type, Integer x, Integer y, Integer w,
			Integer h, Integer color, Integer stroke, Boolean fill) {
		this.type = type;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.color = color;
		this.stroke = stroke;
		this.fill = fill;
	}

	@Override
	public void apply(Graphics2D g) {
		g.setColor(new Color(color));
		g.setStroke(new BasicStroke(stroke));
		if (type.equals("RECT")) {
			if (fill) {
				g.fillRect(x, y, w, h);
			} else if (!fill) {
				g.drawRect(x, y, w, h);
			}
		} else if (type.equals("OVAL")) {
			if (fill) {
				g.fillOval(x, y, w, h);
			} else if (!fill) {
				g.drawOval(x, y, w, h);
			}

		}

	}

	@Override
	public String toString() {
		return "SHAPE " + type + " " + x + " " + y + " " + w + " " + h + " "
				+ color + " " + stroke + " " + fill + "\n";
	}

}