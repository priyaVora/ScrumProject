package csc130.cardmania.launch;

import java.io.IOException;

import csc130.cardmania.blackjack.BlackjackLead;
import csc130.cardmania.gofish.GoFishLead;
import csc130.cardmania.war.WarLead;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenu extends VBox {
	Stage primaryStage;

	public MainMenu(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.getStyleClass().add("background");
		setupMainMenu();
	}

	public void setupMainMenu() {
		Button blackjackStart = new Button("Blackjack");
		blackjackStart.getStyleClass().add("buttons");
		blackjackStart.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				BlackjackLead blackjack = new BlackjackLead(primaryStage);
				blackjack.runGame();
			}
			
		});
		
		Button goFishStart = new Button("Go Fish");
		goFishStart.getStyleClass().add("buttons");
		goFishStart.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				GoFishLead goFish = new GoFishLead(primaryStage);
			}
		});
		
		Button warStart = new Button("War");
		warStart.getStyleClass().add("buttons");
		warStart.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				new WarLead(primaryStage);
			}
		});
		
		Button instructions = new Button("Instructions");
		instructions.getStyleClass().add("buttons");
		instructions.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Instructions instructions = new Instructions(primaryStage);
				Scene s = new Scene(instructions);
				primaryStage.setScene(s);				
			}
		});
		
		Button exit = new Button("Exit");
		exit.getStyleClass().add("buttons");
		exit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				primaryStage.close();				
			}
		});
		
		this.setSpacing(10);
		this.getChildren().addAll(blackjackStart, goFishStart, warStart, instructions, exit);
	}
 
}
