package csc130.cardmania.gofish;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import com.sun.javafx.PlatformUtil;

import csc130.cardmania.utility.Card;
import csc130.cardmania.utility.Dealer;
import csc130.cardmania.utility.Deck;
import csc130.cardmania.utility.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GoFishGameController {
	ArrayList<String> names;

	int scorePlayer1;
	int scorePlayer2;

	boolean goFish = false;
	private ObservableList<String> listOfOpponents1 = FXCollections.observableArrayList();
	private ObservableList<String> listOfOpponents2 = FXCollections.observableArrayList();
	private ObservableList<String> listOfOpponents3 = FXCollections.observableArrayList();
	private ObservableList<String> listOfOpponents4 = FXCollections.observableArrayList();

	int twoPlayerCounter = 1;

	@FXML
	private ComboBox<String> opposingPlayerComboBox1;
	@FXML
	private ComboBox<String> opposingPlayerComboBox2;
	@FXML
	private ComboBox<String> opposingPlayerComboBox3;
	@FXML
	private ComboBox<String> opposingPlayerComboBox4;

	HashMap<Integer, Integer> countForCardsPlayer1 = new HashMap<Integer, Integer>();
	HashMap<Integer, Integer> countForCardsPlayer2 = new HashMap<Integer, Integer>();
	HashMap<Integer, Integer> countForCardsPlayer3 = new HashMap<Integer, Integer>();
	HashMap<Integer, Integer> countForCardsPlayer4 = new HashMap<Integer, Integer>();

	Dealer dealer = new Dealer();
	Deck theDeck = new Deck(false);

	ArrayList<Card> p1Hand;
	ArrayList<Card> p2Hand;
	ArrayList<Card> p3Hand;
	ArrayList<Card> p4Hand;
	private ObservableList<String> player1CardsList = FXCollections.observableArrayList();
	private ObservableList<String> player2CardsList = FXCollections.observableArrayList();
	private ObservableList<String> player3CardsList = FXCollections.observableArrayList();
	private ObservableList<String> player4CardsList = FXCollections.observableArrayList();

	@FXML
	public ComboBox<String> viewForPlayer1;
	@FXML
	public ComboBox<String> viewForPlayer2;
	@FXML
	public ComboBox<String> viewForPlayer3;
	@FXML
	public ComboBox<String> viewForPlayer4;

	@FXML
	private TextField viewCountBox1;
	@FXML
	private TextField viewCountBox2;
	@FXML
	private TextField viewCountBox3;
	@FXML
	private TextField viewCountBox4;

	@FXML
	private TextField messageBox;

	@FXML
	private Player player1;
	@FXML
	private Player player2;
	@FXML
	private Player player3;
	@FXML
	private Player player4;

	@FXML
	private Label playerName1;
	@FXML
	private Label playerName2;
	@FXML
	Label playerName3;
	@FXML
	Label playerName4;

	@FXML
	Label player1CurrentScore = new Label("Current Score: " + 0);
	@FXML
	Label player2CurrentScore = new Label("Current Score: " + 0);
	@FXML
	Label player3CurrentScore = new Label("Current Score: " + 0);
	@FXML
	Label player4CurrentScore = new Label("Current Score: " + 0);

	@FXML
	Button goFishPlayer1;
	@FXML
	Button goFishPlayer2;
	@FXML
	Button goFishPlayer3;
	@FXML
	Button goFishPlayer4;
	@FXML
	Button deal;

	@FXML
	Button move1;
	@FXML
	Button move2;

	@FXML
	Button move3;
	@FXML
	Button move4;

	private int currentNumberOfPeople = 1;

	public GoFishGameController(int currentNumOfPlayers) {
		this.currentNumberOfPeople = currentNumOfPlayers;
	}

	public GoFishGameController() {

	}

	public void opponentsForPlayer1() {
		ArrayList<Player> players = new ArrayList<>();
		players.add(player1);
		players.add(player2);
		players.add(player3);
		players.add(player4);

		for (Player player : players) {
			if (player != null && player.getName() != player1.getName()) {
				listOfOpponents1.add(player.getName());
			}
		}
		opposingPlayerComboBox1.setItems(listOfOpponents1);
	}

	public void opponentsForPlayer2() {
		ArrayList<Player> players = new ArrayList<>();
		players.add(player1);
		players.add(player2);
		players.add(player3);
		players.add(player4);

		for (Player player : players) {
			if (player != null && player.getName() != player2.getName()) {
				listOfOpponents2.add(player.getName());
			}
		}
		opposingPlayerComboBox2.setItems(listOfOpponents2);
	}

	public void viewForPlayer1() {
		for (int i = 0; i < p1Hand.size(); i++) {
			player1CardsList.add(p1Hand.get(i).cardSuitAndValue());

		}

		for (Card string : p1Hand) {
			int counter = 0;
			for (int i = 0; i < p1Hand.size(); i++) {
				if (p1Hand.get(i).getValue() == string.getValue()) {
					counter++;
				}
			}
			if (countForCardsPlayer1.containsKey(string.getValue())) {

			} else {
				countForCardsPlayer1.put(string.getValue(), counter);
			}
		}

	}

	public void viewForPlayer2() {
		for (int i = 0; i < p2Hand.size(); i++) {
			player2CardsList.add(p2Hand.get(i).cardSuitAndValue());
		}

		for (Card string : p2Hand) {
			int counter = 0;
			for (int i = 0; i < p2Hand.size(); i++) {
				if (p2Hand.get(i).getValue() == string.getValue()) {
					counter++;
				}
			}
			if (countForCardsPlayer2.containsKey(string.getValue())) {

			} else {
				countForCardsPlayer2.put(string.getValue(), counter);
			}
		}
	}

	@FXML
	public void callDeal() {
		p1Hand = dealer.dealAHand(5, theDeck);
		p2Hand = dealer.dealAHand(5, theDeck);
		deal.setDisable(true);
		viewForPlayer1();
		viewForPlayer1.setItems(player1CardsList);
		viewForPlayer2();
		viewForPlayer2.setItems(player2CardsList);
		opponentsForPlayer1();
		opponentsForPlayer2();

		opposingPlayerComboBox1.setDisable(false);
		if (twoPlayerCounter % 2 == 0) {
			opposingPlayerComboBox1.setDisable(true);
			goFishPlayer1.setDisable(true);
			viewCountBox1.setDisable(true);
			viewForPlayer1.setDisable(true);
			goFishPlayer1.setDisable(true);
			move1.setDisable(true);
		} else if (twoPlayerCounter % 2 != 0) {
			opposingPlayerComboBox2.setDisable(true);
			goFishPlayer2.setDisable(true);
			viewCountBox2.setDisable(true);
			viewForPlayer2.setDisable(true);
			goFishPlayer2.setDisable(true);
			move2.setDisable(true);
		}
	}

	public void incrementScorePlayer1(int testScore) {
		if (testScore == 4) {
			scorePlayer1++;
		}

		player1CurrentScore.setText("Player Score" + scorePlayer1);
	}

	public void incrementScorePlayer2(int testScore) {
		if (testScore == 4) {
			scorePlayer2++;
		}
		player2CurrentScore.setText("Player Score" + scorePlayer2);
	}

	@FXML
	private void viewCountSelection1(ActionEvent event) {
		String currentPlayerSelection = viewForPlayer1.getValue();
		String grabValue = viewForPlayer1.getValue();
		String[] listOfGrab = grabValue.split(" ");
		int countForCurrentCard = countForCardsPlayer1.get(Integer.parseInt(listOfGrab[0]));
		viewCountBox1.setPromptText(" " + countForCurrentCard);
	}

	@FXML
	private void viewCountSelection2(ActionEvent event) {
		String currentPlayerSelection = viewForPlayer2.getValue();
		String grabValue = viewForPlayer2.getValue();
		String[] listOfGrab = grabValue.split(" ");
		int countForCurrentCard = countForCardsPlayer2.get(Integer.parseInt(listOfGrab[0]));
		viewCountBox2.setPromptText(" " + countForCurrentCard);
	}

	@FXML
	public void callDealForThreePlayers() {
		p1Hand = dealer.dealAHand(5, theDeck);
		p2Hand = dealer.dealAHand(5, theDeck);
		p3Hand = dealer.dealAHand(5, theDeck);
	}

	@FXML
	public void callDealForFourPlayers() {
		p1Hand = dealer.dealAHand(5, theDeck);
		p2Hand = dealer.dealAHand(5, theDeck);
		p3Hand = dealer.dealAHand(5, theDeck);
		p4Hand = dealer.dealAHand(5, theDeck);
	}

	public void begin() {

		viewForPlayer1.setVisibleRowCount(100);
		viewForPlayer2.setVisibleRowCount(100);

		currentNumberOfPeople = 2;
		if (currentNumberOfPeople == 2) {
			player1 = new Player(names.get(0));
			player2 = new Player(names.get(1));
			playerName1.setText(player1.getName());
			playerName2.setText(player2.getName());

			// deal the cards
		} else if (currentNumberOfPeople == 3) {
			player1 = new Player(names.get(0));
			player2 = new Player(names.get(1));
			player3 = new Player(names.get(2));

			playerName1.setText(player1.getName());
			playerName2.setText(player2.getName());
			playerName3.setText(player3.getName());
			playerName4.setText(player4.getName());

		} else {
			player1 = new Player(names.get(0));
			player2 = new Player(names.get(1));
			player3 = new Player(names.get(2));
			player4 = new Player(names.get(3));

			playerName1.setText(player1.getName());
			playerName2.setText(player2.getName());
			playerName3.setText(player3.getName());
			playerName4.setText(player4.getName());

		}
	}

	@FXML
	public void goFishClick1() {
		messageBox.setPromptText(player1.getName() + "--Called GO FISH!");
		Card addCard = theDeck.dealNextCard();
		player2CardsList.add(addCard.cardSuitAndValue());
		viewForPlayer2.setItems(player2CardsList);
		p2Hand.add(addCard);

		if (countForCardsPlayer2.get(addCard.getValue()) != null) {

			HashMap<Integer, Integer> removeExistingMap = new HashMap<>();

			for (Integer entry : countForCardsPlayer2.keySet()) {
				if (addCard.getValue() == entry) {
					int tempCountValue = countForCardsPlayer2.get(entry);

					removeExistingMap.put(entry, tempCountValue + 1);
				}
			}

			for (Integer entry : removeExistingMap.keySet()) {
				countForCardsPlayer2.remove(entry);
				countForCardsPlayer2.put(entry, removeExistingMap.get(entry));
			}

		} else {
			countForCardsPlayer2.put(addCard.getValue(), 1);
		}

	}

	@FXML
	public void goFishClick2() {
		messageBox.setPromptText(player2.getName() + "--Called GO FISH!");
		Card addCard = theDeck.dealNextCard();
		player1CardsList.add(addCard.cardSuitAndValue());
		viewForPlayer1.setItems(player1CardsList);

		p1Hand.add(addCard);
		if (countForCardsPlayer1.get(addCard.getValue()) != null) {

			HashMap<Integer, Integer> removeExistingMap = new HashMap<>();

			for (Integer entry : countForCardsPlayer1.keySet()) {
				if (addCard.getValue() == entry) {
					int tempCountValue = countForCardsPlayer1.get(entry);

					removeExistingMap.put(entry, tempCountValue + 1);
				}
			}

			for (Integer entry : removeExistingMap.keySet()) {
				countForCardsPlayer1.remove(entry);
				countForCardsPlayer1.put(entry, removeExistingMap.get(entry));
			}

		} else {
			countForCardsPlayer1.put(addCard.getValue(), 1);
		}

	}

	@FXML
	public void goFishClick3() {
		// System.out.println("GO FISH WAS DECLARED...");
		// messageBox.setPromptText(player4.getName() + "--Declare GO FISH!");
	}

	@FXML
	public void goFishClick4() {
		// System.out.println("GO FISH WAS DECLARED...");
		// // messageBox.setPromptText(player1.getName() + "--Declare GO FISH!");
	}

	@FXML
	public void playerForMoveSelected1() {
		String opposedPlayer = opposingPlayerComboBox1.getValue().trim();
		messageBox.setPromptText("Being Sent: " + opposedPlayer);
	}

	@FXML
	public void playerForMoveSelected2() {
		String opposedPlayer = opposingPlayerComboBox2.getValue().trim();
		messageBox.setPromptText("Being Sent: " + opposedPlayer);
	}

	@FXML
	public void playerForMoveSelected3() {
		String opposedPlayer = opposingPlayerComboBox3.getValue().trim();
	}

	@FXML
	public void playerForMoveSelected4() {
		String opposedPlayer = opposingPlayerComboBox4.getValue().trim();
	}

	@FXML
	public void move1() {
		accountForDisableControls();

		String askedPlayerName = player1.getName().trim();
		String cardTypeString = viewForPlayer1.getValue().trim();
		String[] splitList = cardTypeString.split(" ");
		int cardType = Integer.parseInt(splitList[0].trim());
		askForACard1(askedPlayerName, cardType);
//		for (int i = 0; i < 13; i++) {
//			int test = countForCardsPlayer1.get(i+1);
//			incrementScorePlayer1(test);
//		}
	}

	public void askForACard1(String askingPlayerName, int cardType) {
		String message = askingPlayerName + " " + " Asked for:" + cardType;
		messageBox.setPromptText(message.trim());

		String[] splitMessage = message.split(":");
		System.out.println("Split: " + splitMessage[1]);

		if (countForCardsPlayer2.containsKey(Integer.parseInt(splitMessage[1]))) {
			ArrayList<String> removeStrings = new ArrayList<>();

			
				
				for (int i = 0; i < player2CardsList.size(); i++) {
					
				
				if (player2CardsList.get(i).contains(splitMessage[1].trim())) {
					removeStrings.add(player2CardsList.get(i));

					ArrayList<Card> removeCards = new ArrayList<>();
					// account for Player's hand
					for (Card string : p2Hand) {
						int handValue = string.getValue();
						String handValueString = "" + handValue;
						if ((handValueString.contains(player2CardsList.get(i)))) {
							removeCards.add(string);

						}

						for (Card removeC : removeCards) {
							p2Hand.remove(removeC);
							p1Hand.add(removeC);
							countForCardsPlayer1.put(removeC.getValue(), countForCardsPlayer2.get(removeC.getValue()));
							countForCardsPlayer2.remove(removeC.getValue());

						}
					}
				}

				for (String removeCard : removeStrings) {

					player2CardsList.remove(removeCard);
					player1CardsList.add(removeCard);
				}
				viewForPlayer2.setItems(player2CardsList);
				viewForPlayer1.setItems(player1CardsList);

			}

			messageBox.setPromptText("Cards were Removed From: " + player2.getName() + "Deck...");
			twoPlayerCounter++;
		} else {
			messageBox.setPromptText(player2.getName() + "--Declare GO FISH!");

		}

	}

	public void askForACard2(String askingPlayerName, int cardType) {
		String message = askingPlayerName + " " + " Asked for:" + cardType;
		System.out.println("Message" + message);
		messageBox.setPromptText(message.trim());

		String[] splitMessage = message.split(":");

		if (countForCardsPlayer1.containsKey(Integer.parseInt(splitMessage[1]))) {
			ArrayList<String> removeStrings = new ArrayList<>();

			for (String p2ObsValue : player1CardsList) {
				if (p2ObsValue.contains(splitMessage[1].trim())) {
					removeStrings.add(p2ObsValue);
					ArrayList<Card> removeCards = new ArrayList<>();
					for (Card string : p1Hand) {
						int handValue = string.getValue();
						String handValueString = "" + handValue;
						if ((handValueString.contains(p2ObsValue))) {
							removeCards.add(string);
						}

						for (Card removeC : removeCards) {
							p2Hand.add(removeC);
							p1Hand.remove(removeC);
							countForCardsPlayer2.put(removeC.getValue(), countForCardsPlayer1.get(removeC.getValue()));
							countForCardsPlayer1.remove(removeC.getValue());

						}
					}
				}
			}

			for (String removeCard : removeStrings) {
				player1CardsList.remove(removeCard);
				player2CardsList.add(removeCard);
			}
			viewForPlayer2.setItems(player2CardsList);
			viewForPlayer1.setItems(player1CardsList);

			messageBox.setPromptText("Cards were Removed From: " + player1.getName() + "Deck...");
			twoPlayerCounter++;
		} else {
			messageBox.setPromptText(player1.getName() + "--Declare GO FISH!");

		}

	}

	public void askForACard3(String askingPlayerName, int cardType) {
		System.out.println("Entered Message Portion....");
		String message = askingPlayerName + " " + " Asked for:" + cardType;
		System.out.println("Message" + message);
		messageBox.setPromptText(message.trim());

	}

	public void askForACard4(String askingPlayerName, int cardType) {
		System.out.println("Entered Message Portion....");
		String message = askingPlayerName + " " + " Asked for:" + cardType;
		System.out.println("Message" + message);
		messageBox.setPromptText(message.trim());

	}

	public void accountForDisableControls() {
		twoPlayerCounter++;
		if (twoPlayerCounter % 2 == 0) {
			opposingPlayerComboBox1.setDisable(true);
			goFishPlayer1.setDisable(true);
			viewCountBox1.setDisable(true);
			viewForPlayer1.setDisable(true);
			goFishPlayer1.setDisable(true);
			move1.setDisable(true);

			opposingPlayerComboBox2.setDisable(false);
			goFishPlayer2.setDisable(false);
			viewCountBox2.setDisable(false);
			viewForPlayer2.setDisable(false);
			goFishPlayer2.setDisable(false);
			move2.setDisable(false);
		} else if (twoPlayerCounter % 2 != 0) {
			opposingPlayerComboBox2.setDisable(true);
			goFishPlayer2.setDisable(true);
			viewCountBox2.setDisable(true);
			viewForPlayer2.setDisable(true);
			goFishPlayer2.setDisable(true);
			move2.setDisable(true);

			opposingPlayerComboBox1.setDisable(false);
			goFishPlayer1.setDisable(false);
			viewCountBox1.setDisable(false);
			viewForPlayer1.setDisable(false);
			goFishPlayer1.setDisable(false);
			move1.setDisable(false);
		}
	}

	@FXML
	public void move2() {
		accountForDisableControls();

		String askedPlayerName = player2.getName().trim();
		String cardTypeString = viewForPlayer2.getValue().trim();

		String[] splitList = cardTypeString.split(" ");
		int cardType = Integer.parseInt(splitList[0].trim());

		System.out.println(cardType);
		askForACard2(askedPlayerName, cardType);
//		for (int i = 0; i < 13; i++) {
//			int test = countForCardsPlayer2.get(i);
//			incrementScorePlayer2(test);
//		}
	}

	@FXML
	public void move3() {
		accountForDisableControls();
	}

	@FXML
	public void move4() {
		accountForDisableControls();
	}

	public void setListOfNames(ArrayList<String> names) {
		setNames(names);
	}

	public ArrayList<String> getNames() {
		return names;
	}

	public void setNames(ArrayList<String> names) {
		this.names = names;
	}

	public Button getDeal() {
		return deal;
	}

	public void setDeal(Button deal) {
		this.deal = deal;
	}

}
