package goFish;

public class Game {

	// Data fields
	private Pool pool;
	private Players players;
	private int currentTurnNumber;

	// Constructor
	public Game(int numPlayers, String[] names) {

		// Instantiate a deck
		Deck deck = new Deck();

		// Pass the deck to create the Players
		this.players = new Players(numPlayers, names, deck);

		// Create the pool with remaining cards
		this.pool = deck.createPool();

		// Set the turn number
		this.currentTurnNumber = 1;
	}

	// Get players
	public Players getPlayers() {
		return this.players;
	}

	// Get current turn number
	public int getCurrentTurnNum() {
		return this.currentTurnNumber;
	}

	// Set current turn number
	public void setCurrentTurnNum(int num) {
		this.currentTurnNumber = num;
	}

	// Get number of players
	public int getNumberOfPlayers() {
		return this.players.getNumPlayers();
	}

	public Player getCurrentPlayer() {
		return this.players.getCurrentPlayer(this.currentTurnNumber);
	}

	public Pool getPool() {
		return this.pool;
	}

	// Get game status. Game is over when there are a total of 13 books.
	public boolean getGameOver() {
		if (this.players.totalBooks() == 13) {
			return true;
		} else {
			return false;
		}
	}

}
