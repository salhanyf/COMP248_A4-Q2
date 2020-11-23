// -------------------------------------------------------
// Assignment (4-Q2)
// For COMP 248 Section (S) – Winter 2019
// --------------------------------------------------------
//class player has 3 attributes: player name, player board, and a turned array
//to keep track when the game is over.

public class Player {
	
	//attribute that holds player's name
	private String playerName;
	
	//two arrays representing the board (holding 9 cards for each player)
	private char [][] board; 
	private boolean [][] turned; 
	
	//default constructor
	public Player() {
		board = new char[3][3];
		turned = new boolean[3][3];

	}
	
	//a constructor which takes one string parameter
	public Player (String name) {
		board = new char[3][3];
		turned  = new boolean[3][3];
		this.playerName = name;

		
	}
	
	//mutator that sets the player name.
	public void setPlayerName(String name) {
		this.playerName = name;
	}
	//accessor that gets name attribute.
	public String getPlayerName() {
		return this.playerName;
	}
	
	//returns the card in the requested location
	public char cardAt(int r, int c) {
		
		return board[r][c];
	}
	
	//flips over the card at the requested location
	//by setting the turned array at the same location to true
	public boolean flip(int r, int c) {
		if (isTurned(r, c)) {
			return false;
		}
		else {
			turned[r][c]=true;
			return true;
		}
	}
	
	//sets the card in board at the specified location to be the passed card
	public void setTo(int r, int c, char card) {
		board[r][c] = card;
	}
	
	//returns true if the card is already flipped, false otherwise 
	public boolean isTurned(int r, int c) {
		if (turned[r][c]==true) {
			return true;
		}
		else {
			return false;
		}		
	}
	
	//flips over the card at the specified location
	public void turn(int r, int c) {
		turned[r][c] = true;
	}
	
	//checks if a player has turned all his cards
	public boolean allTurned() {
		for (int i=0; i<turned.length; i++) {
			for (int j=0; j<turned[i].length; j++) {
				if (turned[i][j]==false) {
					return false;
				}
			}
		}
		return true;
	}
	
	//calculates a player points 
	public int calculatePts() {
		int total=0, value=0;
		
		for (char[]cards : board) {
			for (char card : cards) {
				switch (card) {
				
				case 'A':
					if (isIdentical(card)) {
						value = 0;
						total +=value;
					}
					else {
						value = 1;
						total +=value;
					}
					break;
				case '2':
					if (isIdentical(card)) {
						value = 0;
						total +=value;
					}
					else {
						value = 2;
						total +=value;
					}
					break;
				case '3':
					if (isIdentical(card)) {
						value = 0;
						total +=value;
					}
					else {
						value = 3;
						total +=value;
					}
					break;
				case '4':
					if (isIdentical(card)) {
						value = 0;
						total +=value;
					}
					else {
						value = 4;
						total +=value;
					}
					
					break;
				case '5':
					if (isIdentical(card)) {
						value = 0;
						total +=value;
					}
					else {
						value = 5;
						total +=value;
					}
					break;
				case '6':
					if (isIdentical(card)) {
						value = 0;
						total +=value;
					}
					else {
						value = 6;
						total +=value;
					}
					break;
				case '7':
					if (isIdentical(card)) {
						value = 0;
						total +=value;
					}
					else {
						value = 7;
						total +=value;
					}
					break;
				case '8':
					if (isIdentical(card)) {
						value = 0;
						total +=value;
					}
					else {
						value = 8;
						total +=value;
					}
					break;
				case '9':
					if (isIdentical(card)) {
						value = 0;
						total +=value;
					}
					else {
						value = 9;
						total +=value;
					}
					break;
				case 'T':
					if (isIdentical(card)) {
						value = 0;
						total +=value;
					}
					else {
						value = 10;
						total +=value;
					}
					break;
				case 'J':
					if (isIdentical(card)) {
						value = 0;
						total +=value;
					}
					else {
						value = 10;
						total +=value;
					}
					break;
				case 'Q':
					if (isIdentical(card)) {
						value = 0;
						total +=value;
					}
					else {
						value = 10;
						total +=value;
					}
					break;
				case 'K':
					if (isIdentical(card)) {
						value = 0;
						total +=value;
					}
					else {
						value = 0;
						total +=value;
					}
					break;
				case '?':
					if (isIdentical(card)) {
						value = 0;
						total +=value;
					}
					else {
						value = -5;
						total +=value;
					}
					break;
				
				}//end of switch
			}
		}// end of for loop

		return total;
	}
	
	//checks for identical cards 
	public boolean isIdentical(char card) {
		if (card == board[0][0] && card == board[1][1] & card == board[2][2]) {
			return true;
		}
		else if (card == board[0][2] && card == board[1][1] & card == board[2][0]) {
			return true;
		}
		else if (card == board[0][0] && card == board[1][0] & card == board[2][0]) {
			return true;
		}
		else if (card == board[0][1] && card == board[1][1] & card == board[2][1]) {
			return true;
		}
		else if (card == board[0][2] && card == board[1][2] & card == board[2][2]) {
			return true;
		}
		else if (card == board[0][0] && card == board[0][1] & card == board[0][2]) {
			return true;
		}
		else if (card == board[1][0] && card == board[1][1] & card == board[1][2]) {
			return true;
		}
		else if (card == board[2][0] && card == board[2][1] & card == board[2][2]) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	//displays a player board
	public void displayBoard() {
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board.length; j++) {
				if (!turned[i][j])
					System.out.print("*"+"   ");
				else
					System.out.print(board[i][j]+"   ");
			}
			System.out.println();
		}
	}
	
	//displays the turned array 
	public void displayTurned() {
		for (int i=0; i<turned.length; i++) {
			for (int j=0; j<turned.length; j++) {
				System.out.print(turned[i][j]+"   ");
			}
			System.out.println();
		}	
	}
	
	//displays a player cards all flipped 
	public void displayCardsflipped() {
		System.out.println();
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board.length; j++) {
				System.out.print(board[i][j]+"   ");
			}
			System.out.println();
		}	
	}
	
}//end of class
