package stein.paint;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import stein.paint.message.PaintMessage;
import stein.paint.message.ShapeMessage;

public class OvalListener implements DrawListener{
	
	private int pointXclicked;
	private int pointXreleased;
	private int pointYclicked;
	private int pointYreleased;
	private Canvas canvas;
	
	public OvalListener(Canvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawPreview(Graphics2D g) {
		g.setColor(canvas.getColor());
		g.setStroke(canvas.getStroke());
		g.drawOval(Math.min(pointXclicked, pointXreleased), Math.min(pointYclicked, pointYreleased),
				Math.abs(pointXclicked - pointXreleased), Math.abs(pointYclicked - pointYreleased));
		
	}
	public void draw(){
		PaintMessage msg = null;

		msg = new ShapeMessage("OVAL", Math.min(pointXclicked, pointXreleased),
				Math.min(pointYclicked, pointYreleased), Math.abs(pointXclicked
						- pointXreleased), Math.abs(pointYclicked
						- pointYreleased), canvas.getColor().getRGB(),
				canvas.getStrokeInt(), false);
		canvas.getModule().sendMessage(msg);
	}

}
