import java.util.Random;
import java.util.Scanner;

class Presidents{
	
	public static void main(String[] args){
		System.out.println("Welcome to Presidents. \n"
				+ "Please enter the number of players: ");	// introduction message
		
		Scanner in = new Scanner(System.in);		// scanner for user input
		while (!in.hasNextInt()){					// wait for user to give correct input for number of players
			System.out.println("Please enter the number of players (2-4): ");
		}
		int playerNum = in.nextInt();				// user set number of players in game
		Bot[] cpi = new Bot[playerNum-1];			// initialize array of bots
		User player = new User();					// initialize a user object for the human player
		
		for (int i = 0; i < cpi.length; i++){		// iterate through bot array to initialize bots
			cpi[i] = new Bot();
		}
		int[] nextOrder = new int[playerNum];		// int array to hold the order of the players
		
		for (int j = 0; j < nextOrder.length; j++){	// initialize array with first order
			nextOrder[j] = j;
		}
		
		while (in.nextLine() != "q"){				// play game until user quits (enters "q")
			nextOrder = gameIteration(player, cpi, nextOrder);	// set next order array to be the result of a game's iteration
		}
		
		in.close();									// close scanner
	}
	
	// runs a new iteration of the game
	// @param takes an user object, an array of bots, and the int array holding the order of the players
	// @return returns nothing
	public static int[] gameIteration(User player, Bot[] cpi, int[] order){
		List Deck = newDeck();						// create new deck
		Deck = shuffle(Deck);						// shuffle the deck
		int[] newOrder = new int[order.length];		// create new int array to hold the order at the end of the current iteration
		player.setOrder(order[0]);					// set order for the player
		
		for (int i = 1; i < order.length; i++){		// set order for bots
			cpi[i-1].setOrder(order[i]);
		}
		int orderNum = 0;							// variable with the order number
		if (order.length == 3){						// if there are 3 players (to avoid remainder) 
			player.setHand(deal(Deck, 18));			// set the player and bot hands to be dealt this way
			for (int k = 0; k < cpi.length; k++){
				cpi[k].setHand(deal(Deck, 17));
			}
		}
		else {										// else (2 or 4 players so no need to worry about remainder)
			player.setHand(deal(Deck, 52/order.length));			// set the player and bot hands to be dealt this way
			for (int k = 0; k < cpi.length; k++){
				cpi[k].setHand(deal(Deck, 52/order.length));
			}
		}
		
		while (orderNum != order.length-1){			// while the order number is not the number of players
			if (player.getHand().length() == 0){	// if the player hand is empty
				newOrder[0] = orderNum;				// set the order number to the player's index in newOrder array
				orderNum++;							// increment the order number
			}
			else {									// else (check if the bots have empty hands)
				for (int j = 0; j < cpi.length; j++){	// iterate through the bot array
					if (cpi[j].getHand().length() == 0){	// if the bot's hand is empty
						newOrder[j] = orderNum;		// set the order number to the bot's index in newOrder arrau
						orderNum++;					// increment the order number
					}
				}
			}
			
			
		}
		
		return newOrder;							// return the array with the new order set
	}
	
	// create new deck
	// @param takes no arguments
	// @return returns a List object that will serve as the deck
	public static List newDeck(){
		List D = new List();						// create new list hold the deck of cards
		for (int i = 0; i < 52; i++){				// create a new card object and store it to the list
			String s = "";							// string to store the suit
			String r = "";							// string to store the rank
			int mod = i%13;							// int to hold the mod of i and 13
			// set the rank and suit of the card (Dirty but effective)
			if (mod == 0){
				r = "ACE";
			}
			else if (mod == 1){
				r = "Two";
			}
			else if (mod == 2){
				r = "Three";
			}
			else if (mod == 3){
				r = "Four";
			}
			else if (mod == 4){
				r = "Five";
			}
			else if (mod == 5){
				r = "Six";
			}
			else if (mod == 6){
				r = "Seven";
			}
			else if (mod == 7){
				r = "Eight";
			}
			else if (mod == 8){
				r = "Nine";
			}
			else if (mod == 9){
				r = "Ten";
			}
			else if (mod == 10){
				r = "Jack";
			}
			else if (mod == 11){
				r = "Queen";
			}
			else{
				r = "King";
			}
			if (i >= 0 && i < 13){
				s = "Spade";
			}
			else if (i >= 13 && i < 26){
				s = "Heart";
			}
			else if (i >= 26 && i < 39){
				s = "Club";
			}
			else{
				s = "Diamond";
			}
			Card c = new Card(s, r);
			D.append(c);
		}
		return D;
	}
	
	// shuffle the deck
	// @param takes the list (deck) to shuffle
	// @return returns shuffled deck
	public static List shuffle(List D){
		Random rand = new Random();
		int ranNum = rand.nextInt(D.length());
		for (int i = 0; i < ranNum; i++){
			D.moveFront();
			while (D.get() != null){
				if(D.index() == i){
					Card c = (Card)D.get();
					D.delete();
					D.append(c);
				}
				else{
					D.moveNext();
				}
			}
		}
		return D;
	}
	
	// deals out a set number of cards from the deck
	// @param takes an int to determine how many cards are dealt from the deck and the deck list
	// @return returns a list of the cards handed out from the deck
	public static List deal(List D, int handSize){
		List hand = new List();
		if (handSize <= D.length()){
			for (int i = 0; i <= handSize; i++){
				hand.append(D.front());
				D.deleteFront();
			}
		}
		return hand;
	}
}