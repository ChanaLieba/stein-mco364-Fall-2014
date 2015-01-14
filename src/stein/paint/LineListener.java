package stein.paint;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import stein.paint.message.LineMessage;
import stein.paint.message.PaintMessage;
import stein.paint.message.ShapeMessage;

public class LineListener implements DrawListener {

	private int pointXclicked;
	private int pointXreleased;
	private int pointYclicked;
	private int pointYreleased;
	private Canvas canvas;

	public LineListener(Canvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		pointXclicked = e.getX();
		pointYclicked = e.getY();

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		pointYreleased = e.getY();
		pointXreleased = e.getX();
		draw();
		canvas.setShouldDrawPreview(false);

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		pointYreleased = e.getY();
		pointXreleased = e.getX();
		canvas.setShouldDrawPreview(true);
		canvas.repaint();

	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void drawPreview(Graphics2D g) {
		g.setColor(canvas.getColor());
		g.setStroke(canvas.getStroke());
		g.drawLine(pointXclicked, pointYclicked, pointXreleased, pointYreleased);

	}

	public void draw() {

		PaintMessage msg = null;
		msg = new LineMessage(pointXclicked, pointYclicked, pointXreleased,
				pointYreleased, canvas.getColor().getRGB(),
				canvas.getStrokeInt());
		canvas.getModule().sendMessage(msg);
	}

}
