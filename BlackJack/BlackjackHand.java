package BlackJack;

import java.io.Serializable;

public class BlackjackHand extends Hand implements Serializable, TextPrintable {
 
     public int getBlackjackValue() {
            // Returns the value of this hand for the
            // game of Blackjack.

         int val;      // The value computed for the hand.
         boolean ace;  // This will be set to true if the
                       //   hand contains an ace.
         int cards;    // Number of cards in the hand.

         val = 0;
         ace = false;
         cards = getCardCount();

         for ( int i = 0;  i < cards;  i++ ) {
                 // Add the value of the i-th card in the hand.
             Card card;    // The i-th card; 
             int cardVal;  // The blackjack value of the i-th card.
             card = getCard(i);
             cardVal = card.getValue();  // The normal value, 1 to 13.
             if (cardVal > 10) {
                 cardVal = 10;   // For a Jack, Queen, or King.
             }
             if (cardVal == 1) {
                 ace = true;     // There is at least one ace.
             }
             val = val + cardVal;
          }

          if ( ace == true  &&  val + 10 <= 21 )
              val = val + 10;

          return val;

     }
     
     public String toString(){
    	 
		return "After Inferface :"+getClass().getName() + "@" + Integer.toHexString(hashCode());
    	 
     }
 
} // end class BlackjackHand
