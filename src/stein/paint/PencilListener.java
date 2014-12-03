package stein.paint;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class PencilListener implements DrawListener {
	
	private Integer px = null;
	private Integer py = null;
	private Integer x = null;
	private Integer y = null;
	

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

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

	private Canvas canvas;

	public PencilListener(Canvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(px == null && py == null){
			px = e.getX();
			py = e.getY();
		}
		x = e.getX();
		y = e.getY();
		Graphics2D g2 = (Graphics2D) canvas.getImg().getGraphics();
		g2.setColor(canvas.getColor());
		g2.setStroke(canvas.getStroke());
		if (x != -1 && y != -1) {
			g2.drawLine(px, py, x, y);
		}
		canvas.repaint();
		px = x;
		py = y;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		px = null;
		py = null;

	}

	@Override
	public void drawPreview(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}

}
