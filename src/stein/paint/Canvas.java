package stein.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.ConnectException;
import javax.swing.JComponent;

import stein.paint.message.ClearMessage;
import stein.paint.message.LoopbackNetworkModule;
import stein.paint.message.NetworkModule;
import stein.paint.message.OnlineNetworkModule;
import stein.paint.message.PaintMessage;

public class Canvas extends JComponent {

	private BufferedImage img;
	private Color color;
	private int strokeInt;
	private Stroke stroke;
	private DrawListener listener;
	private boolean clear;
	private NetworkModule module;

	public Canvas() {
		img = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		img.getGraphics().setColor(Color.white);
		img.getGraphics().fillRect(0, 0, 800, 600);
		listener = new PencilListener(this);
		addMouseListener(listener);
		addMouseMotionListener(listener);
		try {
			PaintClient client = new PaintClient(this);
			module = new OnlineNetworkModule(client);
		} catch (ConnectException e) {
			module = new LoopbackNetworkModule(this);
		} catch (IOException d) {
			d.printStackTrace();
		}
		color = Color.BLACK;
		strokeInt = 5;
		stroke = new BasicStroke(strokeInt);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, null);
		if (clear == false) {
			listener.drawPreview((Graphics2D) g);
		} else {
			clear = false;
		}
	}

	//public void clearCanvas() {
		//clear = true;
		//PaintMessage msg = null;
		//msg = new ClearMessage(this);
		//this.getModule().sendMessage(msg);
	//}

	public void setDrawListener(DrawListener receivedListener) {
		this.removeMouseListener(listener);
		this.removeMouseMotionListener(listener);
		listener = receivedListener;
		addMouseListener(listener);
		addMouseMotionListener(listener);
	}
	
	public boolean isClear() {
		return clear;
	}

	public void setClear(boolean clear){
		this.clear = clear;
	}

	public NetworkModule getModule() {
		return module;
	}

	public void setModule(NetworkModule module) {
		this.module = module;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public void setStrokeInt(int strokeInt) {
		stroke = new BasicStroke(strokeInt);
		this.strokeInt = strokeInt;
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

	public Stroke getStroke() {
		return stroke;
	}

	public void setStroke(Stroke stroke) {
		this.stroke = stroke;
	}

}
