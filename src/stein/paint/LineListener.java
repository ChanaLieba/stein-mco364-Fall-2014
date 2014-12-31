package stein.paint;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class LineListener implements DrawListener {
	
	private int pointXclicked;
	private int pointXreleased;
	private int pointYclicked;
	private int pointYreleased;
	private Canvas canvas;
	
	public LineListener(Canvas canvas){
		this.canvas = canvas;
	}

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
	public void mousePressed(MouseEvent e) {
		pointXclicked = e.getX();
		pointYclicked = e.getY();
		//System.out.println("Mouse pressed is called");
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		pointYreleased = e.getY();
		pointXreleased = e.getX();
		draw();
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		//get the xs and ys and then call canvas.repaint and canvas .
		pointYreleased = e.getY();
		pointXreleased = e.getX();
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
		g.drawLine(pointXclicked, pointYclicked, pointXreleased, pointYreleased);
		//canvas.repaint();
		
	}
	public void draw(){
		Graphics2D g2 = (Graphics2D)canvas.getImg().getGraphics();
		g2.setColor(canvas.getColor());
		g2.setStroke(canvas.getStroke());
		g2.drawLine(pointXclicked, pointYclicked, pointXreleased, pointYreleased);
		canvas.repaint();
	}
	
	

}
