package csc130.cardmania.utility;

import java.util.ArrayList;

public class Dealer {
	
	public ArrayList<Card> dealAHand(int numOfCards, Deck gameDeck) {
		ArrayList<Card> hand = new ArrayList<Card>();
		//Check for enough cards.
		if(gameDeck.size() >= numOfCards) {
			for (int i = 0; i < numOfCards; i++) {
				hand.add(gameDeck.dealNextCard());
			}
		}else {
			return null;
		}
		return hand;
	}
	
	

}