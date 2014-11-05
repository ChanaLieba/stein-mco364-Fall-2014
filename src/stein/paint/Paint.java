package stein.paint;

import javax.swing.JFrame;

public class Paint extends JFrame{
	
	public Paint(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args){
		
		Paint paint = new Paint();
	}

}
