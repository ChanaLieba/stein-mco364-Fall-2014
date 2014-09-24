package ChatRoom;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChatGUI extends JFrame{
	
	private JLabel enterText;
	private JTextField theText;
	private JButton send;
	private JPanel panel;
	
	public ChatGUI(String s){
		enterText = new JLabel("Enter Text");
		theText = new JTextField(s);
		send = new JButton("Send");
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(enterText);
		panel.add(theText);
		panel.add(send);
		this.add(panel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(600,800);
	}
	public static void main (String[] args){
		ChatGUI gui = new ChatGUI("CL");
		gui.setVisible(true);
	}

}
