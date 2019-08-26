package csc130.cardmania.war;

import java.io.Serializable;
import java.util.ArrayList;

import csc130.cardmania.utility.Card;
import csc130.cardmania.utility.Deck;
import csc130.cardmania.utility.Player;
import csc130.cardmania.utility.SavableDeck;

public class SavableWar implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<SavableDeck> p1Deck = new ArrayList<SavableDeck>();
	private ArrayList<SavableDeck> p2Deck = new ArrayList<SavableDeck>();
	
	private String p1Name;
	private String p2Name;
	
	public SavableWar(String p1Name, Deck p1Deck, String p2Name, Deck p2Deck) {
		this.p1Name = p1Name;
		this.p2Name = p2Name;
		for (Card card : p1Deck) {			
			this.p1Deck.add(new SavableDeck(card.getSuit(), card.getRank()));
		}
		for (Card card : p2Deck) {
			this.p2Deck.add(new SavableDeck(card.getSuit(), card.getRank()));
		}
	}
	
	public Player listToPlayer1() {
		Player p1 = new Player(p1Name);
		p1.setHand(new Deck(p1Deck));
		return p1;
	}
	
	public Player listToPlayer2() {
		Player p2 = new Player(p2Name);
		p2.setHand(new Deck(p2Deck));
		return p2;
	}


}
