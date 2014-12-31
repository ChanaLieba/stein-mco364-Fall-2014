package stein.paint;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class ChangeLineSizeListener implements MouseWheelListener {

	private int width;
	private Canvas canvas;
	private int notches = 0;
	private ColorPanel panel;

	public ChangeLineSizeListener(Canvas canvas, ColorPanel panel) {
		this.canvas = canvas;
		width = canvas.getStrokeInt();
		this.panel = panel;
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		notches = e.getUnitsToScroll();
		notches = (notches * -1)/3;
		if ((width + notches) > 0) {
			canvas.setStrokeInt(width + notches);
			width = width + notches;
		} else {
			canvas.setStrokeInt(1);
		}
		panel.getStrokeInt().setText("Stroke Int: " + width);
	}
}
