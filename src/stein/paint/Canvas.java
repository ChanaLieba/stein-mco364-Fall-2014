package stein.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public class Canvas extends JComponent {

	BufferedImage img;
	Graphics2D g2;
	Color color = Color.BLACK;
	int strokeInt = 5;
	Stroke stroke = new BasicStroke(strokeInt);
	DrawListener listener;

	public Canvas() {
		img = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		listener = new PencilListener(this);
		addMouseListener(listener);
		addMouseMotionListener(listener);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, null);
		listener.drawPreview((Graphics2D)g);
	}
	
	public void clearCanvas(){
		img = null;
		this.repaint();
		img = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
	}
	
	public void setDrawListenerToRectangle(){
		this.removeMouseListener(listener);
		this.removeMouseMotionListener(listener);
		listener = new RectangleListener(this);
		addMouseListener(listener);
		addMouseMotionListener(listener);
	}
	
	public void setDrawListenerToPencil(){
		this.removeMouseListener(listener);
		this.removeMouseMotionListener(listener);
		listener = new PencilListener(this);
		addMouseListener(listener);
		addMouseMotionListener(listener);
	}
	
	public void setDrawListenerToFillRectangle(){
		this.removeMouseListener(listener);
		this.removeMouseMotionListener(listener);
		listener = new FillRectangleListener(this);
		addMouseListener(listener);
		addMouseMotionListener(listener);
	}
	
	public void setDrawListenerToOval(){
		this.removeMouseListener(listener);
		this.removeMouseMotionListener(listener);
		listener = new FillOvalListener(this);
		addMouseListener(listener);
		addMouseMotionListener(listener);
	}
	public void setDrawListenerToFillOVal(){
		this.removeMouseListener(listener);
		this.removeMouseMotionListener(listener);
		listener = new OvalListener(this);
		addMouseListener(listener);
		addMouseMotionListener(listener);
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public void setStrokeInt(int strokeInt) {
		stroke = new BasicStroke(strokeInt);
	}

	public int getStrokeInt() {
		return strokeInt;
	}

	public BufferedImage getImg() {
		return img;
	}

	public void setImg(BufferedImage img) {
		this.img = img;
	}

	public Graphics2D getG2() {
		return g2;
	}

	public void setG2(Graphics2D g2) {
		this.g2 = g2;
	}

	public Stroke getStroke() {
		return stroke;
	}

	public void setStroke(Stroke stroke) {
		this.stroke = stroke;
	}
	
}
