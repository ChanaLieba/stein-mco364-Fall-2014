package goFish;

import org.junit.Assert;
import org.junit.Test;

public class GoFishMethodsTest {

	@Test
	public void testDeckNumber() {
		Deck d = new Deck();
		d.deal();
		d.deal();
		d.deal();
		Assert.assertEquals(49, d.getNumInDeck());
	}

	@Test
	public void testCheckBook() {
		PlayerHand ph = new PlayerHand();
		Card c = new Card(3,'d');
		ph.insert(c);
		ph.insert(c);
		ph.insert(c);
		ph.insert(c);
		Assert.assertTrue(ph.checkBook());
	}

	@Test
	public void testGetNumberOfBook() {
		PlayerHand ph = new PlayerHand();
		Card one = new Card(1,'d');
		Card two = new Card(2,'d');
		ph.insert(one);
		ph.insert(two);
		ph.insert(one);
		ph.insert(one);
		ph.insert(two);
		ph.insert(one);
		Assert.assertEquals(1, ph.numOfBook());
	}
}
