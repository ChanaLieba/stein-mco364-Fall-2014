package goFish;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.net.MalformedURLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AnimatedGIF {
	public static void main(String[] args) throws MalformedURLException {

		String location1 = "./AnimatedCards/background.gif";
		Icon icon1 = new ImageIcon(location1);
		JLabel label1 = new JLabel(icon1);
		label1.setOpaque(true);
		label1.setBackground(Color.BLUE);

		String location2 = "./AnimatedCards/background2.gif";
		Icon icon2 = new ImageIcon(location1);
		JLabel label2 = new JLabel(icon2);
		label2.setOpaque(true);
		label2.setBackground(Color.BLUE);

		String location3 = "./AnimatedCards/background3.gif";
		Icon icon3 = new ImageIcon(location1);
		JLabel label3 = new JLabel(icon3);
		label3.setOpaque(true);
		label3.setBackground(Color.BLUE);

		// URL location4 = new
		// URL("https://www.youtube.com/watch?v=B2kV9P0LC8s");
		String location4 = "./AnimatedCards/fisherman1.gif";
		Icon icon4 = new ImageIcon(location4);
		JLabel label4 = new JLabel(icon4);
		label4.setOpaque(true);
		label4.setBackground(Color.BLUE);

		JFrame f = new JFrame("Animation");
		JLabel fish = new JLabel();
		fish.setLayout(new GridLayout(1, 3));
		fish.add(label1);
		fish.add(label2);
		fish.add(label3);
		f.add(BorderLayout.CENTER, fish);
		// f.add(BorderLayout.SOUTH, label4);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
}