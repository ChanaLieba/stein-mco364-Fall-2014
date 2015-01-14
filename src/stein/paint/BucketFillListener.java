package stein.paint;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Stack;

import stein.paint.message.BucketFillMessage;
import stein.paint.message.LineMessage;
import stein.paint.message.PaintMessage;

public class BucketFillListener implements DrawListener {
	private Canvas canvas;

	public BucketFillListener(Canvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		PaintMessage msg = null;
		msg = new BucketFillMessage(canvas, e.getX(), e.getY(), canvas
				.getColor().getRGB());
		canvas.getModule().sendMessage(msg);

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}

	@Override
	public void drawPreview(Graphics2D g) {

	}

}
