package BlackJack;

import java.io.Serializable;

/*
An object of type Hand represents a hand of cards.  The maximum number of
cards in the hand can be specified in the constructor, but by default
is 5.  A utility function is provided for computing the value of the
hand in the game of Blackjack.
*/

import java.util.Vector;

public class Hand implements Serializable {
	private Vector hand; // The cards in the hand.

	public Hand() {
		// Create a Hand object that is initially empty.
		hand = new Vector();
	}

	public void clear() {
		// Discard all the cards from the hand.
		hand.removeAllElements();
	}

	public void addCard(Card c) {
		// Add the card c to the hand. c should be non-null. (If c is
		// null, nothing is added to the hand.)
		if (c != null)
			hand.addElement(c);
	}



}
