package csc130.cardmania.utility;

import java.util.List;

public class Player {

	private String name;
	private Deck hand;
	private int bankAmount;
	private Deck captured;
	private int currentBet;
	private int handValue;
	private int handValueWithAce;
	private boolean hasBlackjack = false;
	private boolean busted = false ;
	
	public Player(String name, Deck hand) {
		this.name = name;
		this.hand = hand;
	}
	
	public Player(String name) {
		this.name = name;
	}
	
	public Player(String name, int bankAmount) {
		this.name = name;
		this.hand = new Deck(true);
		setBankAmount(bankAmount);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Deck getHand() {
		return hand;
	}
	public void setHand(Deck hand) {
		this.hand = hand;
	}
	
	public Deck getCaptured() {
		return captured;
	}
	public void setCaptured(Deck captured) {
		this.captured = captured;
	}

	public void placeCardsOnBottomOfDeck(List<Card> cards) {
		for (Card card : cards) {
			this.hand.add(0, card);
		}
	}

	public void placeCardOnBottomOfDeck(Card card) {
		this.hand.add(0, card);
	}
	public int getBankAmount() {
		return bankAmount;
	}

	public void setBankAmount(int bankAmount) {
		this.bankAmount = bankAmount;
	}

	public int getHandValue() {
		return handValue;
	}

	public void setHandValue(int handValue) {
		this.handValue = handValue;
	}

	public int getHandValueWithAce() {
		return handValueWithAce;
	}

	public void setHandValueWithAce(int handValueWithAce) {
		this.handValueWithAce = handValueWithAce;
	}

	public boolean isHasBlackjack() {
		return hasBlackjack;
	}

	public void setHasBlackjack(boolean hasBlackjack) {
		this.hasBlackjack = hasBlackjack;
	}

	public int getCurrentBet() {
		return currentBet;
	}

	public void setCurrentBet(int currentBet) {
		this.currentBet = currentBet;
	}

	public boolean isBusted() {
		return busted;
	}

	public void setBusted(boolean busted) {
		this.busted = busted;
	}

}
