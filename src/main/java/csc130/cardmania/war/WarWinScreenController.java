package csc130.cardmania.war;

import csc130.cardmania.launch.MainMenu;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class WarWinScreenController {
	
	@FXML
	private Label wonText;
	
	@FXML
	private Button menuButton;
	
	@FXML
	private Button exitButton;
	
	
	@FXML
	private void sendToMainMenu() {
		Stage primaryStage = (Stage) wonText.getScene().getWindow();
		MainMenu menu = new MainMenu(primaryStage);
		Scene scene = new Scene(menu);
		primaryStage.setScene(scene);
		primaryStage.centerOnScreen();
		primaryStage.show();
	}
	
	@FXML
	private void exitApp() {
		Stage primaryStage = (Stage) wonText.getScene().getWindow();
		primaryStage.close();
	}

	public void initName(String name) {
		wonText.setText(name + " Won!");
	}

}
