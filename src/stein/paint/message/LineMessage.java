package stein.paint.message;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class LineMessage implements PaintMessage {

	private Integer x1;
	private Integer y1;
	private Integer x2;
	private Integer y2;
	private Integer stroke;
	private Integer color;

	public LineMessage(Integer x1, Integer y1, Integer x2, Integer y2,
			Integer color, Integer stroke) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.stroke = stroke;
		this.color = color;
	}

	@Override
	public void apply(Graphics2D g) {
		g.setColor(new Color((int) color));
		g.setStroke(new BasicStroke(stroke));
		g.drawLine(x1, y1, x2, y2);

	}

	@Override
	public String toString() {
		return "LINE " + x1 + " " + y1 + " " + x2 + " " + y2 + " " + color
				+ " " + stroke + "\n";
	}

}