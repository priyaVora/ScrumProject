package csc130.cardmania.gofish;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GoFishLead {

	private Stage primaryStage;
	
	public GoFishLead(Stage primaryStage) {
		setPrimaryStage(primaryStage);
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("Name.fxml"));
			System.out.println(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		primaryStage.setTitle("Welcome - Go Fish");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	
		
	 
	}
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
}
