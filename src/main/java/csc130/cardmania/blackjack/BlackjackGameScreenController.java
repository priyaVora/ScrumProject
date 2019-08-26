package csc130.cardmania.blackjack;

import java.util.ArrayList;

import csc130.cardmania.utility.Card;
import csc130.cardmania.utility.Dealer;
import csc130.cardmania.utility.Deck;
import csc130.cardmania.utility.Player;
import csc130.cardmania.utility.Rank;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class BlackjackGameScreenController {
	private ArrayList<String> names;
	private ArrayList<Player> players;
	private ArrayList<ImageView> houseCards = new ArrayList<>();
	private ArrayList<ArrayList<ImageView>> gameImageCards = new ArrayList<>();
	private ArrayList<ImageView> player1ImageCards = new ArrayList<>();
	private ArrayList<ImageView> player2ImageCards = new ArrayList<>();
	private ArrayList<ImageView> player3ImageCards = new ArrayList<>();
	private ArrayList<ImageView> player4ImageCards = new ArrayList<>();
	private ArrayList<ImageView> player5ImageCards = new ArrayList<>();
	private ArrayList<Label> leftHandLabels = new ArrayList<>();
	private ArrayList<Label> rightHandLabels = new ArrayList<>();
	private ArrayList<Label> nameLabels = new ArrayList<>();
	private ArrayList<Label> betLabels = new ArrayList<>();
	private ArrayList<Label> bankLabels = new ArrayList<>();
	private int currentPlayer = 1;
	private Deck gameDeck = new Deck(false);
	private Dealer dealer = new Dealer();

	@FXML
	private ImageView houseCard1;
	@FXML
	private ImageView houseCard2;
	@FXML
	private ImageView houseCard3;
	@FXML
	private ImageView houseCard4;
	@FXML
	private ImageView houseCard5;
	@FXML
	private Label houseHandLabel;

	@FXML
	private ImageView p1Card1;
	@FXML
	private ImageView p1Card2;
	@FXML
	private ImageView p1Card3;
	@FXML
	private ImageView p1Card4;
	@FXML
	private ImageView p1Card5;
	@FXML
	private ImageView p1Card6;
	@FXML
	private ImageView p1Card7;
	@FXML
	private ImageView p1Card8;
	@FXML
	private ImageView p1Card9;
	@FXML
	private ImageView p1Card10;
	@FXML
	private Label p1LeftHandLabel;
	@FXML
	private Label p1RightHandLabel;
	@FXML
	private Label p1BetLabel;
	@FXML
	private Label p1NameLabel;
	@FXML
	private Label p1BankLabel;

	@FXML
	private ImageView p2Card1;
	@FXML
	private ImageView p2Card2;
	@FXML
	private ImageView p2Card3;
	@FXML
	private ImageView p2Card4;
	@FXML
	private ImageView p2Card5;
	@FXML
	private ImageView p2Card6;
	@FXML
	private ImageView p2Card7;
	@FXML
	private ImageView p2Card8;
	@FXML
	private ImageView p2Card9;
	@FXML
	private ImageView p2Card10;
	@FXML
	private Label p2LeftHandLabel;
	@FXML
	private Label p2RightHandLabel;
	@FXML
	private Label p2BetLabel;
	@FXML
	private Label p2NameLabel;
	@FXML
	private Label p2BankLabel;

	@FXML
	private ImageView p3Card1;
	@FXML
	private ImageView p3Card2;
	@FXML
	private ImageView p3Card3;
	@FXML
	private ImageView p3Card4;
	@FXML
	private ImageView p3Card5;
	@FXML
	private ImageView p3Card6;
	@FXML
	private ImageView p3Card7;
	@FXML
	private ImageView p3Card8;
	@FXML
	private ImageView p3Card9;
	@FXML
	private ImageView p3Card10;
	@FXML
	private Label p3LeftHandLabel;
	@FXML
	private Label p3RightHandLabel;
	@FXML
	private Label p3BetLabel;
	@FXML
	private Label p3NameLabel;
	@FXML
	private Label p3BankLabel;

	@FXML
	private ImageView p4Card1;
	@FXML
	private ImageView p4Card2;
	@FXML
	private ImageView p4Card3;
	@FXML
	private ImageView p4Card4;
	@FXML
	private ImageView p4Card5;
	@FXML
	private ImageView p4Card6;
	@FXML
	private ImageView p4Card7;
	@FXML
	private ImageView p4Card8;
	@FXML
	private ImageView p4Card9;
	@FXML
	private ImageView p4Card10;
	@FXML
	private Label p4LeftHandLabel;
	@FXML
	private Label p4RightHandLabel;
	@FXML
	private Label p4BetLabel;
	@FXML
	private Label p4NameLabel;
	@FXML
	private Label p4BankLabel;

	@FXML
	private ImageView p5Card1;
	@FXML
	private ImageView p5Card2;
	@FXML
	private ImageView p5Card3;
	@FXML
	private ImageView p5Card4;
	@FXML
	private ImageView p5Card5;
	@FXML
	private ImageView p5Card6;
	@FXML
	private ImageView p5Card7;
	@FXML
	private ImageView p5Card8;
	@FXML
	private ImageView p5Card9;
	@FXML
	private ImageView p5Card10;
	@FXML
	private Label p5LeftHandLabel;
	@FXML
	private Label p5RightHandLabel;
	@FXML
	private Label p5BetLabel;
	@FXML
	private Label p5NameLabel;
	@FXML
	private Label p5BankLabel;

	@FXML
	private Button hitButton;
	@FXML
	private Button standButton;
	@FXML
	private Button splitButton;

	@FXML
	private Button bet1Button;
	@FXML
	private Button bet5Button;
	@FXML
	private Button bet10Button;

	@FXML
	private Button submitBetButton;

	@FXML
	private Label phaseLabel;

	public void begin() {
		makePlayers();
		initLists();
		initNameBankBetHands();
		beginRound();
	}

	private void makePlayers() {
		players = new ArrayList<>();
		players.add(new Player("House", 0));
		for (int i = 0; i < names.size(); i++) {
			players.add(new Player(names.get(i), 20));
		}
	}

	private void beginRound() {
		phaseLabel.setText("Betting Phase");
		hitButton.setOpacity(0.2);
		splitButton.setOpacity(0.2);
		standButton.setOpacity(0.2);
		hitButton.setDisable(true);
		splitButton.setDisable(true);
		standButton.setDisable(true);
		bet1Button.setDisable(false);
		bet5Button.setDisable(false);
		bet10Button.setDisable(false);
		bet1Button.setOpacity(1);
		bet5Button.setOpacity(1);
		bet10Button.setOpacity(1);
		submitBetButton.setDisable(false);
		submitBetButton.setOpacity(1);
		changePlayerFocus(false);
	}

	private void beginPlayPhase() {
		submitBetButton.setOpacity(0.2);
		currentPlayer = 1;
		phaseLabel.setText("Play Phase");
		bet1Button.setDisable(true);
		bet5Button.setDisable(true);
		bet10Button.setDisable(true);
		submitBetButton.setDisable(true);
		// hitButton.setOpacity(1);
		// splitButton.setOpacity(1);
		standButton.setOpacity(1);
		// hitButton.setDisable(false);
		// splitButton.setDisable(false);
		standButton.setDisable(false);
		distributeCards();
		boolean roundOver = checkBoardForBlackjack();
		if (roundOver) {
			distributePay(true);
			endRound(true);
			// CHECK IF PLAYERS CAN STAY
			// DO BET PHASE AGAIN
			// SET BLACKJACK BACK TO FALSE ON ALL PLAYERS
		} else {
			changePlayerFocus(true);
		}
	}

	private boolean checkBoardForBlackjack() {
		boolean roundOver = false;
		boolean houseHasBlackJack = checkForBlackJack(0);

		for (int i = 1; i < players.size(); i++) {
			players.get(i).setHasBlackjack(checkForBlackJack(i));
		}

		if (houseHasBlackJack) {
			roundOver = true;
			for (int i = 1; i < players.size(); i++) {
				for (int j = 0; j < players.get(i).getHand().size(); j++) {
					gameImageCards.get(i).get(j).setImage(players.get(i).getHand().get(j).getFace());
				}
			}

		} else {
			int numbOfPlayersWithBlackJack = 0;
			for (int i = 1; i < players.size(); i++) {
				if (players.get(i).isHasBlackjack()) {
					numbOfPlayersWithBlackJack++;
					gameImageCards.get(i).get(0).setImage(players.get(i).getHand().get(0).getFace());
					players.get(i).setBankAmount(players.get(i).getBankAmount() + (2 * players.get(i).getCurrentBet()));
					// PAY THIS PERSON HIS MONEY
					// CHANGE BET LABEL
					// CONTINIUE WITH OTHEER PLAYERS
				}
			}
			if (numbOfPlayersWithBlackJack == players.size() - 1) {
				roundOver = true;
			}
		}
		return roundOver;
	}

	private void distributeCards() {
		for (int i = 0; i < players.size(); i++) {
			players.get(i).getHand().add(dealer.dealAHand(1, gameDeck).get(0));
			gameImageCards.get(i).get(0).setImage(Card.getBack());
		}

		for (int i = 0; i < players.size(); i++) {
			players.get(i).getHand().add(dealer.dealAHand(1, gameDeck).get(0));
			gameImageCards.get(i).get(1).setImage(players.get(i).getHand().get(1).getFace());
		}

	}

	private void changePlayerFocus(boolean flipCard) {
		if (currentPlayer == players.size()) {
			bankLabels.get(currentPlayer - 2).setOpacity(0.2);
			betLabels.get(currentPlayer - 2).setOpacity(0.2);
			nameLabels.get(currentPlayer - 2).setOpacity(0.2);
			currentPlayer = 0;
			dealerPlayPhase();
			return;
		}
		if (players.get(currentPlayer).isHasBlackjack()) {
			currentPlayer++;
			return;
		}
		if (flipCard) {
			calculateCards();
			if (!players.get(currentPlayer - 1).isBusted()) {
				gameImageCards.get(currentPlayer - 1).get(0).setImage(Card.getBack());
			} else {
				gameImageCards.get(currentPlayer - 1).get(0)
						.setImage(players.get(currentPlayer - 1).getHand().get(0).getFace());
			}
			gameImageCards.get(currentPlayer).get(0).setImage(players.get(currentPlayer).getHand().get(0).getFace());
		}
		for (int i = 0; i < names.size(); i++) {
			if (i != currentPlayer - 1) {
				bankLabels.get(i).setOpacity(0.2);
				betLabels.get(i).setOpacity(0.2);
				nameLabels.get(i).setOpacity(0.2);
			} else {
				bankLabels.get(i).setOpacity(1);
				betLabels.get(i).setOpacity(1);
				nameLabels.get(i).setOpacity(1);
			}
		}
	}

	private void dealerPlayPhase() {
		hitButton.setDisable(true);
		splitButton.setDisable(true);
		standButton.setDisable(true);
		hitButton.setOpacity(0.2);
		splitButton.setOpacity(0.2);
		standButton.setOpacity(0.2);
		gameImageCards.get(0).get(0).setImage(players.get(0).getHand().get(0).getFace());
		int currentAmountA1 = 0;
		int currentAmountA11 = 0;
		boolean aceFound = false;
		for (int i = 0; i < players.get(0).getHand().size(); i++) {
			if (players.get(0).getHand().get(i).getRank() == Rank.JACK
					|| players.get(i).getHand().get(i).getRank() == Rank.QUEEN
					|| players.get(i).getHand().get(i).getRank() == Rank.KING) {
				currentAmountA1 += 10;
				currentAmountA11 += 10;
			} else if (players.get(i).getHand().get(i).getRank() == Rank.ACE) {
				aceFound = true;
				currentAmountA1 += 1;
				currentAmountA11 += 11;
			} else {
				currentAmountA1 += players.get(i).getHand().get(i).getValue();
				currentAmountA11 += players.get(i).getHand().get(i).getValue();
			}
		}

		if (players.get(0).isBusted()) {
			houseHandLabel.setText(currentAmountA1 + "");
		} else if (aceFound && currentAmountA11 == 21) {
			houseHandLabel.setText(currentAmountA11 + "");
		} else if (aceFound && currentAmountA11 < 21) {
			houseHandLabel.setText(currentAmountA1 + "/" + currentAmountA11);
		} else if (currentAmountA11 > 21 && currentAmountA1 <= 21) {
			houseHandLabel.setText(currentAmountA1 + "");
		} else {
			houseHandLabel.setText(currentAmountA1 + "");
		}
		houseHandLabel.setVisible(true);

		boolean isFinished = false;
		boolean on1 = !aceFound;
		while (!isFinished) {
			if (!on1) {

				if (currentAmountA11 == 17) {
					// dont draw, figure out payouts
					isFinished = true;
				} else if (currentAmountA11 > 17 && currentAmountA11 < 22) {
					isFinished = true;
				} else if (currentAmountA11 < 17) {

					players.get(0).getHand().add(dealer.dealAHand(1, gameDeck).get(0));
					gameImageCards.get(0).get(players.get(0).getHand().size() - 1)
							.setImage(players.get(0).getHand().get(players.get(0).getHand().size() - 1).getFace());

					if (players.get(0).getHand().get(players.get(0).getHand().size() - 1).getRank() == Rank.JACK
							|| players.get(0).getHand().get(players.get(0).getHand().size() - 1).getRank() == Rank.QUEEN
							|| players.get(0).getHand().get(players.get(0).getHand().size() - 1)
									.getRank() == Rank.KING) {
						currentAmountA1 += 10;
						currentAmountA11 += 10;
					} else if (players.get(0).getHand().get(players.get(0).getHand().size() - 1)
							.getRank() == Rank.ACE) {
						aceFound = true;
						currentAmountA1 += 1;
						currentAmountA11 += 11;
					} else {
						currentAmountA1 += players.get(0).getHand().get(players.get(0).getHand().size() - 1).getValue();
						currentAmountA11 += players.get(0).getHand().get(players.get(0).getHand().size() - 1)
								.getValue();
					}

					if (players.get(0).isBusted()) {
						houseHandLabel.setText(currentAmountA1 + "");
					} else if (aceFound && currentAmountA11 == 21) {
						houseHandLabel.setText(currentAmountA11 + "");
					} else if (aceFound && currentAmountA11 < 21) {
						houseHandLabel.setText(currentAmountA1 + "/" + currentAmountA11);
					} else if (currentAmountA11 > 21 && currentAmountA1 <= 21) {
						houseHandLabel.setText(currentAmountA1 + "");
					} else {
						houseHandLabel.setText(currentAmountA1 + "");
					}

				} else if (currentAmountA11 > 17) {
					on1 = true;
				}
			} else {

				if (currentAmountA1 == 17) {
					// dont draw, figure out payouts
					isFinished = true;
				} else if (currentAmountA1 >= 17 && currentAmountA1 <= 21) {
					isFinished = true;
				} else if (currentAmountA1 < 17) {
					players.get(0).getHand().add(dealer.dealAHand(1, gameDeck).get(0));
					gameImageCards.get(0).get(players.get(0).getHand().size() - 1)
							.setImage(players.get(0).getHand().get(players.get(0).getHand().size() - 1).getFace());

					if (players.get(0).getHand().get(players.get(0).getHand().size() - 1).getRank() == Rank.JACK
							|| players.get(0).getHand().get(players.get(0).getHand().size() - 1).getRank() == Rank.QUEEN
							|| players.get(0).getHand().get(players.get(0).getHand().size() - 1)
									.getRank() == Rank.KING) {
						currentAmountA1 += 10;
					} else if (players.get(0).getHand().get(players.get(0).getHand().size() - 1)
							.getRank() == Rank.ACE) {
						aceFound = true;
						currentAmountA1 += 1;
					} else {
						currentAmountA1 += players.get(0).getHand().get(players.get(0).getHand().size() - 1).getValue();
					}

					houseHandLabel.setText(currentAmountA1 + "");

				} else if (currentAmountA1 > 21) {
					isFinished = true;
					players.get(0).setBusted(true);
					System.out.println("BUSTED");
					// HOUSE BUSTED
				}
			}
		}
		PauseTransition pause = new PauseTransition(Duration.seconds(3));
		pause.setOnFinished(event ->
			endRound(false)
		);
		pause.play();
	}

	private void endRound(boolean doneDistributing) {

		currentPlayer = 1;
		if (!doneDistributing) {
			distributePay(false);
		}
		clearPlayers();
		initNameBankBetHands();
		clearImages();
		beginRound();
	}

	private void clearImages() {
		for (int i = 0; i < players.size(); i++) {
			for (int j = 0; j < gameImageCards.get(i).size(); j++) {
				gameImageCards.get(i).get(j).setImage(null);
			}
		}
	}

	private void clearPlayers() {
		for (int i = 0; i < players.size(); i++) {
			players.get(i).setCurrentBet(0);
			players.get(i).setHand(new Deck(true));
			players.get(i).setHandValue(0);
			players.get(i).setHandValueWithAce(0);
			players.get(i).setHasBlackjack(false);
		}
	}

	private void distributePay(boolean houseBlackjack) {

		if (houseBlackjack) {
			for (int i = 1; i < players.size(); i++) {
				if (!players.get(i).isHasBlackjack()) {
					players.get(i).setBankAmount(players.get(i).getBankAmount() - players.get(i).getCurrentBet());
				}
			}

			return;
		}

		boolean useAce = false;
		if (players.get(0).getHandValueWithAce() <= 21 && players.get(0).getHandValueWithAce() >= 17) {
			useAce = true;
		}
		for (int i = 1; i < players.size(); i++) {
			if (players.get(i).isHasBlackjack()) {
				i++;
			}
			boolean playerUseAce = false;
			if (useAce) {
				if (!players.get(i).isBusted()) {
					if (!players.get(0).isBusted()) {

						if (players.get(i).getHandValueWithAce() <= 21 && players.get(0).getHandValueWithAce() >= 17) {
							playerUseAce = true;
						}
						if (playerUseAce) {
							if (players.get(i).getHandValueWithAce() == players.get(0).getHandValueWithAce()) {
								// no need to change bank
							} else if (players.get(i).getHandValueWithAce() > players.get(0).getHandValueWithAce()) {
								players.get(i)
										.setBankAmount(players.get(i).getBankAmount() + players.get(i).getCurrentBet());
							} else {
								players.get(i)
										.setBankAmount(players.get(i).getBankAmount() - players.get(i).getCurrentBet());
							}
						} else {
							if (players.get(i).getHandValue() == players.get(0).getHandValueWithAce()) {
								// no need to change bank
							} else if (players.get(i).getHandValue() > players.get(0).getHandValueWithAce()) {
								players.get(i)
										.setBankAmount(players.get(i).getBankAmount() + players.get(i).getCurrentBet());
							} else {
								players.get(i)
										.setBankAmount(players.get(i).getBankAmount() - players.get(i).getCurrentBet());
							}
						}
					} else {
						players.get(i).setBankAmount(players.get(i).getBankAmount() + players.get(i).getCurrentBet());
					}
				}
			} else {
				if (!players.get(i).isBusted()) {
					if (!players.get(0).isBusted()) {
						if (players.get(i).getHandValueWithAce() <= 21 && players.get(0).getHandValueWithAce() >= 17) {
							playerUseAce = true;
						}
						if (playerUseAce) {
							if (players.get(i).getHandValueWithAce() == players.get(0).getHandValue()) {
								// no need to change bank
							} else if (players.get(i).getHandValueWithAce() > players.get(0).getHandValue()) {
								players.get(i)
										.setBankAmount(players.get(i).getBankAmount() + players.get(i).getCurrentBet());
							} else {
								players.get(i)
										.setBankAmount(players.get(i).getBankAmount() - players.get(i).getCurrentBet());
							}
						} else {
							if (players.get(i).getHandValue() == players.get(0).getHandValue()) {
								// no need to change bank
							} else if (players.get(i).getHandValue() > players.get(0).getHandValue()) {
								players.get(i)
										.setBankAmount(players.get(i).getBankAmount() + players.get(i).getCurrentBet());
							} else {
								players.get(i)
										.setBankAmount(players.get(i).getBankAmount() - players.get(i).getCurrentBet());
							}
						}
					} else {
						players.get(i).setBankAmount(players.get(i).getBankAmount() + players.get(i).getCurrentBet());
					}
				}
			}
		}
	}

	private void changeLabelAvailability() {
		if (((Rank) players.get(currentPlayer).getHand().get(0).getRank() == (Rank) players.get(currentPlayer).getHand()
				.get(1).getRank()) && players.get(currentPlayer).getHand().size() == 2) {
			splitButton.setOpacity(1);
			splitButton.setDisable(false);
		} else {
			splitButton.setOpacity(0.2);
			splitButton.setDisable(true);
		}

		if (players.get(currentPlayer).getHandValue() < 21 && players.get(currentPlayer).getHandValueWithAce() != 21) {
			hitButton.setDisable(false);
			hitButton.setOpacity(1);
		} else if (players.get(currentPlayer).getHandValue() == 21
				|| players.get(currentPlayer).getHandValueWithAce() == 21) {
			hitButton.setDisable(true);
			hitButton.setOpacity(0.2);

		} else {
			players.get(currentPlayer).setBusted(true);
			betLabels.get(currentPlayer - 1).setText("BUST");
			players.get(currentPlayer).setBankAmount(
					players.get(currentPlayer).getBankAmount() - players.get(currentPlayer).getCurrentBet());
			bankLabels.get(currentPlayer - 1).setText("Bank: " + players.get(currentPlayer).getBankAmount());
			for (int i = 0; i < players.get(currentPlayer).getHand().size(); i++) {
				gameImageCards.get(currentPlayer).get(i)
						.setImage(players.get(currentPlayer).getHand().get(i).getFace());
			}
			currentPlayer++;
			changePlayerFocus(true);
			// HANDLE BUST PAYOUT
			// switch to next player
		}

	}

	private boolean checkForBlackJack(int playerPosition) {
		boolean aceFound = false;
		boolean faceFound = false;
		Card c = players.get(playerPosition).getHand().get(0);
		if (c.getRank() == Rank.JACK || c.getRank() == Rank.QUEEN || c.getRank() == Rank.KING
				|| c.getRank() == Rank.TEN) {
			faceFound = true;
		} else if (c.getRank() == Rank.ACE) {
			aceFound = true;
		}
		c = players.get(playerPosition).getHand().get(1);
		if (c.getRank() == Rank.JACK || c.getRank() == Rank.QUEEN || c.getRank() == Rank.KING
				|| c.getRank() == Rank.TEN) {
			faceFound = true;
		} else if (c.getRank() == Rank.ACE) {
			aceFound = true;
		}

		if (aceFound && faceFound) {
			return true;
		} else {
			return false;
		}

	}

	private void calculateCards() {
		for (int i = 0; i < players.size(); i++) {
			if (i != currentPlayer && !players.get(i).isHasBlackjack()) {
				int visibleTotal = 0;
				int visibleTotalWAce = 0;
				boolean aceFound = false;
				for (int j = 1; j < players.get(i).getHand().size(); j++) {
					if (players.get(i).getHand().get(j).getRank() == Rank.JACK
							|| players.get(i).getHand().get(j).getRank() == Rank.QUEEN
							|| players.get(i).getHand().get(j).getRank() == Rank.KING) {
						visibleTotal += 10;
						visibleTotalWAce += 10;
					} else if (players.get(i).getHand().get(j).getRank() == Rank.ACE) {
						aceFound = true;
						visibleTotal += 1;
						visibleTotalWAce += 11;
					} else {
						visibleTotal += players.get(i).getHand().get(j).getValue();
						visibleTotalWAce += players.get(i).getHand().get(j).getValue();
					}

				}
				if (players.get(i).isBusted()) {
					if (players.get(i).getHand().get(0).getRank() == Rank.JACK
							|| players.get(i).getHand().get(0).getRank() == Rank.QUEEN
							|| players.get(i).getHand().get(0).getRank() == Rank.KING) {
						visibleTotal += 10;
						visibleTotalWAce += 10;
					} else if (players.get(i).getHand().get(0).getRank() == Rank.ACE) {
						aceFound = true;
						visibleTotal += 1;
						visibleTotalWAce += 11;
					} else {
						visibleTotal += players.get(i).getHand().get(0).getValue();
						visibleTotalWAce += players.get(i).getHand().get(0).getValue();
					}
				}

				if (players.get(i).isBusted()) {
					leftHandLabels.get(i).setText(visibleTotal + "");
				} else if (aceFound && visibleTotalWAce == 21) {
					leftHandLabels.get(i).setText(visibleTotalWAce + "");
				} else if (aceFound && visibleTotalWAce < 21) {
					leftHandLabels.get(i).setText(visibleTotal + "/" + visibleTotalWAce);
				} else if (visibleTotalWAce > 21 && visibleTotal <= 21) {
					leftHandLabels.get(i).setText(visibleTotal + "");
				} else {
					leftHandLabels.get(i).setText(visibleTotal + "");
				}
				leftHandLabels.get(i).setVisible(true);
			} else {
				leftHandLabels.get(i).setVisible(true);
				int total = 0;
				int totalWithAce = 0;
				boolean aceFound = false;

				for (int j = 0; j < players.get(i).getHand().size(); j++) {
					if (players.get(i).getHand().get(j).getRank() == Rank.JACK
							|| players.get(i).getHand().get(j).getRank() == Rank.QUEEN
							|| players.get(i).getHand().get(j).getRank() == Rank.KING) {
						total += 10;
						totalWithAce += 10;
					} else if (players.get(i).getHand().get(j).getRank() == Rank.ACE) {
						aceFound = true;
						total += 1;
						totalWithAce += 11;
					} else {
						total += players.get(i).getHand().get(j).getValue();
						totalWithAce += players.get(i).getHand().get(j).getValue();
					}

				}

				if (aceFound) {
					if (totalWithAce < 21) {
						leftHandLabels.get(i).setText(total + "/" + totalWithAce);
					} else if (total < 21) {
						leftHandLabels.get(i).setText(total + "");
					} else if (totalWithAce == 21) {
						leftHandLabels.get(i).setText(totalWithAce + "");
					}
				} else if (total != 21) {
					leftHandLabels.get(i).setText(total + "");
				} else {
					leftHandLabels.get(i).setText(total + "");
				}
				players.get(currentPlayer).setHandValue(total);
				players.get(currentPlayer).setHandValueWithAce(totalWithAce);
				changeLabelAvailability();
			}
		}
	}

	private void initNameBankBetHands() {
		for (int i = 0; i < names.size(); i++) {
			bankLabels.get(i).setText("Bank: $" + players.get(i + 1).getBankAmount());
			betLabels.get(i).setText("Bet: 0");
			leftHandLabels.get(i).setVisible(false);
			rightHandLabels.get(i).setVisible(false);
			nameLabels.get(i).setText(names.get(i));

		}
		leftHandLabels.get(names.size()).setVisible(false);
		houseHandLabel.setVisible(false);

	}

	@FXML
	private void bet1Clicked(ActionEvent event) {
		players.get(currentPlayer).setCurrentBet(1);
		betLabels.get(currentPlayer - 1).setText("Bet: " + players.get(currentPlayer).getCurrentBet());
	}

	@FXML
	private void bet5Clicked(ActionEvent event) {
		players.get(currentPlayer).setCurrentBet(5);
		betLabels.get(currentPlayer - 1).setText("Bet: " + players.get(currentPlayer).getCurrentBet());
	}

	@FXML
	private void bet10Clicked(ActionEvent event) {
		players.get(currentPlayer).setCurrentBet(10);
		betLabels.get(currentPlayer - 1).setText("Bet: " + players.get(currentPlayer).getCurrentBet());
	}

	@FXML
	private void submitBetClicked(ActionEvent event) {
		if (players.get(currentPlayer).getCurrentBet() != 0) {
			if (currentPlayer != names.size()) {
				currentPlayer++;
				changePlayerFocus(false);
			} else {

				beginPlayPhase();
			}
		}

	}

	@FXML
	private void standClicked(ActionEvent event) {
		if (currentPlayer != names.size()) {
			currentPlayer++;
			changePlayerFocus(true);
		} else {
			bankLabels.get(currentPlayer - 1).setOpacity(0.2);
			betLabels.get(currentPlayer - 1).setOpacity(0.2);
			nameLabels.get(currentPlayer - 1).setOpacity(0.2);
			currentPlayer = 0;
			dealerPlayPhase();
		}

	}

	@FXML
	private void hitClicked(ActionEvent event) {
		players.get(currentPlayer).getHand().add(dealer.dealAHand(1, gameDeck).get(0));
		gameImageCards.get(currentPlayer).get(players.get(currentPlayer).getHand().size() - 1).setImage(
				players.get(currentPlayer).getHand().get(players.get(currentPlayer).getHand().size() - 1).getFace());
		calculateCards();
	}

	private void initLists() {
		leftHandLabels.add(houseHandLabel);
		leftHandLabels.add(p1LeftHandLabel);
		rightHandLabels.add(p1RightHandLabel);
		nameLabels.add(p1NameLabel);
		betLabels.add(p1BetLabel);
		bankLabels.add(p1BankLabel);
		leftHandLabels.add(p2LeftHandLabel);
		rightHandLabels.add(p2RightHandLabel);
		nameLabels.add(p2NameLabel);
		betLabels.add(p2BetLabel);
		bankLabels.add(p2BankLabel);
		leftHandLabels.add(p3LeftHandLabel);
		rightHandLabels.add(p3RightHandLabel);
		nameLabels.add(p3NameLabel);
		betLabels.add(p3BetLabel);
		bankLabels.add(p3BankLabel);
		leftHandLabels.add(p4LeftHandLabel);
		rightHandLabels.add(p4RightHandLabel);
		nameLabels.add(p4NameLabel);
		betLabels.add(p4BetLabel);
		bankLabels.add(p4BankLabel);
		leftHandLabels.add(p5LeftHandLabel);
		rightHandLabels.add(p5RightHandLabel);
		nameLabels.add(p5NameLabel);
		betLabels.add(p5BetLabel);
		bankLabels.add(p5BankLabel);

		for (int i = names.size(); i < 5; i++) {
			leftHandLabels.get(i).setVisible(false);
			rightHandLabels.get(i).setVisible(false);
			nameLabels.get(i).setVisible(false);
			betLabels.get(i).setVisible(false);
			bankLabels.get(i).setVisible(false);
		}
		leftHandLabels.get(5).setVisible(false);

		houseCards.add(houseCard1);
		houseCards.add(houseCard2);
		houseCards.add(houseCard3);
		houseCards.add(houseCard4);
		houseCards.add(houseCard5);

		player1ImageCards.add(p1Card1);
		player1ImageCards.add(p1Card2);
		player1ImageCards.add(p1Card3);
		player1ImageCards.add(p1Card4);
		player1ImageCards.add(p1Card5);
		player1ImageCards.add(p1Card6);
		player1ImageCards.add(p1Card7);
		player1ImageCards.add(p1Card8);
		player1ImageCards.add(p1Card9);
		player1ImageCards.add(p1Card10);

		player2ImageCards.add(p2Card1);
		player2ImageCards.add(p2Card2);
		player2ImageCards.add(p2Card3);
		player2ImageCards.add(p2Card4);
		player2ImageCards.add(p2Card5);
		player2ImageCards.add(p2Card6);
		player2ImageCards.add(p2Card7);
		player2ImageCards.add(p2Card8);
		player2ImageCards.add(p2Card9);
		player2ImageCards.add(p2Card10);

		player3ImageCards.add(p3Card1);
		player3ImageCards.add(p3Card2);
		player3ImageCards.add(p3Card3);
		player3ImageCards.add(p3Card4);
		player3ImageCards.add(p3Card5);
		player3ImageCards.add(p3Card6);
		player3ImageCards.add(p3Card7);
		player3ImageCards.add(p3Card8);
		player3ImageCards.add(p3Card9);
		player3ImageCards.add(p3Card10);

		player4ImageCards.add(p4Card1);
		player4ImageCards.add(p4Card2);
		player4ImageCards.add(p4Card3);
		player4ImageCards.add(p4Card4);
		player4ImageCards.add(p4Card5);
		player4ImageCards.add(p4Card6);
		player4ImageCards.add(p4Card7);
		player4ImageCards.add(p4Card8);
		player4ImageCards.add(p4Card9);
		player4ImageCards.add(p4Card10);

		player5ImageCards.add(p5Card1);
		player5ImageCards.add(p5Card2);
		player5ImageCards.add(p5Card3);
		player5ImageCards.add(p5Card4);
		player5ImageCards.add(p5Card5);
		player5ImageCards.add(p5Card6);
		player5ImageCards.add(p5Card7);
		player5ImageCards.add(p5Card8);
		player5ImageCards.add(p5Card9);
		player5ImageCards.add(p5Card10);

		gameImageCards.add(houseCards);
		gameImageCards.add(player1ImageCards);
		gameImageCards.add(player2ImageCards);
		gameImageCards.add(player3ImageCards);
		gameImageCards.add(player4ImageCards);
		gameImageCards.add(player5ImageCards);

	}

	public void initNames(ArrayList<String> names) {
		setNames(names);
	}

	public ArrayList<String> getNames() {
		return names;
	}

	public void setNames(ArrayList<String> names) {
		this.names = names;
	}

	public int getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(int currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public Deck getGameDeck() {
		return gameDeck;
	}

	public void setGameDeck(Deck gameDeck) {
		this.gameDeck = gameDeck;
	}

	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

}
