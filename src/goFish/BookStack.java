//This object is the graphic representation of the book, symbolizing four cards of a specific number.
package goFish;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class BookStack extends JLabel {

	// Data field
	private int cardNum;

	// Constructor
	public BookStack(int num) {
		this.cardNum = num;
		ImageIcon ii = new ImageIcon("./GoFishCards/book" + this.cardNum
				+ ".png");
		this.setIcon(ii);
	}

}
