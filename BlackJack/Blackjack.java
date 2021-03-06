package BlackJack;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
/*
This program lets the user play Blackjack.  The computer
acts as the dealer.  The user has a stake of $100, and
makes a bet on each game.  The user can leave at any time,
or will be kicked out when he loses all the money.
House rules:  The dealer hits on a total of 16 or less
and stands on a total of 17 or more.  Dealer wins ties.
A new deck of cards is used for each game.
*/

public class Blackjack {

	static int money; // Amount of money the user has.
	static Deck deck; // A deck of cards. A new deck for each game.
	static BlackjackHand dealerHand; // The dealer's hand.
	static BlackjackHand userHand; // The user's hand.

	public static void main(String[] args) {
		
		int newgame;
		int bet; // Amount user bets on a game.
		boolean userWins; // Did the user win the game?

		
		System.out.println("Welcome to the game of blackjack.");	
		System.out.println();

		money = 100; // User starts with $100.

		System.out.println("Load Saved Game ?");
		System.out.println("New Game (1) , Load (2) :");
		Scanner scan1 = new Scanner(System.in);
		newgame = scan1.nextInt();
		

		while (true) {

			if (newgame == 2) {
				try {
					FileInputStream fileIn = new FileInputStream("save.dat");
					ObjectInputStream in = new ObjectInputStream(fileIn);
					saveGame save = (saveGame) in.readObject();
					in.close();
					money = save.money;
					dealerHand = save.dealerHand;
					userHand = save.userHand;
					deck = save.deck;
					newgame=0;
				} catch (Exception e) {
					System.err.println(e);
				}
			}

			System.out.println("You have " + money + " dollars.");
			do {
				System.out.println("How many dollars do you want to bet?  (Enter 0 to end.)");				

				Scanner scan = new Scanner(System.in);
				bet = scan.nextInt();

				if (bet < 0 || bet > money)
					System.out.println("Your answer must be between 0 and " + money + '.');
			} while (bet < 0 || bet > money);
			if (bet == 0)
				break;
			userWins = playBlackjack();
			if (userWins)
				money = money + bet;
			else
				money = money - bet;
			System.out.println();
			if (money == 0) {
				System.out.println("Looks like you've are out of money!");
				break;
			}
			System.out.println("You leave with $" + money + '.');
			System.out.println();
		
		}

	} // end main()

	static boolean playBlackjack() {
		// Let the user play one game of Blackjack.
		// Return true if the user wins, false if the user loses.

		deck = new Deck();
		dealerHand = new BlackjackHand();
		userHand = new BlackjackHand();

		/* Shuffle the deck, then deal two cards to each player. */

		deck.shuffle();
		dealerHand.addCard(deck.dealCard());
		dealerHand.addCard(deck.dealCard());
		userHand.addCard(deck.dealCard());
		userHand.addCard(deck.dealCard());

		System.out.println();
		System.out.println(deck);
		System.out.println(dealerHand);
		System.out.println(userHand);
		System.out.println();

		/*
		 * Check if one of the players has Blackjack (two cards totaling to 21).
		 * The player with Blackjack wins the game. Dealer wins ties.
		 */

		if (dealerHand.getBlackjackValue() == 21) {
			System.out.println("Dealer has the " + dealerHand.getCard(0) + " and the " + dealerHand.getCard(1) + ".");
			System.out.println("User has the " + userHand.getCard(0) + " and the " + userHand.getCard(1) + ".");

			System.out.println();

			System.out.println("Dealer has Blackjack.  Dealer wins.");
			return false;
		}

		if (userHand.getBlackjackValue() == 21) {

			System.out.println("Dealer has the " + dealerHand.getCard(0) + " and the " + dealerHand.getCard(1) + ".");

			System.out.println("User has the " + userHand.getCard(0) + " and the " + userHand.getCard(1) + ".");

			System.out.println();

			System.out.println("You have Blackjack.  You win.");
			return true;
		}
		
		/*
		 * If neither player has Blackjack, play the game. First the user gets a
		 * chance to draw cards (i.e., to "Hit"). The while loop ends when the
		 * user chooses to "Stand". If the user goes over 21, the user loses
		 * immediately.
		 */
		
		while (true) {

			/* Display user's cards, and let user decide to Hit or Stand. */
			Scanner scan = new Scanner(System.in);
			System.out.println();
			System.out.println();
			System.out.println("Your cards are:");
			for (int i = 0; i < userHand.getCardCount(); i++)
				System.out.println("    " + userHand.getCard(i));
			System.out.println("Your total is " + userHand.getBlackjackValue());
			System.out.println();
			System.out.println("Dealer is showing the " + dealerHand.getCard(0));
			System.out.println();

			System.out.print("Hit (1) or Stand (2), or Save & Quit(3)? ");
			// make another option
			int userAction; // User's response, 'H' or 'S'.

			do {
				userAction = scan.nextInt();
				if (userAction != 1 && userAction != 2 && userAction != 3)
					System.out.print("Please respond between 1 and 3 :  ");
			} while (userAction != 1 && userAction != 2 && userAction != 3);

			// If the user Hits, the user gets a card. If the user Stands,
			// the loop ends (and it's the dealer's turn to draw cards).

			if (userAction == 2) {
				// Loop ends; user is done taking cards.
				break;
			} else if (userAction == 1) { // userAction is 'H'. Give the user a
											// card.
				// If the user goes over 21, the user loses.
				Card newCard = deck.dealCard();
				userHand.addCard(newCard);
				System.out.println();
				System.out.println("User hits.");
				System.out.println("Your card is the " + newCard);
				System.out.println("Your total is now " + userHand.getBlackjackValue());
				if (userHand.getBlackjackValue() > 21) {
					System.out.println();
					System.out.println("You busted by going over 21.  You lose.");
					System.out.println("Dealer's other card was the " + dealerHand.getCard(1));
					return false;
				}
			} else if (userAction == 3) { // userAction is 'Save'

				saveGame save = new saveGame();
				save.dealerHand = dealerHand;
				save.userHand = userHand;
				save.deck = deck;
				save.money = money;

				try {
					FileOutputStream fileOut = new FileOutputStream("save.dat");
					ObjectOutputStream out = new ObjectOutputStream(fileOut);
					out.writeObject(save);
					out.close();

				} catch (Exception e) {

				}
				System.out.println("save & quit. Your Money: $" + money);
				System.exit(1);
			}
			
		} // end while loop

		/*
		 * If we get to this point, the user has Stood with 21 or less. Now,
		 * it's the dealer's chance to draw. Dealer draws cards until the
		 * dealer's total is > 16. If dealer goes over 21, the dealer loses.
		 */

		System.out.println();
		System.out.println("User stands.");
		System.out.println("Dealer's cards are");
		System.out.println("    " + dealerHand.getCard(0));
		System.out.println("    " + dealerHand.getCard(1));
		while (dealerHand.getBlackjackValue() <= 16) {
			Card newCard = deck.dealCard();
			System.out.println("Dealer hits and gets the " + newCard);
			dealerHand.addCard(newCard);
			if (dealerHand.getBlackjackValue() > 21) {
				System.out.println();
				System.out.println("Dealer busted by going over 21.  You win.");
				return true;
			}
		}
		System.out.println("Dealer's total is " + dealerHand.getBlackjackValue());

		/*
		 * If we get to this point, both players have 21 or less. We can
		 * determine the winner by comparing the values of their hands.
		 */

		System.out.println();
		if (dealerHand.getBlackjackValue() == userHand.getBlackjackValue()) {
			System.out.println("Dealer wins on a tie.  You lose.");
			return false;
		} else if (dealerHand.getBlackjackValue() > userHand.getBlackjackValue()) {
			System.out.println("Dealer wins, " + dealerHand.getBlackjackValue() + " points to "
					+ userHand.getBlackjackValue() + ".");
			return false;
		} else {
			System.out.println(
					"You win, " + userHand.getBlackjackValue() + " points to " + dealerHand.getBlackjackValue() + ".");
			return true;
		}

	} // end playBlackjack()

} // end class Blackjack