package stein.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public class Canvas extends JComponent {
	
	int x ;
	int y ;
	BufferedImage img;
	
	public Canvas(){
		img = new BufferedImage(800,600,BufferedImage.TYPE_INT_ARGB);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0,0,null);
	}
	
	public void setXandY(int x, int y){
		 this.x = x;
		 this.y = y;
		 Graphics g = img.getGraphics();
		 g.setColor(Color.BLACK);
		 g.fillOval(x, y, 10, 10);
	}
	

}
