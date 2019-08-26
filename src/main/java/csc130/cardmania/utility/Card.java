package csc130.cardmania.utility;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

public class Card implements Serializable{

	private static final long serialVersionUID = 1L;
	private final Rank rank;
	private final Suit suit;
	private final int value;
	Image face;

	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
		this.value = rank.getValue();
	}

	public Rank getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}

	public int getValue() {
		return value;
	}
	
	public Image getFace() {
		return face;
	}

	public void setFace(BufferedImage face) {
		this.face = SwingFXUtils.toFXImage(face, null);
	}

	public static Image getBack() {
		try {
			return SwingFXUtils.toFXImage(ImageIO.read(new File("images/card-deck-161536_1280.png")).getSubimage(196, 612, 101, 154), null);
		} catch (IOException e) {
			e.printStackTrace();
		};
		return null;
	}

	public int compareCards(Card otherCard) {
		if(this.getValue() == otherCard.getValue()) {
			//EQUAL
			return 0;
		}else if (this.getValue() > otherCard.getValue()) {
			//Calling Card is greater
			return 1;
		}else {
			//otherCard is greater
			return -1;
		}
	}

	@Override
	public String toString() {
		return rank + " of " + suit + ", value=" + value;
	}
	
	
	
	public String cardSuitAndValue() { 
		return value + " " + rank + " " + suit;
	}

}
