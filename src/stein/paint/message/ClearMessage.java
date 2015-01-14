package stein.paint.message;

import java.awt.Color;
import java.awt.Graphics2D;

import stein.paint.Canvas;

public class ClearMessage implements PaintMessage {

	private Canvas canvas;

	public ClearMessage(Canvas canvas) {
		this.canvas = canvas;
	}

	public String toString() {
		return "CLEAR\n";
	}

	@Override
	public void apply(Graphics2D g) {
		canvas.setShouldDrawPreview(false);
		g.setColor(Color.white);
		g.fillRect(0, 0, 800, 600);
		//canvas.repaint();
		// cleaning lady 356-5829 (Sheila)
	}
}
