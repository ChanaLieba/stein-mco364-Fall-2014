package stein.chatroom;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChatGUI extends JFrame {

	private JLabel enterText;
	private JTextField theText;
	private JButton send;
	private JPanel panel;

	public ChatGUI(){
		enterText = new JLabel("Enter Text");
		theText = new JTextField(50);
		send = new JButton("Send");
		send.addActionListener(new SendButtonListener());
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(enterText);
		panel.add(theText);
		panel.add(send);
		this.add(panel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(600,800);
	}

	public String getText() {
		return theText.getText();
	}

	private class SendButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			NetworkThread nt = new NetworkThread();

		}
	}
}
