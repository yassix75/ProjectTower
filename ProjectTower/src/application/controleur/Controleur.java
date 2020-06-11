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
    private Pane paneTour;

    @FXML
    private Pane paneEnnemis;

    @FXML
    private VBox vbox;
    
    @FXML
    private Button lancer;

    private Timeline gameLoop;
	
	private int nbTours;
    
	private boolean jeuEstFini;
	
	private Jeu jeu;
	
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	this.jeuEstFini=false;
		this.jeu = new Jeu(57, 42);
		JeuVue jeuvue = new JeuVue(jeu, paneMap);
		jeuvue.afficherMap();
		System.out.println("affichermap ok");		
		initAnimation();
		System.out.println("initAnimation ok");		
		gameLoop.play();
	}
    
    @FXML
	 void Lancer(ActionEvent event) {
		 System.out.println("Appuie sur Lancer");
	 }

    private void initAnimation() {  
    	gameLoop = new Timeline();
    	nbTours = 0;
        gameLoop.setCycleCount(Timeline.INDEFINITE);
        KeyFrame kf = new KeyFrame( //(nbre de frame par seconde)
                Duration.seconds(0.2),//slow = +
                (e -> {
                    if (nbTours == 500 || this.jeuEstFini) {
                        System.out.println("fini");
                        gameLoop.stop();
                    } else {			
                       System.out.println("tour" + nbTours);                       
                       unTour(nbTours);        
                    }
                    nbTours++;
                }));
        gameLoop.getKeyFrames().add(kf);
	}
    
	private void unTour(int nbTour) {
		JeuVue jeuVueEnnemis = new JeuVue(this.jeu, paneEnnemis);
		int rdm = Jeu.getRandomInt(1, 4);
		
		if (nbTour % rdm == 0) {
			System.out.println(this.jeu.getListEnnemis());	
			this.jeu.creationNouveauEnnemi();
			System.out.println("liste crée");
			jeuVueEnnemis.afficheEnnemis(this.jeu.getListEnnemis());
			System.out.println("affiche ennemis de la liste");
		}
		for (Ennemis ennemis : this.jeu.getListEnnemis()) {
			ennemis.seDeplace();
			if(ennemis.atteintMaison()) {
				this.jeuEstFini=true;
			}
		}
		System.out.println("*********************************");
		System.out.println(this.jeuEstFini);
		/*
		for(int i = 0; i < this.jeu.getListEnnemis().size(); i++) {   ///////verif pv de ennemi
			ennemi = this.jeu.getListEnnemis().get(i);
			if (ennemi.Satisfait()) {
				this.jeu.getListEnnemis().remove(i);
			}
		System.out.println(" loop");			
		}*/
	}
}