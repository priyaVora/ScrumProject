package csc130.cardmania.war;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import csc130.cardmania.launch.MainMenu;
import csc130.cardmania.utility.Card;
import csc130.cardmania.utility.Deck;
import csc130.cardmania.utility.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class WarController {

	@FXML
	private Button flipButton;
	@FXML
	private Button saveButton;
	@FXML
	private Button saveGame;

	@FXML
	private ImageView pile1;
	@FXML
	private ImageView pile2;

	@FXML
	private ImageView flipped1;
	@FXML
	private ImageView flipped2;

	@FXML
	private ImageView captured1;
	@FXML
	private ImageView captured2;

	@FXML
	private ImageView p1war1;
	@FXML
	private ImageView p1war2;
	@FXML
	private ImageView p1war3;
	@FXML
	private ImageView p1war4;

	@FXML
	private ImageView p2war1;
	@FXML
	private ImageView p2war2;
	@FXML
	private ImageView p2war3;
	@FXML
	private ImageView p2war4;

	@FXML
	private Label p1Name;
	@FXML
	private Label p2Name;
	
	@FXML
	private Label p1CardsLeft;
	@FXML
	private Label p2CardsLeft;
	
	@FXML
	private TextField fileName;

	private Player player1;
	private Player player2;

	@FXML
	private void onFlip() {
		p1war1.setImage(null);
		p1war2.setImage(null);
		p1war3.setImage(null);
		p1war4.setImage(null);

		p2war1.setImage(null);
		p2war2.setImage(null);
		p2war3.setImage(null);
		p2war4.setImage(null);

		Card flippedCard1 = player1.getHand().dealNextCard();
		Card flippedCard2 = player2.getHand().dealNextCard();
		this.flipped1.setImage(flippedCard1.getFace());
		this.flipped2.setImage(flippedCard2.getFace());
		if (flippedCard1.getValue() > flippedCard2.getValue()) {
			this.captured1.setImage(flippedCard1.getFace());
			player1.placeCardOnBottomOfDeck(flippedCard2);
			player1.placeCardOnBottomOfDeck(flippedCard1);
		} else if (flippedCard1.getValue() < flippedCard2.getValue()) {
			this.captured2.setImage(flippedCard2.getFace());
			player2.placeCardOnBottomOfDeck(flippedCard1);
			player2.placeCardOnBottomOfDeck(flippedCard2);
		} else { // war condition
			war(flippedCard1, flippedCard2);
		}

		// win condition
		if (player1.getHand().size() <= 3) {
			playerWon(player2);
		} else if (player2.getHand().size() <= 3) {
			playerWon(player1);
		}
		
		//update cards left counter
		p1CardsLeft.setText("Cards Left: " + player1.getHand().size());
		p2CardsLeft.setText("Cards Left: " + player2.getHand().size());
		
	}

	private void playerWon(Player winner) {
		Stage primaryStage = (Stage) flipButton.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("WarWinScreen.fxml"));
		Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		WarWinScreenController controller = loader.<WarWinScreenController>getController();
		controller.initName(winner.getName());
		primaryStage.setScene(scene);
		primaryStage.centerOnScreen();
		primaryStage.show();
	}

	private void war(Card card1, Card card2) {
		if (player1.getHand().size() <= 3) {
			playerWon(player2);
		} else if (player2.getHand().size() <= 3) {
			playerWon(player1);
		} else {
			Card p1FlippedCard1 = player1.getHand().dealNextCard();
			p1war1.setImage(new Image("csc130/cardmania/war/card_back.png"));
			Card p1FlippedCard2 = player1.getHand().dealNextCard();
			p1war2.setImage(new Image("csc130/cardmania/war/card_back.png"));
			Card p1FlippedCard3 = player1.getHand().dealNextCard();
			p1war3.setImage(new Image("csc130/cardmania/war/card_back.png"));
			Card p1FlippedCard4 = player1.getHand().dealNextCard();
			p1war4.setImage(p1FlippedCard4.getFace());

			Card p2FlippedCard1;
			Card p2FlippedCard2;
			Card p2FlippedCard3;
			Card p2FlippedCard4;

			p2FlippedCard1 = player2.getHand().dealNextCard();
			p2war1.setImage(new Image("csc130/cardmania/war/card_back.png"));
			p2FlippedCard2 = player2.getHand().dealNextCard();
			p2war2.setImage(new Image("csc130/cardmania/war/card_back.png"));
			p2FlippedCard3 = player2.getHand().dealNextCard();
			p2war3.setImage(new Image("csc130/cardmania/war/card_back.png"));
			p2FlippedCard4 = player2.getHand().dealNextCard();
			p2war4.setImage(p2FlippedCard4.getFace());

			if (p1FlippedCard4.getValue() > p2FlippedCard4.getValue()) {
				Deck deck = new Deck(true);
				deck.add(p2FlippedCard4);
				deck.add(p2FlippedCard3);
				deck.add(p2FlippedCard2);
				deck.add(p2FlippedCard1);
				deck.add(p1FlippedCard4);
				deck.add(p1FlippedCard3);
				deck.add(p1FlippedCard2);
				deck.add(p1FlippedCard1);
				deck.add(card1);
				deck.add(card2);
				player1.placeCardsOnBottomOfDeck(deck);
				captured1.setImage(p1FlippedCard4.getFace());
			} else if (p1FlippedCard4.getValue() < p2FlippedCard4.getValue()) {
				Deck deck = new Deck(true);
				deck.add(p2FlippedCard4);
				deck.add(p2FlippedCard3);
				deck.add(p2FlippedCard2);
				deck.add(p2FlippedCard1);
				deck.add(p1FlippedCard4);
				deck.add(p1FlippedCard3);
				deck.add(p1FlippedCard2);
				deck.add(p1FlippedCard1);
				deck.add(card1);
				deck.add(card2);
				player2.placeCardsOnBottomOfDeck(deck);
				captured2.setImage(p2FlippedCard4.getFace());
			} else {
				war(card1, card2);
			}
		}
	}
	
	@FXML
	public void initialize() {
		
	}

	public void initNames(List<String> names) {
		String name = null;
		p1Name.setText(names.get(0));
		if (names.size() > 1) {
			p2Name.setText(names.get(1));
			name = names.get(1);
		} else {
			p2Name.setText("Computer");
			name = "Computer";
		}
		
		Deck deck = new Deck(false);
		Deck p1Hand = new Deck(true);
		Deck p2Hand = new Deck(true);
		for (int i = 0; i < 26; i++) {
			p1Hand.add(deck.dealNextCard());
		}
		for (int i = 0; i < 26; i++) {
			p2Hand.add(deck.dealNextCard());
		}
		this.player1 = new Player(p1Name.getText(), p1Hand);
		this.player2 = new Player(name, p2Hand);
	}
	
	@FXML
	private void saveGame() {
		SavableWar save = new SavableWar(player1.getName(), player1.getHand(), player2.getName(), player2.getHand());
		FileOutputStream fout;
		ObjectOutputStream oos = null;
		File savesFile = new File("saves/");
		savesFile.mkdirs();
		File file = new File("saves/" + fileName.getText() + ".ser");
		try {
			fout = new FileOutputStream(file);
			oos = new ObjectOutputStream(fout);
			oos.writeObject(save);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Stage primaryStage = (Stage) saveGame.getScene().getWindow();
		MainMenu menu = new MainMenu(primaryStage);
		Scene scene = new Scene(menu);
		primaryStage.setScene(scene);
		primaryStage.centerOnScreen();
		primaryStage.show();
	}
	
	public void loadGame(String fileName) {
		FileInputStream fin;
		ObjectInputStream ois = null;
		SavableWar saved = null;
		File savesFile = new File("saves/");
		savesFile.mkdirs();
		File file = new File("saves/" + fileName + ".ser");
		try {
			fin = new FileInputStream(file);
			ois = new ObjectInputStream(fin);
			saved = (SavableWar)ois.readObject();
			this.player1 = saved.listToPlayer1();
			this.player2 = saved.listToPlayer2();
			this.p1CardsLeft.setText("Cards Left: " + player1.getHand().size());
			this.p2CardsLeft.setText("Cards Left: " + player2.getHand().size());
			this.p1Name.setText(player1.getName());
			this.p2Name.setText(player2.getName());
			ois.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void saveScreen() {
		Stage primaryStage = (Stage) flipButton.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("WarSaveScreen.fxml"));
		Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		WarController controller = loader.<WarController>getController();
		primaryStage.setScene(scene);
		primaryStage.centerOnScreen();
		primaryStage.show();
	}

}
