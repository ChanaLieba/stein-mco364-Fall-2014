package stein.paint;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class DrawListener implements MouseMotionListener {

	private Canvas canvas;

	public DrawListener(Canvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		canvas.setXandY(x, y);
		canvas.repaint();

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		canvas.setPoint(-1, -1);

	}

}
