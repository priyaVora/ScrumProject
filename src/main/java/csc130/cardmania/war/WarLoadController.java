package csc130.cardmania.war;

import java.io.File;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class WarLoadController {
	
	@FXML
	private ComboBox<String> saves;
	
	@FXML
	private Button loadButton;
	@FXML
	private Button backButton;
	
	@FXML
	private void loadGame() {
		Stage primaryStage = (Stage) saves.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("War.fxml"));
		Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		WarController controller = loader.<WarController>getController();
		controller.loadGame(saves.getSelectionModel().getSelectedItem().toString());
		primaryStage.setScene(scene);
		primaryStage.centerOnScreen();
		primaryStage.show();
	}

	public void initSaves() {
		File savesFile = new File("saves/");
		savesFile.mkdirs();
		File saves = new File("saves/");
		for (File f : saves.listFiles()) {
			this.saves.getItems().add(f.getName().substring(0, f.getName().length() - 4));
		}
		
	}
	
	@FXML
	private void sendToNameScreen() {
		Stage primaryStage = (Stage) saves.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("WarNameScreen.fxml"));
		Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		WarNameScreenController controller = loader.<WarNameScreenController>getController();
		primaryStage.setScene(scene);
		primaryStage.centerOnScreen();
		primaryStage.show();
	}

}
