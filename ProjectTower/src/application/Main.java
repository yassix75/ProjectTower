package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.layout.BorderPane;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root =  FXMLLoader.load(getClass().getResource("/application/vue/ProjectTowerD.fxml"));		
			Scene scene = new Scene(root,1050,672);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}
