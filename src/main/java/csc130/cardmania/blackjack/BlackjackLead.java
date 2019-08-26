package csc130.cardmania.blackjack;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BlackjackLead {
	private Stage primaryStage;
	
	public BlackjackLead(Stage primaryStage) {
		setPrimaryStage(primaryStage);
	}

	public void runGame() {
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("BlackJackNameScreen.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		primaryStage.centerOnScreen();
		primaryStage.setScene(new Scene(root));
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	
}
