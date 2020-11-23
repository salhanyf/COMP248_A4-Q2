// -------------------------------------------------------
// Assignment (4-Q2)
// For COMP 248 Section (S) – Winter 2019
// --------------------------------------------------------
//This is the driver class of the Golf Card game

import java.util.Scanner;

public class Golf {
	public static void main(String[] args) {
		
		//declares the scanner object
		Scanner Scan = new Scanner(System.in);
		
		//one object of type DeckAndDiscard since both players are sharing the same deck of cards 
		DeckAndDiscard deck = new DeckAndDiscard();
		
		//an arrays of type Player to store the two players
		Player[] players = new Player[2];
		
		//welcome message and instructions about the game
		System.out.println("\t-----*****-----*****-----*****-----*****-----");
		System.out.println("\t      Welcome to Farah's Card Golf Game      ");
		System.out.println("\t-----*****-----*****-----*****-----*****-----");
		System.out.print("To win this game you need some luck with the cards and a bit of strategy.\n"
				+ "Just like the outdoor game of golf, the card game known as Golf has a goal"
				+ " of keeping\n the score as low as possible.\nOkay .. "
				+ "let's start the game! May the best golfer win!!!\n\n\n");       
		
		//takes the name of the two players and store it in the array
		for (int i=0; i<2; i++) {
			System.out.println("What is the name of "+(i+1)+"st player:");
			String name = Scan.next();
			players[i] = new Player(name);
		}
		
		//deals 9 cards to the first player
		for(int r=0; r<3; r++) {
			for (int c=0; c<3; c++) {
				players[0].setTo(r, c, deck.pickACard());
			}
		}
		
		//deals 9 cards to the second player
		for(int r=0; r<3; r++) {
			for (int c=0; c<3; c++) {
				players[1].setTo(r, c, deck.pickACard());
			}
		}
		System.out.println();
		
		
		//let's the game begins
		//asks for which two cards the two players want to flip at first
		int flipRow, flipCol;
		for (int i=0; i<2; i++) {
			System.out.println(players[i].getPlayerName()+" time to decide which 2 cards you want to turn over");
			System.out.print("Which card do you want to flip (row col) ");
			flipRow = Scan.nextInt();			
			flipCol = Scan.nextInt();
			players[i].flip(flipRow, flipCol);
			
			System.out.print("Which card do you want to flip (row col) ");
			flipRow = Scan.nextInt();			
			flipCol = Scan.nextInt();
			players[i].flip(flipRow, flipCol);
			
			System.out.println();
		}
		
		int row, col;
		char discardPileCard;
		int option;
		boolean gameOver= false;
		
		//game iteration until there is a winner; a players cards are all flipped 
		do {
			
		for (int i=0; i<2; i++) {
			
			//holds the value of the card on the discard pile 
			discardPileCard = deck.pickACard();
			
			//shows the card on the discard pile
			System.out.println("Discard pile has "+discardPileCard);
			System.out.println(players[i].getPlayerName()+"'s turn:");
			System.out.println("-----------------------");
				
			//shows player board 
			System.out.println("Here is your board.");
			players[i].displayBoard();
				
			//1st question: 2 options, take the card on the discard pile or pick a new card 
			System.out.print("Do you want the card on the discard pile(0) or a new card(1) ");
			option = Scan.nextInt();
				
			//if take the card on the discard pile was chosen
			if (option==0) {
					
				//2 options, replace a flipped card or flip a new card
				System.out.print(players[i].getPlayerName()+", do you want to replace a flipped card(0) or flip a new card(1) ");
				option = Scan.nextInt();
					
				//if replace a flipped card was chosen
				if (option==0) {
					System.out.print("Which flipped card do you want to replace (row col)? ");
					row = Scan.nextInt();
					col = Scan.nextInt();
					
					//checks id the card is already flipped 
					while (!players[i].isTurned(row, col)) {
						System.out.println("card is not yet flipped!! try again");
						System.out.print("Which flipped card do you want to replace (row col)? ");
						row = Scan.nextInt();
						col = Scan.nextInt();
					}
					
					players[i].setTo(row, col, discardPileCard);
					
					System.out.println();
				}
					
				//if flip a new card was chosen 
				else if (option==1) {
					System.out.print("Which non-flipped card do you want to flip (row col)? ");
					row = Scan.nextInt();
					col = Scan.nextInt();
						
					//checks if the card is not yet flipped 
					while (players[i].isTurned(row, col)) {
						System.out.println("card is already flipped!! try again");
						System.out.print("Which non-flipped card do you want to flip (row col)? ");
						row = Scan.nextInt();
						col = Scan.nextInt();
					}
					//flips the old card and replace it by the card from the discard pile
					players[i].flip(row, col);
					players[i].setTo(row, col, discardPileCard);
					System.out.println();
				}
			}	
				
			//if pick a new card was chosen
			else if(option==1)	{
				//discards the card and picks a new card from the deck
				deck.discard(discardPileCard);
				discardPileCard = deck.pickACard();
				
				//displays the new card
				System.out.println("The card you are playing is "+discardPileCard+"\n");
			
				//2 options, replace it or toss it and do nothing 
				System.out.print("Replace a card(0) or toss it(1)? ");
				option = Scan.nextInt();
				
				//if replace it is chosen 
				if (option==0) {
					//2 options, replace a flipped card or flip a new card
					System.out.print(players[i].getPlayerName()+", do you want to replace a flipped card(0) or flip a new card(1) ");
					option = Scan.nextInt();
						
					//if replace a flipped card was chosen
					if (option==0) {
						System.out.print("Which flipped card do you want to replace (row col)? ");
						row = Scan.nextInt();
						col = Scan.nextInt();
							
						//checks id the card is already flipped 
						while (!players[i].isTurned(row, col)) {
							System.out.println("card is not yet flipped!! try again");
							System.out.print("Which flipped card do you want to replace (row col)? ");
							row = Scan.nextInt();
							col = Scan.nextInt();
						}
						//sets the card on the specific location to the card on the discard pile
						players[i].setTo(row, col, discardPileCard);
						
						System.out.println();	
					}
					//if flip a new card is chosen
					else if (option==1) {
						System.out.print("Which non-flipped card do you want to flip (row col)? ");
						row = Scan.nextInt();
						col = Scan.nextInt();
						
						//checks if the card is not yet flipped 
						while (players[i].isTurned(row, col)) {
							System.out.println("card is already flipped!! try again");
							System.out.print("Which non-flipped card do you want to flip (row col)? ");
							row = Scan.nextInt();
							col = Scan.nextInt();
						}
						
						//flips the old card and replace it by the card from the discard pile
						players[i].flip(row, col);
						players[i].displayBoard();
						System.out.println();
							
						//asks if the player wants to replace it or toss it and do nothing 
						System.out.print("Replace this card(0) or toss it(1)? ");
						option = Scan.nextInt();
						
						if (option==0) {
							players[i].setTo(row, col, discardPileCard);
							System.out.println();
						}
						else {
							deck.discard(discardPileCard);
							System.out.println();	
						}
					}
				}
				else 
					System.out.println();
					
			}
			
			//checks if the player has turned all his cards to end the game if not the iteration continues
			if (players[i].allTurned()) {
				gameOver = true;
				System.out.println(players[i].getPlayerName()+" has turned over all cards.");
				break;
			}	
		}
		} while (!gameOver);
		
		//displays the flipped cards for each player 
		System.out.println("Time to calculate points! Here are your boards with all cards turned over");
		System.out.println();
		System.out.println(players[0].getPlayerName()+"\t\t"+players[1].getPlayerName());
		System.out.println("-----------------------------------------");
		System.out.print(players[0].cardAt(0, 0)+"   "+players[0].cardAt(0, 1)+"   "+players[0].cardAt(0, 2)+""
				+ "\t\t"+players[1].cardAt(0, 0)+"   "+players[1].cardAt(0, 1)+"   "+players[1].cardAt(0, 2)+"\n"
						+players[0].cardAt(1, 0)+"   "+players[0].cardAt(1, 1)+"   "+players[0].cardAt(1, 2)+""
				+ "\t\t"+players[1].cardAt(1, 0)+"   "+players[1].cardAt(1, 1)+"   "+players[1].cardAt(1, 2)+"\n"
						+players[0].cardAt(2, 0)+"   "+players[0].cardAt(2, 1)+"   "+players[0].cardAt(2, 2)+""
				+ "\t\t"+players[1].cardAt(2, 0)+"   "+players[1].cardAt(2, 1)+"   "+players[1].cardAt(2, 2)+"\n\n");
		
		//calculates each player score
		int ply0Results = players[0].calculatePts();
		int ply1Results = players[1].calculatePts();
		
		//displays results 
		System.out.println("Final resutls:");	
		System.out.println("   "+players[0].getPlayerName()+" scored "+ply0Results);	
		System.out.println("   "+players[1].getPlayerName()+" scored "+ply1Results);	
		
		//checks which player had the lowest score to determine the winner 
		if (ply0Results > ply1Results) {
			System.out.println("\nCONGRATULATIONS!!!! The winner is "+players[1].getPlayerName());
		}
		else if (ply0Results < ply1Results) {
			System.out.println("\nCONGRATULATIONS!!!! The winner is "+players[0].getPlayerName());
		}	
		
		//closing message 
		System.out.println();
		System.out.println("\t              Thanks for playing             ");
		System.out.println("\t-----*****-----*****-----*****-----*****-----");  
		
		//closes the scanner object
		Scan.close();
		
	}//end of main()
}//end of class
