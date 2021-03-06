package BlackJack;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
/* 
    An object of type Deck represents an ordinary deck of 52 playing cards.
    The deck can be shuffled, and cards can be dealt from the deck.
*/

public class Deck implements Serializable, TextPrintable {
	ArrayList<Card> deck = new ArrayList<Card>();
	
	public Deck() {
		// Create an unshuffled deck of cards.			
		//ArrayList supports Dynamic Arrays so no need to state the initial size
		int cardCt = 0;
		for (int suit = 0; suit <= 3; suit++) {
			for (int value = 1; value <= 13; value++) {			
				deck.add(new Card(value, suit));
				//using "add" in Arraylist method				
			}
		}	
	}

	public void shuffle() {
		Collections.shuffle(deck);
	}

	public int cardsLeft() {
		return deck.size();
	}

	public Card dealCard() {
		if (cardsLeft() == 0)
			shuffle();		
		return deck.remove(deck.size()-1);		
	}
	
	public String toString(){    	 
			return "After Inferface :"+getClass().getName() + "@" + Integer.toHexString(hashCode());	    	 
	}

	
} // end class Deck