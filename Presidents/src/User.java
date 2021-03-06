
public class User{
	private List hand;															// List to hold all the cards in the hand
	private int order;															// int to hold the order/ rank of the bot
	
	// user constructor
	public User(){
		hand = new List();
		order = 0;
	}
	
	public List getHand(){
		return hand;
	}
	
	public void setHand(List newHand){
		hand = newHand;
	}
	
	public int getOrder(){
		return order;
	}
	
	public void setOrder(int newOrder){
		order = newOrder;
	}
	
	// makes a move
	// @param takes a list that is the top most card set thrown down in the pile
	// @return returns nothing
	public List move(List top){
		sortRank();
		List stack = new List();
		
		return stack;
	}
	
	// says whether the hand contains a five card hand
	// @param takes no arguments
	// @return returns a boolean regarding whether it has a five card hand
	private boolean containsFiveCard(){
		boolean contains = true;												// initialize a boolean to true
		if (hand.length() < 5){													// if there are less than five cards in the hand
			contains = false;													// set the boolean to false
		}
		else if (!containsFullHouse() && !containsFourOfAKind() && !containsStraightFlush() && !containsFlush() && !containsStraight()){	// else if there is no full house, four of a kind, straight flush, flush, or straight 
			contains = false;													// set the boolean to false
		}
		return contains;														// return the boolean
	}
	
	// says whether the hand contains a full house
	// @param takes no arguments
	// @return returns a boolean regarding whether it has a full house
	private boolean containsFullHouse(){
		sortRank();																// sort the hand
		boolean contains = false;												// initialize boolean to false
		hand.moveFront();														// move cursor of hand to front
		while (hand.index() != hand.length()-2 && contains == false){			// while the cursor is not at the second to last entry in the hand and the boolean is still false
			Card cursor = (Card) hand.get();									// convert cursor to a card
			hand.moveNext();													// move cursor along hand
			Card next = (Card) hand.get(); 										// convert that "next" cursor to a card
			hand.moveNext();													// repeat for a third and fourth card
			Card third = (Card) hand.get();
			hand.moveNext();
			Card fourth = (Card) hand.get();
			if (cursor.compareToRank(next) == 0 && cursor.compareToRank(third) == 0 && cursor.compareToRank(fourth) == 0){	// if the cards have the same rank
				contains = true;												// change the boolean to true
			}
			for (int i = 0; i < 2; i++){										// move cursor back (so that cursor is now where next is)
				hand.movePrev();
			}
		}
		return contains;														// return the boolean
	}
	
	// says whether the hand contains a four of a kind
	// @param takes no arguments
	// @return returns a boolean regarding whether it has a four of a kind
	private boolean containsFourOfAKind(){
		sortRank();																// sort the hand
		boolean contains = false;												// initialize boolean to false
		hand.moveFront();														// move cursor of hand to front
		while (hand.index() != hand.length()-2 && contains == false){			// while the cursor is not at the second to last entry in the hand and the boolean is still false
			Card cursor = (Card) hand.get();									// convert cursor to a card
			hand.moveNext();													// move cursor along hand
			Card next = (Card) hand.get(); 										// convert that "next" cursor to a card
			hand.moveNext();													// repeat for a third and fourth card
			Card third = (Card) hand.get();
			hand.moveNext();
			Card fourth = (Card) hand.get();
			if (cursor.compareToRank(next) == 0 && cursor.compareToRank(third) == 0 && cursor.compareToRank(fourth) == 0){	// if the cards have the same rank
				contains = true;												// change the boolean to true
			}
			for (int i = 0; i < 2; i++){										// move cursor back (so that cursor is now where next is)
				hand.movePrev();
			}
		}
		return contains;														// return the boolean
	}
	
	// say\s whether or not the hand has a straight flush
	// @param takes no arguments
	// @return returns a boolean regarding whether it has a straight flush
	private boolean containsStraightFlush(){
		sortRank();																// sort the hand
		boolean contains = false;												// initialize boolean to false
		hand.moveFront();														// move cursor of hand to front
		while (hand.index() != hand.length()-4 && contains == false){			// while the cursor is not the fourth to last entry in the hand and the boolean is still false
			Card cursor = (Card) hand.get();									// convert cursor to a card
			hand.moveNext();													// move cursor along hand
			Card next = (Card) hand.get(); 										// convert that "next" cursor to a card
			hand.moveNext();													// repeat for a third, fourth, and fifth card
			Card third = (Card) hand.get();
			hand.moveNext();
			Card fourth = (Card) hand.get();
			hand.moveNext();
			Card fifth = (Card) hand.get();
			int difference = fifth.convertRankToInt() - fourth.convertRankToInt() - third.convertRankToInt() - next.convertRankToInt() - cursor.convertRankToInt();
			if (difference == 2-cursor.convertRankToInt()){						// if the difference is equal to 2 minus the cursor rank value
				if (cursor.getSuit().equals(next.getSuit()) && cursor.getSuit().equals(third.getSuit()) && cursor.getSuit().equals(fourth.getSuit()) && cursor.getSuit().equals(fifth.getSuit())){	// if the suits all match
					contains = true;											// change the boolean to true
				}
			}
			for (int i = 0; i < 3; i++){										// move cursor back (so that cursor is now where next is)
				hand.moveBack();
			}
		}
		return contains;														// return the boolean
	}
	
	// says whether or not the hand has a flush
	// @param takes no arguments
	// @return returns a boolean regarding whether it has a flush
	private boolean containsFlush(){
		sortRank();																// sort the hand
		boolean contains = false;												// initialize boolean to false
		int countSpade = 0;														// initialize counters for each suit
		int countHeart = 0;
		int countClub = 0;
		int countDiamond = 0;
		hand.moveFront();														// move cursor of hand to front
		while (contains == false){
			Card cursor = (Card) hand.get();									// convert cursor to a card
			if (cursor.getSuit().equals("Spade")){								// if the cursor rank is spades
				countSpade++;													// increment the spades counter
			}
			else if (cursor.getSuit().equals("Heart")){							// else if the cursor rank is hearts
				countHeart++;													// increment the hearts counter
			}
			else if (cursor.getSuit().equals("Club")){							// else if the cursor rank is clubs
				countClub++;													// increment the club counter
			}
			else if (cursor.getSuit().equals("Diamond")){						// else if the cursor rank is diamonds
				countDiamond++;													// increment the diamond counter
			}
			if (countSpade == 5 || countHeart == 5 || countClub == 5 || countDiamond == 5){	// if any of the counters reach 5
				contains = true;												// change the boolean to true
			}
			hand.moveNext();													// move cursor along hand
		}
		return contains;														// return the boolean
	}
	
	// says whether or not the hand has a straight
	// @param takes no arguments
	// @return returns a boolean regarding whether it has a straight
	private boolean containsStraight(){
		sortRank();																// sort the hand
		boolean contains = false;												// initialize boolean to false
		hand.moveFront();														// move cursor of hand to front
		while (hand.index() != hand.length()-4 && contains == false){			// while the cursor is not the fourth to last entry in the hand and the boolean is still false
			Card cursor = (Card) hand.get();									// convert cursor to a card
			hand.moveNext();													// move cursor along hand
			Card next = (Card) hand.get(); 										// convert that "next" cursor to a card
			hand.moveNext();													// repeat for a third, fourth, and fifth card
			Card third = (Card) hand.get();
			hand.moveNext();
			Card fourth = (Card) hand.get();
			hand.moveNext();
			Card fifth = (Card) hand.get();
			int difference = fifth.convertRankToInt() - fourth.convertRankToInt() - third.convertRankToInt() - next.convertRankToInt() - cursor.convertRankToInt();
			if (difference == 2-cursor.convertRankToInt()){						// if the difference is equal to 2 minus the cursor rank value
				contains = true;												// change the boolean to true
			}
			for (int i = 0; i < 3; i++){										// move cursor back (so that cursor is now where next is)
				hand.moveBack();
			}
		}
		return contains;														// return the boolean
	}
	
	// says whether or not the hand has three of a kind
	// @param takes no arguments
	// @return returns a boolean regarding whether it has three of a kind
	private boolean containsTriple(){
		sortRank();																// sort the hand
		boolean contains = false;												// initialize boolean to false
		hand.moveFront();														// move cursor of hand to front
		while (hand.index() != hand.length()-2 && contains == false){			// while the cursor is not at the second to last entry in the hand and the boolean is still false
			Card cursor = (Card) hand.get();									// convert cursor to a card
			hand.moveNext();													// move cursor along hand
			Card next = (Card) hand.get(); 										// convert that "next" cursor to a card
			hand.moveNext();													// repeat for a third card
			Card third = (Card) hand.get();
			if (cursor.compareToRank(next) == 0 && cursor.compareToRank(third) == 0){	// if the cards have the same rank
				contains = true;												// change the boolean to true
			}
			hand.movePrev();													// move cursor back (so that cursor is now where next is)
		}
		return contains;														// return the boolean
	}
	
	// says whether or not the hand has two pairs
	// @param takes no arguments
	// @return returns a boolean regarding whether it has two pairs
	private boolean containsDouble(){
		sortRank();																// sort the hand
		boolean contains1 = false;												// initialize one boolean to false (for the first pair)
		boolean contains2 = false;												// initialize a second boolean to false (for the second pair)
		hand.moveFront();														// move cursor of hand to front
		while (!hand.get().equals(hand.back()) && contains1 == false){			// while the cursor is not at the back and the boolean is still false
			Card cursor = (Card) hand.get();									// convert cursor to a card
			hand.moveNext();													// move cursor along hand
			Card next = (Card) hand.get(); 										// convert that "next" cursor to a card
			if (cursor.compareToRank(next) == 0){								// if the cards have the same rank
				contains1 = true;												// change the boolean to true
			}
		}
		if (contains1 == true){													// if the first boolean is true (ie containsSingle())
			while (!hand.get().equals(hand.back()) && contains2 == false){		// repeat process from where you left off
				Card cursor = (Card) hand.get();
				hand.moveNext();
				Card next = (Card) hand.get(); 
				if (cursor.compareToRank(next) == 0){
					contains2 = true;
				}
			}
		}
		return (contains1 && contains2);										// return the logical and of both booleans
	}
	
	// says whether or not the hand has a single pair
	// @param takes no arguments
	// @return returns a boolean regarding whether it has a single pair
	private boolean containsSingle(){
		sortRank();																// sort the hand 
		boolean contains = false;												// initialize boolean to false
		hand.moveFront();														// move cursor of hand to front
		while (!hand.get().equals(hand.back()) && contains == false){			// while the cursor is not at the back and the boolean is still false
			Card cursor = (Card) hand.get();									// convert cursor to a card
			hand.moveNext();													// move cursor along hand
			Card next = (Card) hand.get(); 										// convert that "next" cursor to a card
			if (cursor.compareToRank(next) == 0){								// if the cards have the same rank
				contains = true;												// change the boolean to true
			}
		}
		return contains;														// return the boolean
	}
	
	private boolean isFiveCard(){
		return false;
	}
	
	private boolean isDouble(){
		return false;
	}
	
	private boolean isSingle(){
		return false;
	}
	
	// sort the bot's hand by rank
	// @param takes nothing
	// @return returns nothing
	private void sortRank(){
		List sorted = new List();												// create new list that is to be sorted version of the bot's hand
		hand.moveFront();														// move hand cursor to front
		while (hand.get() != null){												// while the cursor of the hand list is not the front
			if (sorted.length() == 0){											// if the sorted list is empty, append the first item on the hand
				sorted.append(hand.front());
			}
			else {
				sorted.moveFront();
				while (sorted.get() != null){
					Card cursorCard = (Card) hand.get();						// convert sorted cursor
					Card sortedCursorCard = (Card) sorted.get();				// convert hand cursor to card
					if (cursorCard.compareToRank(sortedCursorCard) == -1 || cursorCard.compareToRank(sortedCursorCard) == 0){		// if sortedcard rank is greater than or equal to cursorcard rank
						sorted.insertBefore(cursorCard);						// insert cusorcard before sortedcard
						sorted.moveBack();										// make sorted cursor null
						sorted.moveNext();
					}
					else if (cursorCard.compareToRank(sortedCursorCard) == 1 && sorted.get().equals(sorted.back())){	// if sortedcatd rank is less than cursorcard rank and the sortedcard is the last card in the sorted list
						sorted.append(cursorCard);								// append the cursor card to the sorted list
						sorted.moveBack();										// make sorted cursor null
						sorted.moveNext();
					}
					else {														// if sorted cursor is less than cursorcard and sortedcard is not the last card in the sorted list
						sorted.moveNext();										// move to the next item on the sorted list
					}
				}
			}
			hand.moveNext();
		}
		hand = sorted;
	}
}