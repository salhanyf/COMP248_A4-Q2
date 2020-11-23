// -------------------------------------------------------
// Assignment (4-Q2)
// For COMP 248 Section (S) – Winter 2019
// --------------------------------------------------------
//class DeckAndDiscard holds the deck of cards the players are using

public class DeckAndDiscard {
	
	//array deck holds all the cards 
	private char[] deck;
	
	//array discard pile holds the discard cards 
	private char[] discardPile;

	//3 integer attributes
	private int discardCard;
	private int nextCard;
	private int numberLeft;
	
	//default constructor
	public DeckAndDiscard() {
		//2 arrays
		deck = new char[]{'A','2','3','4','5','6','7','8','9','T','J','Q','K',
						  'A','2','3','4','5','6','7','8','9','T','J','Q','K',
						  'A','2','3','4','5','6','7','8','9','T','J','Q','K',
						  'A','2','3','4','5','6','7','8','9','T','J','Q','K','?','?'};    
		//discard pile array which is empty for now 
		discardPile = new char[54];
		
		shuffle();

		//3 integers 
		discardCard = 0;
		nextCard = 53;
		numberLeft = 54;

	}
	
	//returns the top card (char) in the deck.
	public char pickACard() {
		char topCard = deck[nextCard];
		nextCard--;
		numberLeft--;
		return topCard;
	}
	
	//the card that is being added to the discard pile.
	public void discard(char oldCard) {
		discardPile[discardCard] = oldCard;
		discardCard++;
	}

	//shuffles the deck of cards at the start of the game
	public void shuffle() {
		int rand1, rand2;
		for (int i=0; i<1000; i++) {
			rand1 = (int)(Math.random()*deck.length);
			rand2 = (int)(Math.random()*deck.length);
			
			char temp = deck[rand1];
			deck[rand1] = deck[rand2];
			deck[rand2] = temp;
		}
	}
	
	//displays the remaining cards in the deck
	public void displayDeck() {
		System.out.println("The remaining cards in the deck are:");
		for (int i=0; i<deck.length; i++) 
			System.out.print(deck[i]+" ");
	}
	
	//displays the cards in the discard pile
	public void displayDiscardPile() {
		System.out.println("The cards in the discard pile are:");
		for (int i=0; i<discardPile.length; i++) 
			System.out.print(discardPile[i]+" ");
	}	
	
}//end of class
