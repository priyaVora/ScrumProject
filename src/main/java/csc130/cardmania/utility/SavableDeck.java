package csc130.cardmania.utility;

import java.io.Serializable;

public class SavableDeck implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Suit suit;
	private Rank rank;
	
	public SavableDeck(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

}
