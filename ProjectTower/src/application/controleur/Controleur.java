package application.controleur;

import java.net.URL;
import java.util.ResourceBundle;

import application.modele.Ennemis;
import application.modele.Jeu;
import application.vue.JeuVue;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class Controleur implements Initializable {
	
	@FXML
    private Pane panePrem;

    @FXML
    private TilePane mapTiledPane;

    @FXML
    private Pane paneMap;
    
    @FXML
    private Pane paneTours;

    @FXML
    private Pane paneEnnemis;

    @FXML
    private VBox vbox;
    
    @FXML
    private Button lancer;

    private Timeline gameLoop;
	
	private int nbTours;
   
	private Jeu jeu;
	
	private JeuVue jeuVueEnnemis;
	
	private JeuVue jeuvueMap;
	
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {   	
		this.jeu = new Jeu(57, 42);
		this.jeuvueMap = new JeuVue(jeu, paneMap);
		this.jeuVueEnnemis = new JeuVue(jeu, paneEnnemis);
		jeuvueMap.afficherMap();		
		gameLoop();	
		gameLoop.play();
	}
    
    @FXML
	 void Lancer(ActionEvent event) {
		 System.out.println("Appuie sur Lancer");
	 }

    private void gameLoop() {  
    	gameLoop = new Timeline();
    	nbTours = 0;
        gameLoop.setCycleCount(Timeline.INDEFINITE);
        KeyFrame kf = new KeyFrame(
                Duration.seconds(0.25),//slow = +
                (e -> {
                    if (nbTours == 500 || jeu.jeuEstFini) {
                    	System.out.println("*********************************");
                        System.out.println("GAME OVER");//fin de jeu
                        System.out.println("*********************************");
                        gameLoop.stop();
                    } else {			
                       System.out.println("tour" + nbTours);                       
                       jeu.unTour(nbTours, jeuVueEnnemis);        
                    }
                    nbTours++;
                }));
        gameLoop.getKeyFrames().add(kf);
	}
}   