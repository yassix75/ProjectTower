package application.controleur;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;

import application.modele.Bebe;
import application.modele.Ennemis;
import application.modele.Jeu;
import application.vue.JeuVue;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Controleur implements Initializable {
	
	@FXML
    private Pane panePrem;

    @FXML
    private TilePane mapTiledPane;

    @FXML
    private Pane paneMap;

    @FXML
    private Pane paneEnnemis;


    private Timeline gameLoop;
	
	private int temps;
    
	private Jeu jeu;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.jeu = new Jeu(57, 42);
		Ennemis bebe1 = new Bebe(jeu, 5, 2);
		JeuVue jeuvue = new JeuVue(jeu, paneMap);
		JeuVue jeuVueEnnemis = new JeuVue(jeu,paneEnnemis);
		jeuvue.afficherMap();
		System.out.println("affichermap ok");
		initAnimation();
		System.out.println("initAnimation ok");
		jeuVueEnnemis.creerEnnemisChem1(bebe1);
		System.out.println("creerEnenmis ok");
		gameLoop.play();
	}
  
    private void initAnimation() {
    	gameLoop = new Timeline();
        temps = 0;
        gameLoop.setCycleCount(Timeline.INDEFINITE);
        KeyFrame kf = new KeyFrame(
                // on définit le FPS (nbre de frame par seconde)
                Duration.seconds(0.2),

                // on définit ce qui se passe à chaque frame
                // c'est un eventHandler d'ou le lambda
                (e -> {
                    if (temps == 8000) {
                        System.out.println("fini");
                        gameLoop.stop();
                    } else if (temps % 5 == 0) {
                        System.out.println("tour" + temps);
                        unTour();                     
                    }
                    temps++;
                }));
        gameLoop.getKeyFrames().add(kf);
       // k	rgfouz
	}

	@SuppressWarnings("unused")
	private void unTour() {
	 }
}