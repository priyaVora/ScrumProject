package csc130.cardmania.blackjack;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BlackjackNameScreenController {

	private ObservableList<Integer> possiblePlayerNumber = FXCollections.observableArrayList(1, 2, 3, 4, 5);
	private ArrayList<Label> playerLabels = new ArrayList<>();
	private ArrayList<TextField> playerTextFields = new ArrayList<>();
	private int currentPLayers = 1;
	
	@FXML
	private ComboBox<Integer> numOfPLayers;
	@FXML
	private Label player1Label;
	@FXML
	private Label player2Label;
	@FXML
	private Label player3Label;
	@FXML
	private Label player4Label;
	@FXML
	private Label player5Label;
	@FXML
	private TextField player1TextField;
	@FXML
	private TextField player2TextField;
	@FXML
	private TextField player3TextField;
	@FXML
	private TextField player4TextField;
	@FXML
	private TextField player5TextField;
	@FXML
	private Button start;

	@FXML
	private void initialize() {
		numOfPLayers.setItems(possiblePlayerNumber);
		addToArrayLists();
		setInitialLabelsAndFields();
	}

	private void addToArrayLists() {
		playerLabels.add(player1Label);
		playerLabels.add(player2Label);
		playerLabels.add(player3Label);
		playerLabels.add(player4Label);
		playerLabels.add(player5Label);

		playerTextFields.add(player1TextField);
		playerTextFields.add(player2TextField);
		playerTextFields.add(player3TextField);
		playerTextFields.add(player4TextField);
		playerTextFields.add(player5TextField);
	}

	private void setInitialLabelsAndFields() {
		player1Label.setVisible(true);
		player2Label.setVisible(false);
		player3Label.setVisible(false);
		player4Label.setVisible(false);
		player5Label.setVisible(false);

		player1TextField.setVisible(true);
		player2TextField.setVisible(false);
		player3TextField.setVisible(false);
		player4TextField.setVisible(false);
		player5TextField.setVisible(false);

	}

	@FXML
	private void playerNumbersChanged(ActionEvent event) {
		currentPLayers = numOfPLayers.getValue();
		for (int i = currentPLayers; i < playerLabels.size() + 1; i++) {
			playerLabels.get(i - 1).setVisible(false);
			playerTextFields.get(i - 1).setVisible(false);
		}
		for (int i = currentPLayers; i > 0; i--) {
			playerLabels.get(i - 1).setVisible(true);
			playerTextFields.get(i - 1).setVisible(true);
		}
	}

	@FXML
	private void submitClicked(ActionEvent event) {		
		ArrayList<String> names = new ArrayList<String>();
		
		for (int i = 0; i < currentPLayers; i++) {
			names.add(playerTextFields.get(i).getText().trim());
		}
		
		try {
			Stage primaryStage = (Stage) start.getScene().getWindow();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("BlackJackGameScreen.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			BlackjackGameScreenController controller = loader.<BlackjackGameScreenController>getController();
			controller.initNames(names);
			controller.begin();
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
