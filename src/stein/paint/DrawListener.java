package stein.paint;

import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public interface DrawListener extends MouseListener, MouseMotionListener{
	
	public void drawPreview(Graphics2D g);
	
	
	
}
