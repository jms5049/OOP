package BlackJack;

import java.io.Serializable;

public class saveGame implements Serializable{

	public BlackjackHand userHand;
	public BlackjackHand dealerHand;
	public Deck deck;
	public int money;
	
}
