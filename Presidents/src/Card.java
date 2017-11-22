public class Card {
	private String suit;							// hold the suit data
	private String rank;							// hold the rank data
		
	// card constructor
	public Card(String s, String r){
		suit = s;									// initialize suit
		rank = r;									// initialize rank
	}
	
	// compare the ranks of this card to the rank of another
	// @param takes the argument of a card to be compared to
	// @return returns an int representative of the comparison
	public int compareToRank(Card c){
		int ret = 0;								// int variable that starts as 0 (values are equal)
		if (c.convertRankToInt() > convertRankToInt()){
			ret = -1;								// if rank is less than argument, int is -1
		}
		else if (c.convertRankToInt() < convertRankToInt()){
			ret = 1;								// else if rank is greater than argument, int is 1
		}
		return ret;									// return the int
	}
	
	// converts a rank to an int
	// @param takes no arguments
	// @return returns an int representative of the card's rank
	public int convertRankToInt(){
		int num = 0;
		if (getRank().equals("Ace")){
			num = 14;
		}
		else if (getRank().equals("Two")){
			num = 2;
		}
		else if (getRank().equals("Three")){
			num = 3;
		}
		else if (getRank().equals("Four")){
			num = 4;
		}
		else if (getRank().equals("Five")){
			num = 5;
		}
		else if (getRank().equals("Six")){
			num = 6;
		}
		else if (getRank().equals("Seven")){
			num = 7;
		}
		else if (getRank().equals("Eight")){
			num = 8;
		}
		else if (getRank().equals("Nine")){
			num = 9;
		}
		else if (getRank().equals("Ten")){
			num = 10;
		}
		else if (getRank().equals("Jack")){
			num = 11;
		}
		else if (getRank().equals("Queen")){
			num = 12;
		}
		else if (getRank().equals("King")){
			num = 13;
		}
		return num;
	}
		
	private String getSuit(){
		return suit;
	}
		
	private String getRank(){
		return rank;
	}
		
	private void setSuit(String newSuit){
		suit = newSuit;
	}
		
	private void setRank(String newRank){
		rank = newRank;
	}
		
	public boolean equals(Object x){
		boolean equal = false;
		if (x instanceof Card){
			Card N = (Card)x;
			if (rank.equals(N.rank) && suit.equals(N.suit)){
				equal = true;
			}
		}
		return equal;
	}
	
	public String toString(){
		String str = rank+" of "+suit;
		return str;
	}
}