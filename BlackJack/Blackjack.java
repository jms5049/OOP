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

} // end class Blackjack