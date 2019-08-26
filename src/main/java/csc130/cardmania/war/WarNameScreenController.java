package csc130.cardmania.war;

import java.io.IOException;
import java.util.ArrayList;

import csc130.cardmania.launch.MainMenu;
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

public class WarNameScreenController {

	private ObservableList<Integer> possiblePlayerNumber = FXCollections.observableArrayList(1, 2);
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
	private TextField player1TextField;
	@FXML
	private TextField player2TextField;
	@FXML
	private Button start;
	@FXML
	private Button loadButton;
	@FXML
	private Button backButton;

	@FXML
	private void initialize() {
		numOfPLayers.setItems(possiblePlayerNumber);
		addToArrayLists();
		setInitialLabelsAndFields();
	}

	private void addToArrayLists() {
		playerLabels.add(player1Label);
		playerLabels.add(player2Label);

		playerTextFields.add(player1TextField);
		playerTextFields.add(player2TextField);
	}

	private void setInitialLabelsAndFields() {
		player1Label.setVisible(true);
		player2Label.setVisible(false);

		player1TextField.setVisible(true);
		player2TextField.setVisible(false);

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
			FXMLLoader loader = new FXMLLoader(getClass().getResource("War.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			WarController controller = loader.<WarController>getController();
			controller.initNames(names);
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void launchLoadScreen() {
		Stage primaryStage = (Stage) start.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("WarLoadScreen.fxml"));
		Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		WarLoadController controller = loader.<WarLoadController>getController();
		controller.initSaves();
		primaryStage.setScene(scene);
		primaryStage.centerOnScreen();
		primaryStage.show();
	}
	
	@FXML
	private void sendToMainMenu() {
		Stage primaryStage = (Stage) start.getScene().getWindow();
		MainMenu menu = new MainMenu(primaryStage);
		Scene scene = new Scene(menu);
		primaryStage.setScene(scene);
		primaryStage.centerOnScreen();
		primaryStage.show();
	}

}
