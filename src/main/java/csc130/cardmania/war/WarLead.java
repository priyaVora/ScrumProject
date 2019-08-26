package csc130.cardmania.war;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WarLead{
	
	public WarLead(Stage primaryStage) {
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("WarNameScreen.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		primaryStage.setScene(new Scene(root));
		primaryStage.centerOnScreen();
	}
	
	
	
}
