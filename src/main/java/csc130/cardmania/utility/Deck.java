package csc130.cardmania.utility;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

public class Deck extends ArrayList<Card> {
	private static final long serialVersionUID = 1L;
	private Random rand;

	private static int cardStartX = 0, cardStartY = 0;
	private static int CARD_SIZE_X = 98, CARD_SIZE_Y = 153;

	public Deck(boolean empty) {
		if (empty) {

		} else {
			rand = new Random();
			createDeck();
			shuffle();
		}
	}

	public Deck(ArrayList<SavableDeck> deck) {
		createDeck(deck);
	}

	private void createDeck(ArrayList<SavableDeck> deck) {
		for (SavableDeck d : deck) {
			int x = 0;
			int y = 0;
			BufferedImage image = null;
			BufferedImage subImage = null;
			try {
				image = ImageIO.read(new File("images/card-deck-161536_1280.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (d.getSuit() == Suit.HEARTS) {
				y = 2;
			} else if (d.getSuit() == Suit.SPADES) {
				y = 3;
			} else if (d.getSuit() == Suit.DIAMONDS) {
				y = 1;
			} else {
				y = 0;
			}

			switch (d.getRank()) {
			case ACE:
				x = 0;
				break;
			case TWO:
				x = 1;
				break;
			case THREE:
				x = 2;
				break;
			case FOUR:
				x = 3;
				break;
			case FIVE:
				x = 4;
				break;
			case SIX:
				x = 5;
				break;
			case SEVEN:
				x = 6;
				break;
			case EIGHT:
				x = 7;
				break;
			case NINE:
				x = 8;
				break;
			case TEN:
				x = 9;
				break;
			case JACK:
				x = 10;
				break;
			case QUEEN:
				x = 11;
				break;
			case KING:
				x = 12;
				break;
			default:
			}

			cardStartX = CARD_SIZE_X * x;
			cardStartY = CARD_SIZE_Y * y;

			if (d.getRank() == Rank.ACE) {
				subImage = image.getSubimage(cardStartX, cardStartY, CARD_SIZE_X, CARD_SIZE_Y);
			} else {
				subImage = image.getSubimage(cardStartX + (x / 2), cardStartY, CARD_SIZE_X, CARD_SIZE_Y);
			}
			Card card = new Card(d.getRank(), d.getSuit());
			if (subImage != null) {
				card.setFace(subImage);
			}
			this.add(card);
		}

	}

	private void createDeck() {
		int counter = 0;
		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 13; x++) {
				Suit suit;
				Rank rank;
				BufferedImage image = null;
				BufferedImage subImage = null;
				try {
					image = ImageIO.read(new File("images/card-deck-161536_1280.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}

				if (counter > 38) {
					suit = Suit.HEARTS;
				} else if (counter > 25) {
					suit = Suit.SPADES;
				} else if (counter > 12) {
					suit = Suit.DIAMONDS;
				} else {
					suit = Suit.CLUBS;
				}

				switch (counter % 13) {
				case 0:
					rank = Rank.ACE;
					break;
				case 1:
					rank = Rank.TWO;
					break;
				case 2:
					rank = Rank.THREE;
					break;
				case 3:
					rank = Rank.FOUR;
					break;
				case 4:
					rank = Rank.FIVE;
					break;
				case 5:
					rank = Rank.SIX;
					break;
				case 6:
					rank = Rank.SEVEN;
					break;
				case 7:
					rank = Rank.EIGHT;
					break;
				case 8:
					rank = Rank.NINE;
					break;
				case 9:
					rank = Rank.TEN;
					break;
				case 10:
					rank = Rank.JACK;
					break;
				case 11:
					rank = Rank.QUEEN;
					break;
				case 12:
					rank = Rank.KING;
					break;
				default:
					rank = null;
				}

				cardStartX = (CARD_SIZE_X * (x % 13));
				cardStartY = CARD_SIZE_Y * (y % 13);

				if (rank == Rank.ACE) {
					subImage = image.getSubimage(cardStartX, cardStartY, CARD_SIZE_X, CARD_SIZE_Y);
				} else {
					subImage = image.getSubimage(cardStartX + (x / 2), cardStartY, CARD_SIZE_X, CARD_SIZE_Y);
				}
				Card card = new Card(rank, suit);
				if (subImage != null) {
					card.setFace(subImage);
				}
				this.add(card);
				counter++;
			}
		}
	}

	public Card dealNextCard() {
		Card cardToDeal = this.get(this.size() - 1);
		this.remove(this.size() - 1);
		return cardToDeal;
	}

	public void showCards() {
		Suit suit;
		Rank rank;
		for (int i = this.size() - 1; i >= 0; i--) {
			rank = this.get(i).getRank();
			suit = this.get(i).getSuit();
			System.out.println(rank + " of " + suit);
		}
	}

	public void shuffle() {
		int numToSwitch;
		Card tempCard;
		for (int i = this.size() - 1; i >= 1; i--) {
			numToSwitch = rand.nextInt(i);
			tempCard = this.get(numToSwitch);
			this.set(numToSwitch, this.get(i));
			this.set(i, tempCard);
		}
	}

	public ArrayList<Integer> toArrayList() {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for (Card c : this) {
			temp.add(c.getValue());
		}
		return temp;
	}

	@Override
	public String toString() {
		String deck = "";

		for (Card c : this) {
			deck += c.toString() + "\n";
		}

		return deck;
	}
}
