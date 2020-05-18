package application;
	
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			lecteurMap();
			BorderPane root =  FXMLLoader.load(getClass().getResource("/application/vue/ProjectTowerD.fxml"));
			Scene scene = new Scene(root,700,600);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	public void lecteurMap (){
		String csvFile = "src/application/modele/towerdeflight.csv";
        BufferedReader br = null;
        String line = "";
        String [][] map = new String [57][42];
        int lignecourante = 0;
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
            	System.out.println(line);
            	for(int i = 0; i < line.split(";").length; i++) {
            		map[lignecourante][i]=line.split(";")[i];
            	}
            	lignecourante++;
            }
			for(int x = 0; x < map.length; x++) {
				System.out.println();
				for(int y = 0; y < map[x].length; y++)
					System.out.print(map[x][y] + " ");
			}

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
}
