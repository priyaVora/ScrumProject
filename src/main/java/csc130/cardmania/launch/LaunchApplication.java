package csc130.cardmania.launch;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LaunchApplication extends Application{
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		MainMenu menu = new MainMenu(primaryStage);
		Scene s = new Scene(menu);
		File stylesheet = new File("menus.css");
		s.getStylesheets().add(stylesheet.toURI().toString());
		primaryStage.setTitle("Card Mania");
		primaryStage.setScene(s);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
}
