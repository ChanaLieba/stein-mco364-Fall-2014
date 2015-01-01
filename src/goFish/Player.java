package goFish;

import java.util.ArrayList;
import java.util.Collections;

public class Player {

	// Data fields
	private String name;
	private PlayerHand hand;
	private ArrayList<Book> books;
	private int indexInPlayers;

	// Constructor
	public Player(String name, PlayerHand hand, int index) {
		this.name = name;
		this.hand = hand;
		this.books = new ArrayList<Book>();
		this.indexInPlayers = index;
	}

	// Get list of all cards in player's hand
	public Integer[] allCardNumbersInHand() {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		ArrayList<Card> cards = this.hand.getList();
		Integer num;
		for (int i = 0; i < cards.size(); i++) {
			num = cards.get(i).getCardNum();
			if (!numbers.contains(num)) {
				numbers.add(num);
			}
		}
		Collections.sort(numbers);
		Integer[] numberList = new Integer[numbers.size()];
		for (int i = 0; i < numbers.size(); i++) {
			numberList[i] = numbers.get(i);
		}
		return numberList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PlayerHand getHand() {
		return hand;
	}

	public void setHand(PlayerHand hand) {
		this.hand = hand;
	}

	public ArrayList<Book> getBooks() {
		return books;
	}

	// Get number of books
	public int getNumBooks() {
		return this.books.size();
	}

	public int getIndexInPlayers() {
		return this.indexInPlayers;
	}

	@Override
	public String toString() {
		return this.name;
	}

}
