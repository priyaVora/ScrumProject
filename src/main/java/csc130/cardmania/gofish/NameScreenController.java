package csc130.cardmania.gofish;

import java.io.IOException;
import java.util.ArrayList;

import csc130.cardmania.blackjack.BlackjackGameScreenController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NameScreenController {
	Stage primaryStage;
	private int currentNumberOfPLayers = 1;

	@FXML
	private Label playerLabel1;
	@FXML
	private Label playerLabel2;
	@FXML
	private Label playerLabel3;
	@FXML
	private Label playerLabel4;

	@FXML
	private TextField p1Textfield;
	@FXML
	private TextField p2TextField;
	@FXML
	private TextField p3TextField;
	@FXML
	private TextField p4TextField;

	@FXML
	private ComboBox<String> numOfPlayers;
	@FXML
	public Button playGame;

	private ObservableList<String> playersChoice = FXCollections.observableArrayList("2", "3", "4");
	
	private ArrayList<Label> allLabels = new ArrayList<>();
	private ArrayList<TextField> allTextFields = new ArrayList<>();

	@FXML
	private void initialize() {
		System.out.println("In init");
		numOfPlayers.setItems(playersChoice);
		addControls();
		setControlsToVisible();

	}

	private void setControlsToVisible() {
		System.out.println("SetControls");
		playerLabel1.setVisible(true);
		playerLabel2.setVisible(true);
		playerLabel3.setVisible(true);
		playerLabel4.setVisible(true);

		p1Textfield.setVisible(true);
		p2TextField.setVisible(true);
		p3TextField.setVisible(true);
		p4TextField.setVisible(true);
	}

	private void addControls() {
		System.out.println("Add Controls");
		allLabels.add(playerLabel1);
		allLabels.add(playerLabel2);
		allLabels.add(playerLabel3);
		allLabels.add(playerLabel4);

		allTextFields.add(p1Textfield);
		allTextFields.add(p2TextField);
		allTextFields.add(p3TextField);
		allTextFields.add(p4TextField);
	}

	@FXML
	private void playerNumbersChanged(ActionEvent event) {
		String currentPlayers = numOfPlayers.getValue();
		currentNumberOfPLayers = Integer.parseInt(currentPlayers);

		for (int i = currentNumberOfPLayers; i < allLabels.size() + 1; i++) {
			allLabels.get(i - 1).setVisible(false);
			allTextFields.get(i - 1).setVisible(false);
		}
		for (int i = currentNumberOfPLayers; i > 0; i--) {
			allLabels.get(i - 1).setVisible(true);
			allTextFields.get(i - 1).setVisible(true);
		}

		System.out.println("Current Number of Players: " + currentPlayers);
	}

	@SuppressWarnings("unused")
	@FXML
	private void playGameClicked(ActionEvent event) {
		ArrayList<String> listOfNames = new ArrayList<String>();

		for (int i = 0; i < currentNumberOfPLayers; i++) {
			listOfNames.add(allTextFields.get(i).getText().trim());
		}

		if (true) {
			try {
				Stage primaryStage = (Stage) playGame.getScene().getWindow();

				FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML.fxml"));

				BorderPane root = loader.load();

				Scene scene = new Scene(root);
				GoFishGameController controller = loader.<GoFishGameController>getController();;
				controller.setListOfNames(listOfNames);
				controller.begin();
				System.out.println("Set the list of names.");
				primaryStage.setScene(scene);
				System.out.println("Set the primary Stage");
				primaryStage.show();
				System.out.println("Have the primary Stage show");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public ObservableList<String> getPlayersChoice() {
		return playersChoice;
	}

	public void setPlayersChoice(ObservableList<String> playersChoice) {
		this.playersChoice = playersChoice;
	}

	public ArrayList<Label> getPlayerLabels() {
		return allLabels;
	}

	public void setPlayerLabels(ArrayList<Label> playerLabels) {
		this.allLabels = playerLabels;
	}

	public ArrayList<TextField> getPlayerTextFields() {
		return allTextFields;
	}

	public void setPlayerTextFields(ArrayList<TextField> playerTextFields) {
		this.allTextFields = playerTextFields;
	}

	public Label getPlayerLabel1() {
		return playerLabel1;
	}

	public void setPlayerLabel1(Label playerLabel1) {
		this.playerLabel1 = playerLabel1;
	}

	public Label getPlayerLabel2() {
		return playerLabel2;
	}

	public void setPlayerLabel2(Label playerLabel2) {
		this.playerLabel2 = playerLabel2;
	}

	public Label getPlayerLabel3() {
		return playerLabel3;
	}

	public void setPlayerLabel3(Label playerLabel3) {
		this.playerLabel3 = playerLabel3;
	}

	public Label getPlayerLabel4() {
		return playerLabel4;
	}

	public void setPlayerLabel4(Label playerLabel4) {
		this.playerLabel4 = playerLabel4;
	}

	public TextField getP1Textfield() {
		return p1Textfield;
	}

	public void setP1Textfield(TextField p1Textfield) {
		this.p1Textfield = p1Textfield;
	}

	public TextField getP2TextField() {
		return p2TextField;
	}

	public void setP2TextField(TextField p2TextField) {
		this.p2TextField = p2TextField;
	}

	public TextField getP3TextField() {
		return p3TextField;
	}

	public void setP3TextField(TextField p3TextField) {
		this.p3TextField = p3TextField;
	}

	public TextField getP4TextField() {
		return p4TextField;
	}

	public void setP4TextField(TextField p4TextField) {
		this.p4TextField = p4TextField;
	}

	public ComboBox<String> getNumOfPlayers() {
		return numOfPlayers;
	}

	public void setNumOfPlayers(ComboBox<String> numOfPlayers) {
		this.numOfPlayers = numOfPlayers;
	}

	public Button getPlayGame() {
		return playGame;
	}

	public void setPlayGame(Button playGame) {
		this.playGame = playGame;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
}
