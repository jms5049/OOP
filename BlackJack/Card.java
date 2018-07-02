package BlackJack;

import java.io.Serializable;

/*
An object of class card represents one of the 52 cards in a
standard deck of playing cards.  Each card has a suit and
a value.
*/

public class Card implements Serializable, TextPrintable{
	public final static int SPADES = 0, // Codes for the 4 suits.
			HEARTS = 1, DIAMONDS = 2, CLUBS = 3;

	public final static int ACE = 1, // Codes for the non-numeric cards.
			JACK = 11, // Cards 2 through 10 have their
			QUEEN = 12, // numerical values for their codes.
			KING = 13;

	private final int suit;

	private final int value; 

	public Card(int theValue, int theSuit) {
		value = theValue;
		suit = theSuit;
	}

	public int getSuit() {
		return suit;
	}

	public int getValue() {
		return value;
	}

	

} // end class Card