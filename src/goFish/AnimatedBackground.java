package goFish;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class AnimatedBackground extends JLabel {

	public AnimatedBackground() {

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

		this.setLayout(new GridLayout(1, 3));
		this.add(label1);
		this.add(label2);
		this.add(label3);
		//f.add(BorderLayout.CENTER, fish);

	}

}
